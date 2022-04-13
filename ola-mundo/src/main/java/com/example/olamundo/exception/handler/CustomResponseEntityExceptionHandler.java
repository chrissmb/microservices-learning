package com.example.olamundo.exception.handler;

import java.util.Date;

import com.example.olamundo.exception.ExceptionResponse;
import com.example.olamundo.exception.NegocioException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request) {
        ExceptionResponse exceptionResponse = 
                new ExceptionResponse(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NegocioException.class)
    public final ResponseEntity<ExceptionResponse> handleNegocioExceptions(NegocioException e, WebRequest request) {
        ExceptionResponse exceptionResponse = 
                new ExceptionResponse(e.getMessage(), request.getDescription(true), new Date());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
