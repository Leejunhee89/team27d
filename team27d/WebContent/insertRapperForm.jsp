<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
%>
	<form name="insertRapper" action="<%=request.getContextPath()%>/insertRapperAction.jsp" method="post">
		아이디 :	<input type="text" name="id" placeholder="리스트와 중복되지 않은 숫자만 입력해주세요" ><br>
		이름 :	<input type="text" name="name" ><br>
		나이 :	<input type="text" name="age" ><br>
				<input type="submit" value="입력완료"><br>
	</form>
</body>
</html>