package com.pascal.shopaaboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UsernameAlreadyUsed extends RuntimeException{
    public UsernameAlreadyUsed(String message) {
        super(message);
    }
}
