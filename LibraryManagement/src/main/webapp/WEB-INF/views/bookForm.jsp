<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Entry</title>
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
		<legend>Book Input Form: </legend>
		<h4>${sessionScope["userEmail"]}</h4>
		<form:form action="saveBook" method="post" modelAttribute="book">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>Title</td>
					<td><form:input path="title" /> <form:errors path="title"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><form:select path="author" items="${authors}" /></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><form:select path="category" items="${categories}" /></td>
				</tr>

				<tr>
					<td>Publisher</td>
					<td><form:select path="publisher" items="${publisherMap}" /></td>
				</tr>
				<tr>
					<td>Year Published</td>
					<td><form:input path="publicationYear" /></td>
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
		<legend>Book List</legend>
		<table class="resltTable">
			<tr>
				<th>Title</th>
				<th>Authors</th>
				<th>Category</th>
				<th>Publisher</th>
				<th>Year</th>
			</tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.author.firstName}&nbsp;${book.author.lastName} </td>
					<td>${book.category.name}</td>
					<td>${book.publisher.name}</td>
					<td>${book.publicationYear}</td>
					<td><a href="getBook?id=${book.id}"> Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</fieldset>

</body>
</html>