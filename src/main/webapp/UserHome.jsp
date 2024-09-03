<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <img style="height: 30px; width: 30px" src="image/logo1.png"><a class="navbar-brand" href="#">Smart Library</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item col-auto active">
              <a class="nav-link" href="UserHome.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
        
            <li class="nav-item active">
                <a class="nav-link" href="issueBooks.jsp">Issued books <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="ReturnBook.jsp">Return Books <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="RenewBook.jsp">Renew Books <span class="sr-only">(current)</span></a>
              </li>
             <li class="nav-item active">
                <a class="nav-link" href="ReserveBook.jsp">Reserve Books <span class="sr-only">(current)</span></a>
              </li>
          </ul>
          <li class="nav-item">
        <button style="border-radius: 29px; height: 45px; width: 100px; margin-top: 10px; padding-block-end: 22px; text-align: center;" class="btn btn-outline-danger my-2 my-sm-0 text-color-dark">
          <a style="color: whitesmoke; text-decoration: none;" href="logout">Logout</a></button>
      </li>
        </div>
      </nav>
  <%
  String message=(String)session.getAttribute("message");
  if(message!=null){
	  %>
<div class="alert alert-success alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong><%= message %></strong>
</div>
  <% 
  session.removeAttribute("message");
  }
  %>
  
    <%
  String mess=(String)session.getAttribute("messages");
  if(mess!=null){
	  %>
<div class="alert alert-success alert-dismissible">
  <a href="UserHome.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong><%= mess %></strong>
</div>
  <% 
  session.removeAttribute("messages");
  }
  %>
  
      <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img height="500px" width="100%" src="image/im4.png" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h2 style="color:whitesmoke;">Welcome <c:out value="${getName}"/></h2> 
              <p style="color: whitesmoke;">You Can Do Login With any one Account You Have For Books</p>
            </div>
          </div>
    
 </div>


 <div class="container my-4">
  <div class="row mb-2">
    <div class="col-md-6">
      <div
        class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">World</strong>
          <h3 class="mb-0">Library post</h3>
          <p class="card-text mb-auto">A library management system,It helps librarian to maintain the database of new books and the books that are borrowed by members along with their due dates..</p>
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
          <strong class="d-inline-block mb-2 text-success">Design</strong>
          <h3 class="mb-0">Post title</h3>
                    <p class="mb-auto">Library Management System is one of the most common software development and User Frendly.
                   </p>
        </div>
        <div class="col-auto d-none d-lg-block">
          <img width="200" height="250" src="image/im8.png" alt="...">
        </div>
      </div>
    </div>
  </div>
</div>


<div class="container my-4">
  <div class="row featurette d-flex justify-content-center align-items-center">
    <div class="col-md-7">
      <h2 class="featurette-heading">Smart Library Management System. <span class="text-muted">also involve maintaining the database .</span>
      </h2>
      <p class="lead">Libraries rely on library management systems to manage asset collections as well as relationships with their members. Library management systems help libraries keep track of the books and their checkouts, as well as members' subscriptions and profiles.</p>
    </div>
    <div class="col-md-5 order-md-1">
      <img class="img-fluid" width="220" height="300" src="image/img9.png" alt="...">
    </div>
  </div>
</div>

<div class="container my-4 order-md-1">
  <div class="row featurette d-flex justify-content-center align-items-center">
    <div class="col-md-7 order-md-2">
      <h2 class="featurette-heading">The Smar Library work
      </h2>
      <p class="lead">The worldwide library management system the executives framework market is fundamentally determined by ascend deprived for robotization of library the board capacities to oversee educational assets. Moreover, developing interest for speedy access to library management software through mobiles, tablets, and other advanced stages further drives the market all inclusive.</p>
    </div>
    <div class="col-md-5">
      <img class="img-fluid" width="500" height="500" src="image/im11.png" alt="...">
    </div>
  </div>
  <div class="container my-4">
    <div class="row featurette d-flex justify-content-center align-items-center">
      <div class="col-md-7">
        <h2 class="featurette-heading">First featurette heading. 
           </h2>
        <p class="lead"> library the board framework likewise helps in lessening operational cost, expanding productivity, and giving simple access to the tremendous measure of information accessible in the library software. The library management system the board framework causes a curator to keep up a wide range of books.</p>
      </div>
      <div class="col-md-5 order-md-1">
        <img class="img-fluid" width="250" height="500" src="image/im10.png" alt="...">
      </div>
    </div>

  </div>
</div>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>