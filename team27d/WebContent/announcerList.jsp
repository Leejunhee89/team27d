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
	//selectActorList() �޼��带 �����ϱ� ���� ����Ǿ�� �� AnaunseoDao ��ü�� ���� �����ϴ� �κ�.
	AnaunseoDao anaDao = new AnaunseoDao();
	//selectActorList()�ż��� ����� ��ȯ�� ArrayList<Anaunseo>�� �ּҰ��� List�� �޴´�.
	//selectActorList()�޼��� �ȿ��� ������ ArrayList<Anaunseo>�� ��ü�� �ּҸ� �����Ͽ�, 
	//�ּҸ� ���� �� �ִ� ��ü���������� list�� ����Ǿ���.
	ArrayList<Anaunseo> list = anaDao.selectActorList();
%>
	<table border = "1">
		<tr>
			<th>�Ƴ�� ID</th>
			<th>�Ƴ�� NAME</th>
			<th>�Ƴ�� AGE</th>
		</tr>
		<%
			// list�� ����Ž���ϸ鼭 list�� ����ִ� Anaunseo�� �ϳ��ϳ� �����Ѵ�. 
			//�׸��� get�޼��带 ���ؼ� ID, NAME, AGE ������ �����´�.
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
	</table>
</body>
</html>