<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    
    <h1 style="coloe:red;text-align:center">Corona Patient Registration</h1>
    
    <form:form modelAttribute="patCmd">
    	<p color="red">
    		<li><form:errors path="*"/></li>
    	</p>
    	<table bgcolor="cyan" align="center">
    		<tr>
    			<td>Patient Name::</td>
    			<td><form:input path="patName"/></td>
    		</tr>
    		<tr>
    			<td>Patient Address::</td>
    			<td><form:input path="patAdd"/></td>
    		</tr>
    		<tr>
    			<td>Patient Age::</td>
    			<td><form:input path="age"/></td>
    		</tr>
    		<tr>
    			<td>Patient Gender::</td>
    			<td><form:radiobutton path="gender" value="male" checked="checked"/>Male &nbsp;&nbsp;
    				<form:radiobutton path="gender" value="female"/>FeMale</td>
    		</tr>
    		<tr>
    			<td>Patient Stage::</td>
    			<td><form:select path="stage">
    					<form:option value="Stage1" name="stage1"/>
    					<form:option value="Stage2" name="stage2"/>
    					<form:option value="Stage3" name="stage3"/>
    					<form:option value="Stage4" name="stage4"/>
    				</form:select></td>
    		</tr>
    		<tr>
    			<td>Patient Hospital::</td>
    			<td><form:input path="hospital"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="register"></td>
    			<td><input type="reset" value="cancel"></td>
    		</tr>
    	</table>
    	
    </form:form>
