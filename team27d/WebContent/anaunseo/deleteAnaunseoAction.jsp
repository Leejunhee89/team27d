<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<!DOCTYPE html>
<%
	System.out.println("=====deleteAnaunseoAction.jsp=====");

	int aunaunseoId = Integer.parseInt(request.getParameter("anaunseoId"));
	System.out.println("aunaunseoId : " + aunaunseoId);

	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.deleteAnaunseo(aunaunseoId);
	
	response.sendRedirect(request.getContextPath() + "/anaunseo/announcerList.jsp");
%>