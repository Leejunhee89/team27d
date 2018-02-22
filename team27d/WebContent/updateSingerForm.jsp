<!-- team27d[나윤주] -->
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
<h3>가수 수정</h3>
<hr>
<form action="<%=request.getContextPath()%>/singerList.jsp"
	method="post">
	<table border="1">
		<thead>
			<tr>
				<th>속성</th>
				<th>입력란</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="singer_id" size="20" value="singerdbid" readonly>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="singer_name" value="singerdbname" size="20"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="singer_age" value="singerdbage" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="수정버튼"></td>
			</tr>
		</tbody>
	</table>
</form>