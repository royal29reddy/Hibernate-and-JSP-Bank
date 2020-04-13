<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
</head>
<body>
<%
String username=request.getParameter("username");
String action=(String)request.getAttribute("action");
%>
<form action="${pageContext.request.contextPath}/operations" action="get">
Enter the amount: <input type="text" name="amount" placeholder="Enter the amount"/>
<br></br>
Enter the cheque Number: <input type="text" name="cheque" placeholder="Enter the amount"/>
<br></br>
<input type="hidden" name="action" value="deposit"/>
<input type="submit" value="Deposit"/>
</form>
</body>
</html>