package com.klef.fsd.lms.service;

import java.util.List;

import com.klef.fsd.lms.model.Course;
import com.klef.fsd.lms.model.Faculty;

public interface FacultyService 
{
  public Faculty checkfacultylogin(String username,String password);
  public List<Course> viewcoursesbyfaculty(int id);
 
  public Faculty getFacultyById(int fid);

  
}