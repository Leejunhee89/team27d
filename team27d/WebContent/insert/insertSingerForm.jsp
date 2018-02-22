<!-- team27d[나윤주] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>InsertSingerForm.jsp</title>

	<h3>가수 등록</h3>
	<hr>
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
				<th>이름</th>
				<td>
				<input type="text" name="singer_name" size="20">
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
				<input type="text" name="singer_age" size="20">
				</td>
			</tr>
			<tr>
				<td colspan="4">
				<input type="submit" value="등록버튼">
				</td>
			</tr>
			</tbody>
		</table>
	</form>