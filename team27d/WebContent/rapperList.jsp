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

<%
//���� daoŬ���� ��ü ����
RapperDao rapperdao = new RapperDao();
//���۸� Ÿ������ ����Ʈ ��ü ����
ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
//���� dao ��ü ���� �ִ� �޼��� ȣ�⸦ ȣ���ؼ� ����Ʈ�� ����
rapperlist = rapperdao.selectRapperList();
%>

<body>
	<img src=" <%=request.getContextPath()%>/image/Yadon.jpg " title = "����ȭ" width = "400" height = "400">
	
	<p>rapper list</p>
	<table border="1">
		<tr>
			<td>���̵�</td><td>�̸�</td><td>����</td>
		<tr>
		<%for(Rapper rap : rapperlist){ %>
			<tr>
				<td><%=rap.getRapperId()%></td>
				<td><%=rap.getRapperName()%></td>
				<td><%=rap.getRapperAge()%></td>
				<%System.out.println(rap.toString() + "<----for�� ����"); %>		
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>