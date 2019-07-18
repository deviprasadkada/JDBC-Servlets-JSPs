package jdbcSample.jdbc_sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class QueryParams {

	
	Connection con;
	Statement st;
	
	public QueryParams(String name, double sal) {
		// TODO Auto-generated constructor stub

try {
   Class.forName("com.mysql.cj.jdbc.Driver");
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jun2019?serverTimezone=UTC", "root", "prasad");
    System.out.println("Connected to MYSQL!");
    st = con.createStatement();
    
    st.executeUpdate("update emp set salary="+sal+"where fname='" +name+"'");
   
    PreparedStatement ps=con.prepareStatement("update emp set salary=? where fname=?");
   ps.setDouble(1, sal);
   ps.setString(2, name);
   int x=ps.executeUpdate();
   System.out.println(x);
   }
   catch(Exception e) {
   e.printStackTrace();
  }
	}
	
	public static void main(String[] args) {
		new QueryParams("john", 6666.66);
	}
	
	
}
	
	
	
	
	