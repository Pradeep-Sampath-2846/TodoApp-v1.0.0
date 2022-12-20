package lk.ijse.dep9.app.api;

import lk.ijse.dep9.app.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void createUserAccount(@Valid @RequestBody UserDTO user/*, Errors errors*/){
        System.out.println(user);
//        Optional<FieldError> fieldError = errors.getFieldErrors().stream().findFirst();
//        if (fieldError.isPresent()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,fieldError.get().getDefaultMessage());
//        }


    }

    @PatchMapping("/me")
    public void updateUserAccountDetails(){

    }

    @GetMapping("/me")
    public void getUserAccountDetails(){

    }

    @DeleteMapping("/me")
    public void deleteUserAccount(){

    }
}
