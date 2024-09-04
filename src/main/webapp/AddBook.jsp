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
        <span style="display: flex;flex-direction: row" > <a href="AdminHome.jsp"><button style="padding-top: 5px;background-color: #dc3545;" type="submit" class="btn">Back</button></a>
            <h2 style="margin-left: 75px">Add Book</h2></span>
           
            <form action="addingbook" method="post" enctype="multipart/form-data">
                <div class="input-group">
                    <label for="namebook">Name Of Book</label>
                    <input type="text" name="bookname" id="namebook" placeholder="Enter Book Name" required>
                </div>
                <div class="input-group">
                    <label for="authorname">Author Of Book</label>
                    <input type="text" name="author" id="authorname" placeholder="Enter Book Author Name" required>
                </div>
                <div class="input-group">
                    <label for="edition">Edition</label>
                    <input type="text" name="edition" id="edition" placeholder="Enter Book Edition" required>
                </div>
                <div class="input-group">
                    <label for="quantity">Quantity</label>
                    <input type="text" name="quantity" id="quantity" placeholder="Enter Book Quantity" required>
                </div>
                <div class="upload-container">
                    <h2>Upload File</h2>
                    <input type="file" name="bimg" id="bookfile" class="form-control-file" required>
                </div><br><br>
                <button type="submit">Add Book</button>
            </form>
        </div>
    </div>
</body>
</html>
