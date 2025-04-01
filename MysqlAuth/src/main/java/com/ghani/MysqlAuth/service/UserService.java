package com.ghani.MysqlAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ghani.MysqlAuth.model.User;
import com.ghani.MysqlAuth.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);
    }

    public String verify(User user) {
        try {
            // Perform authentication
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            // Check if authentication was successful
            if (authentication.isAuthenticated()) {
                return "success";
            }

        } catch (Exception e) {
            // Handle authentication failure
            return "error";
        }

        return "error";
    }

}
