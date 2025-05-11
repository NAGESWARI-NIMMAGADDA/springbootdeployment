package com.klef.fsd.lms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsd.lms.model.CourseFacultyMapping;

@Repository
public interface CourseFacultyMappingRepository extends JpaRepository<CourseFacultyMapping, Integer> {
    // Custom query to find CourseFacultyMapping by facultyId
    List<CourseFacultyMapping> findByFacultyId(Integer facultyId);
}