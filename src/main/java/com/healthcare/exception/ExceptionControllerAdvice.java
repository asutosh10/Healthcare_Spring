package com.healthcare.exception;

import com.healthcare.DTO.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex){
        return ex.getMessage();
    }
    @ExceptionHandler(WeCareExceptions.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(WeCareExceptions ex){
        ErrorMessage error=new ErrorMessage();
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.OK);
    }
}
