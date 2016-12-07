<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>category</title>
</head>
<body>
	
	<h1>Add a Category</h1>
	<form:form action="addcategory" >
	 	
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
			</tr><br><br>
			
			<tr>
				<td colspan="2">
						<input type="submit" value=Submit />
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	
	<c:if test="${not empty category}">
		<table class="tg">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="200">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${category}" var="Category">
				<tr>
					<td>${Category.id}</td>
					<td>${Category.name}</td>
					<td>${Category.description}</td>
					<td><a href="<c:url value='Category/edit?c=${Category.id}' />">Edit</a></td>
					<td><a href="<c:url value='Category/delete?c=${Category.id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		
</body>
</html>