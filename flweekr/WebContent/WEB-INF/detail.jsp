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
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
     <script src="js/blocksit.min.js"></script>
     
     <link rel="stylesheet" href="css/jquery.fancybox.css" type="text/css" media="screen" />
     <script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>
</head> 

<body>
<jsp:include page="nav.jsp" />

<div class="container">	
	<div class="ez_left" style="float:left;">
		<div class="ez_photo" style="margin-top:60px; margin-left:15px;">
			<img class="img-thumbnail" src="${requestScope.photo_ob.imgUrl_b }" width="780">
		</div>
	
		<div class="ez_twitter" style="margin-top:10px; margin-left:15px;">
			<c:forEach var="tweet" items="${requestScope.oembeds_list }">
				<blockquote class="twitter-tweet" data-link-color="#cc0000" >
					${tweet}
				</blockquote>
				
			</c:forEach>	
			 <script async src="js/widgets.js" charset="utf-8"></script>
			<div class="jumbotron" style="background-color:#fff; padding-top:10px; padding-left:40px; padding-right:30px; padding-bottom:30px; max-width:780px; height:190px;">
				<form id="form" method="POST" action="login.do?photo_id=${requestScope.flickr_id}"><!--  target="_blank"> -->
					<input type="image" src="img/sign-in-with-twitter-gray.png" name="sign_in_button" value="twitter_sign_in">
				</form>
				<form action="getdetail.do" method="POST" id="twitter_text" >
					<textarea class="form-control" rows="3" name="text" form="twitter_text" placeholder="Add a comment..."></textarea>
					<button type="submit" name="send_btn" value="send_tweet" class="btn btn-primary" style="float:right; margin-top:10px;">Tweet</button>
				</form>
			</div>
	
		</div>
	</div>
	
	<div class="ez_right" style="float:right; margin-top:65px;">		
		
<style>
     #map-canvas {
        height: 500px;
       	overflow:hidden;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
    

var lat='${requestScope.photo_ob.location.latitude}';
var lon='${requestScope.photo_ob.location.longitude}';

    
function initialize() {
  var mapOptions = {
    zoom: 8,
    center: new google.maps.LatLng(lat, lon),
    scrollwheel: false,
    panControl: false,
    streetViewControl: false,
    scaleControl: false,
    
    mapTypeControlOptions: {
        style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
      },
      zoomControl: true,
      zoomControlOptions: {
  
        position: google.maps.ControlPosition.RIGHT_CENTER,
      },
  };
  
  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  
  // Add 5 markers to the map at random locations

 var position = new google.maps.LatLng(lat,lon);
  
  
  var marker = new google.maps.Marker({
      position: position,
	  draggable:false,
      animation: google.maps.Animation.DROP,
      map: map
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

    <div id="map-canvas" style="width:290px;height:300px; margin-right:40px;"/></div>

</div>






</body>
</html>