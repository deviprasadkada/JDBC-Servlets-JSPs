package com.javatpoint.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/*
 * DFL(DATA DEFEINITION LANGUAGE)
 *  Here the sql commands deal with CREATE, DROP, ALTER, TRUNCATE,COMMENT,RENAME,
 * 
 * 
 * 
 */



public class TestJdbc1 {

	public TestJdbc1() {

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","prasad");
		System.out.println("connected");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Create table book(id INT,title VARCHAR(30), author varchar(30))");
		ResultSet rs1=st.executeQuery("select * from book");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
	public static void main(String[] args) {
		new TestJdbc1();
	}
}
