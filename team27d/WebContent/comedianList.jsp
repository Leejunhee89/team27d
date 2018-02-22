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
				<tr>
					<td><a href = "<%= request.getContextPath() %>/index.jsp">home</a></td>
					<td><a href = "<%= request.getContextPath() %>/insertComedianForm.jsp">코미디언 추가</a></td>
				</tr>
		</tbody>
	</table>
</body>
</html>