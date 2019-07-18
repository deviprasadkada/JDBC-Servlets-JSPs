package jdbcSample.jdbc_sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestDB {

	Connection con;
	Statement st;
	
	TestDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jun2019?serverTimezone=UTC","root","prasad");
		if(con!=null) {
			System.out.println("connected to mysql");
			st=con.createStatement();
			//int num=st.executeUpdate("insert into emp(fname,lname,age,salary) values('john','williams',25,8794.45)");
			//num+=st.executeUpdate("insert into emp(fname,lname,age,salary) values('Tom','Hanks',28,7484.45)");
			//System.out.println(num+"rows inserted");
		}
		}
	catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void fetchEmployees() {
		try {
			ResultSet rs=st.executeQuery("select * from emp");
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			
			
			while(rs.next()) {
			for(int i=1;i<count;i++) {
				System.out.println(rs.getString(i));
				//System.out.println("========");
			}
			System.out.println("******");
			
			/*   for resltset simple while loop
			 * 		while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getDouble(5));
				System.out.println("===============");
			}
		*/
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new TestDB().fetchEmployees();

	}

}
