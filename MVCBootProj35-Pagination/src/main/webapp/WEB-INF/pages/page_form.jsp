<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <h1 style="color:red;text-align:center">Pagination Form Page</h1>
    
    <form:form modelAttribute="pageCmd" action="report.htm">
    	Enter Page size ::<form:input path="pageSize"/>
    	<form:hidden path="pageNo"/>
    	<input type="submit" value="Show Report">
    </form:form>
