package com.jsf.crud.db.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
 
import javax.faces.context.FacesContext;
 
import com.jsf.crud.StudentBean;
 
public class DatabaseOperation {
 
    public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;
 
    public static Connection getConnection(){  
        try{  
            /*Class.forName("com.mysql.jdbc.Driver");     
            String db_url ="jdbc:mysql://localhost:3306/students",
                    db_userName = "root",
                    db_password = "";*/
            // OK
            Class.forName("oracle.jdbc.driver.OracleDriver");     
            String db_url ="jdbc:oracle:thin:@localhost:1521:XE",
                    db_userName = "system",
                    db_password = "marlabs";
            connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
        } catch(Exception sqlException) {  
            sqlException.printStackTrace();
        }  
        return connObj;
    }
 
    public static ArrayList getStudentsListFromDB() {
        ArrayList studentsList = new ArrayList();  
        try {
            stmtObj = getConnection().createStatement();    
            resultSetObj = stmtObj.executeQuery("select * from student_record");    
            while(resultSetObj.next()) {  
                StudentBean stuObj = new StudentBean(); 
                stuObj.setId(resultSetObj.getInt("student_id"));  
                stuObj.setName(resultSetObj.getString("student_name"));  
                stuObj.setEmail(resultSetObj.getString("student_email"));  
                stuObj.setPassword(resultSetObj.getString("student_password"));  
                stuObj.setGender(resultSetObj.getString("student_gender"));  
                stuObj.setAddress(resultSetObj.getString("student_address"));  
                studentsList.add(stuObj);  
            }   
            System.out.println("Total Records Fetched: " + studentsList.size());
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        } 
        return studentsList;
    }
 
    public static String saveStudentDetailsInDB(StudentBean newStudentObj) {
        int saveResult = 0;
        String navigationResult = "";
        long myId = 0;
        try {
            String sqlIdentifier = "select studsequence.NEXTVAL from dual";
            PreparedStatement pst = getConnection().prepareStatement(sqlIdentifier);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                myId = rs.getLong(1);
            }
            pstmt = getConnection().prepareStatement("insert into student_record values (?, ?, ?, ?, ?, ?)");         
            pstmt.setLong(1, myId);
            pstmt.setString(2, newStudentObj.getName());
            pstmt.setString(3, newStudentObj.getEmail());
            pstmt.setString(4, newStudentObj.getPassword());
            pstmt.setString(5, newStudentObj.getGender());
            pstmt.setString(6, newStudentObj.getAddress());
            saveResult = pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        if(saveResult !=0) {
            navigationResult = "studentsList.jsf?faces-redirect=true";
        } else {
            navigationResult = "createStudent.jsf?faces-redirect=true";
        }
        return navigationResult;
    }
 
    public static String editStudentRecordInDB(int studentId) {
        StudentBean editRecord = null;
        System.out.println("editStudentRecordInDB() : Student Id: " + studentId);
 
        /* Setting The Particular Student Details In Session */
        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
 
        try {
            stmtObj = getConnection().createStatement();    
            resultSetObj = stmtObj.executeQuery("select * from student_record where student_id = "+studentId);    
            if(resultSetObj != null) {
                resultSetObj.next();
                editRecord = new StudentBean(); 
                editRecord.setId(resultSetObj.getInt("student_id"));
                editRecord.setName(resultSetObj.getString("student_name"));
                editRecord.setEmail(resultSetObj.getString("student_email"));
                editRecord.setGender(resultSetObj.getString("student_gender"));
                editRecord.setAddress(resultSetObj.getString("student_address"));
                editRecord.setPassword(resultSetObj.getString("student_password")); 
            }
            sessionMapObj.put("editRecordObj", editRecord);
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/editStudent.jsf?faces-redirect=true";
    }
 
    public static String updateStudentDetailsInDB(StudentBean updateStudentObj) {
        try {
            pstmt = getConnection().prepareStatement("update student_record set student_name=?, student_email=?, student_password=?, student_gender=?, student_address=? where student_id=?");    
            pstmt.setString(1,updateStudentObj.getName());  
            pstmt.setString(2,updateStudentObj.getEmail());  
            pstmt.setString(3,updateStudentObj.getPassword());  
            pstmt.setString(4,updateStudentObj.getGender());  
            pstmt.setString(5,updateStudentObj.getAddress());  
            pstmt.setInt(6,updateStudentObj.getId());  
            pstmt.executeUpdate();
            connObj.close();            
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return "/studentsList.jsf?faces-redirect=true";
    }
 
    public static String deleteStudentRecordInDB(int studentId){
        System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
        try {
            pstmt = getConnection().prepareStatement("delete from student_record where student_id = "+studentId);  
            pstmt.executeUpdate();  
            connObj.close();
        } catch(Exception sqlException){
            sqlException.printStackTrace();
        }
        return "/studentsList.jsf?faces-redirect=true";
    }
}
