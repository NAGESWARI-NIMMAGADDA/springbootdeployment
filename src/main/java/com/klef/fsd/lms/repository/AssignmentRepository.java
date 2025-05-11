package com.klef.fsd.lms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.fsd.lms.model.Assignments;


public interface AssignmentRepository extends JpaRepository<Assignments, String> {
    List<Assignments> findByFacultyId(int facultyId);
}
