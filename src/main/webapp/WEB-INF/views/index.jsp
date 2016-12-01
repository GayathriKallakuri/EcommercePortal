<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body> 


<jsp:include page="header.jsp"/>

<hr>
${registerMessage}
<c:if test="${not empty errorMessage}">
<jsp:include page="login.jsp" />
</c:if>

<c:if test="${isUserClickedLogin==true}">
<jsp:include page="login.jsp" />
</c:if>

<c:if test="${isUserClickedHome}">
<jsp:include page="index.jsp" />
</c:if>
<c:if test="${isUserClickedRegister}">
<jsp:include page="register.jsp" />
</c:if>

<c:if test="${userClickedAboutus}">
<jsp:include page="aboutus.jsp" />
</c:if>
<c:if test="${userClickedContact}">
<jsp:include page="contact.jsp" />
</c:if>
<!-- <c:if test="${userClickedSupplier}">
<jsp:include page="admin/supplier.jsp" />
</c:if> -->

<jsp:include page="footer.jsp"/>
</body>
</html>
