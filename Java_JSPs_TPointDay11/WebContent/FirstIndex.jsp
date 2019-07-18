<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--  *************************************************JSP sciplet tag*******************************************
A scriptlet tag is used to execute java source code in JSP
-->
<%out.print(2*5); %>
<%
String name=request.getParameter("name");
out.println("welcome::"+name);
%>

<!-- ***************************************************JSP Expression tag*********************************** 
The code placed within JSP expression tag is written to the output stream of the response.
 So you need not write out.print() to write data. 
It is mainly used to print the values of variable or method.
-->
<br>
<%= "Welcome to jsp, this is a jsp expression tag" %>
<br>
Current time::<%= java.util.Calendar.getInstance().getTime() %>
<%= "welcome"+request.getParameter("name") %>


<!-- ****************************************************JSP declaration tag*********************************
The JSP declaration tag is used to declare fields and methods.
The code written inside the jsp declaration tag is placed outside the service() method of auto generated servlet.
So it doesn't get memory at each request.
 -->
<%! int data=50;%>
<%="welcome ur data is:"+data %>

</body>
</html>