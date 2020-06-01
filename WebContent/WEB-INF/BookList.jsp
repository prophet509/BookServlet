<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Books</h1>
		<h2>
			<a href="/Book/add">Add New Book</a> 
		</h2>
	</div>
	<div align="center">
		<h2>List of books</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Author</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${listBook}" var="book">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><a href="/Book/edit?id=<c:out value='${book.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/Book/delete?id=<c:out value='${book.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>