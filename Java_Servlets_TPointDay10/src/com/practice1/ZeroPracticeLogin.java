package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ZeroPracticeLogin
 */
@WebServlet("/ZeroPracticeLogin")
public class ZeroPracticeLogin extends HttpServlet {
	// the difference between the get and post method is we can see the 
	//username and password in the url in get method and we cant see the usernae and password in post method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("we are in get method");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		// this is one way to get the output of a number by using the requestparameter
		String n=request.getParameter("name");
		out.println("welcome::"+n);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("we are in post method");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		// this is one way to get the output of a number by using the HttpSession
	HttpSession session=request.getSession(false);
	String n=(String) session.getAttribute("password");
	out.println("hello ur password is::"+n);
	out.close();
	}

}
