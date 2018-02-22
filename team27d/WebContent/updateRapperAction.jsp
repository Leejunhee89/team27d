<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<%@ page import = "service.RapperDao" %>
<!DOCTYPE html>
<%
	int rapper_id = Integer.parseInt(request.getParameter("rapper_id"));
	String rapper_name = request.getParameter("rapper_name");
	int rapper_age = Integer.parseInt(request.getParameter("rapper_age"));
	RapperDao rapdao = new RapperDao();
	rapdao.updateRapper(rapper_id, rapper_name, rapper_age);
	response.sendRedirect(request.getContextPath() + "/rapperList.jsp");
%>