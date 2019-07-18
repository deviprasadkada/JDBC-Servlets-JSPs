package com.javatpoint.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


/*
 * DML(DATA MANIPULATION LANGUAGE)
 *  Here the sql commands deal with SELECT, INSERT, UPDATE, DELETE
 * 
 * 
 * 		Interfaces									classes
 * 	1)Driver					**					1)DriverManager				**
 *  2)Connection				**					2)SQL Exception				**
 *  3)Statement					**					3)java.sql.date
 * 	4)PreparedStatement			**					4)java.sql.types
 *  5)CallableStatement			**
 *  6)Resultset 				**
 *  7)Resultset MetaData        **
 *  8)DataBaseMetaData          **
 *  9)SavePoint
 *  10)DataSource
 */


public class TestJdbc {

	public TestJdbc() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","prasad");
			System.out.println("connected");



			//****************************Statement***************************
			Statement st=con.createStatement();
			//------retrieving the data Result stmt to display the employees
			ResultSet rs=st.executeQuery("select * from foo");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}

			//-----inserting into foo
			int resultinsert=st.executeUpdate("insert into foo values(6897,'john','nash',35,'68000')");
			System.out.println(resultinsert+"records inserted");
			//-----deleting the records
			int resultdelete=st.executeUpdate("delete from foo where age=35");
			System.out.println(resultdelete+"records deleted");
			//----updating the records
			int resultupdate=st.executeUpdate("update foo set fname='jack', age=26 where myid=6897" );
			System.out.println(resultupdate+"records update");

			ResultSet rs1=st.executeQuery("select * from foo");
			while(rs1.next()) {
				System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));
			}


			//*********************PreparedStatement*************************
			System.out.println("now after using execute update the record updated in table for preparedstatement");
			System.out.println("this is a prepared statement crud operations");

			//****************Inserting data from Sql
			PreparedStatement psmt=con.prepareStatement("insert into foo values(1111,'jack','slater',11,'11111')");
			int i=psmt.executeUpdate();
			//*****************Retrieving data from sql
			PreparedStatement psmt1=con.prepareStatement("select * from foo");
			//int i1=psmt.executeUpdate();
					ResultSet rs2 =psmt1.executeQuery() ;
			while(rs2.next()) {
				System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getString(4));
			}

			//**********************ResultSetMetaData**************************
			//   MetaData means data about data, i.e we can metadata of a table like num of column, column name, column type. 
			ResultSetMetaData rsmd=rs2.getMetaData();
			System.out.println("total cloumns:"+rsmd.getColumnCount());
			System.out.println("column name of 1st name:"+rsmd.getColumnName(1));
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  

			
			
			//*******************DatabaseMetaData Interface********************
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println("driver name::"+dbmd.getDriverName());
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
			
			
			//****************Callable Statement*******************
			//   this is used to call the stored procedures and functions

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}				
	}

	public static void main(String[] args)  {
		System.out.println("start of main method");
		new TestJdbc();
		System.out.println("end of main method");
	}
}
