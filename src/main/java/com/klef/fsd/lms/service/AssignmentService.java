package com.klef.fsd.lms.service;

import java.util.List;
import com.klef.fsd.lms.model.Assignments;

public interface AssignmentService {
    Assignments uploadAssignment(Assignments assignment);
    List<Assignments> getAssignmentsByFaculty(int facultyId);
    Assignments updateAssignment(Assignments assignment);
}
