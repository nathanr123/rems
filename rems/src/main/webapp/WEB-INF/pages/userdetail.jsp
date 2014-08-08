<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<form:form action="updateuserdetail" method="post"
			commandName="userdetailForm">
			<table border="0">
				<c:if test="${not empty msg}">
					<tr>
						<td colspan="2" align="center">${msg}</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo -
							Registration</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="username"
							value="${userdetailForm.getUsername()}" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>

				<tr>
					<td>Mail ID:</td>
					<td><form:input path="mailid" /></td>
				</tr>

				<tr>
					<td>Mobile No:</td>
					<td><form:input path="mobileno" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update User Profile" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>