<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
    
    <c:choose>
    	<c:when test="${!empty filesList}">
    		<table align="center" border="1" bgcolor="orange">
    			<tr><th>filename</th><th>operation</th></tr>
    			
    			<c:forEach var="fname" items="${filesList}">
    				<tr>
    				<td>${fname}</td>
    				<td><a href="download.htm?fileName=${fname}">download</a></td>
    				</tr>
    			</c:forEach>
    		</table>
    	</c:when>
    	<c:otherwise>
    		<h1 style="color:red;text-align:center">File not available.</h1>
    	</c:otherwise>
    </c:choose>

    <br><br>
    <a href="upload.htm">Home</a>