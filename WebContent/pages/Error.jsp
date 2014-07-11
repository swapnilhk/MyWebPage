<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/Error.css" type="text/css" />
<title>Error</title>
</head>
<body>
	<div id="headerMessage"><% if(request.getAttribute("headerMessage") != null)out.print(request.getAttribute("headerMessage"));%></div>
	
	<div class="error"><%= request.getAttribute("message") %></div>
</body>
</html>