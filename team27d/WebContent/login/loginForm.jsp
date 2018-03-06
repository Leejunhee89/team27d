<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>loginForm.jsp</title>
		<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#loginButton").click(function(){
					/* 타입 테스트 */
					console.log("-------------------------");
					console.log("$('#loginId').val() : " + jQuery.type($("#loginId").val()));
					console.log("$('#loginPw').val() : " + jQuery.type($("#loginPw").val()));
					
					/* ID 공란 체크 */
					if($("#loginId").val() === ""){
						$("#helper").text("아이디를 입력하세요.");
						return ;
					/* PW 공란 체크 */
					}else if($("#loginPw").val() === ""){
						$("#helper").text("패스워드를 입력하세요.");
						return ;
					}else{
						$("#helper").text("");
						$("#loginForm").submit();
					}
				});
			});
		</script>
	</head>
	<body>
		<%
			System.out.println("=====loginForm.jsp=====");
		%>
		<form id = "loginForm" method = "post" action = "<%= request.getContextPath() %>/login/loginAction.jsp" enctype = "application/x-www-form-urlencoded">
			<table border = "1">
				<tr>
					<th>아이디</th>
					<td><input id = "loginId" type = "text" name = "memberId"></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input id = "loginPw" type = "text" name = "memberPw"></td>
				</tr>
				<tr>
					<td colspan = "2">
						<button id = "loginButton" type = "button">로그인</button>
					</td>
				</tr>
			</table>
			<div>
				<span id = "helper"></span>
			</div>
		</form>
	</body>
</html>