<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html PUBLIC >

<%

AnaunseoDao ana = new AnaunseoDao();

ArrayList<Anaunseo> arrAnaunseo = new ArrayList<Anaunseo>();
//selectActorList()�ż��� ����� ��ȯ�� ArrayList<Anaunseo>�� �ּҰ��� arrAnaunseo�� �޴´�.
arrAnaunseo = ana.selectActorList();
	

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<p>�Ƴ�� ����Ʈ</p>
<table border = "1">
	<tr>
		<td>announcer_id</td><td>announcer_name</td><td>announcer_age</td>
	</tr>
	<%
	//arrAnaunseo ����Ʈ�� ����Ž���ϸ鼭 ����Ʈ�� ����ִ� Anaunseo�� �ϳ��ϳ� �����Ѵ�. 
	//�׸��� get�޼��带 ���ؼ� ID, NAME, AGE ������ �����´�.
	for(Anaunseo anaun : arrAnaunseo){
	%>
		<tr>
			<td><%=anaun.getAnaunseoId() %></td><td><%=anaun.getAnaunseoName() %></td><td><%=anaun.getAnaunseoAge() %></td>
		</tr>
	<%
	}
	%>
</table>





</body>
</html>