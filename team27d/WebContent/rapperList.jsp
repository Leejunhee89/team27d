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
		RapperDao rapperdao = new RapperDao();
		ArrayList<Rapper> rapperlist = rapperdao.selectRapperList();
	%>
	<table border="1">
		<thead>
			<tr>
				<th>���̵�</th>
				<th>�̸�</th>
				<th>����</th>
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
		<a href= "<%= request.getContextPath() %>/insertRapperForm.jsp">���۵��</a>
		</tbody>
	</table>
</body>
</html>