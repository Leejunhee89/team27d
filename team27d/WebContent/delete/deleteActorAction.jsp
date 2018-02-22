<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.ActorDao" %>
<!DOCTYPE html>

<%
	String actorId1 = request.getParameter("actorId");
	int actorId = Integer.parseInt(actorId1);
	System.out.println(actorId + "¹«¾ùÀÌ? actorId" );
	ActorDao actor = new ActorDao();
	actor.deleteActor(actorId);
	
	response.sendRedirect(request.getContextPath() +"/list/actorList.jsp");
%>
