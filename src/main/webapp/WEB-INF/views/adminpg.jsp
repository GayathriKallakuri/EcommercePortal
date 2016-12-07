<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin crud operations</title>
</head>
<body>
<div class="module">
	<center>
		<h1>Administrator Operations</h1>
		
			<h3><a href="<c:url value="/Category"/>">Add Category</a><br><br></h3>
			<h3><a href="<c:url value="/supplier"/>">Add Supplier</a><br><br></h3>
			<h3><a href="<c:url value="/product"/>"> Add Product</a></h3>
	</center>
  </div>
</body>
</html>