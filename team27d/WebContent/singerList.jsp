<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.Connection" %>


<%
	ResultSet rs = null;
	Connection conn = null;

	try{	
	SingerDao dao = new SingerDao();
	dao.selectSingerList(list, conn);
		
	}while(rs.next()){
%>
	<tr>
		<td><%= rs.getString("singer_id")%></td>
		<td><%= rs.getString("singer_name")%></td>
		<td><%= rs.getString("singer_age")%></td>
	</tr>
<%	
	}finally{
		
	}
	
%>
