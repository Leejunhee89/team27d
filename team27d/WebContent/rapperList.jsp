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
	<h1>래퍼 입력하기</h1>
	<%@ include file = "insertRapperForm.jsp"%>
	
	<h1>래퍼 리스트</h1>
	<%
		RapperDao rapperdao = new RapperDao();
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
		rapperlist = rapperdao.selectRapperList();
	%>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
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
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>