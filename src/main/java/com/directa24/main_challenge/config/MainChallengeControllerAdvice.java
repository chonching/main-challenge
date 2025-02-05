package com.directa24.main_challenge.config;

import com.directa24.main_challenge.directorsmoviesapi.DirectorsMoviesApiDownException;
import com.directa24.main_challenge.exceptions.BadRequestException;
import com.directa24.main_challenge.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MainChallengeControllerAdvice {

    private static final String MESSAGE_KEY = "error";
    @ExceptionHandler({BadRequestException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> badRequest(Exception ex){
        Map<String, Object> errorResp = new HashMap<>();
        errorResp.put(MESSAGE_KEY,  ex.getMessage());
        return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> notFound(Exception ex){
        Map<String, Object> errorResp = new HashMap<>();
        errorResp.put(MESSAGE_KEY,  ex.getMessage());
        return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DirectorsMoviesApiDownException.class})
    public ResponseEntity<Object> apiDown(Exception ex){
        Map<String, Object> errorResp = new HashMap<>();
        errorResp.put(MESSAGE_KEY,  ex.getMessage());
        return new ResponseEntity<>(errorResp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
