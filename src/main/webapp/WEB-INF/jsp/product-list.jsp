<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
<title>Product List</title>
<link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
<link rel="stylesheet" href="${resourceContext}/layout.css">
<link rel="stylesheet" href="${resourceContext}/style.css">
<script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="product-list-AJAX.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<link>
</head>
<body>

	<div class="center">
	
	<ul id="navbar">
		  
		  <li>Products</li>
		  
		  <li><a href="/cart" role="button">Cart:
		  	<c:out value="${cartSize}" escapeXml="false" />
		  </a></li>
		  
		  <sec:authorize access="hasRole('ROLE_ADMIN')">
		  	<li><a href="/orderlist" role="button">Order list</a></li>
		  </sec:authorize>
		  
		  <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
          	<li><a href="/user" role="button">Check in</a></li>
          </sec:authorize>
		  
		  <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
          	<li><a href="/login" role="button">Login</a></li>
          </sec:authorize>
          <sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
          	<li><a href="/logout" role="button">Logout</a></li>
          </sec:authorize>
          
          <sec:authorize access="hasRole('ROLE_ADMIN')">
          	<li>Admin</li>
          </sec:authorize>
          <sec:authorize access="hasRole('ROLE_USER')">
          	<li>User: ${pageContext.request.userPrincipal.name}</li>
          </sec:authorize>
	    </ul>
	
		<form id="search-form" class="search-box">
			<input type="text" id="searchProduct" /> 
			<input type="submit" class="btn btn-success" id="bth-search" value="Search" />
		</form>

		<form id="list-form">
			<div id="feedback"></div>
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<input type="submit" value="Delete" class="btn btn-warning" id="bth-del" />
				
				<a href="/product" class="btn btn-warning" role="button">New product</a>
			</sec:authorize>
		</form>
        
	</div>
	
</body>
</html>
