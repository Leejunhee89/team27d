<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.ActorDao" %>
<%@ page import="service.Actor" %>
<!DOCTYPE html>
<%
	
	/* int actorId = Integer.parseInt(request.getParameter("id")); */
	String actorName =  request.getParameter("name");
	int actorAge = Integer.parseInt(request.getParameter("age"));
	System.out.println( ", " + actorName + ", " + actorAge);
	
	Actor actor = new Actor();
	/* actor.setActorId(actorId); */
	actor.setActorName(actorName);
	actor.setActorAge(actorAge);
	
	ActorDao actdao = new ActorDao();
	actdao.InsertActor(actor);
	
	response.sendRedirect(request.getContextPath()+ "/actorList.jsp");

%>