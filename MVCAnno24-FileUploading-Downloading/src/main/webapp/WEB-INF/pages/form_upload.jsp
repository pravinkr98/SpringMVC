<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <h1 style="color:red;text-align:center">File Uploading</h1>
    
    <form:form method="POST" enctype="multipart/form-data" modelAttribute="uplCmd">
    	<table bgcolor="cyan" align="center">
    		<tr><td>Emp name :::</td><td><form:input path="ename"/></td></tr>
    		<tr><td>Emp address :::</td><td><form:input path="eaddrs"/></td></tr>
    		<tr><td>Photo upload :::</td><td><form:input type="file" path="ephoto"/></td></tr>
    		<tr><td>Resume upload :::</td><td><form:input type="file" path="eresume"/></td></tr>
			<tr><td colspan="2"><input type="submit" value="Upload"></td></tr>    		
    	</table>    
    </form:form>
    
    <br><br>
    <a href="listDown.htm">List all uploaded file</a>
    
    
    
