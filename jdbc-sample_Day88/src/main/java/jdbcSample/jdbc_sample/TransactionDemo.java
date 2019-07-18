package jdbcSample.jdbc_sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionDemo {

	Connection con;
	Statement st;
	 TransactionDemo() {
		int empId=0;
		
		
		
		
		
		
		
		

try {
   Class.forName("com.mysql.cj.jdbc.Driver");
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jun2019?serverTimezone=UTC", "root", "prasad");
   if(con != null) {
    System.out.println("Connected to MYSQL!");
    st = con.createStatement();
    
    int num = st.executeUpdate("insert into emp (fname, lname, age, salary) values ('Robert', 'Miles', 28, 8877.66)");
    ResultSet rs = st.executeQuery("select max(eid) from emp");
    
    while(rs.next()) {
     empId = rs.getInt(1);
    }
    rs.close();
    num += st.executeUpdate("insert into address values ('Edison Glen Terrace', '08837', " + empId + ")");
    System.out.println("Committed!");
   }
  } catch(Exception e) {
   e.printStackTrace();
  }

		
		
		
		
		
		
		
		
		
		
		

	 }

	
	public static void main(String[] args) {
		new TransactionDemo();
	}
	
	
}
	
	
	
