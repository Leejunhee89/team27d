<!-- team27d [방민영] --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>코메디언 등록</h3>
		<form action="<%=request.getContextPath() %>/comedian/insertComedianAction.jsp" method="post">
			<hr>
			<table border="1">
				<thead>
					<tr>
						<th>속성</th>
						<th>입력란</th>
					</tr>
				</thead>
				<tbody>				
					<tr>
						<td>이름 </td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type="text" name="age"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="등록버튼"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>