<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
	<%
		if (session.getAttribute("myname") != null) {
	%>
	<h1><a href="Register.html"><button>ADD student</button></a>
	<br>
	<a href="view"><button>Display details</button></a>
	<br>
	<a href="Logout"><button>LogOut</button></a></h1>
	


	<%
		} else {
		response.sendRedirect("Login.html");
		}
	%>
	</center>
</body>
</html>