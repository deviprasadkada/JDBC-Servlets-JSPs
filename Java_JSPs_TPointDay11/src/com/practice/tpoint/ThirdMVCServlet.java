package com.practice.tpoint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdMVCServlet")
public class ThirdMVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ThirdMVCServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");

		ThirdMVCLoginBean bean=new ThirdMVCLoginBean();
		bean.setName(name);
		bean.setPassword(password);
		
		request.setAttribute("bean", bean);
		
		boolean status=bean.validate();
		
		if(status) {
			RequestDispatcher rd=request.getRequestDispatcher("ThirdMVCLoginSuccess.jsp");
			rd.forward(request	, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("ThirdMVCLoginFailure.jsp");
			rd.forward(request	, response);

		}
		
		
		
	}

}
