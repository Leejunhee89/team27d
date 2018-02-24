<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateAnaunseoFrom.jsp</title>
	</head>
	<body>
		<table border = "1">
			<thead>
				<tr>
					<th>속성</th>
					<th>입력란</th>
				</tr>
			</thead>
			<%
				request.setCharacterEncoding("euc-kr");
				System.out.println("===== updateAnaunseoFrom.jsp =====");
				
				int anaunseoId = Integer.parseInt(request.getParameter("anaunseoId"));
				System.out.println("anaunseoId : " + anaunseoId);
				
				AnaunseoDao anaunseoDao = new AnaunseoDao();
				Anaunseo anaunseo = anaunseoDao.updateAnaunseoOne(anaunseoId);
			%>
			<form action = "<%= request.getContextPath() %>/anaunseo/updateAnaunseoAction.jsp" method = "post">
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input type = "text" name = "anaunseo_id" value = "<%= anaunseo.getAnaunseoId() %>" readonly></td>	
					</tr>
					<tr>
						<td>이름</td>
						<td><input type = "text" name = "anaunseo_name" value = "<%= anaunseo.getAnaunseoName() %>"></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type = "text" name = "anaunseo_age" value = "<%= anaunseo.getAnaunseoAge() %>"></td>
					</tr>
					<tr>
						<td colspan = "2"><input type = "submit" value = "수정버튼"></td>
					</tr>
				</tbody>
			</form>
		</table>
	</body>
</html>
