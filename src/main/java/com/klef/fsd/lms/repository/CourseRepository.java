package com.klef.fsd.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.fsd.lms.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}