package com.buyogo.traini8.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {


    /*
     * Handling exception for validation
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> MethodArgumentExceptionHandler(MethodArgumentNotValidException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Current Timestamp", new Date());
        body.put("Status", HttpStatus.BAD_REQUEST.value());

        Map<String, String> errors = new LinkedHashMap<>();

        /*
        * Finding all the errors
        * Map all errors associated with a field.
        * */
        exception.getBindingResult()
                .getFieldErrors()
                .forEach((err) -> {
                    // Mapping all errors associated with a field.
                    errors.put(err.getField(), err.getDefaultMessage());
                });
        body.put("Errors", errors);

        // Returning proper message along with Status code
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


    /*
    *   Handling exception for Duplicate value in DataBase
    * */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> DataIntegrityExceptionHandler(DataIntegrityViolationException exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Current Timestamp", new Date());
        body.put("Status", HttpStatus.BAD_REQUEST.value());

        /*
        *   Finding The detail cause for exception
        * */
        String[] arr = exception.getMessage().split("]");
        int in = arr[0].indexOf("Detail");
        String s = arr[0].substring(in,arr[0].length());

        body.put("Error",s);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


}
