<!-- //team27d [����ȭ] -->
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
	<h1>���� ����Ʈ</h1>
	<%
		request.setCharacterEncoding("euc-kr");
		RapperDao rapperdao = new RapperDao();
		ArrayList<Rapper> rapperlist = rapperdao.selectRapperList();
	%>
	<a href= "<%= request.getContextPath() %>/insertRapperForm.jsp">���۵��</a>
	<table border="1">
		<thead>
			<tr>
				<th>���� ID</th>
				<th>���� NAME</th>
				<th>���� AGE</th>
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