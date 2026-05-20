package com.practise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> validateException(MethodArgumentNotValidException exception){

        Map<String, Object> error =new HashMap<>() ;

        exception.getBindingResult().getFieldErrors().forEach(
                fieldError -> error.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return  ResponseEntity.badRequest().body(error);
    }
}
