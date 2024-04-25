package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.UserData;
import com.example.postgresdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public ResponseEntity<String> addNewUser(@RequestBody final UserData userData){
        try {
            userService.register(userData);
            return ResponseEntity.ok("User saved successfully");
        } catch (final Exception e) {
            // Log the exception details here, if logging is configured
            return ResponseEntity.badRequest().body("Failed to save user: " + e.getMessage());
        }
    }
}
