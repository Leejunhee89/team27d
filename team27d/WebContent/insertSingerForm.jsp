<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>InsertSingerForm.jsp</title>

<%
	request.getRequestURI();
	request.setCharacterEncoding("euc-kr");
%>
<center>
	<h1>insertSingerForm</h1>
	<form action="<%=request.getContextPath()%>/insertSingerAction.jsp"	method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="singer_id" size="20"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="singer_name" size="20"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="singer_age" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="등록하기"></td>
			</tr>
		</table>
	</form>
</center>
