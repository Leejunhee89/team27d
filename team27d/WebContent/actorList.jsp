<!-- team27d [������] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "service.ActorDao"  %>
<%@ page import = "service.Actor"  %>
<%@ page import = "java.util.ArrayList" %>
<% 
	ActorDao ado = new ActorDao();
	ArrayList<Actor> list = ado.selectActor();
%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>

<img src="<%= request.getContextPath() %>/image/niche.jpg" width="300" height="350">
<p>����� ����Ʈ</p>

<table border ="1">
	<tr>
		<td>id</td>	<td>name</td> <td>age</td>
	</tr>
<%
	for(Actor actor : list) {
%>	
	<tr>
		<td><%= actor.getActorId() %></td><td><%= actor.getActorName() %></td><td><%= actor.getActorAge() %></td>
	</tr>

<% 
}
%>

</table>
</body>
</html>
