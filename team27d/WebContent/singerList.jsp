<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>	
<body>
	<h1>���� ����Ʈ</h1>
	<% 		
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> singerlist = new ArrayList<Singer>();
		singerlist = singerdao.selectSingerList();
	%>
	<table border = "1">
		<tr>
			<th>���̵�</th>
			<th>�̸�</th>
			<th>����</th>
		<tr>
	<%
		for(Singer sin : singerlist){
	%>
		<tr>
			<td><%=sin.getSingerId()%></td>
			<td><%=sin.getSingerName()%></td>
			<td><%=sin.getSingerAge()%></td>
		<tr>
	<%
		}
	%>
		<tr>
		<td colspan="4"><a href="/team27d/index.jsp">�������ΰ���</a></td>
		</tr>
	</table> 
</body>
</html>