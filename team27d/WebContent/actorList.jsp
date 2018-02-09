<!-- team27d [이준희] -->

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

<h1>남배우 리스트</h1>

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
