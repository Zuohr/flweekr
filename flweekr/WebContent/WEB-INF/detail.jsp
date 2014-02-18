<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Detail</title>
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/navbar-fixed-top.css" rel="stylesheet">

<link rel='stylesheet' href='css/block.css' media='screen' />
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/superfish.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script src="js/touchTouch.jquery.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="js/blocksit.min.js"></script>

<link rel="stylesheet" href="css/jquery.fancybox.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
<style>
#map-canvas {
	height: 500px;
	overflow: hidden;
}
</style>
			<script
				src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
			<script>
				var lat = '${requestScope.photo_ob.location.latitude}';
				var lon = '${requestScope.photo_ob.location.longitude}';

				function initialize() {
					var mapOptions = {
						zoom : 8,
						center : new google.maps.LatLng(lat, lon),
						scrollwheel : false,
						panControl : false,
						streetViewControl : false,
						scaleControl : false,

						mapTypeControlOptions : {
							style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
						},
						zoomControl : true,
						zoomControlOptions : {

							position : google.maps.ControlPosition.RIGHT_CENTER,
						},
					};

					var map = new google.maps.Map(document
							.getElementById('map-canvas'), mapOptions);

					// Add 5 markers to the map at random locations

					var position = new google.maps.LatLng(lat, lon);

					var marker = new google.maps.Marker({
						position : position,
						draggable : false,
						animation : google.maps.Animation.DROP,
						map : map
					});
					marker.setTitle((1).toString());
					attachSecretMessage(marker, 0);
				}

				function attachSecretMessage(marker, num) {
					/*  var message = ['This', 'is', 'the', 'secret', 'message']; */

					google.maps.event.addListener(marker, 'click', function() {
						infowindow.open(marker.get('map'), marker);
					});
				}

				google.maps.event.addDomListener(window, 'load', initialize);

				function toggleBounce() {

					if (marker.getAnimation() != null) {
						marker.setAnimation(null);
					} else {
						marker.setAnimation(google.maps.Animation.BOUNCE);
					}
				}

				google.maps.event.addDomListener(window, 'load', initialize);
			</script>
<script>
	$(document).ready(function() {
		//vendor script
		$('#header').css({
			'top' : -50
		}).delay(1000).animate({
			'top' : 0
		}, 800);

		$('#footer').css({
			'bottom' : -15
		}).delay(1000).animate({
			'bottom' : 0
		}, 800);

		//blocksit define
		$(window).load(function() {
			$('#container').BlocksIt({
				numOfCol : 4,
				offsetX : 1,
				offsetY : 8
			});
		});

		//window resize
		var currentWidth = 1100;
		$(window).resize(function() {
			var winWidth = $(window).width();
			var conWidth;
			if (winWidth < 660) {
				conWidth = 440;
				col = 2
			} else if (winWidth < 880) {
				conWidth = 660;
				col = 3
			} else if (winWidth < 1100) {
				conWidth = 880;
				col = 4;
			} else {
				conWidth = 1100;
				col = 5;
			}

			if (conWidth != currentWidth) {
				currentWidth = conWidth;
				$('#container').width(conWidth);
				$('#container').BlocksIt({
					numOfCol : col,
					offsetX : 1,
					offsetY : 8
				});
			}
		});
	});
</script>
</head>

<body>
	<jsp:include page="nav.jsp" />

	<div class="container" style="width:1140px; margin-top: 60px;">
		<div class="ez_left" style="float: left; margin-left: 15px; width:735px;">
			<div class="ez_photo" >
				<div class="thumbnail" style=" height:auto; width:725px;">
					
					<img src="${requestScope.bestImgUrl}">
					
				</div>
			</div>
			<div class="thumbnail" style=" width:728px; height:70px; padding-bottom:30px; ">
				<div class="caption" style="margin-left:auto; float:left; margin-right:auto; width:360px;">
					<h4>${requestScope.photo_ob.title._content}</h4>
				</div>
				<div class="button_group" style="width:330px; float:right; text-align:right; margin-top:13px; margin-right:5px;">
				
				<a class="btn btn-primary" href="getdetail.do?wish_btn=submit">I wish to go there  <span class="badge">${requestScope.wish_num } </span></a>
				&nbsp;&nbsp;&nbsp;
				<a class="btn btn-primary" href="getdetail.do?been_btn=submit">I have been there  <span class="badge">${requestScope.been_num }</span></a>
				
				</div>
			</div>
			<div class="ez_twitter" style="margin-top: 10px;">
				<h4>${nearby_title }</h4>
				<c:forEach var="tweet" items="${requestScope.tw_nearby}">
					<blockquote class="twitter-tweet">
						${tweet}</blockquote>

				</c:forEach>

				
				<c:forEach var="tweet" items="${requestScope.tw_discuss}">
					<blockquote class="twitter-tweet">
						${tweet}</blockquote>

				</c:forEach>
				<script async src="js/widgets.js" charset="utf-8"></script>
				<div class="jumbotron"
					style="background-color: #fff; padding-top: 10px; padding-left: 40px; padding-right: 30px; width:728px; padding-bottom: 30px;  height: 190px;">
					<c:choose>
						<c:when test="${empty sessionScope.user}">
							<form id="form" method="POST" action="login.do">
								<input type="image"
									src="img/sign-in-with-twitter-gray.png" name="sign_in_button"
									value="twitter_sign_in">
							</form>
						</c:when>
						<c:otherwise>
							${sessionScope.user.name }@${sessionScope.user.screen_name }&nbsp;|&nbsp;<a
								href="logout.do">Sign out</a>
						</c:otherwise>
					</c:choose>
					<form action="getdetail.do" method="POST" id="twitter_text">
						<textarea class="form-control" rows="3" name="text"
							form="twitter_text" placeholder="Comment via twitter..."></textarea>
						<c:choose>
							<c:when test="${empty sessionScope.user }">
								<button type="submit" name="send_btn" value="send_tweet" disabled="disabled"
									class="btn btn-default" style="float: right; margin-top: 10px;">Tweet</button>
							</c:when>
							<c:otherwise>
								<button type="submit" name="send_btn" value="send_tweet"
									class="btn btn-primary" style="float: right; margin-top: 10px;">Tweet</button>
							</c:otherwise>
						</c:choose>
					</form>
				</div>

			</div>
		</div>

		<div class="ez_right" style=" float:left; margin-left:15px; width:310px; ">
			<div class="img-thumbnail"  id="map-canvas" style=" width: 305px; height:305px;  " /></div>
	
			<ul class="list-group" style="margin-top:10px;">
			  <li class="list-group-item ">
			    <h4 class="list-group-item-heading">Location</h4>
			    <p class="list-group-item-text">${requestScope.photo_ob.location.locality._content}  ${requestScope.photo_ob.location.region._content} ${requestScope.photo_ob.location.country._content}</p>
			  </li>
			  <li class="list-group-item">
			    <h4 class="list-group-item-heading">Description</h4>
			    <p class="list-group-item-text">${requestScope.photo_ob.description._content}</p>
			  </li>
			  <li class="list-group-item ">
			    <h4 class="list-group-item-heading">Photographer</h4>
			    <p class="list-group-item-text">${requestScope.photo_ob.owner.realname}</p>
			  </li>
			</ul>
			<a href="mappic.do" class="btn btn-primary btn-lg" style="width:305px;">I want to go there right now !</a>
			
		</div>

	</div>
	<div class="container" >
		<div class="ez_loc" >
			<h4 style="position:relative; left:30px;">${requestScope.nearbyPhoto }</h4>
			<div id="container">
				<c:forEach var="plist" items="${requestScope.flk_loc_plist}">
					<div class="grid">
						<div class="imgholder">

							<a class="fancybox" title="${plist.title}"
								href="getdetail.do?photo_id=${plist.id}"> <img
								src="${plist.imgUrl}" />
							</a>
						</div>
						<strong></strong>
						<p>
							<a href="getdetail.do?photo_id=${plist.id}" target="_blank"
								style="color: #000; font-weight: bold; font-size: 14px">${plist.title}</a>
						</p>
						<div class="ez_button">
							<a href="getdetail.do?photo_id=${plist.id}" target="_blank"><button
									type="button" class="btn btn-primary btn-xs">Explore</button></a> <span
								style="float: right;"><a href="https://twitter.com/share"
								class="twitter-share-button" data-dnt="true" data-count="none"
								data-via="twitterapi" id="hover">Tweet</a></span>
							<script>
								!function(d, s, id) {
									var js, fjs = d.getElementsByTagName(s)[0];
									if (!d.getElementById(id)) {
										js = d.createElement(s);
										js.id = id;
										js.src = "js/widgets.js";
										fjs.parentNode.insertBefore(js, fjs);
									}
								}(document, "script", "twitter-wjs");
							</script>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>


</body>
</html>