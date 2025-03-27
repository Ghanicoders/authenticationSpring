package com.ghani.MysqlAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ghani.MysqlAuth.model.User;
import com.ghani.MysqlAuth.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        repo.save(user);
    }
}
