<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "service.Member" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="SHIELD - Free Bootstrap 3 Theme">
    <meta name="author" content="Carlos Alvarez - Alvarez.is - blacktie.co">
    <link rel="shortcut icon" href="<%= request.getContextPath() %>/Shield Theme/assets/ico/favicon.png">

    <title> SHIELD - Free Bootstrap 3 Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath() %>/Shield Theme/assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%= request.getContextPath() %>/Shield Theme/assets/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Shield Theme/assets/css/icomoon.css">
    <link href="<%= request.getContextPath() %>/Shield Theme/assets/css/animate-custom.css" rel="stylesheet">


    
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
    
    <script src="<%= request.getContextPath() %>/Shield Theme/assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/modernizr.custom.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
  </head>
<body data-spy="scroll" data-offset="0" data-target="#navbar-main">
  
  
  	<div id="navbar-main">
      <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon icon-shield" style="font-size:30px; color:#3498db;"></span>
          </button>
          <a class="navbar-brand hidden-xs hidden-sm" href="#home"><span class="icon icon-shield" style="font-size:18px; color:#3498db;"></span></a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li> <a href="<%= request.getContextPath() %>/index.jsp" class="smoothScroll">Home</a></li>
			
			<%	 
				Member member = (Member)session.getAttribute("loginMember");
				if(member == null){
			%>
				<li> <a href="<%= request.getContextPath() %>/login/loginForm.jsp" class="smoothScroll"> Login</a></li>
		   		<%-- <a href="<%= request.getContextPath() %>/login/loginForm.jsp"> 로그인 </a> &nbsp; --%>
		   	<%
		   		}else {
		   	%>			   		
		   		<li><a href="<%= request.getContextPath() %>/login/logoutAction.jsp" class="smoothScroll"> Logout</a></li>
		   		<li><div style="padding: 15px 0px 0px 0px;"><%= member.getMemberId() %>  님은 로그인 되었습니다.</div></li>
		   		<%-- <a href="<%= request.getContextPath() %>/login/logoutAction.jsp">  로그아웃</a> --%>
		   	<%
		   		}
		    %>
						
        </div><!--/.nav-collapse -->
      </div>
    </div>
    </div>

  
  			<%-- <%	 
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
		    %> --%>
  
  
   
  
		<!-- ==== HEADERWRAP ==== -->
	    <div id="headerwrap" id="home" name="home">
			<header class="clearfix">
	  		 		<h1><span class="icon icon-shield"></span></h1>
	  		 		<p>Team27d</p>
	  		 		<p>Index 화면 입니다.</p>
	  		</header>	    
	    </div><!-- /headerwrap -->
			<br>
			<br>
		
	<section class="section-divider textdivider divider3">
			<div class="container">
				<h1>Team27d</h1>
				<hr>				
			</div><!-- container -->
		</section><!-- section -->
		
		<!-- ==== PORTFOLIO ==== -->
		<div class="container" id="portfolio" name="portfolio">
		<br>
			<div class="row">
				<br>
				<h1 class="centered">List LINK</h1>
				<hr>
				<br>
				<br>
			</div><!-- /row -->
			<div class="container">
			<div class="row">	
			
				<!-- PORTFOLIO IMAGE 1 -->
				<div class="col-md-4 ">
			    	<div class="grid mask">
						<figure>
							<img class="img-responsive" src="<%= request.getContextPath() %>/Shield Theme/assets/img/portfolio/folio01.jpg" alt="">
							<figcaption>
								<h5>Actor List</h5>
								<a data-toggle="modal" href="<%= request.getContextPath() %>/actor/actorList.jsp" class="btn btn-primary btn-lg">Take a Look</a>
							</figcaption><!-- /figcaption -->
						</figure><!-- /figure -->
			    	</div><!-- /grid-mask -->
				</div><!-- /col -->	  
		
		 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						    <div class="modal-dialog">
						      <div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						          <h4 class="modal-title">Project Title</h4>
						        </div>
						        <div class="modal-body">
						          <p><img class="img-responsive" src="<%= request.getContextPath() %>/Shield Theme/assets/img/portfolio/folio01.jpg" alt=""></p>
						          <p>This project was crafted for Some Name corp. Detail here a little about your job requirements and the tools used. Tell about the challenges faced and what you and your team did to solve it.</p>
						          <p><b><a href="#">Visit Site</a></b></p>
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        </div>
						      </div><!-- /.modal-content -->
						    </div><!-- /.modal-dialog -->
						  </div><!-- /.modal -->
				
				
				<!-- PORTFOLIO IMAGE 2 -->
				<div class="col-md-4">
			    	<div class="grid mask">
						<figure>
							<img class="img-responsive" src="<%= request.getContextPath() %>/Shield Theme/assets/img/portfolio/folio02.jpg" alt="">
							<figcaption>
								<h5>Actress</h5>
								<a data-toggle="modal" href="<%= request.getContextPath() %>/actress/actressList.jsp" class="btn btn-primary btn-lg">Take a Look</a>
							</figcaption><!-- /figcaption -->
						</figure><!-- /figure -->
			    	</div><!-- /grid-mask -->
				</div><!-- /col -->
				
				<!-- PORTFOLIO IMAGE 3 -->
				<div class="col-md-4">
			    	<div class="grid mask">
						<figure>
							<img class="img-responsive" src="<%= request.getContextPath() %>/Shield Theme/assets/img/portfolio/folio03.jpg" alt="">
							<figcaption>
								<h5>Rapper</h5>
								<a data-toggle="modal" href="<%= request.getContextPath() %>/rapper/rapperList.jsp" class="btn btn-primary btn-lg">Take a Look</a>
							</figcaption><!-- /figcaption -->
						</figure><!-- /figure -->
			    	</div><!-- /grid-mask -->
				</div><!-- /col -->
			</div><!-- /row -->

				<!-- PORTFOLIO IMAGE 4 -->
			<div class="row">	
				<div class="col-md-4 ">
			    	<div class="grid mask">
						<figure>
							<img class="img-responsive" src="<%= request.getContextPath() %>/Shield Theme/assets/img/portfolio/folio04.jpg" alt="">
							<figcaption>
								<h5>Anaunseo</h5>
								<a data-toggle="modal" href="<%= request.getContextPath() %>/anaunseo/anaunseoList.jsp" class="btn btn-primary btn-lg">Take a Look</a>
							</figcaption><!-- /figcaption -->
						</figure><!-- /figure -->
			    	</div><!-- /grid-mask -->
				</div><!-- /col -->
				
				<!-- PORTFOLIO IMAGE 5 -->
				<div class="col-md-4">
			    	<div class="grid mask">
						<figure>
							<img class="img-responsive" src="<%= request.getContextPath() %>/Shield Theme/assets/img/portfolio/folio05.jpg" alt="">
							<figcaption>
								<h5>Comedian</h5>
								<a data-toggle="modal" href="<%= request.getContextPath() %>/comedian/comedianList.jsp" class="btn btn-primary btn-lg">Take a Look</a>
							</figcaption><!-- /figcaption -->
						</figure><!-- /figure -->
			    	</div><!-- /grid-mask -->
				</div><!-- /col -->
				
				<!-- PORTFOLIO IMAGE 6 -->
				<div class="col-md-4">
			    	<div class="grid mask">
						<figure>
							<img class="img-responsive" src="<%= request.getContextPath() %>/Shield Theme/assets/img/portfolio/folio06.jpg" alt="">
							<figcaption>
								<h5>Singer</h5>
								<a data-toggle="modal" href="<%= request.getContextPath() %>/singer/singerList.jsp" class="btn btn-primary btn-lg">Take a Look</a>
							</figcaption><!-- /figcaption -->
						</figure><!-- /figure -->
			    	</div><!-- /grid-mask -->
				</div><!-- /col -->
			</div><!-- /row -->
			<br>
			<br>
		</div><!-- /row -->
	</div><!-- /container -->
	 

	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/retina.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/smoothscroll.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/jquery-func.js"></script>
  </body>
</html>