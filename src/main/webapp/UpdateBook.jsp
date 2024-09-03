<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page import="com.DAO.BookUserDAO"%>
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
            <h2>Update Book</h2>
            <form action="updatepagedata" method="post">
             <input type="hidden" name="id" value='<c:out value="${a}"></c:out>'>
            <sql:setDataSource driver="com.mysql.cj.jdbc.Driver" var="ds" url="jdbc:mysql://localhost:3306/library_project" user="root" password="4093"/>
            <sql:query dataSource="${ds}" var="rs">select * from addbook where id='<c:out value="${a}" ></c:out>';</sql:query>
                
                <c:forEach items="${rs.rows}" var="row">
                <div class="input-group">
                    <label for="namebook">Name Of Book</label>
                    <input type="text" name="bookname" id="namebook" placeholder="Enter Book Name" value='<c:out value="${row.BookName}"></c:out>' required>
                </div>
                <div class="input-group">
                    <label for="authorname">Author Of Book</label>
                    <input type="text" name="author" id="authorname" placeholder="Enter Book Author Name" value='<c:out value="${row.Author}"></c:out>' required>
                </div>
                <div class="input-group">
                    <label for="edition">Edition</label>
                    <input type="text" name="edition" id="edition" placeholder="Enter Book Edition" value='<c:out value="${row.Edition}"></c:out>' required>
                </div>
                <div class="input-group">
                    <label for="quantity">Quantity</label>
                    <input type="text" name="quantity" id="quantity" placeholder="Enter Book Quantity" value='<c:out value="${row.Quantity}"></c:out>' required>
                </div>
                </c:forEach><br><br>
                <button type="submit">Update Book</button>
            </form>
        </div>
    </div>
</body>
</html>
