package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  <servlet>
  <servlet-name>FourthRequestDispatcherValidate</servlet-name>
  <servlet-class>FourthRequestDispatcherValidate</servlet-class>
  </servlet>
  <servlet>
  <servlet-name>FourthRequestDispatcher</servlet-name>
  <servlet-class>FourthRequestDispatcher</servlet-class>
  </servlet>
  <servlet-mapping>
  <servlet-name>FourthRequestDispatcherValidate</servlet-name>
  <url-pattern>FourthRequestDispatcherValidate</url-pattern>
  </servlet-mapping> 
  
  <servlet-mapping>
  <servlet-name>FourthRequestDispatcher</servlet-name>
  <url-pattern>FourthRequestDispatcher</url-pattern>
  </servlet-mapping> 
 */

/**
 * Servlet implementation class FourthRequestDispatcherValidate
 */
@WebServlet("/FourthRequestDispatcherValidate")
public class FourthRequestDispatcherValidate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			String name=request.getParameter("userName");
			String password=request.getParameter("password");
			
			if(password.equals("kada")) {
				RequestDispatcher rd=request.getRequestDispatcher("FourthRequestDispatcher");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("FourthRequestDispatcherIndex.html");
				rd.include(request, response);
			}
			
		
	}finally {
		out.close();
	}
	}
}
