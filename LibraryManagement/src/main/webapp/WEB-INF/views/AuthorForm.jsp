<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author Entry</title>
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
		<legend>Author Input Form: </legend>
		<h4>${sessionScope["userEmail"]}</h4>
		<form:form action="saveAuthor" method="post" modelAttribute="author">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /> <form:errors
							path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
				<td>Last Name</td>
					<td><form:input path="lastName" /> <form:errors
							path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
	<br>
	<br>
	<fieldset>
		<legend>Author List</legend>
		<table class="resltTable">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<c:forEach items="${authors}" var="author">
				<tr>
					<td>${author.firstName}</td>
					<td>${author.lastName}</td>
					<td><a href="getAuthor?id=${author.id}"> Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</fieldset>

</body>
</html>