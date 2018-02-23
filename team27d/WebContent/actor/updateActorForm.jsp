<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="service.ActorDao" %>
<%@ page import="service.Actor" %>
<!DOCTYPE html>
<% 	
	String actorId1 = request.getParameter("actorId");
	int actorId = Integer.parseInt(actorId1);
	ActorDao actor = new ActorDao();
	Actor act = actor.updateActorOne(actorId);
	System.out.println(act + "무엇이? act");
	int dbid = act.getActorId();
	String dbname = act.getActorName();
	int dbage = act.getActorAge();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <h3>남배우 수정화면</h3>
 <form action="<%=request.getContextPath() %>/actor/updateActorAction.jsp" method= "post">
 <table border="1">
 	
 	<tbody>
	 <tr>	
	 	<th>속성</th>   
	 	<th>입력란</th>
	 </tr>	
 	</tbody>
 	
 	<tbody>
	 	<tr>
	 		<td>아이디:</td> <td><input type="text" name="id" value=<%=dbid %> readonly></td>
	 	</tr>
	 	<tr>
	 		<td>이름:</td> <td><input type="text" name="name" value=<%=dbname %>></td>
	 	</tr>
	 	<tr>
	 		<td>나이:</td> <td><input type="text" name="age" value=<%=dbage %>></td>
	 	</tr>
	 	<tr>
			<td colspan="4"><input type="submit" value="수정버튼"></td>
		</tr>
 	</tbody>
 
 
     
 
 </table>
 </form>

</body>
</html>  