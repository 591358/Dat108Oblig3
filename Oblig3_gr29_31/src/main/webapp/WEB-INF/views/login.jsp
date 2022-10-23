<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="login-form-wrapper">
		<form action="/" method="post">
			<div class="login-content-wrapper">
				<p style="color: red" class="login-text">${redirectMessage}</p>
				<p class="login-text">Enter password:</p>
				<div class="login-content">
					<input type="password" name="pass" id="pass">
				</div>
				<div class="login-content">
					<input type="submit" value="Log in">
				</div>
			</div>
		</form>
	</div>
</body>
</html>