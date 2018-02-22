<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <h3>남배우 등록화면</h3>
 <form action="<%=request.getContextPath() %>/insertActorAction.jsp" method= "post">
 <table border="1">
 	
 	<tbody>
	 <tr>	
	 	<th>속성</th>   
	 	<th>입력란</th>
	 </tr>	
 	</tbody>
 	
 	<tbody>
	 	<!-- <tr>
	 		<td>아이디:</td> <td><input type="hidden" name="id"></td>
	 	</tr>
	 	 -->
	 	<tr>
	 		<td>이름:</td> <td><input type="text" name="name"></td>
	 	</tr>
	 	<tr>
	 		<td>나이:</td> <td><input type="text" name="age"></td>
	 	</tr>
	 	<tr>
			<td colspan="4"><input type="submit" value="등록버튼"></td>
		</tr>
 	</tbody>
 
 
     
 
 </table>
 </form>

</body>
</html>  