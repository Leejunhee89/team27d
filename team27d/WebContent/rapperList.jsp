<!-- //team27d [유국화] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<%@ page import = "service.Rapper" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>래퍼 리스트</h1>
	<%
		//래퍼 dao클래스 객체 생성
		RapperDao rapperdao = new RapperDao();
		//래퍼를 타입으로 리스트 객체 생성
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
		//래퍼 dao 객체 내에 있는 메서드 호출를 호출해서 리스트에 담음
		rapperlist = rapperdao.selectRapperList();
	%>
	<table border="1">
		<tr>
			<th>아이디</th><th>이름</th><th>나이</th>
		<tr>
		<%
			for(Rapper rap : rapperlist){ 
		%>
			<tr>
				<%
					System.out.println(rap + "<----for문 실행"); 
				%>		
				<td><%=rap.getRapperId()%></td>
				<td><%=rap.getRapperName()%></td>
				<td><%=rap.getRapperAge()%></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>