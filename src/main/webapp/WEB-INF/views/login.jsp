<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>LogIn with valid credentials
	<br>${message}
	<c:url var="action" value="/validate" ></c:url>
        <form  name="loginForm" action="${action}" method="post">
        <div class ="input-group margin-buttom-sm">
        <span class="input=group-addon"><i class="fa fa-envelope-o fa-fw"></i>Email</span>
        <input class="form-control" type="text" name="username" placeholder="mailId">
        </div>
       
            <div class ="input-group ">
        <span class="input=group-addon"><i class="fa fa-key fa-fw"></i>Password</span>
        <input class="form-control" type="password" name="password" placeholder="password">
        </div>
           <div class="input-group">
           <span class="input=group-addon"><i class="fa fa-key fa-fw"></i></span>
            <input type="submit" value="login" align ="center"  />   </div>
          
            <input type="checkbox" checked="checked" align="center"> Remember me
           
        </form>
        </div>
</body>
</html>