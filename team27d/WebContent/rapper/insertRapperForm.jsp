<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
	%>
	<h3>래퍼 등록화면</h3>
		<hr>
		<table border = "1">
			<thead>
				<tr>
					<th>속성</th>
					<th>입력란</th>
				</tr>	
			</thead>
			<tbody>
				<form action = "<%= request.getContextPath() %>/rapper/insertRapperAction.jsp" method = "post">
					<tr>
						<tr>
						<td>이름</td>
						<td><input type = "text" name = "rapper_name"></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type = "text" name = "rapper_age"></td>
					</tr>
					<tr>
						<td colspan = "2"><input type = "submit" value = "등록버튼" ></td>
					</tr>
				</form>
			</tbody>
		</table>
</body>
</html>