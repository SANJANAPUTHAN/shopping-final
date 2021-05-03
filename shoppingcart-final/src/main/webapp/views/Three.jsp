<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Snack Shop</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
	<style type="text/css">
	
	.navbar-light {
  color: #fff;
  font-size: 25px;
  text-transform: uppercase;
  font-weight: bold;
  letter-spacing: 2px;
}
.navbar-light .navbar-nav .active > .nav-link, .navbar-light .navbar-nav .nav-link.active, .navbar-light .navbar-nav .nav-link.show, .navbar-light .navbar-nav .show > .nav-link {
  color: white;
}
.navbar-light .navbar-nav .nav-link {
  color: white;
}
.navbar-toggler {
  background: white;
}
.navbar-nav {
  text-align: center;
}
.nav-link {
  padding: .2rem 1rem;
}
.nav-link.active,.nav-link:focus{
  color: white;
}
.navbar-toggler {
  padding: 1px 5px;
  font-size: 18px;
  line-height: 0.3;
}
.navbar-light .navbar-nav .nav-link:focus, .navbar-light .navbar-nav .nav-link:hover {
  color: white;
}
.text-center h2 {
	font-family: 'Rubik', sans-serif;
}
.text-center p {
	font-family: 'Courgette', cursive;
}
	</style>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-danger">
	
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
	<br>
	<br>
	
	<div class="container-fluid">
	<figure class="text-center" style="padding: 2%;">
			<blockquote class="blockquote">
				<h3>Snacks</h3>
				<p>Grab the best quality snacks!</p>
			</blockquote>
	</figure>
	
	<div class="container" style="padding-left: 8%;">
		<form action="../loadshop/savedata" method="post">
			<mytags:getdata number="3" />
			<div class="d-grid gap-2 col-6 mx-auto" style="padding-bottom: 3%;">
				<button class="btn btn-danger" type="submit">Continue</button>
			</div>
		</form>
	</div>
	</div>
</body>
</html>