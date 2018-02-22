<!-- team27d [��ο�] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>�ڹ̵�� ����Ʈ</h1>
	<%
		/*ComedianŬ������ ���� ���ο� ��ü�� ������ �� �� �ּҸ� comedianDao�� ��´�.
		 *Comedian�� ArrayList Ŭ������ ���� ���ο� ��ü�� ������ �� �ּҸ� list�� ��´�.
		 *ComedianDaoŬ���� �� selectComedianList�޼ҵ带 ������ �� �ּҸ� list�� ��´�.
		 */
		ComedianDao comedianDao = new ComedianDao();
		ArrayList<Comedian> list = new ArrayList<Comedian>();
		list=comedianDao.selectComedianList();
	%>
	<a href = "<%= request.getContextPath() %>/insertComedianForm.jsp">�ڸ޵�� ���</a>
	<table border = "1">
		<thead>
			<tr>
				<th>�ڹ̵�� ID</th>
				<th>�ڹ̵�� NAME</th>
				<th>�ڹ̵�� AGE</th>
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
				</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>