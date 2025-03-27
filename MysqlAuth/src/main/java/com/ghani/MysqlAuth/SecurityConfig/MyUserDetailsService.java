package com.ghani.MysqlAuth.SecurityConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ghani.MysqlAuth.model.User;
import com.ghani.MysqlAuth.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user from the database using the provided username
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincple(user);
    }

    // Implement the logic to fetch user details from the database

}
