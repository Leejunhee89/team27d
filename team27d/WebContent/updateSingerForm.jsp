<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import="service.Singer"%>
<%@ page import="service.SingerDao"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>InsertSingerForm.jsp</title>
<%
	String send_id = request.getParameter("send_id");

	SingerDao singerdao = new SingerDao();
	Singer singer = singerdao.selectforupdate(send_id);

	int singerdbid = singer.getSingerId();
	String singerdbname = singer.getSingerName();
	int singerdbage = singer.getSingerAge();
%>
<h3>���� ����</h3>
<hr>
<form action="<%=request.getContextPath()%>/singerList.jsp"
	method="post">
	<table border="1">
		<thead>
			<tr>
				<th>�Ӽ�</th>
				<th>�Է¶�</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>���̵�</th>
				<td><input type="text" name="singer_id" size="20" value="singerdbid" readonly>
				</td>
			</tr>
			<tr>
				<th>�̸�</th>
				<td><input type="text" name="singer_name" value="singerdbname" size="20"></td>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="singer_age" value="singerdbage" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="������ư"></td>
			</tr>
		</tbody>
	</table>
</form>