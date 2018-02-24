<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>
<%@ page import = "service.LoginDao" %>
<!DOCTYPE html>
<%
	System.out.println("=====loginAction.jsp=====");
	/*
		Member객체를 생성한 후 객체참조변수 member에 그 주소를 할당한다.
		set메서드를 통해 loginform.jsp 화면에서 입력한 id, pw를
		Member객체에 각각 세팅하여 loginDao.loginCheck() 메서드의 매개변수로 넣어준다.
	*/
	Member member = new Member();
	member.setMemberId(request.getParameter("memberId"));
	member.setMemberPw(request.getParameter("memberPw"));
	System.out.println("memberId : " + member.getMemberId());
	System.out.println("memberPw : " + member.getMemberPw());

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