<%@page import="com.dto.BookUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Data</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 style="text-align: center; color: green;">There is Data Of
		Book Table</h1>
	<a href="AdminHome.jsp"><button style="margin-left: 30px"
			type="submit" class="btn btn-danger">Go Back</button></a>
	<sql:setDataSource driver="${getdriver}" var="ds" url="${geturl}"
		user="${getUser}" password="${getPass}" />
	<sql:query dataSource="${ds}" var="rs">SELECT * FROM addbook where adminName='<c:out value="${getAdminName}"></c:out>';</sql:query>
	<div class="container">
		<table class="table">
			<tr>
				<td>Image</td>
				<td>Book Name</td>
				<td>Author Name</td>
				<td>Edition</td>
				<td>Quantity</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			<c:forEach items="${rs.rows}" var="row">
				<tr>
					<td><a href="issuebooks?id=${row.id}"><c:url
								var="imageUrl" value="/Book/${row.Book}" /> <img
							src="${imageUrl}" alt="Book Image" style="max-width: 50px;" /></a></td>

					<td><c:out value="${row.BookName}" /></td>
					<td><c:out value="${row.Author}" /></td>
					<td><c:out value="${row.Edition}" /></td>
					<td>
                        <c:choose>
                            <c:when test="${row.quantity < 0}">
                                0
                            </c:when>
                            <c:otherwise>
                                <c:out value="${row.quantity}" />
                            </c:otherwise>
                        </c:choose>
                    </td>
					<td>
						<form action="deletebook" method="post">
							<input type="hidden" name="id" value="${row.id}" />
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</td>
					<td>
						<form action="editdatabook" method="post">
							<input type="hidden" name="id" value="${row.id}" />
							<button type="submit" class="btn btn-success">Edit</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
