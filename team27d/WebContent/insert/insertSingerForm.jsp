<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>InsertSingerForm.jsp</title>
</head>
<body>
	<h3>���� ���ȭ��</h3>
	<form action="<%=request.getContextPath()%>/insert/insertSingerAction.jsp"	method="post">
		<table border="1">
			<thead>
				<tr>
					<th>�Ӽ�</th>
					<th>�Է¶�</th>
				</tr>	
			</thead>
			<tbody>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="singer_name" size="20"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="singer_age" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="��Ϲ�ư"></td>
			</tr>
			</tbody>
		</table>
	</form>
</body>