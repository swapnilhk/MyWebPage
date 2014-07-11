<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="../js/ForgotPasswordAjax.js"></script>
<script src="../js/Validations.js"></script>
<link rel="stylesheet" href="../css/table.css" type="text/css" />
<link rel="stylesheet" href="../css/heading.css" type="text/css" />
<link rel="stylesheet" href="../css/Error.css" type="text/css" />
<title>Forgot Password</title>
</head>
<body>	
	<table align="center">
		<tr><td>Userame</td><td><input id="username" name="username" type="text" /></td></tr>
		<tr><td colspan="2" align="center"><button type="button" onclick="searchUsername()">Submit</button></td></tr>
	</table>	
	<div id="question"></div>	
</body>
</html>