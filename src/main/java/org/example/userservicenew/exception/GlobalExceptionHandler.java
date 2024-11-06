package org.example.userservicenew.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> responseNotFound(Exception  exception) {
       String msg= exception.getMessage();
      ApiResponse res=  ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
        return  new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
