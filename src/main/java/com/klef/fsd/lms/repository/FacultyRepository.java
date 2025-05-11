package com.klef.fsd.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.fsd.lms.model.Faculty;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Integer>
{
  public Faculty findByUsernameAndPassword(String username, String password);
  
  @Query("select count(f) from Faculty f")
  public long facultycount();
}