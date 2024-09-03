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
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="#">Library</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
          </ul>
        </div>
      </nav>
 </div>
  
    <!-- Container for the registration form -->
     
    <div style="margin: 60px;" class="container">
      <!-- Title of the form -->
      <div style="color: brown;" class="title">Registration Form</div>
      <hr>
      <link rel="stylesheet" href="CssFile/Registercss.css">
      <div class="content">
        <!-- Registration form Of Library -->
        <form action="registerpageadmin" method="post">
          <div class="user-details">
            <div class="input-box">
              <span class="details">Role</span>
              <input type="text" name="role" placeholder="Enter your Role" list="role" id="role11" onchange="rolefun()" value="Admin" readonly>
            </div>
            <div class="input-box">
              <span class="details">Name</span>
              <input type="text" name="name" placeholder="Enter your Name" required>
            </div>
            <div class="input-box">
              <span id="admind" class="details">Name of library</span>
              <input type="text" name="library" placeholder="Enter your Name of library" id="admindi2" required>
            </div>
            <div class="input-box">
              <span id="admind2" class="details">Address</span>
              <input type="text" name="add" placeholder="Enter your Adress" id="admindi" required>
            </div>
             <div class="input-box">
              <span id="error" class="details">Email</span>
              <input  type="text" name="email" placeholder="Enter your Email" id="email" oninput="emailcheker()" required>
              <script src="JavaScript/Register.js"></script>
            </div>
            <div class="input-box">
            </style>
              <span id="errorpass" class="details">Password</span>
              <input type="password" id="password" name="pass" placeholder="Enter your password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8}" oninput="passwordValidation()" required>
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
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>