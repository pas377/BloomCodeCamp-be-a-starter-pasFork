package com.hcc.controllers;

import com.hcc.entities.User;
import com.hcc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
//import com.hcc.services.UserDetailServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    //CREATE
    @GetMapping
    public ResponseEntity<?> getEntity() {
        return ResponseEntity.ok(userService.findAll());
    }

    //READ
    @GetMapping("{userId}")
    public ResponseEntity<?> getEntityById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }
    @PostMapping
    public ResponseEntity<?> createEntity(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    //UPDATE
    @PutMapping("{userId}")
    public ResponseEntity<?> updateEntity(@PathVariable Long userId, @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.update(userId, updatedUser));
    }

    //DELETE
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long userId) {
        return userService.delete(userId);
    }


}
