<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>LogIn</div>
        <form action="index" method="post">
            EmailID<input type="email" name="mailId" placeholder="Email ID" /><br/><br/>
            Password<input type="password" name="password" placeholder="password" /><br/><br/>
            <input type="submit" value="login" />   
            <input type="checkbox" checked="checked"> Remember me
        </form>
</body>
</html>