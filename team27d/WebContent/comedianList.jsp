<!-- team27d [��ο�] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
ComedianDao comedianDao = new ComedianDao();
ArrayList<Comedian> list = new ArrayList<Comedian>();
list=comedianDao.selectComedianList();
%>

<table border="1">
	<tr>
		<td>�ڹ̵�� ���̵�</td>
		<td>�ڹ̵�� �̸�</td>
		<td>�ڹ̵�� ����</td>
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