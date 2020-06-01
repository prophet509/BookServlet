<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
	<div align="center">
		<h1>
			<c:if test="${book !=null }">Edit Book</c:if>
			<c:if test="${book == null }">Add Book</c:if>
		</h1>
	</div>
	<div align="center">
		<form method="post">
			<table border="1">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" size="50"
						required="required" value="<c:out value='${book.name}' />" /></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input type="text" name="author" size="50"
						value="<c:out value='${book.author }'/>" /></td>
				</tr>
			</table>
			<input type="submit" value="Save" />
		</form>

	</div>
</body>
</html>