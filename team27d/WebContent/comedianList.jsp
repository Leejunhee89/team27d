<!-- team27d [방민영] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
	<h1>코미디언 리스트</h1>
	<%
		// 주석 추가
		ComedianDao comedianDao = new ComedianDao();
		ArrayList<Comedian> list = new ArrayList<Comedian>();
		list=comedianDao.selectComedianList();
	%>
	<table border = "1">
		<thead>
			<tr>
				<!-- th -->
				<th>코미디언 ID</th>
				<th>코미디언 NAME</th>
				<th>코미디언 AGE</th>
			</tr>
		</thead>
		<tbody>
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
		</tbody>
	</table>
</body>
</html>