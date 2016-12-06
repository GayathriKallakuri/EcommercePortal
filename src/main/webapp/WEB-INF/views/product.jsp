<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Add a Product</h1>
		<form:form action="addproduct" enctype="multipart/form-data">
			
		<table>
			<tr>
				<form:input path="name" hidden="true" />
				<td><form:label path="name">Name
						<spring:message text="Name" />
					</form:label>
				</td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="description">Description
						<spring:message text="Desc" />
					</form:label>
				</td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="price">Price
						<spring:message text="Price" />
					</form:label>
				</td>
				<td><form:input path="price" required="true" /></td>
			</tr>
			
			
			
			<tr>
				<td><form:label path="stock">Stock
						<spring:message text="stock" />
					</form:label>
				</td>
				<td><form:input path="stock" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="category">Category
						<spring:message text="category" />
					</form:label>
				</td>
				<td>
					<select name="category">
						<c:forEach var="c" items="${Category}">
							<option value="${c.id}">${c.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><form:label path="supplier">Supplier
						<spring:message text="supplier" />
					</form:label>
				</td>
				<td>
					<select name="supplier">
						<c:forEach var="s" items="${Supplier}">
							<option value="${s.id}">${s.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			
		
			<tr>
				<td colspan="2">
						<input type="submit" value="submit"/>
				</td>
			</tr>
		</table>
	</form:form>
	
	<br>
	<h3>Product List</h3>
	
	<c:if test="${not empty products}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Price</th>
				<th width="80">Stock</th>
				<th width="80">category</th>
				<th width="80">Supplier</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${products}" var="Product">
				<tr>
					<td>${Product.id}</td>
					<td>${Product.name}</td>
					<td>${Product.description}</td>
					<td>${Product.price}</td>
					<td>${Product.stock}</td>
					<td>${Product.category_id}</td>
					<td>${Product.supplier_id}</td>		
					<td><a href="<c:url value='Product/edit?p=${Product.id}' />">Edit</a></td>
					<td><a href="<c:url value='Product/delete?p=${Product.id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>

</html>