<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<%@ page import = "service.Rapper" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	int rapperId = Integer.parseInt(request.getParameter("rapperId"));
	RapperDao rapdao = new RapperDao();
	Rapper rapper = rapdao.updateRapperSelect(rapperId);
%>
	<h3>���� ����</h3>
		<hr>
		<table border = "1">
			<thead>
				<tr>
					<th>�Ӽ�</th>
					<th>�Է¶�</th>
				</tr>	
			</thead>
			<tbody>
				<form action = "<%= request.getContextPath() %>/updateRapperAction.jsp" method = "post">
					<tr>
						<td>���̵�</td>
						<td><input type = "text" name = rapper_id value = <%= rapper.getRapperId() %> readonly></td>
					</tr>
					<tr>
						<td>�̸�</td>
						<td><input type = "text" name = rapper_name value = <%= rapper.getRapperName() %>></td>
					</tr>
					<tr>
						<td>����</td>
						<td><input type = "text" name = rapper_age value = <%= rapper.getRapperAge() %>></td>
					</tr>
					<tr>
						<td colspan = "2">
							<input type = "submit" value = "������ư" >
						</td>
					</tr>
				</form>
			</tbody>
		</table>
</body>
</html>