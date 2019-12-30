package com.victorvn.hibernate.practice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeManager {
	
	private static SessionFactory factory;
	private static Session newSession;
	
	public static Employee getEmployeeById(int employeeId) {
		
		newSession = createFactory();
		Employee searchedEmployee = new Employee();
		
		try {
			
			newSession.beginTransaction();
			
			searchedEmployee = newSession.get(Employee.class, employeeId);
			
			newSession.getTransaction().commit();
			
		} finally {
			
			factory.close();
		}
		
		return searchedEmployee;		
	}
	
	public static List<Employee> getEmployeesByCompanyName(String companyName){
		
		List<Employee> employeeList;
		
		try {
			
			newSession = createFactory();
			
			newSession.beginTransaction();
			
			employeeList = newSession.createQuery("from Employee e where e.company='"+companyName+"'").getResultList();
			
			newSession.getTransaction().commit();
			
		} finally {
			
			factory.close();
		}		
		
		return employeeList;
	}
	
	
	public static void createEmployee(Employee employee) {
		
		newSession = createFactory();
		
		try {
			
			newSession.beginTransaction();
			
			System.out.println("Saving new employee " + employee.getFirstName() + " "+ employee.getLastName() + " ...");
			newSession.save(employee);
			
			newSession.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}
	
	private static Session createFactory() {	
		
		// Create a session factory
		factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
				
		// create a session
		Session session = factory.getCurrentSession();
		
		return session;
				
	}

}
