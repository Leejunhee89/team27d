<!-- team27d [이준희] -->
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
	<!-- 들여쓰기 -->
	<h1>남배우 리스트</h1>
	<% 
		ActorDao ado = new ActorDao();
		ArrayList<Actor> list = ado.selectActor();
	%>
	<table border ="1">
		<thead>
			<th>id</th>
			<th>name</th>
			<th>age</th>
		</thead>
		
		<%
			for(Actor actor : list) {
		%>	
			<tfoot>
				<tr>
					<td><%= actor.getActorId() %></td><td><%= actor.getActorName() %></td><td><%= actor.getActorAge() %></td>
				</tr>  
			</tfoot>
			
		<% 
		} 
		%>
		<a href= "<%= request.getContextPath() %>/insertActorForm.jsp">배우등록</a>
		
	<!-- 리스트 안에 insert링크 걸기 (폼으로이동?) ,  -->
	</table>
</body>
</html>
