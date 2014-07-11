<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="../js/Validations.js"></script>
<link rel="stylesheet" href="../css/table.css" type="text/css" />
<link rel="stylesheet" href="../css/heading.css" type="text/css" />
<link rel="stylesheet" href="../css/Error.css" type="text/css" />
<script src="js/Validations.js"></script>
<link rel="stylesheet" href="css/table.css" type="text/css" />
<link rel="stylesheet" href="css/heading.css" type="text/css" />
<link rel="stylesheet" href="css/Error.css" type="text/css" />
<title>Edit Profile</title>
</head>
<body>
	<div id="headerMessage"><% if(request.getAttribute("headerMessage") != null)out.print(request.getAttribute("headerMessage"));%></div>
	<h1>Swapnil's Web Page</h1>	
	<div class="error" id="errorMessage"><% if(request.getAttribute("errorMessage") != null)out.print(request.getAttribute("errorMessage"));%></div>
	<form action="/MyWebPage/changepassword" method="POST" onsubmit="return validateChangePassword2()">
		<table align="center">
			<tr><td>Old Password</td><td><input id="oldPassword" name="oldPassword" type="password" /></td></tr>
			<tr><td>New Password</td><td><input id="newPassword" name="newPassword" type="password" /></td></tr>
			<tr><td>Confirm Password</td><td><input id="confirmPassword" name="confirmPassword" type="password" /></td></tr>			
			<tr><td colspan="2" align="center"><input type="submit" value="Submit" /></td></tr>
		</table>			
	</form>
</body>
</html>
