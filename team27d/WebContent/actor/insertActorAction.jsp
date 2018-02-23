<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="service.ActorDao" %>
<%@ page import="service.Actor" %>
<% 	request.setCharacterEncoding("utf-8"); %>
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
	actdao.insertActor(actor);
	
	response.sendRedirect(request.getContextPath()+ "/list/actorList.jsp");

%>