<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ page import="service.ActressDao" %>
<%@ page import="service.Actress" %>
<!DOCTYPE html>
<%
	String actressId1 = request.getParameter("actressId");
	int actressId = Integer.parseInt(actressId1);
	System.out.println(actressId + "---------------");
	ActressDao actressdao = new ActressDao();
	Actress actress = actressdao.updateActressOne(actressId);
	int dbid = actress.getActressId();
	String dbname = actress.getActressName();
	int dbage = actress.getActressAge();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<h3>여배우 수정화면</h3>
 <form action="<%=request.getContextPath() %>/actress/updateActressAction.jsp" method= "post">
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