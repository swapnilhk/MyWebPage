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
<title>Register</title>
</head>
<body>	
	<h1>Swapnil's Web Page</h1>	
	<div class="error" id="registerError"><% if(request.getAttribute("registerError") != null)out.print(request.getAttribute("registerError"));%></div>
	<form action="register" method="POST" onsubmit="return validateRegister()">
		<table align="center">
			<tr><th colspan="2" align="center">Register</th></tr>
			<tr><td>Userame</td><td><input id="username2" name="username2" type="text" /></td></tr>
			<tr><td>Password</td><td><input id="password2" name="password2" type="password" /></td></tr>
			<tr><td>Confirm Password</td><td><input id="confirmPassword2" name="confirmPassword2" type="password" /></td></tr>
			<tr><td>Full Name</td><td><input id="fullName" name="fullName" type="text" /></td></tr>			
			<tr><td>
			<select name="question">
			<%	HashMap<Integer, String> questions = (HashMap<Integer, String>)request.getAttribute("questions");
				Set<Integer> s = questions.keySet();
				Iterator<Integer> i = s.iterator();
				while(i.hasNext()){
					int k = i.next();
					%><option value="<%= k%>"><%= questions.get(k)%></option><%		
				}				
			%>
			</select>
			</td><td><input id="answer" name="answer" type="text" /></td></tr>
			<tr><td colspan="2" align="center"><input type="submit" value="Register" /></td></tr>
		</table>			
	</form>
</body>
</html>
