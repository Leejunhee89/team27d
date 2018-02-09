<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table border="1"> 
		   <tr>   
		      <td>팀명 : team27d</td><td>사진</td>
		   </tr>
		   <tr>
		      <td>팀장 :이준희 역할: actor,actoress CRUD</td>
		      <td><img src="<%= request.getContextPath() %>/image/niche.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>팀원 :이춘림 역할: anaunseo CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/tam.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>팀원 :방민영 역할: comedian CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/rabbit.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>팀원 :유국화 역할: rapper CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/Yadon.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>팀원 :나윤주 역할: singer CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/kong.JPG" width="100" height="150"> </td>
		   </tr>
		</table>
   

   <ul>
      <li><a href="<%= request.getContextPath() %>/actorList.jsp">actor list</a></li> 
      <li><a href="<%= request.getContextPath() %>/actressList.jsp">actoress list</a></li> 
      <li><a href="<%= request.getContextPath() %>/announcerList.jsp">anaunseo list</a></li> 
      <li><a href="<%= request.getContextPath() %>/comedianList.jsp">comedian list</a></li>
      <li><a href="<%= request.getContextPath() %>/rapperList.jsp">rapper list</a></li>
      <li><a href="<%= request.getContextPath() %>/singerList.jsp">singer list</a></li>
   </ul>   

</body>
</html>