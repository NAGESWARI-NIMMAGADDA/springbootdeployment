package com.klef.fsd.lms.service;

import java.util.List;


import com.klef.fsd.lms.model.Student;
import com.klef.fsd.lms.model.Course;

public interface StudentService 
{
  public Student checkStudentLogin(String username,String password);
  public List<Course> viewallcourses();
  public Student getStudentById(int sid);
  public Course getCourseById(int cid);
  
 
  
}