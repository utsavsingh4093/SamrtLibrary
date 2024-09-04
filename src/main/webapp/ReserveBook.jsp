<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<h1 style="text-align: center; color: blue;">This is Reserve Books
		Details</h1>
		<a href="UserHome.jsp"><button style="margin-left: 30px;border-radius: 50px;" type="submit" class="btn btn-danger">Go Back</button></a>
	<sql:setDataSource driver="com.mysql.cj.jdbc.Driver" var="ds"
		url="jdbc:mysql://localhost:3306/library_project" user="root"
		password="4093" />
	<sql:query dataSource="${ds}" var="rs">select * from issueBooks where status='Reserved' and sid='<c:out
			value="${getsId}" />';</sql:query>
	<div class="container">
		<table class="table">
			<tr>
				<td>Image</td>
				<td>Book Name</td>
				<td>Author Name</td>
				<td>Edition</td>
				<td>Book Quantity</td>
				<td>issue Date</td>
				<td>Return Date</td>
				<td>status</td>
			</tr>

			<tbody id="myTable">
				<c:forEach items="${rs.rows}" var="row">
					<tr>
						<td><a href="issueBooks.jsp"><c:url var="imageUrl"
									value="/Book/${row.bookimg}" /> <img src="${imageUrl}"
								alt="Book Image" style="max-width: 50px;" /></a></td>
						<td><c:out value="${row.bookname}"></c:out></td>
						<td><c:out value="${row.authorname}"></c:out></td>
						<td><c:out value="${row.edition}" /></td>
						<td><c:out value="${row.userbooks}" /></td>
						<td><c:out value="${row.issuedate}" /></td>
						<td><c:out value="${row.returndate}" /></td>
						<td><c:out value="${row.status}"></c:out>
						<td>
					</tr>
				</c:forEach>
			<tbody>
		</table>
	</div>
</body>
</html>