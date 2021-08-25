<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--import spring supplied JSP tag lib to use URL rewriting tags --%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align = center>Welcome to Spring Employee-Department</h1>
	<h3 align = "center">
		<a href="<spring:url value='/department/list'/>">Display Departments</a>
	</h3>
</body>
</html>