<!-- team27d [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "service.ActressDao"  %>
<%@ page import = "service.Actress"  %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
	<h1>����� ����Ʈ</h1>
<% 
	ActressDao ado = new ActressDao();
	ArrayList<Actress> list = ado.selectActress();
%>	
	<a href= "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
	<a href= "<%= request.getContextPath() %>/insert/insertActressForm.jsp">�����</a> <br><br>
	<table border ="1">
	<thead>
		<tr>	
			<th>����� ID</th>	
			<th>����� NAME</th> 
			<th>����� AGE</th>
			<th>����</th>
			<th>����</th>
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
			<td><a href="<%=request.getContextPath()%>/update/updateActressForm.jsp?actressId=<%=actress.getActressId() %>">����</a></td>
			<td><a href="<%=request.getContextPath()%>/delete/deleteActressAction.jsp?actressId=<%=actress.getActressId() %>">����</a></td>
		</tr>
	</tbody>  
	<% 
	}
	%>
		
</table>
</body>
</html>