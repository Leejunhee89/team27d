<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<%@ page import = "service.RapperDao" %>
<%@ page import = "service.Rapper" %>
<!DOCTYPE html>
<%
	Rapper rapper = new Rapper();
	rapper.setRapperId(Integer.parseInt(request.getParameter("rapper_id")));
	rapper.setRapperName(request.getParameter("rapper_name"));
	rapper.setRapperAge(Integer.parseInt(request.getParameter("rapper_age")));
	
	RapperDao rapdao = new RapperDao();
	rapdao.updateRapper(rapper);
	response.sendRedirect(request.getContextPath() + "/list/rapperList.jsp");
%>