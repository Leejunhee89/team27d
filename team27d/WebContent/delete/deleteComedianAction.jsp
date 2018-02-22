<!-- team27d [¹æ¹Î¿µ] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao"%>
<!DOCTYPE html>

<%
	String id = request.getParameter("comedianId");
	int comId = Integer.parseInt(id);
	ComedianDao comediandao = new ComedianDao();
	comediandao.deleteComedian(comId);
	response.sendRedirect(request.getContextPath() + "/list/comedianList.jsp");
%>
 