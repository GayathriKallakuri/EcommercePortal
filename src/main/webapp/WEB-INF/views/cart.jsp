<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">MyCart</h2><br><br>
<c:if test="${not empty Cartitems}">
		<table class="tg">
			<tr>
				<th width="80">Cart ID</th>
				<th width="120">Cart Date</th>
				<th width="200">Price</th>
				<th width="200">ProductName</th>
				<th width="200">Quantity</th>
				<th width="200">Status</th>
				<th width="200">User</th>
				<!--  <th width="60">Edit</th>-->
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${Cartitems}" var="cart">
				<tr>
					<td>${cart.cartId}</td>
					<td>${cart.cartDate}</td>
					<td>${cart.price}</td>
					<td>${cart.productName}</td>
					<td>${cart.quantity}</td>
					<td>${cart.status}</td>
					<td>${cart.userId.id}</td>
					<!--  <td><a href="<c:url value='/editcart/${cart.cartId}' />">Edit</a></td>-->
					<td><a href="<c:url value='/deletecart/${cart.cartId}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
</body>
</html>