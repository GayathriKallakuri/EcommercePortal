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
<h1>Add Supplier</h1>
		<form:form action="addsupplier" >
			 
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
				<td><form:label path="address">Address
						<spring:message text="Address" />
					</form:label>
				</td>
				<td><form:input path="address" required="true" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
						<input type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form:form>
	
	<br>
	<h3>Supplier List</h3>
	
	<c:if test="${not empty supplier}">
		<table class="tg">
			<tr>
				<th width="80">Supplier ID</th>
				<th width="120">Supplier Name</th>
				<th width="200">Supplier Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			
			<c:forEach items="${supplier}" var="Supplier">
				<tr>
					<td>${Supplier.id}</td>
					<td>${Supplier.name}</td>
					<td>${Supplier.address}</td>
					<td><a href="<c:url value='Supplier/edit?s=${Supplier.sid}' />">Edit</a></td>
					<td><a href="<c:url value='Supplier/delete?s=${Supplier.sid}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</body>
</html>