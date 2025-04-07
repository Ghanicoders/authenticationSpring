package com.ghani.MysqlAuth.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ghani.MysqlAuth.model.User;
import com.ghani.MysqlAuth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        // Implementation to fetch all users from the database
        return new ResponseEntity<>("Hello world!", HttpStatus.OK);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // TODO: process POST request

        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // TODO: process POST request
        return service.verify(user);
    }

    @GetMapping("/home/{Id}")
    public User user(@RequestParam Long Id) {
        return service.getUserbyId(Id);
    }

}
