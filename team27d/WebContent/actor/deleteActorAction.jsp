<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.ActorDao" %>
<!DOCTYPE html>

<%
	String actorId1 = request.getParameter("actorId");
	int actorId = Integer.parseInt(actorId1);
	System.out.println(actorId + "������? actorId" );
	ActorDao actor = new ActorDao();
	actor.deleteActor(actorId);
	
	response.sendRedirect(request.getContextPath() +"/actor/actorList.jsp");
%>
