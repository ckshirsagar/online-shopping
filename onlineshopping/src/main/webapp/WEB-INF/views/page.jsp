<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>Online Shopping -${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link href="${css}/bootstrap.min.css" rel="stylesheet" />
<%-- <link href="${css}/bootstrap-flaty.css" rel="stylesheet" /> --%>
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet" />
<!-- Custom styles for this template -->

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet" />
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>


	<div class="wrapper">

		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>
		<!-- Page Content -->

		<div class="content">

			<c:if test="${userClickHome == true}">
				<%@ include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<%@ include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@ include file="contact.jsp"%>
			</c:if>

			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts ==  true}">
				<%@ include file="listproducts.jsp"%>
			</c:if>

			<c:if test="${userClickShowProducts == true}">
				<%@ include file="singleProduct.jsp"%>
			</c:if>
			<c:if test="${userClickManageProduct == true}">
				<%@ include file="manageProduct.jsp"%>
			</c:if>
			<c:if test="${userClickShowCart == true}">
				<%@ include file="cart.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/proper.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/bootbox.min.js"></script>

		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
