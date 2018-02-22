<!-- team27d[나윤주] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>InsertSingerForm.jsp</title>

	<h3>회원가입</h3>
	<hr>
	<form action="<%=request.getContextPath()%>/insertSingerAction.jsp"	method="post">
		<table border="1">
			<thead>
				<tr>
					<th>
						속성
					</th>
					<th>
						입력란
					</th>
				</tr>	
			</thead>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" size="20"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" size="20"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="입력완료"></td>
			</tr>
		</table>
	</form>

