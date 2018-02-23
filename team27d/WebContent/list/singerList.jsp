<!-- //team27d [나윤주] -->
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
	<h1>가수 리스트</h1>
	<%
		request.setCharacterEncoding("euc-kr");
		SingerDao rapperdao = new SingerDao();
		ArrayList<Singer> singerlist = rapperdao.selectSinger();
	%>
		<a href= "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
		<a href= "<%= request.getContextPath() %>/insert/insertSingerForm.jsp">가수등록</a> <br><br>
	<table border="1">
		<thead>
			<tr>
				<th>가수 ID</th>
				<th>가수 NAME</th>
				<th>가수 AGE</th>
				<th>수정</th>
				<th>삭제</th>
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
				<td><a href = "<%= request.getContextPath() %>/update/updateSingerForm.jsp?singerId=<%= sing.getSingerId() %>">수정</a></td>
				<td><a href = "<%= request.getContextPath() %>/delete/deleteSingerAction.jsp?singerId=<%= sing.getSingerId() %>">삭제</a>	</td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>