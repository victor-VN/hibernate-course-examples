package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)								
								.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			/*Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"https://www.udemy.com/course/spring-hibernate", 
							"To play FIFA!!");
			
			// associate the objects		
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			*/
			
			Instructor tempInstructor = 
					new Instructor("Josh", "Darby", "josh@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"https://www.udemy.com/course/spring-hibernate", 
							"To play GOW!!");
			
			// associate the objects		
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO  save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: "+ tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		

	}

}
