package com.klef.fsd.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.fsd.lms.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
  public Student findByUsernameAndPassword(String username, String password);
  
//  @Query("select c from Student c where c.gender=?1")
//  public List<Student> displaystudentbygender(String gender);
//  
//  @Modifying
//  @Transactional
//  @Query("delete from Student c where c.location=?1")
//  public int deletestudentbylocation(String location);
//  
//  @Query("select count(c) from Student c")
//  public long studentcount();
}