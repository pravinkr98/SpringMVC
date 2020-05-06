<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<c:choose>
		<c:when test="${!empty listRDTO }">
			<table align="center" border="1" bgcolor="green">
				<tr bordercolor="red">
				<th>EmpNo</th><th>EmpName</th><th>Desg</th><th>Salary</th><th>DeptNo</th><th>MgrNo</th>
				</tr>
				<c:forEach var='dto' items="${listRDTO}">
					<tr bgcolor="orange">
					<td>${dto.empno}</td>
					<td>${dto.ename}</td>
					<td>${dto.job}</td>
					<td>${dto.sal}</td>
					<td>${dto.deptno}</td>
					<td>${dto.mgr}</td>
				</c:forEach>
			</table>
		</c:when>
		
		<c:otherwise>
			<h1 style="color:red;text-align:center">Records not found</h1>
		</c:otherwise>
	</c:choose>
	
	<br><br>
	<h1><a href="home.htm">Home</a></h1>
	