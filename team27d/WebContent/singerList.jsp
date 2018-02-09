<!-- team27d[나윤주] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<!DOCTYPE html>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr><th>SingerList</th></tr>
		<tr>
		<th>id</th><th>name</th><th>age</th>
		</tr> 
		<% 		
			SingerDao singerdao = new SingerDao();
			ArrayList<Singer> singerlist = singerdao.selectSingerList();		
			
			for(Singer singer : singerlist){
		%>
		<tr>
		<td><%=singer.getSingerId()%></td><td><%=singer.getSingerName()%></td><td><%=singer.getSingerAge()%></td>
		</tr>
		<%
			}
		%>
	</table> 
</body>
</html>