<!-- author -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
	      <td>팀명 : team27d</td><td>사진</td>
	   </tr>
	   <tr>
	      <td>팀장 :이준희 역할: actor,actoress CRUD</td>
	      <!-- request.getContextPath() -->	
	      <td><img src="/team27d/image/niche.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>팀원 :이춘림 역할: anaunseo CRUD</td>
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
	   <li><a href="/team27d/actorList.jsp">actor list</a></li> 
	   <li><a href="/team27d/actressList.jsp">actoress list</a></li> 
	   <li><a href="/team27d/announcerList.jsp">anaunseo list</a></li> 
	   <li><a href="/team27d/comedianList.jsp">comedian list</a></li>
	   <li><a href="/team27d/rapperList.jsp">rapper list</a></li>
	   <li><a href="/team27d/singerList.jsp">singer list</a></li>
	</ul>   

</body>
</html>