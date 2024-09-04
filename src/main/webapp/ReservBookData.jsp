<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page import="java.io.*, java.util.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.jsp.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Reservation</title>
<link rel="stylesheet" href="CssFile/AddBook.css">
</head>
<body>
    <%
        String bookId = request.getParameter("id");
    request.setAttribute("getbookId", bookId);
    %>
    <c:set value="${getbookId}" var="a" ></c:set>
    
     <div class="login-container">
        <div class="login-box">
  <c:set value="${getbookId}" var="a" ></c:set>
            <c:set value="${getsId}" var="v"></c:set>          
            <form action="reservebook" method="post">
            <%LocalDate date=LocalDate.now(); %>
            <%LocalDate afterday=date.plusDays(30); %>
           
            <h2>Update Book</h2>
             <input type="hidden" name="id" value='<c:out value="${a}"></c:out>'>
             <input type="hidden" name="sid" value='<c:out value="${v}"></c:out>'>
            <sql:setDataSource driver="com.mysql.cj.jdbc.Driver" var="ds" url="jdbc:mysql://localhost:3306/library_project" user="root" password="4093"/>
            <sql:query dataSource="${ds}" var="rs">select * from AddBook where id='<c:out value="${a}"></c:out>';</sql:query>
                <c:forEach items="${rs.rows}" var="row">
                <div class="input-group">
                    <label for="username">Name Of Student</label>
                    <input type="text" id="username" name="studentName" value='<c:out value="${getName}"></c:out>' readonly>
                </div>
                <div class="input-group">
                    <label for="username">Book</label>
                    <input type="text" id="username" name="book" value='<c:out value="${row.book}"></c:out>' readonly>
                </div>
                <div class="input-group">
                    <label for="username">Name Of Book</label>
                    <input type="text" id="username" name="bookname" value='<c:out value="${row.BookName}"></c:out>' readonly>
                </div>
                <div class="input-group">
                    <label for="username">Author Of Book</label>
                    <input type="text" id="username" name="author" value='<c:out value="${row.Author}"></c:out>' readonly>
                </div>
               
                <div class="input-group">
                    <label for="password">Edition</label>
                    <input type="text" id="edition" name="edition" value='<c:out value="${row.edition}"></c:out>' readonly>
                </div>
                <div class="input-group">
                    <label for="password">Enter Book Quantity You want</label>
                    <input type="text" id="bookquantity" name="bookquantity" value="1" readonly>
                </div>
                </c:forEach>
                <sql:query dataSource="${ds}" var="ro">select returndate from issuebooks where status='Issued';</sql:query>
                <div class="input-group">
                    <label for="password">Select Issuedate According to You</label>
                   <select name="issuedate" required>
                   <option>Select</option>
                    <c:forEach items="${ro.rows}" var="row">
                   <option value="${row.returndate}">
                    <c:out value="${row.returndate}"/>  
                   </option>
                   </c:forEach>
                   </select>
                </div>
                
                <button type="submit">Reserve</button>
            </form>
        </div>
    </div>
</body>
</html>
 
