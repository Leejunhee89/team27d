<!-- team27d [��ο�] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("comedianId");
	int comId = Integer.parseInt(id);
	
	ComedianDao comedianDao = new ComedianDao();
	Comedian comedian = comedianDao.forUpdateComedian(comId);
	
	int dbid = comedian.getComedianId();
	String dbname = comedian.getComedianName();
	int dbage = comedian.getComedianAge();
%>
	<form action="<%=request.getContextPath() %>/updateComedianAction.jsp" method="post">
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>�Ӽ�</th>
				<th>�Է¶�</th>
			</tr>
		</thead>
		<tbody>		
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="id" value="<%=dbid%>" readonly></td>		
			<tr>
				<td>�̸� </td>
				<td><input type="text" name="name" value="<%=dbname%>"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="age" value="<%=dbage%>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="��Ϲ�ư"></td>
			</tr>
		</tbody>
	</table>
</form>
	
