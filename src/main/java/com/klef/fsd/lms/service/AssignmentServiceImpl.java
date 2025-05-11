package com.klef.fsd.lms.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.fsd.lms.model.Assignments;
import com.klef.fsd.lms.repository.AssignmentRepository;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public Assignments uploadAssignment(Assignments assignment) {
        assignment.setUploadDate(LocalDate.now());
        assignment.setSubmissionDeadline(LocalDate.now().plusWeeks(1));
        return assignmentRepository.save(assignment);
    }

    @Override
    public List<Assignments> getAssignmentsByFaculty(int facultyId) {
        return assignmentRepository.findByFacultyId(facultyId);
    }

    @Override
    public Assignments updateAssignment(Assignments assignment) {
        return assignmentRepository.save(assignment);
    }
}
