<!-- team27d [���Ḳ] -->
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
					/* 2�� �̸� �̸� �Է� ���� */
					/*
					if($("#anaunseoName").val().length < 2){
						$("#helper").text("�̸��� 2�� �̻� �Է��ϼ���.");
						//return ;
					}else {
						$("#helper").text("");
					}
					*/
					 	
					/* if( isNaN($("anaunseoAge").val()) ){
						$("#helper").text("����.");
					}else{
						$("#helper").text("����");
					} */
					
					if(typeof $("anaunseoAge").val() === 'number' && isFinite($("anaunseoAge").val())){
						$("#helper").text("����");
					}/* else{
						$("#helper").text("����");
					} */
					
				});
			});
		</script>
	</head>
	<body>
		<%
			System.out.println("===== insertAnnouncerForm.jsp =====");
		%>
		<h3>�Ƴ�� ���</h3>
		<hr>
		<form id = "announcerForm" method = "post" action = "<%= request.getContextPath() %>/anaunseo/insertAnnouncerAction.jsp" enctype = "application/x-www-form-urlencoded">
			<table border = "1">
				<thead>
					<tr>
						<th>�Ӽ�</th>
						<th>�Է¶�</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<td>�̸�</td>
						<td><input id = "anaunseoName" type = "text" name = "anaunseo_name"></td>
					</tr>
					<tr>
						<td>����</td>
						<td><input id = "anaunseoAge" type = "text" name = "anaunseo_age"></td>
					</tr>
					<tr>
						<td colspan = "2">
							<button id = "insertButtion" type = "button">��Ϲ�ư</button>
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




















