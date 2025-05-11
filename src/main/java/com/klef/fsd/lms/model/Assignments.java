package com.klef.fsd.lms.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assignments_table")
public class Assignments {

    @Id
    @Column(name="assignment_title",length=100,nullable=false)
    private String title;
    @Column(name="description",length=100,nullable=false)
    private String description;
    @Column(name="upload_date",length=100,nullable=false)
    private LocalDate uploadDate;
    @Column(name="submission_deadline",length=100,nullable=false)
    private LocalDate submissionDeadline;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

	public LocalDate getSubmissionDeadline() {
		return submissionDeadline;
	}

	public void setSubmissionDeadline(LocalDate submissionDeadline) {
		this.submissionDeadline = submissionDeadline;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

    // Getters and Setters
}
