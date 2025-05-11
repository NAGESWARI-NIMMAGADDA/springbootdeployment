package com.klef.fsd.lms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.fsd.lms.model.Assignments;
import com.klef.fsd.lms.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/upload")
    public Assignments uploadAssignment(@RequestBody Assignments assignment) {
        return assignmentService.uploadAssignment(assignment);
    }

    @GetMapping("/faculty/{facultyId}")
    public List<Assignments> getAssignmentsByFaculty(@PathVariable int facultyId) {
        return assignmentService.getAssignmentsByFaculty(facultyId);
    }

    @PutMapping("/edit")
    public Assignments updateAssignment(@RequestBody Assignments assignment) {
        return assignmentService.updateAssignment(assignment);
    }
}
