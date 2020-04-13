<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
            <%@ page import="org.kautilya.entity.Users" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<center>
<%
String username=request.getParameter("username");
long accountNumber=(Long)request.getAttribute("accountNumber");
List<Users> users=(List<Users>)request.getAttribute("users");
for(Users user:users){
	if(username.equals(user.getUserName())){
		String fName=user.getFirstName();
		String lName=user.getLastName();
		String uName=user.getUserName();
		String password=user.getPassword();
		String email=user.getEmail();
		long mobile=user.getMobile();
		
%>
<form action="${pageContext.request.contextPath}/operations" method="get">
First Name: <input type="text" name="fname" value="<%=fName%>"/><br></br>
Last Name: <input type="text" name="lname" value="<%=lName%>"/><br></br>
User Name: <input type="text" name="uname" value="<%=uName%>"/><br></br>
Password: <input type="text" name="password" value="<%=password%>"/><br></br>
Email: <input type="text" name="email" value="<%=email%>"/><br></br>
Mobile: <input type="text" name="mobile" value="<%=mobile%>"/><br></br>
<input type="hidden" name="action" value="update"/>
<input type="hidden" name="accountNumber" value="<%=accountNumber%>"/>
<input type="submit" value="Update Information"/>
</form>
<%		
	}
}

%>
<br>
<a href="${pageContext.request.contextPath}/home.jsp?username=<%=username %>">Click to go back home</a>
</center>
</body>
</html>