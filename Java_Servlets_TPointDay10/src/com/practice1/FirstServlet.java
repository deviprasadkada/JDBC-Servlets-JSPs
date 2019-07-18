package com.practice1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */

/* Servlet Interface
public void init(ServletConfig config)										initializes the servlet. It is the life cycle method of servlet and invoked by the web container only once.
public void service(ServletRequest request,ServletResponse response)		provides response for the incoming request. It is invoked at each request by the web container.
public void destroy()														is invoked only once and indicates that servlet is being destroyed.
public ServletConfig getServletConfig()										returns the object of ServletConfig.
public String getServletInfo()												returns information about servlet such as writer, copyright, version etc.

*/

/*interfaces 	              					Classes
 * 							
 * 1.servlet									1.Servlet Exception
 * 2.ServletRequest								2.Generic Servlet Abstract Class
 * 3.ServletResponse                        	3.Http Servlet Abstract Class
 * 4.HttpServletRequest							4.Cookies
 * 5.HttpServletRresponse
 * 6.RequestDispatcher
 * 7.ServletCOnfig
 * 8.ServletContext
 * 9.Filter
 * 10.HttpSession
 * 
 * 
 * 
 */


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("this is init method");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("THis is destroy method");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("this is a service methos");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>i am invincible</h1></body></html>");
	}

}
