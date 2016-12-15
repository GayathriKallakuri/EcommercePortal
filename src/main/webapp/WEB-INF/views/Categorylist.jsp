<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${categoryList}" var="c">

	<div class="container">
		<h2>${category}</h2>
		 <div class="row text-center">

			<c:forEach items="${c}" var="p">
				
					<div class="col-lg-2 ">
						<div class="panel panel-default">
							<div class="panel-body">
								<h4>${p.productName}</h4>
								<h6>${p.category.categoryName}</h6>			
							</div>

						</div>
					</div>
				
			</c:forEach>

		</div>


	</div>

	<hr>

</c:forEach>
</body>
</html>