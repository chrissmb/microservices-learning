package com.example.serviceconfig.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NegocioException extends RuntimeException {

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(Throwable throwable) {
        super(throwable);
    }

    public NegocioException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
