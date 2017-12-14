<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
    <title>Contact</title>
    <link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceContext}/layout.css">
    <link rel="stylesheet" href="${resourceContext}/style.css">
    <script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="center">

<ul id="navbar">
		  
		  <li>Contact</li>
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

	<form:form modelAttribute="userDataForm">
		<fieldset>
			<form:label path="name">Name:</form:label>
	        <form:input path="name" />
	        <br/>
	        
	        <form:label path="city">City:</form:label>
	        <form:input path="city" />
	        <br/>
	
	        <input type="submit" class="btn btn-success" value="buy" />
        </fieldset>
    </form:form>	
</div>
</body>
</html>