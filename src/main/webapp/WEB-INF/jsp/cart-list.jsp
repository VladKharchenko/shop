<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceContext}/layout.css">
    <link rel="stylesheet" href="${resourceContext}/style.css">
    <script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="center">

		<ul id="navbar">
		  
		  <li>Cart</li>
		  <li><a href="/products" role="button">Products</a></li>
		  
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


		<table class="cart-list">
			<tr>
				<th class="cart-item">Product</th>
				<th>Amount and Cost</th>
			</tr>
		</table>
		<c:forEach items="${products}" var="prod">
			<table class="cart-list">
				<tr>
					<th class="cart-item">${prod.title}</th>
					<th><a href="/cart?delete&prodId=${prod.id}"
						class="btn btn-danger" role="button">Remove</a></th>
				</tr>
				<tr>
					<td>${prod.description}</td>
					<td>(${prod.count})${prod.totalCost}</td>
				</tr>
			</table>
		</c:forEach>

		<div class="cart-buy">

			<h4>Total:${allTotalCost}</h4>
			
			<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
				<a href="/contact" class="btn btn-info" role="button">Buy</a>
			</sec:authorize>
			<sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
				<a href="/order" class="btn btn-info" role="button">Buy</a>
			</sec:authorize>

		</div>

	</div>
</body>
</html>
