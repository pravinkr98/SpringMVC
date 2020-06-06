<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color:blue;text-align:center">Faculty page</h1>
    <br>
    <b>Current username is <%=request.getUserPrincipal().getName() %></b>
	<br>
	<a href="admin.jsp">Go to Admin page</a><br>
	<a href="../index.jsp">home</a><br><br><br>
	<a href="../logout">logout</a>