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
  <%
  String message=(String)session.getAttribute("message");
  if(message!=null){
	  %>
<div class="alert alert-success alert-dismissible">
  <a href="ReturnBook.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong><%= message %></strong>
</div>
  <% 
  session.removeAttribute("message");
  }
  %>
<h1 style="text-align: center; color: green;">There is Data Of Book Table</h1>
<sql:setDataSource driver="com.mysql.cj.jdbc.Driver" var="ds" url="jdbc:mysql://localhost:3306/library_project" user="root" password="4093"/>
<sql:query dataSource="${ds}" var="rs">SELECT * FROM issueBooks where sid='<c:out value="${getsId}"/>' and userbooks>0 and status='Issued';</sql:query>
<a href="UserHome.jsp"><button type="submit" id="changing" class="btn btn-success">Home</button> </a>
<div class="container">
<table class="table">
<tr>
<td>Image</td>
<td>Book Name</td>
<td>Author Name</td>
<td>Status</td>
<td>Student Name</td>
<td>Student Books</td>
<td>Issue Date</td>
<td>Return Date</td>
<td>Return</td>
</tr>

<c:forEach items="${rs.rows}" var="row">
<tr>
<td>
   <c:url var="imageUrl" value="/Book/${row.bookimg}" />
    <img src="${imageUrl}" alt="Book Image" style="max-width: 50px;" />
</td>
<td><c:out value="${row.bookName}" /></td>
<td><c:out value="${row.authorname}" /></td>
<td style="color: blue"><c:out value="${row.status}" /></td>
<td style="color: blue"><c:out value="${row.studentname}" /></td>
<td><c:out value="${row.userbooks}"/></td>
<td style="color: black" ><c:out value="${row.issueDate}" /></td>
<td style="color: blue" ><c:out value="${row.returnDate}" /></td>
<td>
<form action="returnbook" method="post">
    <input type="hidden" name="id" value="${row.id}" />
    <input type="hidden" name="bookid" value="${row.bookid}" />
    <button type="submit" id="changing" class="btn btn-danger">Return</button> 
</form>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>