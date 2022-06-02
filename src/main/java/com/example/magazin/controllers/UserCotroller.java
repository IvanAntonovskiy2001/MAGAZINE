package com.example.magazin.controllers;

import com.example.magazin.models.User;
import com.example.magazin.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserCotroller {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/login";
    }


}

