<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>

<body>
	<div class="div1">
		<table>
			<tr>
				<td>Department Name</td>
				<td>Location</td>
				<td>Strength</td>
			</tr>
			<c:forEach var="detail" items="${sessionScope.dept_details}">
				<tr>
					<td><a href="<spring:url value='/employee/hire?dept_name=${detail.deptName}'/>">${detail.deptName}</a></td>
					<td>${detail.location}</td>
					<td>${detail.strength}</td>
					</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>