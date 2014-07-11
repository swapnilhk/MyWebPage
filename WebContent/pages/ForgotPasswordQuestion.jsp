<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="../js/ForgotPasswordAjax.js"></script>
<link rel="stylesheet" href="css/Error.css" type="text/css" />
</head>
<body>
	<table align="center">
	<tr><td colspan="2" align="center">Answer the following question</tr></tr>
	<tr><td>
	<%	String question = (String)request.getAttribute("question");
			out.print(question);
	%>
	</td>
	<td><input id="answer" name="answer" type="text" /></td></tr>	
	<tr><td colspan="2" align="center"><button type="button" onclick="validateAnswer()">Submit</button></td></tr>
	</table>
	<div id="validationResponse"></div>
</body>
</html>