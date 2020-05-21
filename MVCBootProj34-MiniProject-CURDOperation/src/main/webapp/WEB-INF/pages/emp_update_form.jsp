<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	<form:form modelAttribute="empCmd">
	<table align="center" border="0" bgcolor="cyan">
		<tr><td>Employee no. ::</td><td><form:input path="empNo"/></td></tr>
		<tr><td>Name ::</td><td><form:input path="eName"/></td></tr>
		<tr><td>Desig ::</td><td><form:input path="job"/></td></tr>
		<tr><td>Salary ::</td><td><form:input path="sal"/></td></tr>
		<tr><td>Dept No. ::</td><td><form:input path="deptNo"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="UpdateEmployee"></td></tr>
	</table>
	
	</form:form>
    