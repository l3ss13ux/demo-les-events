package com.example.demolesevents.hexagon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadEventException extends Exception {
    public BadEventException() {
        super();
    }
}
