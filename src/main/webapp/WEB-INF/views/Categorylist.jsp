<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Filter</a>
    </div>
     
    <ul class="nav navbar-nav">
    <c:forEach items="${CategoryList}" var="c">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${c.name}  <span class="caret"></span></a>
         <ul class="dropdown-menu">
        	<c:forEach items="${product.productByCategory(c.id)}" var="p">
          <li><a href="productDetails/${p.id}">${p.name}</a></li>
           </c:forEach>
       </ul>
       </li>
        </c:forEach>   
       </ul>
  </div>
</nav>
</body>
</html>