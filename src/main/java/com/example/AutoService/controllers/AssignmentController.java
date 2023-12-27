package com.example.AutoService.controllers;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.services.AssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autoservice")
public class AssignmentController {

    private final AssignmentService assignmentService;

    // Получение всех заданий (assignments)
    @GetMapping("/assignments")
    public List<Assignment> getAllAssignmentsForAdmin() {
        return assignmentService.getAllAssignments();
    }

    // Получение задания (assignment) по ID
    @GetMapping("/assignments/{assignmentId}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long assignmentId) {
        Assignment assignment = assignmentService.getAssignmentById(assignmentId);

        if (assignment != null) {
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Добавление нового задания (assignment)
    @PostMapping("/addAssignment")
    public String createAssignment(@RequestBody Assignment assignment) {

        assignmentService.createAssignment(assignment);

        return "Assignment added";
    }
}
