<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<style type="text/css">
fieldset {
	border: 1px solid #dedede;
}

legend {
	font-size: 20px;
	text-transform: uppercase;
}

.error {
	color: red;
}

.resltTable {
	width: 50%;
	border-collapse: collapse;
	border-spacing: 0px;
}

.resltTable td, .resltTable th {
	border: 1px solid #565454;
}
</style>
</head>
<body>
	<fieldset>
		<legend>Please log in.</legend>
		${errorMessage}
		<form:form action="login" method="post" modelAttribute="user">
			<table>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /> <form:errors path="email"
							cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td>password</td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
	<br>
	<br>


</body>
</html>