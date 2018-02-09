<!-- team27d[³ªÀ±ÁÖ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<!DOCTYPE html>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>

<html>
<body>
	<table>
		<tr><th>SingerList</th></tr>
		<tr>
		<td>id</td><td>name</td><td>age</td>
		</tr> 
		<% 		
			SingerDao singerdao = new SingerDao();
			ArrayList<Singer> singerlist = singerdao.selectSingerList();		
			
			for(Singer singer : singerlist){
		%>
		<tr>
		<td><%=singer.getSingerId()%></td>
		<td><%=singer.getSingerName()%></td>
		<td><%=singer.getSingerAge()%></td>
		</tr>
		<%
			}
		%>
	</table> 
</body>
</html>