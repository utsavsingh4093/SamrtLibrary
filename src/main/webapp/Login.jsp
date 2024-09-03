<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="CssFile/AddBook.css">
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <h2>Login Page</h2>
           <form action="login" method="post">
                <div class="input-group">
                    <label for="password">Member Ship Number</label>
                    <input type="text" name="number" id="username" placeholder="Enter Book Quantity" required>
                </div>
                <div class="input-group">
                    <label for="password">Your Password</label>
                    <input type="password" name="pass" id="password" placeholder="Enter your Book Edition" required>
                </div>
              <br><br>
                <button type="submit">Login</button>
            </form>
        </div>
    </div>
</body>
</html>
