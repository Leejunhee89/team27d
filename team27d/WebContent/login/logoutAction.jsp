<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.Member" %>
<!DOCTYPE html>
<%
	Member member = (Member)session.getAttribute("loginMember");
	System.out.println(member.getMember_no());
	System.out.println(member.getMember_id());
	System.out.println(member.getMember_pw());
	System.out.println("'--------------------0");
	session.invalidate();
	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>
