<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<div class="row text-center">
		<div class="col-lg-5 " style="margin-left: 10%">
			<div class="panel panel-default">
				<div class="panel-body">

					<img
						src="<c:url value="resources\images\${product.id}.jpg"></c:url>"
						class="image-responsive" alt="titan" />

					<h4>${product.name}</h4>
				</div>

			</div>
		</div>
		<div class="col-lg-5" style="margin-right: 5%">
			<div class="panel panel-default">
				<div class="panel-body">
					<h4>${product.name}from${product.category.name} Category</h4>
					<h3>${product.description}</h3>
					<h4>Rs.${product.price}</h4>

					<br> <br> <br> <a href="../addtocart/${product.id}"
						style="margin-right: 3%" class="btn btn-primary  " role="button"
						aria-pressed="true">Add to Cart</a> <a
						class="btn btn-md btn-success" style="text-decoration: none"
						href="#">Buy Now</a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>