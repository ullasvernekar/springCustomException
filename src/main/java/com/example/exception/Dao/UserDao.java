package com.example.exception.Dao;

import com.example.exception.Dto.User;
import com.example.exception.Exception.InvalidUserException;
import com.example.exception.Exception.UserNotFoundException;
import com.example.exception.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);
        return  user.orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findByPhone(long phone) {
        Optional<User> user = userRepository.findByPhone(phone);
        return  user.orElseThrow(() -> new InvalidUserException(phone));
    }
}
