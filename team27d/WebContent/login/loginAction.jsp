<!-- team27d [���Ḳ] -->
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
		System.out.println("result : " + result + " /�α��� ����");
		session.setAttribute("loginMember", member);
	}else if(result == 2){
		System.out.println("result : " + result + " /���̵� ����ġ");
	}else if(result == 3){
		System.out.println("result : " + result + " /�н����� ����ġ");
	}else{
		System.out.println("result : " + result + " /�ý��� ����");
	}
	
	System.out.println("���� �ɹ���ü Ȯ�� : " + session.getAttribute("loginMember"));

	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>