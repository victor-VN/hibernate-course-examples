package com.victorvn.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemoApp {

	public static void main(String[] args) {
		
		
		//Employee employee = new Employee("Victor", "Nascimento", "Google");
		
		//EmployeeManager.createEmployee(employee);
		
		// Employee retrievedEmployeee = EmployeeManager.getEmployeeById(1);
		
		// System.out.println(retrievedEmployeee);
		
		List<Employee> employees = EmployeeManager.getEmployeesByCompanyName("Google");
		
		for(Employee emp : employees) {
			System.out.println(emp.getFirstName());
		}

	}

}
