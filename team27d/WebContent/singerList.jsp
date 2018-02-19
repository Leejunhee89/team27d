<!-- team27d[나윤주] -->
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
	<h1>가수 리스트</h1>
	<% 		
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> singerlist = new ArrayList<Singer>();
		singerlist = singerdao.selectSingerList();
	%>
	<table border = "1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
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
		<td colspan="4"><a href="/team27d/index.jsp">메인으로가기</a></td>
		</tr>
	</table> 
</body>
</html>