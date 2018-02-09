<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC>
<%@ page import = "service.ActressDao"  %>
<%@ page import = "service.Actress"  %>
<%@ page import = "java.util.ArrayList" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<% 
	ActressDao ado = new ActressDao();
	ArrayList<Actress> list = ado.selectActress();

%>

<table border ="1">
	<tr>
		<td>id</td>
		<td>name</td>
		<td>age</td>
	</tr>
<%
	for(Actress actress : list) {
%>	
	<tr>
		<td><%= actress.getActressId() %></td><td><%= actress.getActressName() %></td><td><%= actress.getActressAge() %></td>
	</tr>



<% 
}
%>



</body>
</html>