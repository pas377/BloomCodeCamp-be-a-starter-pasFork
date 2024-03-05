package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.hcc.services.UserDetailServiceImpl;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    //CREATE
    @GetMapping
    public ResponseEntity<?> getEntity() {
        return ResponseEntity.ok(assignmentService.findAll());
    }

    //READ
    @GetMapping("{assignmentId}")
    public ResponseEntity<?> getEntityById(@PathVariable Long userId) {
        return ResponseEntity.ok(assignmentService.findById(userId));
    }
    @PostMapping
    public ResponseEntity<?> createEntity(@RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignmentService.save(assignment));
    }

    //UPDATE
    @PutMapping("{assignmentId}")
    public ResponseEntity<?> updateEntity(@PathVariable Long assignmentId, @RequestBody Assignment updatedAssignment) {
        return ResponseEntity.ok(assignmentService.update(assignmentId, updatedAssignment));
    }

    //DELETE
    @DeleteMapping("{assignmentId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long assignmentId) {
        return assignmentService.delete(assignmentId);
    }


}
