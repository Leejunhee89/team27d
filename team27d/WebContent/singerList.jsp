<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>	
<body>
	<h1>���� ����Ʈ</h1>
	<% 	
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> singerlist = new ArrayList<Singer>();
		singerlist = singerdao.selectSingerList();
	%>
	<a href = "<%= request.getContextPath() %>/insertSingerForm.jsp">���� �߰�</a>
	<table border = "1">
	<thead>
		<tr>
			<th>���� ID</th>
			<th>���� NAME</th>
			<th>���� AGE</th>
			<th>���� UPDATE</th>
			<th>���� DELETE</th>
		<tr>
	</thead>
	<tbody>
	<%
		for(Singer sin : singerlist){
	%>
		<tr>
			<td><%=sin.getSingerId()%></td>
			<td><%=sin.getSingerName()%></td>
			<td><%=sin.getSingerAge()%></td>
	<%
		}
	%>
			<!-- request.getParameter("singerId") -->

			
			<!-- 
			������ ���� > �׼� ������Ʈ
			 -->
<%-- 			<td><a href = "<%= request.getContextPath() %>/updateSingerForm.jsp?singerId=<%=singer.getsingerId()%>">����</a></td>
			<td><a href = "<%= request.getContextPath() %>/deleteSingerAction.jsp?singerId=<%=singer.getsingerId()%>">����</a></td>
 --%>		<tr>
	</tbody>
	</table> 
</body>
</html>