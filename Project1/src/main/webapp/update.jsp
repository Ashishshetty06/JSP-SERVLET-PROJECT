<%@page import="com.alvas.proj.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student = (Student) request.getAttribute("stu");
	%>
	<form action="updatestage2" method="get">
		<table border="black">
		<tr>
				<td>ID:<input type="tel" name="id" value="<%= student.getSid()%>" readonly="readonly"><br><br>
				</td>
			</tr>
			<tr>
				<td>NAME:<input type="text" name="name" value="<%= student.getName()%>"><br><br>
				</td>
			</tr>

			<tr>
				<td>Email:<input type="email" name="email" value="<%= student.getEmail()%>">
				</td>
			</tr>

			<tr>
				<td>Phone:<input type="text" name="pno" value="<%= student.getPhone()%>">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="UPDATE"></td>
			</tr>

		</table>
	</form>
</body>
</html>