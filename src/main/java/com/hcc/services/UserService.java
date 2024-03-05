package com.hcc.services;

import com.hcc.entities.User;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public User update(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).get();

        existingUser.setUsername(updatedUser.getUsername());

        return userRepository.save(existingUser);
    }
    public ResponseEntity<?> delete(Long id) {
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "User not found with id" + id));
        userRepository.delete(userToDelete);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
