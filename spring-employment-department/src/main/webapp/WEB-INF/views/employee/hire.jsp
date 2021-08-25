<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	background-color:rgba(53,48,63);
}
.div1{
	margin: auto;
	margin-top : 100px;
	width : 400px;
	border : 2px white solid;
	color : white;
	padding : 10px;
}
table{

}
table, tr, td{
	padding : 5px;
}
</style>

</head>
<body>
<div class= "div1">
	<form:form method="post" modelAttribute="employee">

		<table style = "margin: auto;">
			<tr>
				<td>Enter name</td>
				<td><form:input path="empName" /></td>
				<td><form:errors path="empName"/></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><form:input type="email" path="email" required="true"/></td>
				</tr>
			<tr>
				<td>Enter Date of Birth</td>
				<td><form:input type="date" path="DoB" /></td>
				<td><form:errors path="DoB"/></td>
			</tr>
			<tr>
				<td>Enter Salary</td>
				<td><form:input type="text" path="salary" /></td>
				<td><form:errors path="salary"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Hire Employee" /></td>
			</tr>
		</table>
	</form:form>
	<h5 style="color:red; text-align:center;">${requestScope.msg}</h5>
</div>
</body>
</html>