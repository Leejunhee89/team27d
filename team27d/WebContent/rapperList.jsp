<!-- //team27d [����ȭ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<%@ page import = "service.Rapper" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>���� ����Ʈ</h1>
	<%
		//���� daoŬ���� ��ü ����
		RapperDao rapperdao = new RapperDao();
		//���۸� Ÿ������ ����Ʈ ��ü ����
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
		//���� dao ��ü ���� �ִ� �޼��� ȣ�⸦ ȣ���ؼ� ����Ʈ�� ����
		rapperlist = rapperdao.selectRapperList();
	%>
	<table border="1">
		<tr>
			<th>���̵�</th><th>�̸�</th><th>����</th>
		<tr>
		<%
			for(Rapper rap : rapperlist){ 
		%>
			<tr>
				<%
					System.out.println(rap + "<----for�� ����"); 
				%>		
				<td><%=rap.getRapperId()%></td>
				<td><%=rap.getRapperName()%></td>
				<td><%=rap.getRapperAge()%></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>