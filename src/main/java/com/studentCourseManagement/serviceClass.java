package com.studentCourseManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceClass {
	@Autowired
	private CourseRepo courseRepo;
	
	public Course saveCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public List<Course> findAllCourses(){
		return (List<Course>) courseRepo.findAll();
	}
	public Course findById(int Id) {
		return courseRepo.findById(Id).orElse(null);
	}
	public Course updateCourse(Course course) {
		Course existedCourse = findById(course.getCourseID());
		if(existedCourse!=null) {
			existedCourse.setCourseDuration(course.getCourseDuration());
			existedCourse.setCourseID(course.getCourseID());
			existedCourse.setCourseName(course.getCourseName());
			
			courseRepo.save(existedCourse);
		}
		return existedCourse;
	}
	
	public String deleteCourse(int Id) {
		courseRepo.deleteById(Id);
		return "Course Deleted!!";
	}
}
