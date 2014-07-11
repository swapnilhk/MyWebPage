<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/HomepageStyle.css" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Princess+Sofia|Snowburst+One|Frijole|Joti+One|Vampiro+One|Faster+One|Akronim|Merienda|Arizonia|Stalinist+One|Macondo+Swash+Caps|Smokum|Snowburst+One|The+Girl+Next+Door|Elsie|Bonbon|Hanalei|Architects+Daughter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/heading.css" type="text/css" />
<title>Swapnil's Web Site</title>

<style type="text/css">

td, th {
	padding: 5px;
	color: #333;
}

td:hover {
	background-color: #fff;
}
</style>

</head>
<body>
	<h1>Swapnil's Web Page</h1>
	<div id="headerMessage"><% if(request.getAttribute("headerMessage") != null)out.print(request.getAttribute("headerMessage"));%></div>
	<div class="sidebar">
		<div class="topblock">
			<% if(session != null && session.getAttribute("fullName") != null){ %>				
				<font size="6" color="<%= session.getAttribute("fontColor")%>" face="<%= session.getAttribute("fontFamily")%>"><%= session.getAttribute("fullName")%></font><br>
				<table align="center">			
					<tr><td><a class="button" href="pages/ChangeFont.jsp">Change Font</a></td>
					<td><a class="button" href="pages/ChangePassword2.jsp">Change Password</a></td></tr>
					<tr><td><a class="button" href="logout">Logout</a></td>
					<td><a class="button" href="delete" onclick='return confirm("Are you sure you want to delete your name from the list?")'>Delete My Name</a></td></tr>
				</table>
			<% } else { %>		
				<table align="center"><tr><td colspan="2"><a class="button" href="register">Write Name</a></td></tr></table>		
				<table align="center"><tr><td colspan="2"><a class="button" href="login">Login</a></td></tr></table>
			<% } %>
		</div>	
		<% ArrayList<String> followers = (ArrayList<String>)request.getAttribute("followers"); 
		   if(followers != null){
			   ArrayList<String> fontFamily = (ArrayList<String>)request.getAttribute("fontFamily");
			   ArrayList<String> fontColor = (ArrayList<String>)request.getAttribute("fontColor");			   
		   	Iterator<String> i1 = followers.iterator();
		   	Iterator<String> i2 = fontFamily.iterator();
		   	Iterator<String> i3 = fontColor.iterator();
		   	while(i1.hasNext()){
			   %><font size="6" face="<%= i2.next()%>" color="<%= i3.next()%>"><%= i1.next()%></font><br><%
		   	}
		   }
		%>
	</div>
	<table>
		<tr><th colspan="2">About Me</th></tr>
		<tr><td>Name</td><th>Swapnil Kharabe</th></tr>
		<tr><td>Hometown</td><th>Nagpur</th></tr>
		<tr><th colspan="2">My Courses</th></tr>
		<tr><td colspan="2">
			<ul>
				<li>Advances in Algorithms</li>
				<li>Advanced Compiler Construction</li>
				<li>Advanced Computer Architecture</li>
				<li>Pattern Recognition</li>
				<li>Distributed Systems</li>
				<li>Distributed and Parallel Databases</li>
				<li>Soft Computing</li>
				<li>Bioinformatics</li>
				<li>Information Security</li>
			</ul>
		</td></tr>
		<tr><th colspan="3">My Hobbies</th></tr>
		<tr><td colspan="3">
			<ul>
				<li>Reading
<p align="left">Reading is probably the most common hobby. The kind of literature I like is fiction. My<br>
favourite books are the Harry Potter Series by J. K. Rowling, A Prisoner of Birth by<br>
Jeffrey Archer and The Da Vinci Code by Dan Brown. Among other novels I have read<br>
include The Godfather, Palillon, The Lost Symbol etc.</p>
			</li>
				<li>Web Surfing
<p align="left">I like to surf the internet on websites such as Wikipedia following some intresting line<br>
of thought. I like to read any random topics which intrest melike the history of WWII,<br>
the military capabilities of various countries, mystries etc.</p>
				</li>
				<li>Gardening
<p><i>So I decided to spend an hour doing almost nothing,<br>
Sitting and enjoying the best of what nature could bring.<br>
There was a kind of music as the bee flapped its wing,<br>
Music so perfect That no one could ever sing.<br>
Walking little further, I spotted a butterfly<br>
Which was hovering over the flowers and then soaring high<br>
My evening hour in the garden was very well spent<br>
And now I know what beauty and music really meant!!</i></p>
				</li>

			</ul>			
		</td></tr>
		<tr><td></td><th></th></tr>
		<tr><td></td><th></th></tr>
		
	</table>
</body>
</html>
