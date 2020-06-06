<%@page import="com.iud.model.LoginUser"%>
<style>
.topbar {
	background-color: #cbe4f8;
	height: 20px;
	position: relative;
	width: 100%;
	color: #000;
	font-size: 15px;
	font-weight: bold;
	padding-top: 0.5%;
	border: 0px;
}

.tdHeader {
	COLOR: #FFFFFF;
	FONT-FAMILY: Arial;
	FONT-SIZE: 0.28cm;
	FONT-WEIGHT: bold;
	TEXT-VALIGN: top;
	TEXT-INDENT: 2pt;
	border: 0px;
}

.tdNoBoder {
	border: 0px;
}
</style>


<%
	if (session.getAttribute("loginUserDetails") == null) {
%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
	}

	LoginUser loginUserDetails = (LoginUser) session.getAttribute("loginUserDetails");
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr class="tdNoBoder">
		<td colspan="2" align="left" class="tdNoBoder" style="opacity:0.65"><img
			src="resource/img/LogoImgUpDown.png" width="180" height="45" /></td>
	</tr>
	<tr class="topbar">
		<td class="tdHeader" nowrap><font color="blue">User
				Id&nbsp;&nbsp;:<%=loginUserDetails.getEmail_id()%></font></td>
		<td class="tdHeader" align=right><a target=_self
			href="<%=request.getContextPath()%>/logout">LOGOUT</a></td>
	</tr>
</table>
