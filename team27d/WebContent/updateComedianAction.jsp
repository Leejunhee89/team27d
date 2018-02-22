<!-- team27d [¹æ¹Î¿µ] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "service.Comedian" %>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("euc-kr");
	Comedian comedian = new Comedian();
	comedian.setComedianId(Integer.parseInt(request.getParameter("id")));
	comedian.setComedianName(request.getParameter("name"));
	comedian.setComedianAge(Integer.parseInt(request.getParameter("age")));
	
	ComedianDao comedianDao = new ComedianDao();
	comedianDao.updateComedian(comedian);
	
	
	
	response.sendRedirect(request.getContextPath()+"/comedianList.jsp");
%>