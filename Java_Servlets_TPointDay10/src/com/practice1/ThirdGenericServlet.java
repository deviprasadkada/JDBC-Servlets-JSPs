package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


/*
 * GenericServlet class implements Servlet, ServletConfig and Serializable interfaces. 
 * It provides the implementation of all the methods of these interfaces except the service method.
 */


@WebServlet("/ThirdGenericServlet")
public class ThirdGenericServlet extends GenericServlet {
       
    public ThirdGenericServlet() {
        super();
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>hello this is from generic servlet</body></html>");
		
	
	}

}
