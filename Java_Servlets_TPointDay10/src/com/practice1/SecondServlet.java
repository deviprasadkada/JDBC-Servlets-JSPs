package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet implements Servlet {
       
    public SecondServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	System.out.println("this is a init method");
	}
	

	public void destroy() {
		System.out.println("Servlet is destroyed");
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("this is a service method");
	response.setContentType("text/html");
	PrintWriter  out=response.getWriter();
	out.println("<html><body>HI iam from servlet </body></html>");
	
	response.sendRedirect("http://www.google.com");  
	out.close();
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
