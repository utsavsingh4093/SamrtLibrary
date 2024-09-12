<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CssFile/AddBook.css">
</head>
<body>
	<div class="login-container">
		<div class="login-box">
			<c:set value="${getid}" var="a"></c:set>
			<c:set value="${getsId}" var="v"></c:set>

			<span style="display: flex; flex-direction: row">
				<h2>Issue Book</h2> <a href="issueBooks.jsp"><button
						style="padding-top: 5px; padding-bottom: 5px; background-color: #dc3545; border-radius: 50px;"
						submit" class="btn">X</button></a>
			</span>
			<form action="issue" method="post">
				<%
				LocalDate date = LocalDate.now();
				%>
				<%
				LocalDate afterday = date.plusDays(30);
				%>
				<input type="hidden" name="id" value='<c:out value="${a}"></c:out>'>
				<input type="hidden" name="sid" value='<c:out value="${v}"></c:out>'>
				<sql:setDataSource driver="${getdriver}" var="ds" url="${geturl}"
					user="${getUser}" password="${getPass}" />
				<sql:query dataSource="${ds}" var="rs">select * from addbook where id='<c:out
						value="${a}"></c:out>';</sql:query>

				<c:forEach items="${rs.rows}" var="row">
					<input type="hidden" name="book"
						value='<c:out value="${row.Book}"></c:out>'>
					<div class="input-group">
						<label for="namebook">Your Name</label> <input type="text"
							name="studentname" id="namebook"
							value='<c:out value="${getName}"></c:out>' readonly>
					</div>
					<div class="input-group">
						<label for="namebook">Name Of Book</label> <input type="text"
							name="bookname" id="namebook" placeholder="Enter Book Name"
							value='<c:out value="${row.BookName}"></c:out>' readonly>
					</div>
					<div class="input-group">
						<label for="authorname">Author Of Book</label> <input type="text"
							name="author" id="authorname"
							placeholder="Enter Book Author Name"
							value='<c:out value="${row.Author}"></c:out>' readonly>
					</div>
					<div class="input-group">
						<label for="quantity">Quantity</label> <input type="text"
							name="quantity" id="getvalue" placeholder="Enter Book Quantity"
							value='<c:out value="${row.Quantity}"></c:out>' readonly>
						<input type="hidden" name="edition" id="edition"
							placeholder="Enter Book Quantity"
							value='<c:out value="${row.edition}"></c:out>' readonly>
					</div>

					<div class="input-group">
						<label id="geting" for="booksquantity">How Many Book
							Quantity You want</label> <input type="text" name="bookquantity"
							id="bookvalue"
							placeholder="Enter Number of Book Quantity you want"
							oninput="datavalue()" required>
						<script src="JavaScript/MyFile.js"></script>
					</div>
					<div class="input-group">
						<input type="hidden" name="avaliableQuantityNow"> <input
							type="hidden" name="status" value="Issued">
					</div>

					<div class="input-group">
						<label for="issuedate">Date Of Issue</label> <input type="text"
							name="issuedate" value="<%out.println(date);%>" readonly>
					</div>

					<div class="input-group">
						<label for="issuedate">Date Of Return</label> <input type="text"
							name="returndate" value="<%out.println(afterday);%>" readonly>
					</div>
				</c:forEach>
				<button id="hidingbutton" type="submit">submit</button>

			</form>
		</div>
	</div>
</body>
</html>
