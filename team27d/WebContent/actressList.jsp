<!-- team27d [������] -->

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
	<h1>����� ����Ʈ</h1>
	<table border ="1">
	<thead>
		<tr>	
			<th>����� ID</th>	
			<th>����� NAME</th> 
			<th>����� AGE</th>
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
		<a href= "<%= request.getContextPath() %>/insertActressForm.jsp">�����</a>
</table>
</body>
</html>