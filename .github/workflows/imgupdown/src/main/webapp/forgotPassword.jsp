<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload/Download</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="resource/js/jquery.placeholder-enhanced.js"></script>
</head>
<body style="background: url(resource/img/bkg.jpg) no-repeat; background-size: cover;">
<div style="padding:75px">
<%
String msg = (String) request.getAttribute("msg");
String msgcolor = (String) request.getAttribute("msgcolor");
msgcolor = msgcolor != null ? msgcolor : "red";
if(msg != null)
{
%>
<div>
	<h3 style="margin:5px; color:<%=msgcolor%>; text-align:center"> <%=msg%> </h3>
</div>
<%
}
%>
<form action="forgotPassword" method="post" >
		
	<table style="width: 35%;border: 2px solid #dadce0; border-radius :8px; margin:0 auto;" align="center"  cellpadding = "1px" cellspacing = "1px">
		<tr>
			<td colspan=2 align="center"><h3 style="margin:5px; color:grey">Reset Your Account Password</h3></td>
		</tr>
		<tr>
			<td colspan=2 align="center"><h4 style="margin:5px; color:grey">Please enter your login email, we'll send a new random password to your inbox</h4></td>
		</tr>
		<tr>
			<td style="text-align: center; color:grey">Your Email : </td>
			<td><input type="text" name="email" placeholder="Enter Your Email" tab='0'/></td>
		</tr>
		<tr>		
				<td colspan='2' style="text-align: center; height:40px;">
				<input type="submit" value="Send me new password" tab='1'/> </td>
		</tr>
		<%
		if(request.getAttribute("message") != null) {
		%>
		<tr>
			<td colspan='2' style="text-align: center; color:grey"><%=request.getAttribute("message")%></td>
		</tr>
		
		<% } %>
	</table> 
</form>
</div>
</body>
</html>