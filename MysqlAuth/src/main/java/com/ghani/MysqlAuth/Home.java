package com.ghani.MysqlAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/home")
    public String home() {
        return "well come to the home";
    }

    @GetMapping("/")
    public String wellCome() {
        return "well come to the home";
    }
}
