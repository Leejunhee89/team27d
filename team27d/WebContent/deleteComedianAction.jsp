<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao"%>
<!DOCTYPE html>

<%
	String id = request.getParameter("comedianId");
	int comId = Integer.parseInt(id);
	ComedianDao comediandao = new ComedianDao();
	comediandao.deleteComedian(comId);
	response.sendRedirect(request.getContextPath() + "/comedianList.jsp");
%>
 