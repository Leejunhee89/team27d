<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html PUBLIC >

<%
//selectActorList() 메서드를 실행하기 위해 선행되어야 할 AnaunseoDao 객체를 먼저 생성하는 부분.
AnaunseoDao anaDao = new AnaunseoDao();
//selectActorList()매서드 결과로 반환된 ArrayList<Anaunseo>형 주소값을 List로 받는다.
//selectActorList()메서드 안에서 생성된 ArrayList<Anaunseo>형 객체의 주소를 리턴하여, 
//주소를 담을 수 있는 객체참조변수인 list에 저장되었다.
ArrayList<Anaunseo> list = anaDao.selectActorList();

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>아나운서 리스트</h1>
<table border = "1">
	<tr>
		<th>아나운서 ID</th><th>아나운서 NAME</th><th>아나운서 AGE</th>
	</tr>
	<%
	// list를 순차탐색하면서 list에 들어있는 Anaunseo를 하나하나 참조한다. 
	//그리고 get메서드를 통해서 ID, NAME, AGE 정보를 가져온다.
	for(Anaunseo anaun : list){
	%>
		<tr>
			<td><%=anaun.getAnaunseoId() %></td>
			<td><%=anaun.getAnaunseoName() %></td>
			<td><%=anaun.getAnaunseoAge() %></td>
		</tr>
	<%
	}
	%>
</table>

</body>
</html>