<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html PUBLIC >

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>�Ƴ�� ����Ʈ</h1>
<%
	AnaunseoDao anaDao = new AnaunseoDao();
	ArrayList<Anaunseo> list = anaDao.selectActorList();
%>
	<table border = "1">
		<tr>
			<th>�Ƴ�� ID</th>
			<th>�Ƴ�� NAME</th>
			<th>�Ƴ�� AGE</th>
		</tr>
		<%
			for(Anaunseo anaun : list){
		%>
				<tr>
					<td><%=anaun.getAnaunseoId() %></td>
					<td><%=anaun.getAnaunseoName() %></td>
					<td><%=anaun.getAnaunseoAge() %></td>
				</tr>
		<%
			}
		%>
		<tr>
			<td>
				<a href = "<%= request.getContextPath() %>/index.jsp">home</a>
			</td>
			<td>
				<a href = "<%= request.getContextPath() %>/insertAnnouncerForm.jsp">�Ƴ�� �߰�</a>
			</td>
		</tr>
	</table>
	
</body>
</html>