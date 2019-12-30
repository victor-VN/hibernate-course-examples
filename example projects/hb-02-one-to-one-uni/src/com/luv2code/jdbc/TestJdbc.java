package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "root";
		String pass= "";
		
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successfull!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
