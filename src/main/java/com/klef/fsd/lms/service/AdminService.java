package com.klef.fsd.lms.service;

import java.util.List;

import com.klef.fsd.lms.model.Admin;
import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.Faculty;
import com.klef.fsd.lms.model.Student;

public interface AdminService {
    public Admin checkadminlogin(String username, String password);
    public String addStudent(Student student);
    public String addFaculty(Faculty faculty);
    public String addcourse(Course course);

    public String deletecourse(int cid);
    public List<Course> displayCourse();
    public String mapCourseToFaculty(int facultyId, int courseId);
    public List<Faculty> displayfaculty();
    public String deletefaculty(int fid);

    public List<Student> displaystudents();
    public String deletestudent(int sid);
}