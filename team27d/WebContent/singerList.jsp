<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>

<!DOCTYPE html PUBLIC >
<html>
<body>
	<h1>���� ����Ʈ</h1>
	<% 	
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> singerlist = singerdao.selectSingerList();
	%>
		<a href= "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
		<a href= "<%= request.getContextPath() %>/insertActorForm.jsp">�������</a> <br><br>
	<table border = "1">
	<thead>
		<tr>
			<th>���� ID</th>
			<th>���� NAME</th>
			<th>���� AGE</th>
			<th>����</th>
			<th>����</th>
		<tr>
	</thead>
	<tbody>
	<%
		for(Singer sin : singerlist){
	%>
		<tr>
			<td><%=sin.getSingerId()%></td>
			<td><%=sin.getSingerName()%></td>
			<td><%=sin.getSingerAge()%></td>
			<td><a href = "updateSingerForm.jsp?singerId=<%=sin.getSingerId()%>">����</a></td>
			<td><a href = "deleteSingerAction.jsp?singerId=<%=sin.getSingerId()%>">����</a></td>
		<tr>
	<%
		}
	%>
	</tbody>
	</table> 
</body>
</html>