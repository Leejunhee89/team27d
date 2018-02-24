<!-- author -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>
<!DOCTYPE html >

<html>
<head>
	<!-- 들여쓰기 -->
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>index.jsp</title>
</head>
<body>
	<table border="1"> 
	   <tr>
			<%	 
				Member member = (Member)session.getAttribute("loginMember");
				if(member == null){
			%>
		   		<a href="<%= request.getContextPath() %>/login/loginForm.jsp"> 로그인 </a> &nbsp;
		   	<%
		   		}else {
		   	%>	
		   		<%= member.getMemberId() %>  님은 로그인 되었습니다.
		   		<a href="<%= request.getContextPath() %>/login/logoutAction.jsp">  로그아웃</a>
		   	<%
		   		}
		    %>
	   </tr>
	   <tr>   
	      <td>팀명 : team27d </td>  
	      <td>사진</td>
	   </tr>
	   <tr>
	      <td>팀장 :이준희 역할: actor,actress CRUD</td>
	      <!-- request.getContextPath() -->	
	      <td><img src="/team27d/image/niche.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>팀원 :이춘림 역할: announcer CRUD</td>
	      <td><img  src="/team27d/image/tam.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>팀원 :방민영 역할: comedian CRUD</td>
	      <td><img  src="/team27d/image/rabbit.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>팀원 :유국화 역할: rapper CRUD</td>
	      <td><img  src="/team27d/image/Yadon.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>팀원 :나윤주 역할: singer CRUD</td>
	      <td><img  src="/team27d/image/kong.JPG" width="100" height="150"> </td>
	   </tr>
	</table>
             

	<ul>
	   <!-- request.getContextPath() -->
	   <li><a href="<%= request.getContextPath() %>/actor/actorList.jsp">actor list</a></li> 
	   <li><a href="<%= request.getContextPath() %>/actress/actressList.jsp">actress list</a></li> 
	   <li><a href="<%= request.getContextPath() %>/anaunseo/announcerList.jsp">announcer list</a></li> 
	   <li><a href="<%= request.getContextPath() %>/comedian/comedianList.jsp">comedian list</a></li>
	   <li><a href="<%= request.getContextPath() %>/rapper/rapperList.jsp">rapper list</a></li>
	   <li><a href="<%= request.getContextPath() %>/singer/singerList.jsp">singer list</a></li>
	</ul>   

</body>
</html>