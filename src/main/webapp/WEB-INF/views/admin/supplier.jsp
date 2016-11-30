<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>Supplier</div>
<form>
ID<input type="ID" name="ID" placeholder="ID"/> <br/>
Name<input type="text" name="supplierName" placeholder="supplierName"/><br/>
Address<input type="textarea" name="address" placeholder="address"/><br/>
<button type="button" onclick="alert('Add Supplier')">Add </button>
<button type="button" onclick="alert('Update Supplier')">Update  </button>
<button type="button" onclick="alert('Delete Supplier')">Delete</button>
</form>
</body>
</html>