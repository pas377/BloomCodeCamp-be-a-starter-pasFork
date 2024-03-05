package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }
    public Optional<Assignment> findById(Long id) {
        return assignmentRepository.findById(id);
    }
//    public Optional<User> findByName(String name) {
//        return userRepository.findByName(name);
//    }
    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
    public Assignment update(Long id, Assignment updatedAssignment) {
        Assignment existingAssignment = assignmentRepository.findById(id).get();

        existingAssignment.setName(updatedAssignment.getName());

        return assignmentRepository.save(existingAssignment);
    }
    public ResponseEntity<?> delete(Long id) {
        Assignment assignmentToDelete = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "User not found with id" + id));
        assignmentRepository.delete(assignmentToDelete);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
