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
		ArrayList<Rapper> rapperlist = rapperdao.selectRapper();
	%>
		<a href= "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
		<a href= "<%= request.getContextPath() %>/rapper/insertRapperForm.jsp">���۵��</a> <br><br>
	<table border="1">
		<thead>
			<tr>
				<th>���� ID</th>
				<th>���� NAME</th>
				<th>���� AGE</th>
				<th>����</th>
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
				<td><a href = "<%= request.getContextPath() %>/rapper/updateRapperForm.jsp?rapperId=<%= rap.getRapperId() %>">����</a></td>
				<td><a href = "<%= request.getContextPath() %>/rapper/deleteRapperAction.jsp?rapperId=<%= rap.getRapperId() %>">����</a>	</td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>