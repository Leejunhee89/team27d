<!-- team27d[나윤주] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>

<!DOCTYPE html PUBLIC >
<html>
<body>
	<h1>가수 리스트</h1>
	<% 	
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> singerlist = singerdao.selectSingerList();
	%>
		<a href= "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
		<a href= "<%= request.getContextPath() %>/insertSingerForm.jsp">가수등록</a> <br><br>
	<table border = "1">
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
		for(Singer sin : singerlist){
	%>
		<tr>
			<td><%=sin.getSingerId()%></td>
			<td><%=sin.getSingerName()%></td>
			<td><%=sin.getSingerAge()%></td>
			<td><a href = "updateSingerForm.jsp?singerId=<%=sin.getSingerId()%>">수정</a></td>
			<td><a href = "deleteSingerAction.jsp?singerId=<%=sin.getSingerId()%>">삭제</a></td>
		<tr>
	<%
		}
	%>
	</tbody>
	</table> 
</body>
</html>