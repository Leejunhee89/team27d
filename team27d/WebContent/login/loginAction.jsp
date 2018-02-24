<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>
<%@ page import = "service.LoginDao" %>
<!DOCTYPE html>
<%
	System.out.println("=====loginAction.jsp=====");
	Member member = new Member();
	member.setMember_id(request.getParameter("memberId"));
	member.setMember_pw(request.getParameter("memberPw"));
	System.out.println("memberId : " + member.getMember_id());
	System.out.println("memberPw : " + member.getMember_pw());
	
	LoginDao loginDao = new LoginDao();
	int result = loginDao.loginCheck(member);
	
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
	
	System.out.println("세션 맴버객체 확인 : " + session.getAttribute("loginMember"));

	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>