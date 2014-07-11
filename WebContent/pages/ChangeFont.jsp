<!DOCTYPE html>
<html>
<head>
<script src="http://yui.yahooapis.com/3.8.0/build/yui/yui-min.js"></script>
<link rel="stylesheet" href="../css/ChangeFont.css" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Princess+Sofia|Snowburst+One|Frijole|Joti+One|Vampiro+One|Faster+One|Akronim|Merienda|Arizonia|Stalinist+One|Macondo+Swash+Caps|Smokum|Snowburst+One|The+Girl+Next+Door|Elsie|Bonbon|Hanalei|Architects+Daughter' rel='stylesheet' type='text/css'>
<script src="../js/ChangeFont.js"></script>
<link rel="stylesheet" href="../css/heading.css" type="text/css" />
<title>Change Font</title>
</head>
<body onload="selectDropdown()">
	<h1>Swapnil's Web Page</h1>
	<div id="headerMessage"><% if(request.getAttribute("headerMessage") != null)out.print(request.getAttribute("headerMessage"));%></div>
	<div class="centerBox" align="center">
		<% if(session!=null && session.getAttribute("username") != null){%>
			<form action="/MyWebPage/changefont" method="POST">
				<div class="sliders yui3-skin-sam">
					<dl>
						<dt>R: <span id="r-val" class="val"></span></dt>
						<dd id="r-slider"></dd>
						<dt>G: <span id="g-val" class="val"></span></dt>
						<dd id="g-slider"></dd>
						<dt>B: <span id="b-val" class="val"></span></dt>
						<dd id="b-slider"></dd>
					</dl>
				</div>
				<input name="fontColor" id="fontColor" type="hidden" value="<%= session.getAttribute("fontColor")%>"></input>
				<input name="oldFontFamily" id="oldFontFamily" type="hidden" value="<%= session.getAttribute("fontFamily")%>"></input>
				<select name="fontFamily" id="fontFamily" onchange="setfontFamily()">
					<option id="Princess Sofia" value="Princess Sofia">Princess Sofia</option>
					<option id="Snowburst One" value="Snowburst One">Snowburst One</option>
					<option id="Frijole" value="Frijole">Frijole</option>
					<option id="Joti One" value="Joti One">Joti One</option>
					<option id="Vampiro One" value="Vampiro One">Vampiro One</option>
					<option id="Faster One" value="Faster One">Faster One</option>
					<option id="Akronim" value="Akronim">Akronim</option>		
					<option id="Merienda" value="Merienda">Merienda</option>
					<option id="Arizonia" value="Arizonia">Arizonia</option>
					<option id="Stalinist One" value="Stalinist One">Stalinist One</option>		
					<option id="Macondo+Swash Caps" value="Macondo Swash Caps">Macondo Swash Caps</option>
					<option id="Smokum" value="Smokum">Smokum</option>
					<option id="The Girl Next Door" value="The Girl Next Door">The Girl Next Door</option>
					<option id="Elsie" value="Elsie">Elsie</option>
					<option id="Bonbon" value="Bonbon">Bonbon</option>
					<option id="Hanalei" value="Hanalei">Hanalei</option>
					<option id="Architects Daughter" value="Architects Daughter">Architects Daughter</option>
				</select>
				<br><font id="text" size="6" color="<%= session.getAttribute("fontColor")%>" face="<%= session.getAttribute("fontFamily")%>"><%= session.getAttribute("fullName")%></font><br>
				<input type="submit" value="Save"></input>
			</form>
		<% } else out.print("Session Expired");	%>
	</div>
</body>
</html>