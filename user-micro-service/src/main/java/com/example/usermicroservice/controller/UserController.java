package com.example.usermicroservice.controller;

import com.example.usermicroservice.bean.User;
import com.example.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/username/{username}")
    public ResponseEntity<Object> findByUserName(@PathVariable String username) {
        User user = userRepository.findByUserName(username);
        return ResponseEntity.ok(user);
    }
}
