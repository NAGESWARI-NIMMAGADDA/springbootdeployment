package com.klef.fsd.lms.controller;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.Student;
import com.klef.fsd.lms.service.StudentService;


@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class StudentController 
{
   @Autowired
   private StudentService studentservice;
	
   @GetMapping("/")
   public String home()
   {
	   return " SDP LMS Project";
   }
   
 
   @PostMapping("/checkstudentlogin")
   public ResponseEntity<?> checkStudentLogin(@RequestBody Student student) {
       try {
           System.out.println("Received login request: username=" + student.getUsername() + ", password=" + student.getPassword());
           Student foundStudent = studentservice.checkStudentLogin(student.getUsername(), student.getPassword());
           if (foundStudent != null) {
               System.out.println("Login successful for: " + foundStudent.getUsername());
               return ResponseEntity.ok(foundStudent);
           } else {
               System.out.println("Login failed: Invalid credentials");
               return ResponseEntity.status(401).body("Invalid Username or Password");
           }
       } catch (Exception e) {
           System.out.println("Login error: " + e.getMessage());
           return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
       }
   }

   @GetMapping("/viewallstudents")
   public ResponseEntity<List<Course>> viewallcourses()
   {
 	 List<Course> courses =  studentservice.viewallcourses();
 	 
 	 return ResponseEntity.ok(courses); // 200 - success
   }
 
   
   
}