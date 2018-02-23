<!-- //team27d [유국화] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<%@ page import = "service.Rapper" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>래퍼 리스트</h1>
	<%
		request.setCharacterEncoding("euc-kr");
		RapperDao rapperdao = new RapperDao();
		ArrayList<Rapper> rapperlist = rapperdao.selectRapper();
	%>
		<a href= "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
		<a href= "<%= request.getContextPath() %>/rapper/insertRapperForm.jsp">래퍼등록</a> <br><br>
	<table border="1">
		<thead>
			<tr>
				<th>래퍼 ID</th>
				<th>래퍼 NAME</th>
				<th>래퍼 AGE</th>
				<th>수정</th>
				<th>삭제</th>
			<tr>
		</thead>
		<tbody>
		<%
			for(Rapper rap : rapperlist){
		%>
			<tr>
				<td><%=rap.getRapperId()%></td>
				<td><%=rap.getRapperName()%></td>
				<td><%=rap.getRapperAge()%></td>
				<td><a href = "<%= request.getContextPath() %>/rapper/updateRapperForm.jsp?rapperId=<%= rap.getRapperId() %>">수정</a></td>
				<td><a href = "<%= request.getContextPath() %>/rapper/deleteRapperAction.jsp?rapperId=<%= rap.getRapperId() %>">삭제</a>	</td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>