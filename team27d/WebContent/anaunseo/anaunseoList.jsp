<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>announcerList.jsp</title>
	</head>
	<body>
		<h1>�Ƴ�� ����Ʈ</h1>
		<%
			request.setCharacterEncoding("euc-kr");
			System.out.println("=====announcerList.jsp=====");
			
			AnaunseoDao anaunseoDao = new AnaunseoDao();
			ArrayList<Anaunseo> list = anaunseoDao.selectAnaunseo();
		%>
		<a href = "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
		<%
			/*
				Ű���� loginMember�� �ش��ϴ� ���� ���� ������ �α��� �������θ� �Ǻ��Ѵ�
				������ �����Ѵٸ� �α��� ������ ���̴�.
				�α��� ������ �ؾ� ��� ��ư�� ���̵��� �Ͽ���.
			*/
			if(session.getAttribute("loginMember") != null){
		%>
				<a href = "<%= request.getContextPath() %>/anaunseo/insertAnaunseoForm.jsp">�Ƴ�� ���</a>
		<%
			}
		%>
		<br><br>
		<table border = "1">
			<thead>
				<tr>
					<th>�Ƴ�� ID</th>
					<th>�Ƴ�� NAME</th>
					<th>�Ƴ�� AGE</th>
					<%
						/*
							Ű���� loginMember�� �ش��ϴ� ���� ���� ������ �α��� �������θ� �Ǻ��Ѵ�
							������ �����Ѵٸ� �α��� ������ ���̴�.
							�α��� ������ �ؾ� ����, ���� ���� ���̵��� �Ͽ���.
						*/
						if(session.getAttribute("loginMember") != null){
					%>
							<th>����</th>
							<th>����</th>
					<%
						}
					%>
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
							<%
								/*
									Ű���� loginMember�� �ش��ϴ� ���� ���� ������ �α��� �������θ� �Ǻ��Ѵ�
									������ �����Ѵٸ� �α��� ������ ���̴�.
									�α��� ������ �ؾ� ����, ���� ��ư�� ���̵��� �Ͽ���.
								*/
								if(session.getAttribute("loginMember") != null ){
							%>
									<!--
										a�ױ׸� ���� get������� anaunseo ��ü�� �ɹ����� �߿� key���� �ش��ϴ� ���� anaunseoId ���� get������� anaunseoId��� ������ ��� 
										updatedAnaunseoForm.jsp, deleteAnaunseoAction.jsp ���Ϸ� ���� ��� anaunseoId ������ �ѱ��. �̶�, get������� �Ѿ��.
									-->
									<td><a href = "<%= request.getContextPath() %>/anaunseo/updateAnaunseoForm.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">����</a></td>
									<td><a href = "<%= request.getContextPath() %>/anaunseo/deleteAnaunseoAction.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">����</a></td>
							<%
								}
							%>
						</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</body>
</html>