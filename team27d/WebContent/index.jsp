<!-- author -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html >

<html>
<head>
	<!-- �鿩���� -->
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>index.jsp</title>
</head>
<body>
	<table border="1"> 
	   <tr>   
	      <td>���� : team27d  &nbsp; <a href="<%= request.getContextPath() %>/login/loginForm.jsp">actor list</a></td>  
	      <td>����</td>
	   </tr>
	   <tr>
	      <td>���� :������ ����: actor,actress CRUD</td>
	      <!-- request.getContextPath() -->	
	      <td><img src="/team27d/image/niche.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>���� :���Ḳ ����: announcer CRUD</td>
	      <td><img  src="/team27d/image/tam.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>���� :��ο� ����: comedian CRUD</td>
	      <td><img  src="/team27d/image/rabbit.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>���� :����ȭ ����: rapper CRUD</td>
	      <td><img  src="/team27d/image/Yadon.jpg" width="100" height="150"> </td>
	   </tr>
	   <tr>
	      <td>���� :������ ����: singer CRUD</td>
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