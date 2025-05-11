package com.klef.fsd.lms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.CourseFacultyMapping;
import com.klef.fsd.lms.model.Faculty;
import com.klef.fsd.lms.repository.CourseFacultyMappingRepository;
import com.klef.fsd.lms.service.FacultyService;

@RestController
@RequestMapping("/faculty")
@CrossOrigin("*")
public class FacultyController {
	@Autowired
	private FacultyService facultyService;
	 @PostMapping("/checkfacultylogin")
	  public ResponseEntity<?> checkfacultylogin(@RequestBody Faculty faculty)
	  {
		  try 
	      {
	          Faculty f = facultyService.checkfacultylogin(faculty.getUsername(), faculty.getPassword());

	          if (f!=null) 
	          {
	              return ResponseEntity.ok(f); 
	          } 
	          else 
	          {
	              return ResponseEntity.status(401).body("Invalid Username or Password"); // if login is fail
	          }
	      } 
	      catch (Exception e) 
	      {
	          return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
	      }
	  }
	 
	 private CourseFacultyMappingRepository courseFacultyMappingRepository;


	     private CourseFacultyMappingRepository mappingRepository;

	     @GetMapping("/{facultyId}/mapped-courses")
	     public List<CourseFacultyMapping> getMappedCourses(@PathVariable Integer facultyId) {
	         return mappingRepository.findByFacultyId(facultyId);
	     }
	 

	    }
