<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 
 <form action="<%=request.getContextPath() %>/insertActorAction.jsp" method= "post">
 <table border="1">
 	<tr>
 		<td>���̵�:</td> <td><input type="text" name="id"></td>
 	</tr>
 	<tr>
 		<td>�̸�:</td> <td><input type="text" name="name"></td>
 	</tr>
 	<tr>
 		<td>����:</td> <td><input type="text" name="age"></td>
 	</tr>
 	<tr>
		<td colspan="4"><input type="submit" value="���Թ�ư"></td>
	</tr>
 
 
 
 
 
 </table>
 </form>






</body>
</html>  