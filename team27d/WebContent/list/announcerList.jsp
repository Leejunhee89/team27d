<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>�Ƴ�� ����Ʈ</h1>
<%
	request.setCharacterEncoding("euc-kr");
	AnaunseoDao anaDao = new AnaunseoDao();
	ArrayList<Anaunseo> list = anaDao.selectAnaunseo();
%>
	<a href = "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
	<a href = "<%= request.getContextPath() %>/insert/insertAnnouncerForm.jsp">�Ƴ�� ���</a><br><br>
	<table border = "1">
		<thead>
			<tr>
				<th>�Ƴ�� ID</th>
				<th>�Ƴ�� NAME</th>
				<th>�Ƴ�� AGE</th>
				<th>����</th>
				<th>����</th>
			</tr>
		<thead>
		<tbody>
		<%
			for(Anaunseo anaunseo : list){
		%>
				<tr>
					<td><%= anaunseo.getAnaunseoId() %></td>
					<td><%= anaunseo.getAnaunseoName() %></td>
					<td><%= anaunseo.getAnaunseoAge() %></td>
					<td><a href = "<%= request.getContextPath() %>/update/updateAnaunseoFrom.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">����</a></td>
					<td><a href = "<%= request.getContextPath() %>/delete/deleteAnaunseoAction.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">����</a></td>
				</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>