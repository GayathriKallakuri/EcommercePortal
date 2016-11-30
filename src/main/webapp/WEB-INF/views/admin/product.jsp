<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>Product</div>
<form>
ID<input type="ID" name="ID"placeholder="ID"/> <br/>
Name<input type="text" name="productNmae"placeholder="productName"/> <br/>
Price<input type="text" name="price"placeholder="price"/> <br/>
Category_id<input type="text" name="category_id"placeholder="category_id"/> <br/>
<button type="button" onclick="alert('Add Product')">Add </button>
<button type="button" onclick="alert('Update Product')">Update</button>
<button type="button" onclick="alert('Delete Product')">Delete </button>

</form>
</body>
</html>