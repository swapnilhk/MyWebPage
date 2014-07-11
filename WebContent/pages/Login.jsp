<!DOCTYPE html>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/Validations.js"></script>
<link rel="stylesheet" href="css/table.css" type="text/css" />
<link rel="stylesheet" href="css/heading.css" type="text/css" />
<link rel="stylesheet" href="css/Error.css" type="text/css" />
<title>Login</title>
</head>
<body>	
	<h1>Swapnil's Web Page</h1>	
	<div class="error" id="loginError"><% if(request.getAttribute("loginError") != null)out.print(request.getAttribute("loginError"));%></div>
	<form action="login" method="POST" onsubmit="return validateLogin()">
		<table align="center">
			<tr><th colspan="2" align="center">Login</th></tr>
			<tr><td>Userame</td><td><input id="username" name="username" type="text" /></td></tr>
			<tr><td>Password</td><td><input id="password" name="password" type="password" /></td></tr>
			<tr><td colspan="2" align="center"><input type="submit" value="Login" /></td></tr>
			<tr><td colspan="2" align="center"><a href="pages/ForgotPassword.jsp">Forgot Password?</a></td></tr>
		</table>
	</form>
</body>
</html>
