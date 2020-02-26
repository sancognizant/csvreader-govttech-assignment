package com.example.csvreader.controller;

import com.example.csvreader.model.Output;
import com.example.csvreader.model.User;
import com.example.csvreader.model.UserDB;
import com.example.csvreader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Output> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
