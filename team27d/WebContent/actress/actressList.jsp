<!-- team27d [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "service.ActressDao"  %>
<%@ page import = "service.Actress"  %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>
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
	Member member = (Member)session.getAttribute("loginMember");
%>	
	<a href= "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
<% 
	if (member != null) {
%>	
	<a href= "<%= request.getContextPath() %>/actress/insertActressForm.jsp">�����</a> <br><br>
<%
	}
%>	
	
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
	<%
		if (member != null) {
	%>		
			<td><a href="<%=request.getContextPath()%>/actress/updateActressForm.jsp?actressId=<%=actress.getActressId() %>">����</a></td>
			<td><a href="<%=request.getContextPath()%>/actress/deleteActressAction.jsp?actressId=<%=actress.getActressId() %>">����</a></td>
	<%
		}
	%>	
		</tr>		
	</tbody>  
	<% 
	}
	%>
		
</table>
</body>
</html>