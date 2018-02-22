<!-- team27d [������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ActorDao"  %>
<%@ page import = "service.Actor"  %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html PUBLIC >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
	<!-- �鿩���� -->
	<h1>����� ����Ʈ</h1>
	<% 
		ActorDao ado = new ActorDao();
		ArrayList<Actor> list = ado.selectActor();
	%>
	<table border ="1">
		<thead>
			<tr>
				<th>����� ID</th>
				<th>����� NAME</th>
				<th>����� AGE</th>
				<th>����</th>
				<th>����</th>
			</tr>
		</thead>
		
		<%
			for(Actor actor : list) {
		%>	
			<tbody>
				<tr>
					<td><%= actor.getActorId() %></td>
					<td><%= actor.getActorName() %></td>
					<td><%= actor.getActorAge() %></td>
					<td><a href="updateActorForm.jsp?actorId=<%=actor.getActorId()%>">����</a></td>
					<td><a href="deleteActorAction.jsp?actorId=<%=actor.getActorId()%>">����</a></td>
				</tr>  
			</tbody>
			
		<% 
		} 
		%>
		<a href= "<%= request.getContextPath() %>/insertActorForm.jsp">�����</a>
		
	<!-- ����Ʈ �ȿ� insert��ũ �ɱ� (�������̵�?) ,  -->
	</table>
</body>
</html>
