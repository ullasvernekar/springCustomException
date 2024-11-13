package com.example.exception.Repository;

import com.example.exception.Dto.User;
import com.example.exception.Exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

     Optional<User>  findByPhone(long phone);
   }



