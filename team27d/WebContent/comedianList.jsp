<!-- team27d [��ο�] -->

<!-- ����: form���� ���°�, ���̵��̸������Է��ϰ� post������κ����� -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<%
ComedianDao comedianDao = new ComedianDao();
ArrayList<Comedian> list = new ArrayList<Comedian>();
list=comedianDao.selectComedianList();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�ڹ̵�� ����Ʈ</h1>
	<table border = "1">
		<tr>
			<td>�ڹ̵�� ID</td><td>�ڹ̵�� NAME</td><td>�ڹ̵�� AGE</td>
		</tr>
			<%
				for(Comedian comedian : list) {
			%>
		<tr>
			<td><%=comedian.getComedianId()%></td>
			<td><%=comedian.getComedianName() %></td>
			<td><%=comedian.getComedianAge() %></td>
		</tr>
			<%
				}
			%>
	</table>
</body>
</html>