package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * ServletContext Interface
An object of ServletContext is created by the web container at time of deploying the project. 
This object can be used to get configuration information from web.xml file. 
There is only one ServletContext object per web application.
 * Advantages::
 * Easy to maintain if any information is shared to all the servlet, 
 * it is better to make it available for all the servlet. 
 * We provide this information from the web.xml file, so if the information is changed, we don't need to modify the servlet. 
 * Thus it removes maintenance problem.


 */


/**
 * Servlet implementation class SixthServletContextInterface
 */
@WebServlet("/SixthServletContextInterface")
public class SixthServletContextInterface extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();  
		  
		//creating ServletContext object  
		ServletContext context=getServletContext();  
		  
		//Getting the value of the initialization parameter and printing it  
		String driverName=context.getInitParameter("dname");  
		pw.println("driver name is="+driverName);  
		  
	
		Enumeration<String> e=context.getInitParameterNames();  
	      
		String str="";  
		while(e.hasMoreElements()){  
		    str=e.nextElement();  
		    pw.print("<br> "+context.getInitParameter(str));  
		}  
		
		pw.close();  
	}

}
