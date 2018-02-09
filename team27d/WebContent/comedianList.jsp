<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<%@ page import = "service.Comedian" %>

<%
Comedian comedian=null;
%>

<table border="1">
	<tr>
		<td>코미디언 아이디</td>
		<td>코미디언 이름</td>
		<td>코미디언 나이</td>
	</tr>
	<tr>
		<td><%=comedian.getComedianId() %></td>
		<td><%=comedian.getComedianName() %></td>
		<td><%=comedian.getComedianAge() %></td>
	</tr>

</table>