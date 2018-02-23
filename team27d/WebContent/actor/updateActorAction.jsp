<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="service.ActorDao" %>
<%@ page import="service.Actor" %>
<!DOCTYPE html >

<% 	request.setCharacterEncoding("utf-8"); %>

<%
	int actorId = Integer.parseInt(request.getParameter("id"));
	String actorName = request.getParameter("name");
	int actorAge = Integer.parseInt(request.getParameter("age"));
	
	Actor actor = new Actor();
	actor.setActorId(actorId);
	actor.setActorName(actorName);
	actor.setActorAge(actorAge);

	ActorDao actdao = new ActorDao();
	actdao.updateActor(actor);
	response.sendRedirect(request.getContextPath() + "/list/actorList.jsp");

%>


