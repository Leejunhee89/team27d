<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>loginForm.jsp</title>
</head>
<body>
	<%
		System.out.println("=====loginForm.jsp=====");
	%>
	<form action = "<%= request.getContextPath() %>/login/loginAction.jsp" method = "post">
		<table border = "1">
			<tr>
				<th>아이디</th>
				<td><input type = "text" name = "memberId"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type = "text" name = "memberPw"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center"><input type = "submit" value = "로그인"></td>
			</tr>
		</table>
	</form>
</body>
</html>