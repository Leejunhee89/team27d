<!-- team27d [���Ḳ] -->
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
				/* Ÿ�� �׽�Ʈ */
				console.log("-------------------------");
				console.log("$('#loginId').val() : " + jQuery.type($("#loginId").val()));
				console.log("$('#loginPw').val() : " + jQuery.type($("#loginPw").val()));
				
				/* ID ���� üũ */
				if($("#loginId").val() === ""){
					$("#helper").text("���̵� �Է��ϼ���.");
					return ;
				/* PW ���� üũ */
				}else if($("#loginPw").val() === ""){
					$("#helper").text("�н����带 �Է��ϼ���.");
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
				<th>���̵�</th>
				<td><input id = "loginId" type = "text" name = "memberId"></td>
			</tr>
			<tr>
				<th>�н�����</th>
				<td><input id = "loginPw" type = "text" name = "memberPw"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<button id = "loginButton" type = "button">�α���</button>
				</td>
			</tr>
		</table>
		<div>
			<span id = "helper"></span>
		</div>
	</form>
</body>
</html>