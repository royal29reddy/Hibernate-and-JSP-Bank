<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
td {
  padding: 15px;
}
</style>
</head>
<body>
<%
String errorMessage="";
if(request.getParameter("message")==null){
	errorMessage="";
}
else if(request.getParameter("message").equals("mobile")){

	out.print("<html><head>");
	out.print("<script type='text/javascript'>alert('Invalid Mobile number while profile update. Please Try Again !');</script>");
	out.print("</head><body></body></html>");
}
else if(request.getParameter("message").equals("cheque")){

	out.print("<html><head>");
	out.print("<script type='text/javascript'>alert('Cheque must only contain 10 numerical digits. Please Try Again !');</script>");
	out.print("</head><body></body></html>");
}
String username=request.getParameter("username");
%>
<center>
<h1>Hello <%=username%></h1>
<h3>Services you can do Today are:</h3>
<table width="80%" border="1">
<tr><td>
<form action="${pageContext.request.contextPath}/service">
<input type="hidden" name="username" value="<%=username%>"/>

</form>
<a href="${pageContext.request.contextPath}/service?action=send&username=<%=username%>">Send Money</a>
</td><td>
<a href="${pageContext.request.contextPath}/service?action=request&username=<%=username%>">Recieve Money</a>
</td></tr>
<tr><td>
<a href="${pageContext.request.contextPath}/service?action=deposit&username=<%=username%>">Deposit Cheques</a>
</td><td>
<a href="${pageContext.request.contextPath}/service?action=balance&username=<%=username%>">View Account Balance</a>
</td></tr>
<tr><td colspan="2">
<center>
<a href="${pageContext.request.contextPath}/service?action=profile&username=<%=username%>">View Profile</a>
</center>
</td></tr>
</table>
<br></br>
<a href="${pageContext.request.contextPath}/">Logout</a>
</center>
</body>
</html>