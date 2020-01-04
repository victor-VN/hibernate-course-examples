package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCourseForJohnDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse2 = new Course("PacMan - Advanced ");
			
			// save the course
			System.out.println("Saving the course ...");
			session.save(tempCourse2);
			System.out.println("Course: "+ tempCourse2.getTitle() + " saved");
			
			// create the students
			Student tempStudent1 = new Student("my@email.com", "John", "Doe");
			Student tempStudent2 = new Student("myrita@email.com", "Rita", "Claire");
			
			// add students to the course
			System.out.println("Saving the students ...");
			tempCourse2.addStudent(tempStudent1);
			tempCourse2.addStudent(tempStudent2);
			System.out.println("Students Saved!");
			
			// save the students			
			System.out.println("Saving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
		

	}

}
