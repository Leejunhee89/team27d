<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
</head>
<body>
 
 <form action="<%=request.getContextPath() %>/insertActressAction.jsp" method= "post">
 <table border="1">
 	<tbody>
 		<th>속성</th> 
 		<th>입력란</th>
 	</tbody>
 	
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
			<td colspan="4"><input type="submit" value="가입버튼"></td>
		</tr>
	 </tbody>
 </table>
 </form>

</body>
</html>