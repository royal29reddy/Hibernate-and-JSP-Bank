<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
</head>
<body>
<%
out.print("<html><head>");
if(request.getParameter("message")==null){
	
}
else if(request.getParameter("message").equals("amount")){
	out.print("<script type='text/javascript'>alert('Amount should be greater than 0. Please Try Again !');</script>");
}
else{
	out.print("<script type='text/javascript'>alert('Wrong Credentials or User is not registered in the system');</script>");
}
out.print("</head><body></body></html>");

String operation=(String)request.getAttribute("operation");
String username=request.getParameter("username");
if((String)request.getAttribute("operation")==null){
	operation=request.getParameter("operation");
}
%>

<center>
<h1>Send/Request Money</h1>

<form action="${pageContext.request.contextPath}/operations" method="post">
<%
if(operation.equals("deposit")){
%>
Cheque Number: <input type="text" name="chequeNumber" placeholder="Enter Cheque Number" required/><br></br>
<%
}
else{
%>
First Name:<input type="text" name="userfirstname" placeholder="Enter First name" required/><br></br>
Last Name:<input type="text" name="userlastname" placeholder="Enter Last name" required/><br></br>
User Name:<input type="text" name="userusername" placeholder="Enter User name" required/><br></br>
Email:<input type="email" name="useremail" placeholder="Enter Email Adress" required/><br></br>
Mobile Number:<input type="text" name="usermobile" placeholder="Enter Mobile Number" required/><br></br>
<%
}

%>
<input type="hidden" name="operation" value="<%=operation%>"/>
<input type="hidden" name="username" value="<%=username%>"/>
<input type="submit" value="Proceed !"/>
</form>
<br>
<a href="${pageContext.request.contextPath}/home.jsp?username=<%=username %>">Click to go back home</a>
</center>
</body>
</html>