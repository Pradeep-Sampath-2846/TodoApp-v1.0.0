package lk.ijse.dep9.app.advice;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> validationException(MethodArgumentNotValidException e){
        HashMap<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status",HttpStatus.BAD_REQUEST.value());
        errAttributes.put("error",HttpStatus.BAD_REQUEST.getReasonPhrase());
        errAttributes.put("timeStamp",new Date().toString());
        List<String> validationList = e.getFieldErrors().stream().map(err -> err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
        errAttributes.put("errors",validationList);
        return errAttributes;
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    public Map<String, Object> duplicateEntityExceptionHandler(){
        HashMap<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status",HttpStatus.CONFLICT.value());
        errAttributes.put("error",HttpStatus.CONFLICT.getReasonPhrase());
        errAttributes.put("message","Duplicate entry found!");
        errAttributes.put("timeStamp",new Date().toString());
        return errAttributes;
    }
}
