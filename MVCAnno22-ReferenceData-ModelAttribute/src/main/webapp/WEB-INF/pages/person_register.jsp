<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <h1 style="color:blue;text-align:center">Person Registration</h1>
    
    <form:form modelAttribute="perCmd">
    	<table bgcolor="cyan" align="center">
    	<p style="color:red">
    		<form:errors path="*"/>
    	</p>
    		<tr>
    			<td>Person name::</td>
    			<td><form:input path="name"/></td>
    		</tr>
    		<tr>
    			<td>Person age::</td>
    			<td><form:input path="age"/></td>
    		</tr>
    		<tr>
    			<td>Gender::</td>
    			<td><form:radiobuttons path="gender" items="${gendersList}"/></td>
    		</tr>
    		<tr>
    			<td>Hobbies::</td>
    			<td><form:checkboxes items="${hobiesList}"  path="hobies"/></td>
    		</tr>
    		<tr>
    			<td>Qulification::</td>
    			<td><form:select path="qlfy" multiple="no">
    					<form:options items="${qlfyList}"/>
    				</form:select></td>
    		</tr>
    		<tr>
    			<td>Courses::</td>
    			<td><form:select path="courses" multiple="yes">
    					<form:options items="${coursesList}"/>
    				</form:select></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="Register"></td>
    		</tr>
    	</table>
    </form:form>
    