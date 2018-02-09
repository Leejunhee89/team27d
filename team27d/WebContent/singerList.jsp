<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>
<!-- <table>
<tr><th>SingerList</th></tr>
<tr>
<td>id</td><td>name</td><td>age</td>
</tr> -->
<% 		
	SingerDao singerdao = new SingerDao();
	singerdao.selectSingerList();
	
%>
<%-- <tr>
<td><%= s.getSingerId()%></td><td><%=s.getSingerName()%></td><td><%=s.getSingerAge()%></td>
</tr>
</table> --%>