<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	


</script>
<body>
 <section class="section-divider textdivider divider6">
			<div class="container">
				<h1>CRAFTED IN TEAM27D, JeonJU.</h1>
				<hr>
				<p>한국스마트 정보교육원</p>
				<p>+061+063-717-1008</p>
				<p><a class="icon icon-twitter" href="#"></a> | <a class="icon icon-facebook" href="#"></a></p>
			</div><!-- container -->
		</section><!-- section -->
		
		<div class="container" id="contact" name="contact">
			<div class="row">
			<br>
				<h1 class="centered">INSERTActorFORM</h1>
				<hr>
				<br>
				<br>
				<div class="col-lg-4"></div>
				<div class="col-lg-4" >
					<h3 style="text-align: center;" >남자배우들을 입력시켜보자!</h3>
					<p style="text-align: center;"> My actor is hot. if you see my actor you would love to my actor </p>
					<p>
						<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/actor/insertActorAction.jsp" method= "post">
						  <div class="form-group">
						    <label for="inputEmail1" class="col-lg-4 control-label"></label>
						    <div class="col-lg-10">
						      <input type="text" class="form-control" id="inputEmail1" placeholder="Name" name="name">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="text1" class="col-lg-4 control-label"></label>
						    <div class="col-lg-10">
						      <input type="text" class="form-control" id="text1" placeholder="Age" name="age">
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-lg-10">
						      <button type="submit" class="btn btn-success">INSERT IN</button>
						    </div>
						  </div>
					   </form><!-- form -->
					</p>
				</div><!-- col -->
			<div class="col-lg-4"></div>					
			</div><!-- row -->
		
		</div><!-- container -->

		<div id="footerwrap">
			<div class="container">
				<h4>Created by <a href="http://blacktie.co">TEAM27D</a> - Copyright 2018</h4>
			</div>
		</div>
  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
		

	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/retina.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/smoothscroll.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/Shield Theme/assets/js/jquery-func.js"></script>
  </body>
</html>
