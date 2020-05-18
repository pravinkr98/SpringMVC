<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <h1 style="color:red;text-align:center">Login Page</h1>
    
    <form:form modelAttribute="userCmd">
    	<table bgcolor="pink" align="center">
    		<tr>
    			<td>Username ::</td>
    			<td><form:input path="userName"/></td>
    		</tr>
    		<tr>
    			<td>Password ::</td>
    			<td><form:input path="password"/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="Login"></td>
    		</tr>
    	</table>
    </form:form>
    <br>
    <c:if test="${!empty loginMsg}">
    	${loginMsg}
    </c:if>
    
