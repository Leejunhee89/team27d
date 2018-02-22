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
	<a href = "<%= request.getContextPath() %>/insertSingerForm.jsp">가수 추가</a>
	<table border = "1">
	<thead>
		<tr>
			<th>가수 ID</th>
			<th>가수 NAME</th>
			<th>가수 AGE</th>
			<th>가수 UPDATE</th>
			<th>가수 DELETE</th>
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
	<%
		}
	%>
			<!-- request.getParameter("singerId") -->

			
			<!-- 
			수정폼 선택 > 액션 업데이트
			 -->
<%-- 			<td><a href = "<%= request.getContextPath() %>/updateSingerForm.jsp?singerId=<%=singer.getsingerId()%>">수정</a></td>
			<td><a href = "<%= request.getContextPath() %>/deleteSingerAction.jsp?singerId=<%=singer.getsingerId()%>">삭제</a></td>
 --%>		<tr>
	</tbody>
	</table> 
</body>
</html>