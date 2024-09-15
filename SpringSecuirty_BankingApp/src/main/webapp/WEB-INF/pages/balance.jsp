<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
</head>
<body>

	<h1 style='text-align: center; color: red'>Welcome to Balance Page</h1>
	<pre>
		<b>
 		Current Account Balance  = <%=new Random().nextInt(200000)%>
 		Saving Account Balance = <%=new Random().nextInt(100000)%>
		</b>
 	</pre>
	<br>
	<a href='./'>Home</a>
	<br>
	<a href='./payment'>Payment</a>
	<br>
	<a href='./loan'>Loan</a>
	<br>
	<a href='logout'>Sign Out</a>


</body>
</html>