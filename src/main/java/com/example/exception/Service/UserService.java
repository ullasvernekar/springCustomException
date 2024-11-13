package com.example.exception.Service;

import com.example.exception.Dao.UserDao;
import com.example.exception.Dto.ResponseStructure;
import com.example.exception.Dto.User;
import com.example.exception.Exception.InvalidUserException;
import com.example.exception.Exception.UserNotFoundException;
import com.example.exception.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<ResponseStructure<User>> save(User user) {
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        if ( userDao.findByPhone(user.getPhone()) != null) {
            responseStructure.setStatus(HttpStatus.CONFLICT.value());
            responseStructure.setMessage("User Could Not Be Saved, Already Exists");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.CONFLICT);
        } else {
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("User Saved Successfully");
            responseStructure.setData(userDao.saveUser(user));
            return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<ResponseStructure<User>> findByPhone(long phone) {
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        User user = userRepository.findByPhone(phone).orElseThrow(() -> new InvalidUserException(phone));
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("User Found By Phone " + phone);
        responseStructure.setData(user);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<User>> findById(long id) {
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("User Found By Id " + id);
        responseStructure.setData(user);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
}
