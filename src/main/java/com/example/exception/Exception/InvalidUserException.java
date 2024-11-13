package com.example.exception.Exception;

public class InvalidUserException extends  RuntimeException{
    public  InvalidUserException(long phone){
        super("User with Phone " + phone + " not  found with custom exception");
    }
}
