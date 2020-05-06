<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<c:choose>
		<c:when test="${!empty listDTO }">
			<table align="center" border="1" bgcolor="cyan">
				<tr bordercolor="red">
				<th>srNo</th><th>EmpNo</th><th>EmpName</th><th>Desg</th><th>Salary</th><th>DeptNo</th><th>Operations</th>
				</tr>
				<c:forEach var='dto' items="${listDTO}">
					<tr bgcolor="pink">
					<td>${dto.getSrNo()}</td>
					<td>${dto.getEmpNo()}</td>
					<td>${dto.getEName()}</td>
					<td>${dto.getJob()}</td>
					<td>${dto.getSal()}</td>
					<td>${dto.getDeptNo()}</td>
					<td><a href="update.htm?empno=${dto.getEmpNo()}"><img src="images/edit.png" width="30" hight="30"></a>&nbsp;&nbsp;
						<a href="delete.htm?empno=${dto.getEmpNo()}" onclick="confirm('Do you want to delete ?')"><img src="images/delete.png" width="30" hight="30"></a></td>
				</c:forEach>
			</table>
		</c:when>
		
		<c:otherwise>
			<h1 style="color:red;text-align:center">Records not found</h1>
		</c:otherwise>
	</c:choose>
	
	<br><br><p align="center">
		<a href="welcome.htm"><img src="images/home.png" width="50" hight="50"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="register.htm"><img src="images/add.png" width="50" hight="50"></a></p><br><br>
		<h1 style="color:red;text-align:center">${resMsg}</h1>
	