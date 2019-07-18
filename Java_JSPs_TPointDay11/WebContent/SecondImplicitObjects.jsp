<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- JSPs Implicit Objects -->


<!-- *************Request -->
<% 
String name=request.getParameter("name");
out.println("Welcome::"+name);
%>


<!-- ******************2. Response -->
<!--  response.sendRedirect("https://www.javatpoint.com/jsp-declaration-tag");  -->

<!-- *****************3.Jsp Config  -->
<%
out.print("Welcome "+request.getParameter("uname"));  
String driver=config.getInitParameter("dname");  
out.print("driver name is="+driver); 
%>
<!-- ******************4.Jsp Application -->
<%   
  
out.print("Welcome "+request.getParameter("uname"));  
  
String driver1=application.getInitParameter("dname");  
out.print("driver name is="+driver1);  		
  
%>  

<!-- ****************5. Session Object -->
<%   
  
out.print("Welcome "+name);  
  
session.setAttribute("user",name);  
  
  
%>  



</body>
</html>