<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/slider.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/sForm.js"></script>
<script src="js/jquery.jqtransform.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/tms-0.4.1.js"></script>
<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<title>Fixed Top Navbar Example for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/navbar-fixed-top.css" rel="stylesheet">
</head>

<body>


	<!-- map -->
	<jsp:include page="map.jsp" />
	<!-- map end -->

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Travel Advisor</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>Navbar example</h1>
			<p>This example is a quick exercise to illustrate how the
				default, static and fixed to top navbar work. It includes the
				responsive CSS and HTML, so it also adapts to your viewport and
				device.</p>
			<p>To see the difference between static and fixed top navbars,
				just scroll.</p>
			<p>
				<a class="btn btn-lg btn-primary" href="../../components/#navbar"
					role="button">View navbar docs &raquo;</a>
			</p>
		</div>
		
		<div class="boxes">
					<div class="grid_4">
						<figure>
							<div>
								<img src="images/page1_img1.jpg" alt="">
							</div>
							<figcaption>
								<h3>Venice</h3>
								Lorem ipsum dolor site geril amet, consectetur cing eliti.
								Suspendisse nulla leo mew dignissim eu velite a rew qw vehicula
								lacinia arcufasec ro. Aenean lacinia ucibusy fase tortor ut
								feugiat. Rabi tur oliti aliquam bibendum olor quis
								malesuadivamu. <a href="" class="btn">Details</a>
							</figcaption>
						</figure>
					</div>
					<div class="grid_4">
						<figure>
							<div>
								<img src="images/page1_img2.jpg" alt="">
							</div>
							<figcaption>
								<h3>New York</h3>
								Psum dolor sit ametylo gerto consectetur ertori hykill holit
								adipiscing lity. Donecto rtopil osueremo kollit asec emmodem
								geteq tiloli. Aliquam dapibus neclol nami wertoli elittro eget
								vulpoli no utaterbil congue turpis in su. <a href="" class="btn">Details</a>
							</figcaption>
						</figure>
					</div>
					<div class="grid_4">
						<figure>
							<div>
								<img src="images/page1_img3.jpg" alt="">
							</div>
							<figcaption>
								<h3>Paris</h3>
								Lorem ipsum dolor site geril amet, consectetur cing eliti.
								Suspendisse nulla leo mew dignissim eu velite a rew qw vehicula
								lacinia arcufasec ro. Aenean lacinia ucibusy fase tortor ut
								feugiat. Rabi tur oliti aliquam bibendum olor quis
								malesuadivamu. <a href="" class="btn">Details</a>
							</figcaption>
						</figure>
					</div>
					<div class="clear"></div>
				</div>
		
		
		<!-- /container -->


		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>
