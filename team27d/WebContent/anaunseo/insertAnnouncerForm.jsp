<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>�Ƴ�� ���</h3>
		<hr>
		<form action = "<%= request.getContextPath() %>/insert/insertAnnouncerAction.jsp" method = "post">
			<table border = "1">
				<thead>
					<tr>
						<th>�Ӽ�</th>
						<th>�Է¶�</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<td>�̸�</td>
						<td><input type = "text" name = "anaunseo_name"></td>
					</tr>
					<tr>
						<td>����</td>
						<td><input type = "text" name = "anaunseo_age"></td>
					</tr>
					<tr><td colspan = "2"><input type = "submit" value = "��Ϲ�ư" ></td></tr>
				</tbody>
			</table>
		</form>
	</body>
</html>




















