<%@page import="com.thirdparty.server.validate_code_source"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Hello, world!</title>

</head>
<body>

	<!-- Container for the registration form -->
	<%
	String mess = (String) session.getAttribute("getMessage");
	if (mess != null) {
	%>
	<div class="alert alert-danger alert-dismissible">
		<a href="RegisterUser.jsp" class="close" data-dismiss="alert"
			aria-label="close">&times;</a> <strong><%=mess%></strong>
	</div>
	<%
	session.removeAttribute("getMessage");
	}
	%>

	<div style="margin: 60px;" class="container">
		<!-- Title of the form -->
		<span style="display: flex; flex-direction: row">
			<h2 style="color: brown;" class="title">Registration Form</h2> <a
			href="Home.jsp"><button
					style="padding-top: 5px; padding-bottom: 5px; background-color: #dc3545; border-radius: 50px; margin-left: 350px"
					type="submit" class="btn">X</button></a>
		</span>
		<link rel="stylesheet" href="CssFile/Registercss.css">
		<div class="content">
			<!-- Registration form Of Library -->
			<form action="registerpageuser" method="post">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Role</span> <input type="text" name="role"
							placeholder="Enter your Role" list="role" id="role11"
							onchange="rolefun()" value="User" readonly>
					</div>
					<div class="input-box">
						<span class="details">Name</span> <input type="text" name="name"
							placeholder="Enter your Name" required>
					</div>
					<div class="input-box">
						<span id="error" class="details">Email</span> <input type="text"
							name="email" placeholder="Enter your Email" id="email"
							oninput="emailcheker()" required> <br>
						<script src="JavaScript/Register.js"></script>
					</div>
					<div class="input-box">
						</style>
						<span id="errorpass" class="details">Password</span> <input
							type="password" id="password" name="pass"
							placeholder="Enter your password"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8}"
							oninput="passwordValidation()" required>
					</div>

				</div>
				<!-- Button container -->
				<div class="button-container">
					<div class="button">
						<!-- Submit button -->
						<input type="submit" value="Register">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</body>
</html>