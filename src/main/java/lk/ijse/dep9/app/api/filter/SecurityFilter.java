package lk.ijse.dep9.app.api.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.dep9.app.dto.UserDTO;
import lk.ijse.dep9.app.exceptions.AuthenticationException;
import lk.ijse.dep9.app.service.custom.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
public class SecurityFilter extends HttpFilter {

    private UserService userService;

    public SecurityFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println(req.getServletPath());
       if (req.getServletPath().matches("/api/v1/users/?") && req.getMethod().equals("POST")){
           chain.doFilter(req,res);
       }else if (req.getServletPath().matches("/api/v1/auth/.+")){
           chain.doFilter(req,res);
       }else {

           String authorization = req.getHeader("Authorization");
           if (authorization!=null && authorization.startsWith("Basic")){
               String token = authorization.substring("Basic".length() + 1);
               String credentials = new String(Base64.getDecoder().decode(token));
               String username = credentials.split(":")[0];
               String password = credentials.split(":")[1];

               try{
                   userService.verifyUser(username, password);
                   req.setAttribute("username",username);
                   chain.doFilter(req,res);
                   return;
               }catch (AuthenticationException e){

               }
           }

           HashMap<String, Object> errAttributes = new LinkedHashMap<>();
           errAttributes.put("status", HttpStatus.UNAUTHORIZED.value());
           errAttributes.put("error",HttpStatus.UNAUTHORIZED.getReasonPhrase());
           errAttributes.put("message","Invalid login credentials!");
           errAttributes.put("timeStamp",new Date().toString());
           res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           ObjectMapper objectMapper = new ObjectMapper();
           res.setContentType("application/json");
           objectMapper.writeValue(res.getWriter(),errAttributes);
       }
    }
}
