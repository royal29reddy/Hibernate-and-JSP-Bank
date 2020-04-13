<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
<center>
<%
String errorMessage="";
if(request.getParameter("message")==null){
	errorMessage="";
}
else{

	out.print("<html><head>");
	out.print("<script type='text/javascript'>alert('Wrong Credentials');</script>");
	out.print("</head><body></body></html>");
}
%>
<h1>User Registration Screen</h1>
<form action="${pageContext.request.contextPath}/user" method="post">
First Name:<input type="text" name="firstname" placeholder="Enter your First name" required/><br></br>
Last Name:<input type="text" name="lastname" placeholder="Enter your Last name" required/><br></br>
User Name:<input type="text" name="username" placeholder="Enter your User name" required/><br></br>
Password:<input type="password" name="password" placeholder="Enter your Password" required/><br></br>
Email:<input type="email" name="email" placeholder="Enter your Email Adress" required/><br></br>
Mobile Number:<input type="text" name="mobile" placeholder="Enter your Mobile Number" required/><br></br>
<input type="hidden" name="action" value="signup"/>
<input type="submit" value="Sign Up!"/>
</form>
</center>
</body>
</html>