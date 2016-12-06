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

	<div> LogIn with valid credentials
	<form:form action="validate" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="inputlg">Email</label>
      <form:input class="form-control" path="email" type="email"/>
    </div>
    <div class="form-group">
      <label for="inputlg">Password</label>
      <form:input class="form-control" path="password" type="password"/>
    </div>
     <br>
    <div class="form-group">
    	<button type="submit" class="btn btn-primary">Login</button>
   	</div>
  	</form:form>
        </div>
</body>
</html>