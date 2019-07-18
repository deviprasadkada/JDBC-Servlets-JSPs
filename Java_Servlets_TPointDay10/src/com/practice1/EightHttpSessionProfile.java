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
 * Servlet implementation class EightHttpSessionProfile
 */
@WebServlet("/EightHttpSessionProfile")
public class EightHttpSessionProfile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("we are in post method");
       request.getRequestDispatcher("EightHttpSessionLink.html").include(request, response);  
        HttpSession session=request.getSession(false);  
        if(session!=null){  
            String name=(String)session.getAttribute("name");  
              
            out.print("Hello, "+name+" Welcome to Profile");  
            }  
            else{  
                out.print("Please login first");  
                request.getRequestDispatcher("EightHttpSessionLogin.html").include(request, response);  
            }  
            out.close();  
	
	
	}

}
