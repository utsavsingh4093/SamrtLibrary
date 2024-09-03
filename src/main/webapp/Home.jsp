<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

  <title>Hello, world!</title>
</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <img style="height: 30px; width: 30px" src="image/logo1.png"><a class="navbar-brand" href="#">Smart Library</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
        </li>
      </ul>
      <li class="nav-item">
         <button type="button" class="btn btn-primary"><a style="color:whitesmoke; text-decoration: none;"
              href="Login.jsp">User</a></button>
          <button type="button" class="btn btn-success"><a style="color:whitesmoke; text-decoration: none;"
              href="RegisterUser.jsp">User Register</a></button>
      </li>
    </div>
  </nav>
  <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
      </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img height="500px" width="100%" src="image/im3.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h2 style="color:whitesmoke;">A Library Managment</h2> 


          <p style="color: whitesmoke;">You Can Do Login With any one Account You Have For Books</p>
          <button type="button" class="btn btn-primary"><a style="color:whitesmoke; text-decoration: none;"
              href="Login.jsp">Admin</a></button>
          <button type="button" class="btn btn-success"><a style="color:whitesmoke; text-decoration: none;"
              href="RegisterAdmin.jsp">Admin Register</a></button>
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
            <strong class="d-inline-block mb-2 text-primary">Books</strong>
            <h3 class="mb-0">Featured post</h3>
            <div class="mb-1 text-muted">Nov 12</div>
            <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to
              additional content.</p>
            <a href="#" class="stretched-link">Continue reading</a>
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
            <strong class="d-inline-block mb-2 text-success">Design</strong>
            <h3 class="mb-0">Post title</h3>
            <div class="mb-1 text-muted">Nov 11</div>
            <p class="mb-auto">This is a wider card with supporting text below as a natural lead-in to additional
              content.</p>
            <a href="#" class="stretched-link">Continue reading</a>
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
              <strong class="d-inline-block mb-2 text-primary">World</strong>
              <h3 class="mb-0">Featured post</h3>
              <div class="mb-1 text-muted">Nov 12</div>
              <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to
                additional content.</p>
              <a href="#" class="stretched-link">Continue reading</a>
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
              <div class="mb-1 text-muted">Nov 11</div>
              <p class="mb-auto">This is a wider card with supporting text below as a natural lead-in to additional
                content.</p>
              <a href="#" class="stretched-link">Continue reading</a>
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
          <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It’ll blow your mind.</span>
          </h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod
            semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus
            commodo.</p>
        </div>
        <div class="col-md-5 order-md-1">
          <img class="img-fluid" width="220" height="300" src="image/img9.png" alt="...">
        </div>
      </div>
    </div>

    <div class="container my-4 order-md-1">
      <div class="row featurette d-flex justify-content-center align-items-center">
        <div class="col-md-7 order-md-2">
          <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It’ll blow your mind.</span>
          </h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod
            semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus
            commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="img-fluid" width="500" height="500" src="image/im11.png" alt="...">
        </div>
      </div>
      <div class="container my-4">
        <div class="row featurette d-flex justify-content-center align-items-center">
          <div class="col-md-7">
            <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It’ll blow your
                mind.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod
              semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus
              commodo.</p>
          </div>
          <div class="col-md-5 order-md-1">
            <img class="img-fluid" width="250" height="500" src="image/im10.png" alt="...">
          </div>
        </div>

      </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
      integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
      integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
      crossorigin="anonymous"></script>
</body>

</html>