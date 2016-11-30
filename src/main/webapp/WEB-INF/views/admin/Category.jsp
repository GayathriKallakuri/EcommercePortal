<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>Category</div>
<form action="index" method="post">
<table>
<tr>
					<td>Id</td>
					<td><input type="text" name="Id"></td>
					<br>
				</tr> 
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name"></td>
					<br>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description"></td>
					<br><
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
			<button type="button" onclick="alert('Add Supplier')">Add </button>
<button type="button" onclick="alert('Update Supplier')">Update  </button>
<button type="button" onclick="alert('Delete Supplier')">Delete</button>
</form>
</body>
</html>