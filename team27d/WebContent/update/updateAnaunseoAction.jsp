<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
	String send_id = request.getParameter("anaunseo_id");
	int anaunseo_id = Integer.parseInt(send_id);
	String anaunseo_name = request.getParameter("anaunseo_name");
	String send_age = request.getParameter("anaunseo_age");
	int anaunseo_age = Integer.parseInt(send_age);
	
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	Anaunseo anaunseo = new Anaunseo();
	
	anaunseo.setAnaunseoId(anaunseo_id);
	anaunseo.setAnaunseoName(anaunseo_name);
	anaunseo.setAnaunseoAge(anaunseo_age);
	
	anaunseoDao.updateAnaunseo(anaunseo);
	
	response.sendRedirect(request.getContextPath() + "/list/announcerList.jsp");
%>