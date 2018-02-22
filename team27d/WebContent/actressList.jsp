<!-- team27d [이준희] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "service.ActressDao"  %>
<%@ page import = "service.Actress"  %>
<%@ page import = "java.util.ArrayList" %>
<% 
	ActressDao ado = new ActressDao();
	ArrayList<Actress> list = ado.selectActress();
%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
	<h1>여배우 리스트</h1>
	<table border ="1">
	<thead>
		<tr>	
			<th>여배우 ID</th>	
			<th>여배우 NAME</th> 
			<th>여배우 AGE</th>
		</tr>
	</thead>	
	
	<%
		for(Actress actress : list) {
	%>	
	<tbody>	
		<tr>
			<td><%= actress.getActressId() %></td>
			<td><%= actress.getActressName() %></td>
			<td><%= actress.getActressAge() %></td>
		</tr>
	</tbody>  
	<% 
	}
	%>
		<a href= "<%= request.getContextPath() %>/insertActressForm.jsp">배우등록</a>
</table>
</body>
</html>