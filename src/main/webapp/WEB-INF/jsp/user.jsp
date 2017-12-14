<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
    <title>Check in</title>
    <link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceContext}/layout.css">
    <link rel="stylesheet" href="${resourceContext}/style.css">
    <script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="center">
	
	<ul id="navbar">
		<li>Check in</li>
		<li><a href="/products" role="button">Products</a></li>
		<li><a href="/login" role="button">Login</a></li>
	</ul>

    <form:form modelAttribute="userForm">
    	<fieldset>
	        <form:label path="login">Login:</form:label>
	        <form:input path="login" />
	        <br>
	        <form:label path="password">Password:</form:label>
	        <form:input path="password" />
	        <br>
	        <form:label path="name">Name:</form:label>
	        <form:input path="name" />
	        <br>
	        <form:label path="city">City:</form:label>
	        <form:input path="city" />
			<br>
	        <form:select path="role">
	            <form:options items="${roles}"/>
	        </form:select>
	        <br>
	        <input type="submit" class="btn btn-success" value="create" />
        </fieldset>
    </form:form>
</div>
</body>
</html>