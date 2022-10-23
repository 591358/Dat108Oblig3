<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoppinglist</title>
<style type="text/css">
	<%@ include file="style.css" %>
</style>
</head>
<body>
	<form action="shoppinglist" method="post">
		<div class="wrapper">
			<div class="item-wrapper-container">
				<div class="item-wrapper">
					<p class="list-title">Shopping list</p>
					<input type="submit" value="Add item" /> 
					<input type="text" name="item" />
				</div>
				<c:forEach var="item" items="${shopping}">
					<div class="itemWrapper">
						<button name="delete" type="submit" value="${item}">Delete</button>
						<c:out value="${item}" />
					</div>
				</c:forEach>
			</div>
		</div>
	</form>
</body>
</html>