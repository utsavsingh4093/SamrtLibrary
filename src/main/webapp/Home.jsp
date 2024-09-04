<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!Doctype html>
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

<title>Home</title>
</head>

<body>
	<%
	String mess = (String) session.getAttribute("getMessage");
	if (mess != null) {
	%>
	<div class="alert alert-danger alert-dismissible">
		<a href="Home.jsp" class="close" data-dismiss="alert"
			aria-label="close">&times;</a> <strong><%=mess%></strong>
	</div>
	<%
	session.removeAttribute("getMessage");
	}
	%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<img style="height: 30px; width: 30px" src="image/logo1.png"><a
			class="navbar-brand" href="#">Smart Library</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="Home.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<li class="nav-item">
				<button style="border-radius: 50px;" type="button"
					class="btn btn-primary">
					<a style="color: whitesmoke; text-decoration: none;"
						href="Login.jsp">User Login</a>
				</button>
				<button style="border-radius: 50px;" type="button"
					class="btn btn-success">
					<a style="color: whitesmoke; text-decoration: none;"
						href="RegisterUser.jsp">User Register</a>
				</button>
			</li>
		</div>
	</nav>
	<div id="carouselExampleCaptions" class="carousel slide carousel-fade"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleCaptions" data-slide-to="0"
				class="active"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img height="500px" width="100%" src="image/im3.jpg"
					class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h2 style="color: whitesmoke;">A Library Managment</h2>


					<p style="color: whitesmoke;">You Can Do Login With any one
						Account You Have For Books</p>
					<button style="border-radius: 50px;" type="button"
						class="btn btn-primary">
						<a style="color: whitesmoke; text-decoration: none;"
							href="Login.jsp">Admin Login</a>
					</button>
					<button style="border-radius: 50px;" type="button"
						class="btn btn-success">
						<a style="color: whitesmoke; text-decoration: none;"
							href="RegisterAdmin.jsp">Admin Register</a>
					</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container my-4">
		<div class="row mb-2">
			<div class="col-md-6">
				<div
					class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
						<h3 class="mb-0">Book post</h3>
						<p class="card-text mb-auto">Libraries typically have a
							collection of books for study, enrichment, or extension. They may
							include reference sets, dictionaries, and other general or
							specialized books.</p>
					</div>
					<div class="col-auto d-none d-lg-block">
						<img width="200" height="250" src="image/im5.png" alt="...">
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div
					class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
						<h3 class="mb-0">About Books</h3>
						<p class="mb-auto">an organized collection of printed or other
							library materials, or a combination thereof; paid staff; an
							established schedule in which services of the staff are available
							to the public; the facilities necessary to support such a
							collection, staff, and schedule, and.</p>
					</div>
					<div class="col-auto d-none d-lg-block">
						<img width="200" height="250" src="image/im6.png" alt="...">
					</div>
				</div>
			</div>
		</div>


		<div class="container my-4">
			<div class="row mb-2">
				<div class="col-md-6">
					<div
						class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
						<div class="col p-4 d-flex flex-column position-static">
							<h3 class="mb-0">About Library</h3>
							<p class="card-text mb-auto">A library management system is
								software that is designed to manage all the functions of a
								library. It helps librarian to maintain the database of new
								books and the books that are borrowed by members along with
								their due dates..</p>
						</div>
						<div class="col-auto d-none d-lg-block">
							<img width="200" height="250" src="image/im7.png" alt="...">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div
						class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
						<div class="col p-4 d-flex flex-column position-static">
							<h3 class="mb-0">Update Books</h3>
							<p class="mb-auto">When someone publishes an update to a main
								component, style, or variable in a library, Figma makes the
								updates available in every file where the component, style, or
								variable is used.</p>
						</div>
						<div class="col-auto d-none d-lg-block">
							<img width="200" height="250" src="image/im8.png" alt="...">
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="container my-4">
			<div
				class="row featurette d-flex justify-content-center align-items-center">
				<div class="col-md-7">
					<h2 class="featurette-heading">Library User</h2>
					<p class="lead">According to a Pew Research Center study,
						library users are more likely to use technology than non-library
						users. The study found that: 93% of library users are internet
						users 76% of library users are smartphone users 74% of library
						users are home broadband users 74% of library users are social
						media users</p>
				</div>
				<div class="col-md-5 order-md-1">
					<img class="img-fluid" width="220" height="300"
						src="image/img9.png" alt="...">
				</div>
			</div>
		</div>

		<div class="container my-4 order-md-1">
			<div
				class="row featurette d-flex justify-content-center align-items-center">
				<div class="col-md-7 order-md-2">
					<h2 class="featurette-heading">Vision Of Samrt Library</h2>
					<p class="lead">The ultimate goal of the Open Library is to
						make all the published works of humankind available to everyone in
						the world. While large in scope and ambition, this goal is within
						our grasp. Achieving it will require the participation of
						librarians, authors, government officials and technologists.</p>
				</div>
				<div class="col-md-5">
					<img class="img-fluid" width="500" height="500"
						src="image/im11.png" alt="...">
				</div>
			</div>
</div>
			<footer class="text-center text-lg-start bg-body-tertiary text-muted">
				<div class="text-center p-4"
					style="background-color: rgba(0, 0, 0, 0.05);">
					Smart Library Management <br> <a class="text-reset fw-bold"
						href="https://mdbootstrap.com/">Email:-
						smartlibrary40@gmail.com</a>
				</div>
			</footer>

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