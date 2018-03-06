<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertAnnouncerForm.jsp</title>
		<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#insertButtion").click(function(){
					/* 타입 테스트 */
					console.log("-------------------------");
					console.log("$('#anaunseoName').val() : " + jQuery.type($("#anaunseoName").val()));
					console.log("$('#anaunseoAge').val() : " + jQuery.type($("#anaunseoAge").val()));
					
					/* 2자 미만 이름 입력 막기 */
					if($("#anaunseoName").val().length < 2){
						$("#helper").text("이름을 2자 이상 입력하세요.");
						return ;
					/* 
						isNaN(is Not a Number) : 숫자가 아닐 경우 true 리턴 ;
						즉, 숫자형태의 문자열이나 숫자가 값으로 안들어왔을 경우 "나이를 입력하세요." 라는 메시지가 나타난다.
						또한, 나이입력란은 공란으로 남겨두고 버튼을 눌렀다면 "나이를 입력하세요." 라는 메시지가 나타나게 하였다.
					*/
					}else if(isNaN($("#anaunseoAge").val()) || $("#anaunseoAge").val() === ""){
						$("#helper").text("나이를 입력하세요.");
						return ;
					}else{
						$("#helper").text("");
						$("#insertForm").submit();
					}
				});
			});
		</script>
	</head>
	<body>
		<%
			System.out.println("===== insertAnnouncerForm.jsp =====");
		%>
		<h3>아나운서 등록</h3>
		<hr>
		<form id = "insertForm" method = "post" action = "<%= request.getContextPath() %>/anaunseo/insertAnnouncerAction.jsp" enctype = "application/x-www-form-urlencoded">
			<table border = "1">
				<thead>
					<tr>
						<th>속성</th>
						<th>입력란</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<td>이름</td>
						<td><input id = "anaunseoName" type = "text" name = "anaunseo_name"></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input id = "anaunseoAge" type = "text" name = "anaunseo_age"></td>
					</tr>
					<tr>
						<td colspan = "2">
							<button id = "insertButtion" type = "button">등록버튼</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<span id = "helper"></span>
			</div>
		</form>
	</body>
</html>




















