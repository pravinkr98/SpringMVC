<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color:red;text-align:center">Access Denied page</h1>
    
    <b><%=request.getUserPrincipal().getName() %> is not authorized to access page</b>
	<br><br>
	<a href="home.htm">home</a><br>
	<a href="logout">logout</a>