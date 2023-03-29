<%@page import="org.apache.catalina.User"%>
<%@page import="dto.user"%>
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
<table border="1">
<tr>
 
<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Gender</th>
<th>mobile</th>
<th>Passwod</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<% List<user> list=(List<user>)request.getAttribute("list"); 
for(user user:list){%>
<tr>
<th><%=user.getName() %></th>
<th><%=user.getEmail() %></th>
<th><%=user.getAddress() %></th>
<th><%=user.getGender() %></th>
<th><%=user.getMobile() %></th>
<th><%=user.getPassword() %></th>
<th><a href="edit.jsp?email=<%=user.getEmail()%>"><button>Edit</button></th>
<th><a href="delete?email=<%=user.getEmail()%>"><button>Delete</button></th>
</tr>
<% }%>



</table>

</body>
</html>