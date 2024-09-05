<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Data</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<c:set value="${getBookId}" var="a"></c:set>
<h1 style="text-align: center; color: green;">There is Data Of Issue Books Table</h1>
<sql:setDataSource driver="${getdriver}" var="ds" url="${geturl}" user="${getUser}" password="${getPass}"/>
<sql:query dataSource="${ds}" var="rs">select issuebooks.id,addbook.Quantity,issuebooks.bookimg,issuebooks.studentname,issuebooks.bookname,issuebooks.status,issuebooks.userbooks,issuebooks.issuedate,issuebooks.returndate,issuebooks.authorname from student inner join issuebooks on student.id = issuebooks.sid inner join addbook on addbook.id = issuebooks.bookid where addbook.id='<c:out value="${a}"></c:out>' and issuebooks.status<>'NotIssued';</sql:query>

<a href="ViewBook.jsp"><button style="margin-left: 30px" type="submit" class="btn btn-success">Back</button></a>

<div class="container">
<table class="table">
<tr>
<td>Book</td>
<td>Author</td>
<td>Studant_Name</td>
<td>Available_Book_Quantity</td>
<td>User_book_issued</td>
<td>Status</td>
<td>Issue Date</td>
<td>Return Date</td>
</tr>

<c:forEach items="${rs.rows}" var="row">
<tr>
<td><c:out value="${row.bookName}" /></td>
<td><c:out value="${row.authorname}" /></td>
<td><c:out value="${row.studentname}" /></td>
<td><c:out value="${row.quantity}" /></td>
<td><c:out value="${row.userbooks}"/></td>
<td><c:out value="${row.status}"/></td>
<td><c:out value="${row.issueDate}" /></td>
<td><c:out value="${row.returnDate}" /></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>