package com.klef.fsd.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.lms.model.Admin;
import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.Faculty;
import com.klef.fsd.lms.model.Student;
import com.klef.fsd.lms.model.CourseFacultyMapping;
import com.klef.fsd.lms.repository.AdminRepository;
import com.klef.fsd.lms.repository.FacultyRepository;
import com.klef.fsd.lms.repository.StudentRepository;
import com.klef.fsd.lms.repository.CourseRepository;
import com.klef.fsd.lms.repository.CourseFacultyMappingRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseFacultyMappingRepository courseFacultyMappingRepository;

    @Override
    public Admin checkadminlogin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student Added Successfully";
    }

    @Override
    public String addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
        return "Faculty Added Successfully";
    }

    @Override
    public String addcourse(Course course) {
        courseRepository.save(course);
        return "Course Added Successfully";
    }

    @Override
    public String deletestudent(int sid) {
        Optional<Student> student = studentRepository.findById(sid);
            if (student.isPresent()) {
                studentRepository.deleteById(sid);
                return "Student Deleted Successfully";
            } else {
                return "Student ID Not Found";
            }
    }

    @Override
    public String deletefaculty(int fid) {
        Optional<Faculty> faculty = facultyRepository.findById(fid);
        if (faculty.isPresent()) {
            facultyRepository.deleteById(fid);
            return "Faculty Deleted Successfully";
        } else {
            return "Faculty ID Not Found";
        }
    }

    @Override
    public String deletecourse(int cid) {
        Optional<Course> course = courseRepository.findById(cid);
        if (course.isPresent()) {
            courseRepository.deleteById(cid);
            return "Course Deleted Successfully";
        } else {
            return "Course ID Not Found";
        }
    }

    @Override
    public List<Course> displayCourse() {
        return courseRepository.findAll();
    }

    @Override
    public String mapCourseToFaculty(int facultyId, int courseId) {
        Optional<Faculty> facultyOpt = facultyRepository.findById(facultyId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (facultyOpt.isPresent() && courseOpt.isPresent()) {
            Faculty faculty = facultyOpt.get();
            Course course = courseOpt.get();

            CourseFacultyMapping mapping = new CourseFacultyMapping();
            mapping.setFaculty(faculty);
            mapping.setCourse(course);

            courseFacultyMappingRepository.save(mapping);

            return "Course successfully mapped to Faculty.";
        } else {
            return "Faculty or Course not found.";
        }
    }

    @Override
    public List<Faculty> displayfaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public List<Student> displaystudents() {
        return studentRepository.findAll();
    }
}