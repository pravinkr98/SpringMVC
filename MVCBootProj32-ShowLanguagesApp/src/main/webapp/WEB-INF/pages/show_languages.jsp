<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	
	<h1 style="color:red;text-align:center"><u>All Languages are ::</u></h1>
	
	<c:choose>
		<c:when test="${!empty langList}">
			<ul>
				<c:forEach var="lang" items="${langList}">
					<li>${lang}</li>					
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<h1 style="color:red;text-align:center">Language not availabe</h1>
		</c:otherwise>
	</c:choose>
	
	
	
    