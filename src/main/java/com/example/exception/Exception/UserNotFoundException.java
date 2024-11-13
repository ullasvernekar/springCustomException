package com.example.exception.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super("User with ID " + id + " not  found with custom exception");
    }


}


