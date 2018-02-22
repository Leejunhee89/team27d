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
		<th>id</th>	
		<th>name</th> 
		<th>age</th>
	</thead>	
	<%
		for(Actress actress : list) {
	%>	
		<tr>
			<td><%= actress.getActressId() %></td><td><%= actress.getActressName() %></td><td><%= actress.getActressAge() %></td>
		</tr>
	  
	<% 
	}
	%>
	<a href= "<%= request.getContextPath() %>/insertActressForm.jsp">배우등록</a>
</table>
</body>
</html>