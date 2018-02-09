<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html PUBLIC >

<%

AnaunseoDao ana = new AnaunseoDao();
//selectActorList()매서드 결과로 반환된 ArrayList<Anaunseo>형 주소값을 arrAnaunseo로 받는다.
ArrayList<Anaunseo> arrAnaunseo = ana.selectActorList();

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<p>아나운서 리스트</p>
<table border = "1">
	<tr>
		<td>announcer_id</td><td>announcer_name</td><td>announcer_age</td>
	</tr>
	<%
	//arrAnaunseo 리스트를 순차탐색하면서 리스트에 들어있는 Anaunseo를 하나하나 참조한다. 
	//그리고 get메서드를 통해서 ID, NAME, AGE 정보를 가져온다.
	for(Anaunseo anaun : arrAnaunseo){
	%>
		<tr>
			<td><%=anaun.getAnaunseoId() %></td><td><%=anaun.getAnaunseoName() %></td><td><%=anaun.getAnaunseoAge() %></td>
		</tr>
	<%
	}
	%>
</table>





</body>
</html>