<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.ActorDao" %>
<!DOCTYPE html>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	String name =  request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	System.out.println(id + ", " + name + ", " + age);
	
	ActorDao actdao = new ActorDao();
	actdao.InsertActor(id, name, age);
	


%>