<!-- team27d [방민영] -->

<!-- 과제: form으로 가는것, 아이디이름나이입력하고 post방식으로보내기 -->

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
	<h1>코미디언 리스트</h1>
	<table border = "1">
		<tr>
			<td>코미디언 ID</td><td>코미디언 NAME</td><td>코미디언 AGE</td>
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