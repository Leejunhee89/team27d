<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<%@ page import="service.Singer"%>
<%@ page import="service.SingerDao"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>InsertSingerForm.jsp</title>
</head>
<body>
	<%		
		int singerId = Integer.parseInt(request.getParameter("singerId"));
		SingerDao singerdao = new SingerDao();
		Singer singer = singerdao.updateSingerOne(singerId);
	%>
	<h3>���� ����ȭ��</h3>
	<form action="<%=request.getContextPath()%>/singer/updateSingerAction.jsp" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>�Ӽ�</th>
					<th>�Է¶�</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>���̵�</td>
					<td><input type="text" name="singer_id" size="20" value=<%= singer.getSingerId() %> readonly></td>
				</tr>
				<tr>
					<td>�̸�</td>
					<td><input type="text" name="singer_name" value=<%= singer.getSingerName() %> size="20"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="singer_age" value=<%= singer.getSingerAge() %> size="20"></td>
				</tr>
				<tr>
					<td colspan="4"><input type="submit" value="������ư"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>