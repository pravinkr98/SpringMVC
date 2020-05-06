<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<c:choose>
		<c:when test="${!empty listDTO }">
			<table align="center" border="1" bgcolor="cyan">
				<tr bordercolor="red">
				<th>srNo</th><th>EmpNo</th><th>EmpName</th><th>Desg</th><th>Salary</th><th>DeptNo</th>
				</tr>
				<c:forEach var='dto' items="${listDTO}">
					<tr bgcolor="blue">
					<td>${dto.getSrNo()}</td>
					<td>${dto.getEmpNo()}</td>
					<td>${dto.getEName()}</td>
					<td>${dto.getJob()}</td>
					<td>${dto.getSal()}</td>
					<td>${dto.getDeptNo()}</td>				
				</c:forEach>
			</table>
		</c:when>
		
		<c:otherwise>
			<h1 style="color:red;text-align:center">Records not found</h1>
		</c:otherwise>
	</c:choose>
	
	<br><br>
		<h1><a href="welcome.htm">Home</a></h1>
		
	