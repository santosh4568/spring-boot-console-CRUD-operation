package com.studentCourseManagement;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentCourseManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(StudentCourseManagementApplication.class, args);
		serviceClass service = context.getBean(serviceClass.class);
	}
	@Bean
	public CommandLineRunner demo(serviceClass service) {
		return (args)->{
			Scanner scanner = new Scanner(System.in);
			boolean flag = true;
			while(flag) {
				System.out.println("1 : Create");
				System.out.println("2 : ReadAll");
				System.out.println("3 : ReadById");
				System.out.println("4 : Update");
				System.out.println("5 : Delete");
				System.out.println("6 : Exit");
				System.out.print("Enter your choice : ");
				int choice = scanner.nextInt();
				if(choice==1) {
					System.out.print("Enter Course ID : ");
					int id = scanner.nextInt();
					Course course1 = service.findById(id);
					if(course1!=null) {
						System.out.println("Course ID already existed");
					}
					else {
					System.out.print("Enter Course Name : ");
					String nameString = scanner.next();
					System.out.print("Enter Course Duration : ");
					float duration = scanner.nextFloat();
					
					Course course = new Course();
					course.setCourseDuration(duration);
					course.setCourseID(id);
					course.setCourseName(nameString);
					
					service.saveCourse(course);
					System.out.println("Course Added!!");
					}
				}
				else if(choice==2) {
					List<Course> displayCourses = service.findAllCourses();
					for(Course crCourse : displayCourses ) {
						System.out.println(crCourse.getCourseID()+"  : "+crCourse.getCourseName()+
								"  : "+crCourse.getCourseDuration());
					}
				}
				else if(choice==3) {
					System.out.print("Enter Course ID : ");
					int id = scanner.nextInt();
					Course course = service.findById(id);
					if(course!=null) {
					System.out.println(course.getCourseID()+"  :  "+course.getCourseName()
					+"  :  "+course.getCourseDuration());
					}
					else {
						System.out.println("Couse Id " +id+" does not exists");
					}
				}
				else if(choice==4) {
					System.out.print("Enter Course ID : ");
					int id = scanner.nextInt();
					Course course  = service.findById(id);
					if(course!=null) {
						System.out.print("Enter New Course Name : ");
						String name = scanner.next();
						System.out.print("Enter New Duration : ");
						float duration = scanner.nextFloat();
						course.setCourseDuration(duration);
						course.setCourseID(id);
						course.setCourseName(name);
						
						service.updateCourse(course);
					}
					else {
						System.out.println("Course Id "+id+" does not exists.");
					}
				}
				else if(choice==5) {
					System.out.print("Enter Course Id : ");
					int id = scanner.nextInt();
					Course course = service.findById(id);
					if(course!=null) {
						System.out.println(service.deleteCourse(id));
					}
					else {
						System.out.println("Course ID "+id+" does not exists.");
					}
				}
				else if(choice==6) {
					flag = false;
				}
				else {
					System.out.println("Enter a valid choice!!");
				}
			}
		};
	}
}
