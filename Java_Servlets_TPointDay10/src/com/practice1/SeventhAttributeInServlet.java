package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeventhAttributeInServlet
 */

/*
 * Attribute in Servlet
An attribute in servlet is an object that can be set, get or removed from one of the following scopes:
1.request scope
2.session scope
3.application scope
The servlet programmer can pass informations from one servlet to another using attributes. 
It is just like passing object from one class to another so that we can reuse the same object again and again.
 * 
 * 
 */




@WebServlet("/SeventhAttributeInServlet")
public class SeventhAttributeInServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		  
		ServletContext context=getServletContext();  
		context.setAttribute("company","IBM");  
		  
		out.println("Welcome to first servlet");  
		out.println("<a href='servlet2'>visit</a>");  
		out.close();  
		  
		String n=(String)context.getAttribute("company");  
		  
		out.println("Welcome to "+n);  
		  
		  
		
	}

}
