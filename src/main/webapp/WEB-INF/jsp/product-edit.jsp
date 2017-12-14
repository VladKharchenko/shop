<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceContext}/layout.css">
    <link rel="stylesheet" href="${resourceContext}/style.css">
    <script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="center">

	<ul id="navbar">  
		<li>Edit</li>
		<li><a href="/products" role="button">Products</a></li>
        <li><a href="/logout" role="button">Logout</a></li>
        <li>Admin</li>
	</ul>

    <form:form modelAttribute="product">
        <fieldset>
            <form:label path="title">Title:</form:label>
	        <form:input path="title" />
	        <span class="error"><form:errors path="title" /></span>
	        <br />

            <form:label path="description">Description:</form:label>
	        <form:input path="description" />
	        <span class="error"><form:errors path="description" /></span>
	        <br />

            <form:label path="cost">Cost:</form:label>
	        <form:input path="cost" />
	        <span class="error"><form:errors path="cost" /></span>
	        <br />

            <form:label path="balance">Balance:</form:label>
	        <form:input path="balance" />
	        <span class="error"><form:errors path="balance" /></span>
	        <br />
        </fieldset>

        <input type="submit" value="Save" />
    </form:form>

</div>
</body>
</html>
