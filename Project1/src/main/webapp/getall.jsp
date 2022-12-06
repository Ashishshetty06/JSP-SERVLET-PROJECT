<%@page import="java.util.ArrayList"%>
<%@page import="com.alvas.proj.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>

		<h1>STUDENTS LIST</h1>
		<table border="5px">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>DELETE</th>
				<th>UPDATE</th>
			</tr>
			<%
				List<Student> students = (ArrayList) request.getAttribute("list");
				for (Student student : students) {
			%>
			<tr>
				<th><%=student.getSid()%></th>
				<th><%=student.getName()%></th>
				<th><%=student.getEmail()%></th>
				<th><%=student.getPhone()%></th>
				<th><a href="delete?id=<%=student.getSid()%>">Delete</a></th>
				<th><a href="update?id=<%=student.getSid()%>">Update</a></th>
			</tr>

			<%
				}
			%>
		</table>

	</center>

</body>
</html>