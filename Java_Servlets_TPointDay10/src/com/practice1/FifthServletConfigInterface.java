package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * ServletConfig Interface
An object of ServletConfig is created by the web container for each servlet.
 This object can be used to get configuration information from web.xml file.
 Advantage
 The core advantage of ServletConfig is that you don't need to edit the servlet file if
  information is modified from the web.xml file.


 */


/**
 * Servlet implementation class FifthServletConfigInterface
 */
@WebServlet("/FifthServletConfigInterface")
public class FifthServletConfigInterface extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	      
	    ServletConfig config=getServletConfig();  
	   // String driver=config.getInitParameter("driver");  
	    //out.print("Driver is: "+driver);  
	    
	    Enumeration<String> e=config.getInitParameterNames();  
        
	    String str="";  
	    while(e.hasMoreElements()){  
	    str=e.nextElement();  
	    out.print("<br>Name: "+str);  
	    out.print(" value: "+config.getInitParameter(str));  
	    }  
	    
	    out.close();  
	}

}
