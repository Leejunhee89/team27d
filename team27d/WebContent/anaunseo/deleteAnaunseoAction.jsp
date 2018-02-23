<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<!DOCTYPE html>
<%
	String anaunseoId = request.getParameter("anaunseoId");
	int anaId = Integer.parseInt(anaunseoId);
	System.out.println("===========anaId : " + anaId);

	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.deleteAnaunseo(anaId);
	
	response.sendRedirect(request.getContextPath() + "/anaunseo/announcerList.jsp");
%>