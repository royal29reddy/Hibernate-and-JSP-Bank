<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<center>
<%
if(request.getParameter("message")==null){
}
else if(request.getParameter("message").equals("error")){
	out.print("<html><head>");
	out.print("<script type='text/javascript'>alert('Wrong Credentials');</script>");
	out.print("</head><body></body></html>");
}
%>
<h1>Welcome to Hibernate and JSP Bank</h1>
<form action="${pageContext.request.contextPath}/user" method="post"/>
User name: <input type="text" name="username" placeholder="Enter your User name" autofocus/><br></br>
Password: <input type="password" name="password" placeholder="Enter your Password"/><br></br>
<input type="hidden" name="action" value="login"/>
<input type="submit" value="Login"/><br></br>
</form>

<a href="${pageContext.request.contextPath}/user">Don't have an Account? Create One!</a>
</center>
</body>
</html>