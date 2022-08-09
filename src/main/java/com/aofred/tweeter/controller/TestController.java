package com.aofred.tweeter.controller;

import com.aofred.tweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    /*
    @GetMapping("/user")
    public String addUser() {
        userService.addUser("Erkki Esimerkki", "eesimerkki");
        return "redirect:/";
    }
    */
}
