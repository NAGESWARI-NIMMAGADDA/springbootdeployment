package com.klef.fsd.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	@Column(name="student_name",length=55,nullable=false)
	private String username;
	@Column(name="student_password",length=55,nullable=false,unique=true)
	private String password;
	@Column(name="student_dob",length=55,nullable=false)
	private String dob;
	@Column(name="student_gender",length=55,nullable=false)
	private String gender; 
	@Column(name="student_email",length=55,nullable=false,unique=true)
	private String email;
	@Column(name="year_of_study",length=55,nullable=false)
	private String yearofstudy;
	@Column(name="mobile_no",length=55,nullable=false,unique=true)
	private String mobileno;
	@Column(name="department_name",length=55,nullable=false)
	private String department_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getYearofstudy() {
		return yearofstudy;
	}
	public void setYearofstudy(String yearofstudy) {
		this.yearofstudy = yearofstudy;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

}