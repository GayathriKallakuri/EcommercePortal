<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>category</title>
</head>
<body>
	
	<h1>Add a Category</h1>
	<form:form action="addcategory" method="post">
	 	
		<table>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name"/>
					</form:label>
				</td>
				<td><form:input path="name" required="true" value="${command.name}"/></td>
			</tr>
			
			<tr>
				<td><form:label path="description">
						<spring:message text="Desc"/>
					</form:label>
				</td>
				<td><form:input path="description" required="true" value="${command.description}"/></td>
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
	
	<c:if test="${not empty Categoryitems}">
		<table class="tg">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="200">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${Categoryitems}" var="cat">
				<tr>
					<td>${cat.id}</td>
					<td>${cat.name}</td>
					<td>${cat.description}</td>
					<td><a href="<c:url value='Category/editcategory/${cat.id}' />">Edit</a></td>
					<td><a href="<c:url value='/deletecategory/${cat.id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		
</body>
</html>