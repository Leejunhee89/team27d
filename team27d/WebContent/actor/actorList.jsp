<!-- team27d [이준희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ActorDao"  %>
<%@ page import = "service.Actor"  %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>
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
		Member member = (Member)session.getAttribute("loginMember");
		
	%>
		<a href= "<%= request.getContextPath() %>/index.jsp">홈</a>
	<% 
		if (member != null) {
	%>
		<a href= "<%= request.getContextPath() %>/actor/insertActorForm.jsp">배우등록</a> <br><br>
	 
	<% 
	}
	%>
	<table border ="1">
		<thead>
			<tr>
				<th>남배우 ID</th>
				<th>남배우 NAME</th>
				<th>남배우 AGE</th>
				<th>수정</th>
				<th>삭제</th>
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
		<% 
				if (member != null)	{	
		%>		
					<td><a href="<%=request.getContextPath()%>/actor/updateActorForm.jsp?actorId=<%=actor.getActorId()%>">수정</a></td>
					<td><a href="<%=request.getContextPath()%>/actor/deleteActorAction.jsp?actorId=<%=actor.getActorId()%>">삭제</a></td>
				</tr>  
			</tbody>
		<%
				}
		%>	
		<% 
			} 
		%>
		
		
	<!-- 리스트 안에 insert링크 걸기 (폼으로이동?) ,  -->
	</table>
</body>
</html>
