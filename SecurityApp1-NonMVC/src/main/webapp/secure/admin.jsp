<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color:blue;text-align:center">Admin page</h1>
    <br>
    <b>Current username is <%=request.getUserPrincipal().getName() %></b>
	<br>
	<a href="faculty.jsp">Go to Faculty page</a><br>
	<a href="../index.jsp">home</a><br><br><br>
	<a href="../logout">logout</a>