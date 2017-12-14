<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <title>Order List</title>
    <link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceContext}/layout.css">
    <link rel="stylesheet" href="${resourceContext}/style.css">
    <script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
</head>
<body>
	  <div class="center">
	
	
		<ul id="navbar">
		  
		  <li>Order List</li>
		  
		  <li><a href="/products" role="button">Products</a></li>
		  
		  <li><a href="/cart" role="button">Cart:
		  	<c:out value="${cartSize}" escapeXml="false" />
		  </a></li>

          <li><a href="/logout" role="button">Logout</a></li>
          
          <sec:authorize access="hasRole('ROLE_ADMIN')">
          	<li>Admin</li>
          </sec:authorize>
	    </ul>
	    
	
	        <c:forEach items="${orders}" var="order">
			  <table class="cart-list">	  
	        	<tr>
	        		<td>User name</td>
	        		<td class='cart-item'>${order.userData.name}</td>
	        	</tr>
	        	<tr>
	        		<td>User city</td>
	        		<td>${order.userData.city}</td>
	        	</tr>
	        	
		        	<c:forEach items="${order.products}" var="product">
		        		<tr>
		        			<td>Title</td>
		        			<td>${product.title}</td>
		        		</tr>
		        		<tr>
		        			<td>Description</td>
		        			<td>${product.description}</td>
		        		</tr>
		        		<tr>
		        			<td>Cost</td>
		        			<td>${product.cost}</td>
		        		</tr>
		        	</c:forEach>
			    </table>
	        	<br>
	        </c:forEach>      
	</div>
</body>
</html>