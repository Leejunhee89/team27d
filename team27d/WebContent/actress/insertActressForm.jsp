<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
</head>
<body>
 <h3>여배우 등록화면</h3>
 <form action="<%=request.getContextPath() %>/actress/insertActressAction.jsp" method= "post">
 <table border="1">
 	<thead>
 		<tr>	
 			<th>속성</th> 
 			<th>입력란</th>
 		</tr>
 	</thead>
 	
 	<tbody>
	 	<!-- <tr>
	 		<td>아이디:</td> <td><input type="hidden" name="id"></td>
	 		</tr>-->
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