package com.klef.fsd.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.Student;
import com.klef.fsd.lms.repository.CourseRepository;
import com.klef.fsd.lms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Student checkStudentLogin(String username, String password) 
	{
		return studentRepository.findByUsernameAndPassword(username, password);
	}
	@Override
	public List<Course> viewallcourses() {
		return courseRepository.findAll();
		// TODO Auto-generated method stub
	
	}

	@Override
	public Student getStudentById(int sid) {
		return studentRepository.findById(sid).orElse(null);
		// TODO Auto-generated method stub

	}

	@Override
	public Course getCourseById(int cid) {
		return courseRepository.findById(cid).orElse(null);
	}
	


	

}