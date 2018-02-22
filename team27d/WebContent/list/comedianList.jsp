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
		/*Comedian클래스를 통해 새로운 객체를 생성한 후 그 주소를 comedianDao에 담는다.
		 *Comedian형 ArrayList 클래스를 통해 새로운 객체를 생성한 후 주소를 list에 담는다.
		 *ComedianDao클래스 내 selectComedianList메소드를 실행한 후 주소를 list에 담는다.
		 */
		request.setCharacterEncoding("euc-kr");
		ComedianDao comedianDao = new ComedianDao();
		ArrayList<Comedian> list = comedianDao.selectComedianList();
	%>
	<a href = "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
	<a href = "<%= request.getContextPath() %>/insert/insertComedianForm.jsp">코메디언 등록</a><br><br>
	<table border = "1">
		<thead>
			<tr>
				<th>코미디언 ID</th>
				<th>코미디언 NAME</th>
				<th>코미디언 AGE</th>
				<th>수정</th>
				<th>삭제</th>
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
					<td><a href="<%=request.getContextPath()%>/update/updateComedianForm.jsp?comedianId=<%=comedian.getComedianId()%>">수정</a></td>
					<td><a href="<%=request.getContextPath()%>/delete/deleteComedianAction.jsp?comedianId=<%=comedian.getComedianId()%>">삭제</a></td>
				</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>