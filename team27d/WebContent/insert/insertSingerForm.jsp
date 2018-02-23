<!-- team27d[나윤주] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>InsertSingerForm.jsp</title>
</head>
<body>
	<h3>가수 등록화면</h3>
	<form action="<%=request.getContextPath()%>/insert/insertSingerAction.jsp"	method="post">
		<table border="1">
			<thead>
				<tr>
					<th>속성</th>
					<th>입력란</th>
				</tr>	
			</thead>
			<tbody>
			<tr>
				<td>이름</td>
				<td><input type="text" name="singer_name" size="20"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="singer_age" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="등록버튼"></td>
			</tr>
			</tbody>
		</table>
	</form>
</body>