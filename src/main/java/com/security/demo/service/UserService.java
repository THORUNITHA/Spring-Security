package com.security.demo.service;

import com.security.demo.model.Users;
import com.security.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public Users register(Users user){
        //BcryptPassword Encoder - hashing the password - hash 12 rounds - using SHA256 Algo

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
}