<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Books here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#issueBookTable").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).find("td").eq(2).text().toLowerCase().indexOf(value) > -1);
        });
    });

    $(".issueBookBtn").click(function(event) {
        var quantity = $(this).closest("tr").find(".quantityInput").val();
        if (parseInt(quantity) === 0) {
            event.preventDefault(); // Prevent form submission
            window.location.href = "Error.jsp";
        }
    });
});
</script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
     <%
  String message=(String)session.getAttribute("getmessage");
  if(message!=null){
	  %>
  <div class="alert alert-success alert-dismissible">
    <a href="issueBooks.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong><%=message%>!</strong>
  </div>
  <% 
  session.removeAttribute("getmessage");
  }
  %>
<h1 style="text-align: center; color: blue;">This is Book Detail</h1>
<a href="UserHome.jsp"><button style="margin-left: 30px;border-radius: 50px;" type="submit" class="btn btn-danger">Go Back</button></a>
<sql:setDataSource driver="com.mysql.cj.jdbc.Driver" var="ds" url="jdbc:mysql://localhost:3306/library_project" user="root" password="4093"/>
<sql:query dataSource="${ds}" var="rs">SELECT * FROM addBook;</sql:query>              
<div class="container">
<h3 style="color: gray">Enter Book Author Name To Search The Book..</h3>
<input type="text" id="issueBookTable" placeholder="Search.."><br><br>
<table class="table">
<tr>
<td>Image</td>
<td>Book Name</td>
<td>Author Name</td>
<td>Edition</td>
<td>Books Quantity</td>
<td>Today</td>
<td>Return Date</td>
<td>Issue</td>
<td>Reserve</td>
</tr>

<tbody id="myTable">
<c:forEach items="${rs.rows}" var="row">
<tr>
<td>
    <a href="issueBooks.jsp"><c:url var="imageUrl" value="/Book/${row.Book}" />
    <img src="${imageUrl}" alt="Book Image" style="max-width: 50px;" /></a>
</td>
<td><c:out value="${row.BookName}"></c:out></td>
<td><c:out value="${row.Author}"></c:out></td>
<td><c:out value="${row.Edition}" /></td>
<td><c:out value="${row.Quantity}" /></td>
<td><%= LocalDate.now() %></td>
<td><%= LocalDate.now().plusDays(30) %></td>
<td>
<form action="issuebooksdata" method="post">
     <input type="hidden" name="id" value="${row.id}" />
    <input type="hidden" class="quantityInput" value="<c:out value="${row.Quantity}" />" />
    <button type="submit" class="btn btn-success issueBookBtn">IssueBook</button>
</form>
</td>
<td>
<a href="ReservBookData.jsp?id=${row.id}"><button type="submit" class="btn btn-success issueBook">Reserve</button></a>
</td>
</tr>
</c:forEach>
<tbody>
</table>
</div>
</body>
</html>
