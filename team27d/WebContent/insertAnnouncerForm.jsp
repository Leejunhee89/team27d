<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>ȸ�� ����</h3>
		<hr>
		<table border = "1">
			<thead>
				<tr>
					<th>
						�Ӽ�
					</th>
					<th>
						�Է¶�
					</th>
				</tr>	
			</thead>
			<tbody>
				<form action = "<%= request.getContextPath() %>/insertAnnouncerAction.jsp" method = "post">
					<tr>
						<td>
							�̸�
						</td>
						<td>
							<input type = "text" name = "anaunseo_name">
						</td>
					</tr>
					<tr>
						<td>
							����
						</td>
						<td>
							<input type = "text" name = "anaunseo_age">
						</td>
					</tr>
					<tr>
						<td colspan = "2">
							<input type = "submit" value = "���Թ�ư" >
						</td>
					</tr>
				</form>
			</tbody>
		</table>
	</body>
</html>




















