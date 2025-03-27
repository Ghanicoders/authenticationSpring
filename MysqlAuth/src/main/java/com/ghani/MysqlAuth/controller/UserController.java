package com.ghani.MysqlAuth.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        // Implementation to fetch all users from the database
        return new ResponseEntity<>("Hello world!", HttpStatus.OK);
    }

}
