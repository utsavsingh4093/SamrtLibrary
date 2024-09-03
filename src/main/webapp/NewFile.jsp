<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserve Book</title>
<link rel="stylesheet" href="CssFile/AddBook.css">
</head>
<body>
 <div class="login-container">
        <div class="login-box">
        
        <c:set value="${getid}" var="a"></c:set>
            <c:set value="${getsId}" var="v"></c:set>

            <form action="reservebook" method="post">
                <h2>Reserve Book</h2>
                <input type="hidden" name="id" value='<c:out value="${a}" />'>
                <input type="hidden" name="sid" value='<c:out value="${v}" />'>
                
                <sql:setDataSource driver="com.mysql.cj.jdbc.Driver" var="ds" 
                    url="jdbc:mysql://localhost:3306/library_project" 
                    user="root" password="4093" />
                
                <sql:query dataSource="${ds}" var="rs">
                    SELECT * FROM IssueBooks WHERE id='<c:out value="${a}" />' ORDER BY sid ASC;
                </sql:query>
                
                <c:forEach items="${rs.rows}" var="row">
                    <div class="input-group">
                        <label for="studentName">Name Of Student</label>
                        <input type="text" id="studentName" name="studentName" value='<c:out value="${row.studentname}" />' readonly>
                    </div>
                    </c:forEach>
                    </form>
        </div></div>
</body>
</html>