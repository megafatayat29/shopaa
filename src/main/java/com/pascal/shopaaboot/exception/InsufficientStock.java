package com.pascal.shopaaboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InsufficientStock extends RuntimeException{
    public InsufficientStock(String message) {
        super(message);
    }
}
