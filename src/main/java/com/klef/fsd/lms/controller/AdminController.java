package com.klef.fsd.lms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.fsd.lms.dto.CourseFacultyMappingDTO;
import com.klef.fsd.lms.model.Admin;
import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.CourseFacultyMapping;
import com.klef.fsd.lms.model.Faculty;
import com.klef.fsd.lms.model.Student;
import com.klef.fsd.lms.repository.CourseFacultyMappingRepository;
import com.klef.fsd.lms.repository.CourseRepository;
import com.klef.fsd.lms.repository.FacultyRepository;
import com.klef.fsd.lms.service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseFacultyMappingRepository courseFacultyMappingRepository;

    // Admin login
    @PostMapping("/admin/checkadminlogin")
    public ResponseEntity<?> checkAdminLogin(@RequestBody Admin admin) {
        try {
            Admin a = adminService.checkadminlogin(admin.getUsername(), admin.getPassword());
            if (a != null) {
                return ResponseEntity.ok(a);
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }

    // Add Faculty
    @PostMapping("/admin/addfaculty")
    public ResponseEntity<String> addFaculty(@RequestBody Faculty faculty) {
        try {
            String response = adminService.addFaculty(faculty);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add faculty: " + e.getMessage());
        }
    }

    // Add Student
    @PostMapping("/admin/addstudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        try {
            String response = adminService.addStudent(student);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add student: " + e.getMessage());
        }
    }

    // Add Course
    @PostMapping("/admin/addcourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        try {
            String response = adminService.addcourse(course);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add course: " + e.getMessage());
        }
    }

    // View All Faculties
    @GetMapping("/admin/viewallfaculty")
    public ResponseEntity<List<Faculty>> viewAllFaculty() {
        try {
            List<Faculty> faculty = adminService.displayfaculty();
            return ResponseEntity.ok(faculty != null ? faculty : new ArrayList<>());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ArrayList<>());
        }
    }

    // View All Students
    @GetMapping("/admin/viewallstudents")
    public ResponseEntity<List<Student>> viewAllStudents() {
        try {
            List<Student> students = adminService.displaystudents();
            return ResponseEntity.ok(students != null ? students : new ArrayList<>());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ArrayList<>());
        }
    }

    // View All Courses
    @GetMapping("/admin/viewallcourses")
    public ResponseEntity<List<Course>> viewAllCourses() {
        try {
            List<Course> courses = adminService.displayCourse();
            return ResponseEntity.ok(courses != null ? courses : new ArrayList<>());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ArrayList<>());
        }
    }

    @DeleteMapping("/deletefaculty")
    public ResponseEntity<String> deletefaculty(@RequestParam int fid) {
        try {
            String output = adminService.deletefaculty(fid);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete Faculty ... !!");
        }
    }

    @DeleteMapping("/deletestudent")
    public ResponseEntity<String> deletestudent(@RequestParam int sid) {
        try {
            String output = adminService.deletestudent(sid);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete Student ... !!");
        }
    }

    // Delete Course
    @DeleteMapping("/admin/deletecourse")
    public ResponseEntity<String> deleteCourse(@RequestParam int cid) {
        try {
            String response = adminService.deletecourse(cid);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete course: " + e.getMessage());
        }
    }

    // Map Course to Faculty
    @PostMapping("/admin/mapcourse")
    public ResponseEntity<String> mapCourseToFaculty(@RequestBody CourseFacultyMappingDTO dto) {
        try {
            System.out.println("Received mapping request: facultyId=" + dto.getFacultyId() + ", courseId=" + dto.getCourseId());

            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found with ID: " + dto.getFacultyId()));

            Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + dto.getCourseId()));

            CourseFacultyMapping mapping = new CourseFacultyMapping();
            mapping.setFaculty(faculty);
            mapping.setCourse(course);

            CourseFacultyMapping savedMapping = courseFacultyMappingRepository.save(mapping);
            System.out.println("Mapping saved with ID: " + savedMapping.getMappingId());

            return ResponseEntity.ok("Course successfully mapped to Faculty!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to map course to faculty: " + e.getMessage());
        }
    }
}