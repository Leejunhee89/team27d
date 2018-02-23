<!-- team27d [¹æ¹Î¿µ] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao"%>
<%@ page import = "service.Comedian"%>

<!DOCTYPE html>

<%
	Comedian comedian = new Comedian();
	comedian.setComedianId(Integer.parseInt(request.getParameter("comedianId")));
	
	ComedianDao comediandao = new ComedianDao();
	comediandao.deleteComedian(comedian);
	response.sendRedirect(request.getContextPath() + "/list/comedianList.jsp");
%>
 