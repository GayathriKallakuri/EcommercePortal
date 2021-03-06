<!DOCTYPE html>
<html lang="en">
<head>
  <title>Ecommerce</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container text-center">

<div class="page-header" align="center">
<h1><img src="/ShoppingCartFrontEnd/src/main/webapp/WEB-INF/views/images/1.jpg"/> <small>The Watch Stop</small></h1>
<p>Trendy and Classy</p>
</div>

  </div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">ShoppingCart</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="">Home</a></li>
      <li class="active"><a href="aboutus">About Us</a></li>
      <li class="active"><a href="contact">Contact Us</a></li>
      <!--<li class="active"><a href="Category">Category</a></li> -->
      <!--<li class="active"><a href="supplier">Supplier</a></li> -->
      <!--<li class="active"><a href="product">Product</a></li>-->
    </ul>
   
    <c:if test="${loggedInUser==false}">
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      </ul>
      </c:if>
      
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${loggedInUser==false }">
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
     
       <c:if test="${loggedInUser==true}">
     <span class="glyphicon glyphicon-shopping-cart"></span> 
   
     <a href="cart" >Cart</a><i class="fa-fa-shopping-cart">${cartSize }</i> 
     <!--   <li><a href="cart"><span class="fa-fa-shopping-cart"></span>Cart</a></li>-->
      <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
      </c:if>
      </ul>
      
  </div>
</nav>
</body>
</html>
