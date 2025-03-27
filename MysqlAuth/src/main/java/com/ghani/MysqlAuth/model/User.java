package com.ghani.MysqlAuth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long Id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String role;

    // Constructor
    public User(Long id, String username, String password, String email, String role) {
        this.Id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User() {

    }

    // getter and seeter
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
