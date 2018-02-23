<!-- team27d [방민영] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("euc-kr");
	
	Comedian comedian = new Comedian();
	comedian.setComedianId(Integer.parseInt(request.getParameter("comedianId")));
	
	ComedianDao comedianDao = new ComedianDao();
	comedianDao.updateComedianOne(comedian);
	
	int dbid = comedian.getComedianId();
	String dbname = comedian.getComedianName();
	int dbage = comedian.getComedianAge();
	System.out.println(dbid+"==========dbid========");
	System.out.println(dbname+"========dbname======");
	System.out.println(dbage+"=========dbage=======");
%>
<form action="<%=request.getContextPath() %>/update/updateComedianAction.jsp" method="post">
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>속성</th>
				<th>입력란</th>
			</tr>
		</thead>
		<tbody>		
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=dbid%>" readonly></td>	
			</tr>	
			<tr>
				<td>이름 </td>
				<td><input type="text" name="name" value="<%=dbname%>"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="<%=dbage%>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록버튼"></td>
			</tr>
		</tbody>
	</table>
</form>
	
