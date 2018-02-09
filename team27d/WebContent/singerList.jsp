<!-- team27d[나윤주] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<!DOCTYPE html>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>

<% 		
			SingerDao singerdao = new SingerDao();
			ArrayList<Singer> list = singerdao.selectSingerList();			
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table>
		<tr>
		<th>id</th><th>name</th><th>age</th>
		</tr> 
		
		<%
			for(Singer sin : list){
		%>
		<tr>
		<td><%=sin.getSingerId()%></td><td><%=sin.getSingerName()%></td><td><%=sin.getSingerAge()%></td>
		</tr>
		<%
			}
		%>
	</table> 
</body>
</html>