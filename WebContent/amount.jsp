<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amount</title>
</head>
<body>
<center>
<%
String action=(String)request.getAttribute("action");
String username=request.getParameter("username");
String userfirstname=(String)request.getAttribute("userfirstname");
String userlastname=(String)request.getAttribute("userlastname");
String userusername=(String)request.getAttribute("userusername");
String useremail=(String)request.getAttribute("useremail");
long usermobile=0;
if(request.getAttribute("usermobile")==null){
	usermobile=0;
}
else{
	usermobile=(Long)request.getAttribute("usermobile");
}

%>
<form action="${pageContext.request.contextPath}/operations" action="get">

<br></br>

Enter Amount:<input type="number" name="amount" placeholder="Enter the amount"/>
<input type="hidden" name="userfirstname" value="<%=userfirstname%>"/>
<input type="hidden" name="userlastname" value="<%=userlastname%>"/>
<input type="hidden" name="userusername" value="<%=userusername%>"/>
<input type="hidden" name="useremail" value="<%=useremail%>"/>
<input type="hidden" name="usermobile" value="<%=usermobile%>"/>
<input type="hidden" name="action" value="<%=action%>"/>
<input type="hidden" name="username" value="<%=username%>"/>
<input type="submit" value="Proceed"/>
</form>

</center>
</body>
</html>