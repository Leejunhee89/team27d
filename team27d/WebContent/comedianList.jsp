<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<%@ page import = "service.Comedian" %>

<%
Comedian comedian=null;
%>

<table border="1">
	<tr>
		<td>�ڹ̵�� ���̵�</td>
		<td>�ڹ̵�� �̸�</td>
		<td>�ڹ̵�� ����</td>
	</tr>
	<tr>
		<td><%=comedian.getComedianId() %></td>
		<td><%=comedian.getComedianName() %></td>
		<td><%=comedian.getComedianAge() %></td>
	</tr>

</table>