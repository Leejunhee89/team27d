<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>
<%@ page import = "service.LoginDao" %>
<%@ page import = "java.util.HashMap" %>
<!DOCTYPE html>


<%
	Member member = new Member();
	member.setMember_id(request.getParameter("memberId"));
	member.setMember_pw(request.getParameter("memberPw"));
	System.out.println(member.getMember_id());
	System.out.println(member.getMember_pw());
	
	LoginDao loginDao = new LoginDao();
	int result = loginDao.loginCheck(member);
	System.out.println("result : " + result);
	
	if(result == 1){
		System.out.println("result : " + result + " /로그인 성공");
		session.setAttribute("loginMember", member);
	}else if(result == 2){
		System.out.println("result : " + result + " /아이디 불일치");
	}else if(result == 3){
		System.out.println("result : " + result + " /패스워드 불일치");
	}else{
		System.out.println("result : " + result + " /시스템 오류");
	}
	
	System.out.println(session.getAttribute("loginMember"));
	/*
		session getting할때 이런식으로 받으면 된다.
		Member member = (Member)session.getAttribute("loginMember");
	*/
	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>