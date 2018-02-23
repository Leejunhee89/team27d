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
		Rapper rapper = rapdao.updateRapperOne(rapperId);
	%>
	<h3>래퍼 수정</h3>
		<hr>
		<table border = "1">
			<thead>
				<tr>
					<th>속성</th>
					<th>입력란</th>
				</tr>	
			</thead>
			<tbody>
				<form action = "<%= request.getContextPath() %>/rapper/updateRapperAction.jsp" method = "post">
					<tr>
						<td>아이디</td>
						<td><input type = "text" name = rapper_id value = <%= rapper.getRapperId() %> readonly></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type = "text" name = rapper_name value = <%= rapper.getRapperName() %>></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type = "text" name = rapper_age value = <%= rapper.getRapperAge() %>></td>
					</tr>
					<tr>
						<td colspan = "2">
							<input type = "submit" value = "수정버튼" >
						</td>
					</tr>
				</form>
			</tbody>
		</table>
</body>
</html>