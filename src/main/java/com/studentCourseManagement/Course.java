package com.studentCourseManagement;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Course {
	@Id
	private int courseID;
	private String courseName;
	private float courseDuration;
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public float getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(float courseDuration) {
		this.courseDuration = courseDuration;
	}
	
}
