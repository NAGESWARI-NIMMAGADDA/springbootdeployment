package com.klef.fsd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.Faculty;
//import com.klef.fsd.lms.repository.CourseRepository;
import com.klef.fsd.lms.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService
{
	@Autowired
    private FacultyRepository facultyRepository;
	
    //private CourseRepository courseRepository;
	
	
	@Override
	public Faculty checkfacultylogin(String username, String password) 
	{
		return facultyRepository.findByUsernameAndPassword(username, password);
	}


	@Override
	public Faculty getFacultyById(int id) 
	{
	   return facultyRepository.findById(id).get();
	}


	@Override
	public List<Course> viewcoursesbyfaculty(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}