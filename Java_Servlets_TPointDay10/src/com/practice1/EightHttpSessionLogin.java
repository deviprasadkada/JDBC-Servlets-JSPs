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
 * Servlet implementation class EightHttpSessionLogin
 */
@WebServlet("/EightHttpSessionLogin")
public class EightHttpSessionLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       request.getRequestDispatcher("EightHttpSessionLink.html").include(request, response);
       String name=request.getParameter("name");
       String password=request.getParameter("password");
       if(password.equals("admin123")) {
    	   out.println("Welcome::"+name);
    	   HttpSession session=request.getSession();
    	   session.setAttribute("name", name);
       }
       else {
    	   out.println("sorry username or password error!");
    	   request.getRequestDispatcher("EightHttpSessionLogin.html").include(request, response);
       }
		out.close();
		
	}

	}

