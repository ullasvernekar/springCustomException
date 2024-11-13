package com.example.exception.Controller;
import com.example.exception.Dto.ResponseStructure;
import com.example.exception.Dto.User;
import com.example.exception.Exception.InvalidUserException;
import com.example.exception.Exception.UserNotFoundException;
import com.example.exception.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/exception")
public class UserController {

    @Autowired
    private UserService  userService;

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseStructure<User>> save(@RequestBody User user) {
        return userService.save(user);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseStructure<User>> findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/findByPhone/{phone}")
    public ResponseEntity<ResponseStructure<User>> findByPhone(@PathVariable long phone) {
        return userService.findByPhone(phone);
    }
    
}







