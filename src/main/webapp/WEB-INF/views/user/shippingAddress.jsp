<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form:form class="form-horizontal" role="form"
		commandName="shippingAddress">
		<h2>Please Provide Shipping Address</h2>

		<div class="form-group">
			<form:label for="" path="line1" class="col-sm-3 control-label">Line1</form:label>
			<div class="col-sm-9">
				<form:input path="line1" type="text" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="" path="line2" class="col-sm-3 control-label">Line2</form:label>
			<div class="col-sm-9">
				<form:input path="line2" type="text" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="" path="city" class="col-sm-3 control-label">City</form:label>
			<div class="col-sm-9">
				<form:input path="city" type="text" class="form-control" required="true"/>
			</div>
		</div>

		<div class="form-group">
			<form:label path="city_Town" for="city_Town"
				class="col-sm-3 control-label">City/ Town</form:label>
			<div class="col-sm-9">
				<form:input path="city_Town" type="text" id="city_Town"
					placeholder="City/Town" class="form-control" />
			</div>
		</div>


		<div class="form-group">
			<form:label for="state_Province_RegionNumber"
				path="state_Province_RegionNumber" class="col-sm-3 control-label">State/ Province/ Region No</form:label>
			<div class="col-sm-9">
				<form:input type="text" id="state_Province_RegionNumber"
					path="state_Province_RegionNumber"
					placeholder="State / Province / Region
					" class="form-control" />
			</div>
		</div>


		<div class="form-group">
			<form:label for="zip_PostalCode" path="zip_PostalCode"
				class="col-sm-3 control-label">Zip/ Postal Code</form:label>
			<div class="col-sm-9">
				<form:input type="text" id="Zip/Postal Code" path="zip_PostalCode"
					class="form-control" placeholder="Zip / Postal Code" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="country" path="country"
				class="col-sm-3 control-label">Country</form:label>
			<div class="col-sm-9">
				<form:input type="text" id="country" path="country"
					placeholder="Country" 
					 class="form-control" />
			</div>
		</div>


		<!-- /.form-group -->
		<div class="form-group">
			<div class="col-sm-9 col-sm-offset-3">
				<input type="submit" name="_eventId_submitShippingAddress"
					value="save" class="btn btn-primary btn-block">
			</div>
			<br>
			<div class="col-sm-9 col-sm-offset-3">
				<input type="submit" name="_eventId_goToBillingAddress"
					value="Back" class="btn btn-primary btn-block">
			</div>
		</div>

	</form:form>
</div>
</body>
</html>