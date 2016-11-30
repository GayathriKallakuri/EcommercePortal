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
	<div>
		Sign Up
		<form action="index" method="post">
			<table>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name"></td>
					<br>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"></td>
					<br>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="pwd"></td>
					<br>
				</tr>
				<tr>
					<td>Confirm Password :</td>
					<td><input type="password" name="cpwd"><br>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="address" name="address"><br>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>