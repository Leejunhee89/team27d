<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<form action = "<%= request.getContextPath() %>/login/loginAction.jsp" method = "get">
		<table border = "1">
			<tr>
				<th>���̵�</th>
				<td><input type = "text" name = "memberId"></td>
			</tr>
			<tr>
				<th>�н�����</th>
				<td><input type = "text" name = "memberPw"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center"><input type = "submit" value = "�α���"></td>
			</tr>
		</table>
	</form>
</body>
</html>