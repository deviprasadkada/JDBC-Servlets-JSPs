package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * this program is an integration of the html page with servlet, 
 * we wrote an html document of login form and displayed the data on another webpage using servlet 
 * 
 * 
 * RequestDispatcher is an interface, implementation of which defines an object 
 * which can dispatch request to any resources(such as HTML, Image, JSP, Servlet) on the server.
*
*void forward(ServletRequest request, ServletResponse response)	
*forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server
*void include(ServletRequest request, ServletResponse response)
*	includes the content of a resource (servlet, JSP page, HTML file) in the response

 * 
 */


@WebServlet("/FourthRequestDispatcher")
public class FourthRequestDispatcher extends HttpServlet {
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String n=request.getParameter("userName");
	String p=request.getParameter("password");
	out.println("Welcome:"+n);
	out.println("\nur password is:"+p);
	
	}

}
