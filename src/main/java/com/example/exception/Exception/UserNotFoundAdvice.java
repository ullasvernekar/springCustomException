package com.example.exception.Exception;

import com.example.exception.Dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {


@ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(userNotFoundException.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
    }
@ResponseBody
    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ResponseStructure<String>> handleInvalidUserException(InvalidUserException invalidUserException) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(invalidUserException.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }
}

