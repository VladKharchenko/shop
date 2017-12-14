<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <title>Product View</title>
    <link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceContext}/layout.css">
    <link rel="stylesheet" href="${resourceContext}/style.css">
    <script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="center">
	
		<ul id="navbar">
		  
		  <li>View</li>
		  
		  <li><a href="/products" role="button">Products</a></li>
		  
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
	
		<h1 class="title">
			<c:out value="${product.title}" escapeXml="false"/>
		</h1>
		<p>
			<c:out value="${product.description}" escapeXml="false" />
		</p>
		<p class="g-price-uah">
			<p>Cost:<c:out value="${product.cost}" escapeXml="false" />
			<span class='g-price-uah-sign'>grn</span></p>
			<p>Balance:<c:out value="${product.balance}" escapeXml="false" /></p>
		</p>

		<c:if test="${product.balance > 0}">   			
			<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
				<a href='/contact/${product.id}' class='btn btn-info' role='button'>Buy</a>
			</sec:authorize>
			<sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
				<a href='/order/${product.id}' class='btn btn-info' role='button'>Buy</a>
			</sec:authorize>
			
			<a href='/cart?add&prodId=${product.id}' class='btn btn-info' role='button'>Add to Cart</a>
		</c:if>
		
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href='/product/${product.id}' class='btn btn-warning' role='button'>Edit</a>
		</sec:authorize>
	</div>
</body>
</html>