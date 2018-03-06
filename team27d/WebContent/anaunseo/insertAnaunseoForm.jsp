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
					/* Ÿ�� �׽�Ʈ */
					console.log("-------------------------");
					console.log("$('#anaunseoName').val() : " + jQuery.type($("#anaunseoName").val()));
					console.log("$('#anaunseoAge').val() : " + jQuery.type($("#anaunseoAge").val()));
					
					/* 2�� �̸� �̸� �Է� ���� */
					if($("#anaunseoName").val().length < 2){
						$("#helper").text("�̸��� 2�� �̻� �Է��ϼ���.");
						return ;
					/* 
						isNaN(is Not a Number) : ���ڰ� �ƴ� ��� true �����Ѵ�.
						��, ���������� ���ڿ��̳� ���ڰ� ������ �ȵ����� ��� "���̸� �Է��ϼ���." ��� �޽����� ��Ÿ����.
						����, �����Է¶��� �������� ���ܵΰ� ��ư�� �����ٸ� "���̸� �Է��ϼ���." ��� �޽����� ��Ÿ���� �Ͽ���.
					*/
					}else if(isNaN($("#anaunseoAge").val()) || $("#anaunseoAge").val() === ""){
						$("#helper").text("���̸� �Է��ϼ���.");
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
		<h3>�Ƴ�� ���</h3>
		<hr>
		<form id = "insertForm" method = "post" action = "<%= request.getContextPath() %>/anaunseo/insertAnaunseoAction.jsp" enctype = "application/x-www-form-urlencoded">
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




















