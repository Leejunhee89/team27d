<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>InsertSingerForm.jsp</title>

	<h3>ȸ������</h3>
	<hr>
	<form action="<%=request.getContextPath()%>/insertSingerAction.jsp"	method="post">
		<table border="1">
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
			<tr>
				<th>���̵�</th>
				<td><input type="text" name="id" size="20"></td>
			</tr>
			<tr>
				<th>�̸�</th>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="age" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="�Է¿Ϸ�"></td>
			</tr>
		</table>
	</form>

