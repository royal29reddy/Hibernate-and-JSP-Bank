<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ page import="org.kautilya.entity.Transaction" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
</head>
<body>
<center>

<%
String username=request.getParameter("username");
%>
<h1>Hello <%=username %></h1>
<%
List<Transaction> users=(List<Transaction>)request.getAttribute("users");
for(Transaction user:users){
	out.println("Your Account Balance is: $"+user.getBalance());
}
%>
<br></br>
<a href="${pageContext.request.contextPath}/home.jsp?username=<%=username%>">Return to Home</a>
</center>
</body>
</html>