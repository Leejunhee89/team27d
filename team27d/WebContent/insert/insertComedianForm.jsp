<!-- team27d [��ο�] --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>�ڸ޵�� ���</h3>
		<form action="<%=request.getContextPath() %>/insert/insertComedianAction.jsp" method="post">
			<hr>
			<table border="1">
				<thead>
					<tr>
						<th>�Ӽ�</th>
						<th>�Է¶�</th>
					</tr>
				</thead>
				<tbody>				
					<tr>
						<td>�̸� </td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>����</td>
						<td><input type="text" name="age"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="��Ϲ�ư"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>