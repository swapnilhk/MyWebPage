<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="../js/Validations.js"></script>
</head>
<body>
	<div class="error" id="errorMessage"><% if(request.getAttribute("headerMessage") != null)out.print(request.getAttribute("headerMessage"));%></div>
	<form action="/MyWebPage/forgotpassword" method="POST" onsubmit="return validateChangePassword()">	
	<table align="center">
	<tr><td colspan="2" align="center">Your answer is correct. Choose an new password for yourself.</td></tr>
	<tr><td>New Password</td><td><input id="newPassword" name="newPassword" type="password" /></td></tr>	
	<tr><td>Confirm Password</td><td><input id="confirmPassword" name="confirmPassword" type="password" /></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="Submit" /></td></tr>
	</table>
	</form>
</body>
</html>