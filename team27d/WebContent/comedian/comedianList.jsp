<!-- team27d [��ο�] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>�ڹ̵�� ����Ʈ</h1>
		<%
			/*ComedianDao��ü �� selectComedianList�޼ҵ带 ������� ���ϰ��� list�� ���,
			 *�� ������ comedian�� ��´�. =>Comedian��ü �� ������ �̷������.
			 *�׸��� Comedian��ü���� ���� getting�Ͽ� ȭ�鿡 �����ش�.
			 */
			request.setCharacterEncoding("euc-kr");
			ComedianDao comedianDao = new ComedianDao();
			ArrayList<Comedian> list = comedianDao.selectComedianList();
			Member member = (Member)session.getAttribute("loginMember");

		%>
		<a href = "<%= request.getContextPath() %>/index.jsp">Ȩ</a> &nbsp;
		<% 
			//������ null���� �ƴϸ�(�α����� �Ǿ��ִ� ���) �ڸ޵�� ����� ���δ�.
			if (session.getAttribute("loginMember") != null) {
		%>
				<a href = "<%= request.getContextPath() %>/comedian/insertComedianForm.jsp">�ڸ޵�� ���</a><br><br>
		 
		<% 
			}
		%>
		
		<table border = "1">
			<thead>
				<tr>
					<th>�ڹ̵�� ID</th>
					<th>�ڹ̵�� NAME</th>
					<th>�ڹ̵�� AGE</th>
				<%
					//������ null���� �ƴϸ�  ����, ������ ���δ�.
					if(session.getAttribute("loginMember") !=null){
				%>
						<th>����</th>
						<th>����</th>
				<%
					}
				%>
				</tr>
			</thead>
			<tbody>
				<%
					for(Comedian comedian : list) {
				%>
						<tr>
							<td><%=comedian.getComedianId()%></td>
							<td><%=comedian.getComedianName() %></td>
							<td><%=comedian.getComedianAge() %></td>
						<% 
							//������ null���� �ƴϸ� ����, ������ư�� ���δ�.
							if (session.getAttribute("loginMember")!= null)	{	
						%>	
								<td><a href="<%=request.getContextPath()%>/comedian/updateComedianForm.jsp?comedianId=<%=comedian.getComedianId()%>">����</a></td>
								<td><a href="<%=request.getContextPath()%>/comedian/deleteComedianAction.jsp?comedianId=<%=comedian.getComedianId()%>">����</a></td>
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