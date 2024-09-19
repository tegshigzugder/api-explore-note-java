package com.tegshigzugder.explorenote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tegshigzugder.explorenote.model.User;
import com.tegshigzugder.explorenote.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User createUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        return userService.createUser(username, email, password);
    }
}