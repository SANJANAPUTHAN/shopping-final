<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<!-- CSS only -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Vollkorn:wght@700&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Antonio:wght@700&display=swap" rel="stylesheet">
<style type="text/css">
.navbar-light {
  color: #fff;
  font-size: 25px;
  text-transform: uppercase;
  font-weight: bold;
  letter-spacing: 2px;
}
.navbar-light .navbar-nav .active > .nav-link, .navbar-light .navbar-nav .nav-link.active, .navbar-light .navbar-nav .nav-link.show, .navbar-light .navbar-nav .show > .nav-link {
  color: #616060;
}
.navbar-light .navbar-nav .nav-link {
  color: #616060;
}
.navbar-toggler {
  background: #616060;
}
.navbar-nav {
  text-align: center;
}
.nav-link {
  padding: .2rem 1rem;
}
.nav-link.active,.nav-link:focus{
  color: #616060;
}
.navbar-toggler {
  padding: 1px 5px;
  font-size: 18px;
  line-height: 0.3;
}
.navbar-light .navbar-nav .nav-link:focus, .navbar-light .navbar-nav .nav-link:hover {
  color: #616060;
}
.btn {
color: #616060;
}
.img {
	background-size: cover;
   	height: 70vh;
   	width: 100vw;
}
.title {
	width: 450px;
	padding: 10px;
	background: #92BD53;
	color: #ffff;
	margin-left: 530px;
	margin-top: -20px;
	letter-spacing: 2px;
	position: absolute;
	text-align: center;
}
.card {
	margin-top: 100px;
	padding: 20px;
}
.card-text {
	font-family: 'Antonio', sans-serif;
	font-size: 1.5em;
}
.btn {
	color: white;
}
.row {
	margin-left: 300px;
	padding: 20px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-white">
	
  <div class="container">
  	 <a class="navbar-brand" href="#">Fresh Basket </a>
     <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
		<li class="nav-item active">
    		<button class="nav-link btn bg-transparent">Welcome <%=session.getAttribute("username")%></button>		
        </li>
		<li class="nav-item active">
          	<form action="../logout/" method="get">
  				<button class="nav-link btn bg-transparent" type="submit" >Logout</button>
			</form>
        </li>
		<li class="nav-item active">
			<form action="../loadshop/shop1" method="get">
				<button class="nav-link btn bg-transparent" type="submit">Shop</button>
			</form>
        </li>
	</ul>
	</div>
</div>
</nav>
<div class="banner">
	<img src="/images/welcome.jpg" class="img">
</div>
<div class="title">
	<h3>SHOP BY CATEGORY</h3>
</div>
	<div class="row">
        <div class="col-md-3">
			<div class="card">
  				<img class="card-img-top" src="https://image.freepik.com/free-photo/colorful-fruits-tasty-fresh-ripe-juicy-white-desk_179666-169.jpg" alt="Card image cap">
  				<div class="card-body text-center">
      				<p class="card-text">Fruit Store</p>
    			</div>
  			</div>
  		</div>
		
		<div class="col-md-3">
		<div class="card">
  			<img class="card-img-top" src="https://image.freepik.com/free-photo/mix-vegetable_1339-374.jpg" alt="Card image cap">
  			<div class="card-body text-center">
      				<p class="card-text">Vegetable Store</p>
    		</div>
		</div>
		</div>
		
		<div class="col-md-3">
		<div class="card">
  			<img class="card-img-top" src="https://www.foodbusinessnews.net/ext/resources/2019/5/PepsiCoMexicoSnacks_Lead.jpg?1557345289" alt="Card image cap">
  			<div class="card-body text-center">
      				<p class="card-text">Snacks Store</p>
    		</div>
		</div>
		</div>
	</div>
</body>
</html>