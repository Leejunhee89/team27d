<!-- //team27d [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.SingerDao" %>
<%@ page import = "service.Singer" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>���� ����Ʈ</h1>
	<%
		request.setCharacterEncoding("euc-kr");
		SingerDao rapperdao = new SingerDao();
		ArrayList<Singer> singerlist = rapperdao.selectSinger();
	%>
		<a href= "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
		<a href= "<%= request.getContextPath() %>/insert/insertSingerForm.jsp">�������</a> <br><br>
	<table border="1">
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
			for(Singer sing : singerlist){
		%>
			<tr>
				<td><%= sing.getSingerId() %></td>
				<td><%= sing.getSingerName() %></td>
				<td><%= sing.getSingerAge() %></td>
				<td><a href = "<%= request.getContextPath() %>/update/updateSingerForm.jsp?singerId=<%= sing.getSingerId() %>">����</a></td>
				<td><a href = "<%= request.getContextPath() %>/delete/deleteSingerAction.jsp?singerId=<%= sing.getSingerId() %>">����</a>	</td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>