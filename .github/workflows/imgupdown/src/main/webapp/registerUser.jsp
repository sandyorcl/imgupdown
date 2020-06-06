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
        <script type="text/javascript" src="resource/js/StdValidations.js"></script>
        <script type="text/javascript" src="resource/js/register.js"></script>
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
	<form name="addform" action="registerUser" method="post">
		
		<table style="width: 35%;border: 2px solid #dadce0; border-radius :8px; margin:0 auto;" align="center"  cellpadding = "1px" cellspacing = "1px">
			<tr>
				<td colspan=2 align="center"><h3 style="margin:5px; color:grey">Create Your Account</h3></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><h4 style="margin:5px; color:grey">Continue To Image UpDown</h4></td>
			</tr>
			<tr>
				<td style="text-align: center; color:grey; padding-left: 17px">First Name : </td>
				<td><input type="text" name="firstName" placeholder="Enter First Name" tab='0' maxlength="30"/></td>
			</tr>
			<tr>
				<td style="text-align: center; color:grey; padding-left: 17px">Last Name : </td>
				<td><input type="text" name="lastName" placeholder="Enter Last Name" tab='1' maxlength="30"/></td>
			</tr>
			<tr>
				<td style="text-align: center; color:grey;padding-left: 6px">Your Mobile : </td>
				<td><input type="text" name="mobile" placeholder="Enter Mobile Number" tab='2' maxlength="10" /></td>
			</tr>
			<tr>
				<td style="text-align: center; color:grey; padding-left: 13px">Your Email : </td>
				<td><input type="text" name="email" placeholder="Enter Your Email" tab='3' maxlength="30"/></td>
			</tr>
			<tr>
				<td style="text-align: center; color:grey; padding-left: 24px" >Password : </td>
				<td><input type="password" name="password" maxlength="15" placeholder="Enter Password" tab='4'/></td>
			</tr>
			<tr>
				<td style="text-align: center; color:grey" maxlength="15">Re-Password : </td>
				<td><input type="password" name="repassword" maxlength="15" placeholder="Re-enter Password" tab='5'/></td>
			</tr>
			<tr>
				<td style="text-align: center; color:grey; padding-left: 37px;">Gender : </td>
				<td>
					<select name='gender' tab='6'>
						<option>Select</option>
						<option value="M">Male</option>
						<option value="F">Female</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan='2' style="text-align: center;">Already member? <a href="index.jsp" style="color:blue" tab='7'>Log in</a></td>
			</tr>
			<tr>		
				<td colspan='2' style="text-align: center; height:40px;"><input type="button" value="Create User" tab='8' onclick="validateForm()"/> </td>
			</tr>
		</table> 
	</form>
</div>
</body>
</html>