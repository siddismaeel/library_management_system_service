package com.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
    	log.error("Unexpected error: ", ex);
        return new ResponseEntity<>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleGeneralException(IllegalArgumentException ex) {
    	log.error(ex.getMessage());
        return new ResponseEntity<>("Bad Request: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
   
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleMemberException(Exception ex) {
    	log.error("Unexpected error: ", ex);
        return new ResponseEntity<>("Bad Request: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
