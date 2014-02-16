<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html><!--  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body background="img/shutterstock_51832540.jpg">


    <br />
    <div class="container" style="margin:0px;padding:0px;margin-right:0px;">
   
      <br />
      <div class="tab-content">

      <ul class="nav nav-pills" id="myTab" style="width:300px;">
  <li class="active"><a href="#as_employee" data-toggle="tab" style="font-size:15px">Pictures</a></li>
  <li><a href="#as_customer" data-toggle="tab" style="font-size:15px">Weather</a></li>

  
</ul>

<!-- <div class="tab-content"> -->
  <div class="tab-pane active" id="as_employee">
		
		<div >
		
<style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
      #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      }
#photo-panel {
  background: #fff;
  padding: 5px;
  overflow-y: auto;
  overflow-x: hidden;
  width: 300px;
  max-height: 300px;
  font-size: 14px;
  font-family: Arial;
  border: 1px solid #ccc;
  box-shadow: -2px 2px 2px rgba(33, 33, 33, 0.4);
  display: none;
}
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=panoramio"></script>
    <script>
	var lat='${map.latitude}';
	var lon='${map.longitude}';
	
	
function initialize() {

	
  var mapOptions = {
    zoom: 12,
    center: new google.maps.LatLng(lat, lon),
    scrollwheel: false,
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var panoramioLayer = new google.maps.panoramio.PanoramioLayer();
  panoramioLayer.setMap(map);

  var photoPanel = document.getElementById('photo-panel');
  map.controls[google.maps.ControlPosition.RIGHT_TOP].push(photoPanel);

  google.maps.event.addListener(panoramioLayer, 'click', function(photo) {
    var li = document.createElement('li');
    var link = document.createElement('a');
    link.innerHTML = photo.featureDetails.title + ': ' +
        photo.featureDetails.author;
    link.setAttribute('href', photo.featureDetails.url);
    li.appendChild(link);
    photoPanel.appendChild(li);
    photoPanel.style.display = 'block';
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>

  
    <div id="map-canvas" style="width:300px;height:400px;"></div>	
		
		</div>
		  
		  
  </div>
  
  <div class="tab-pane" id="as_customer">
		      
          <iframe src="weather.do" frameborder="0"  marginheight="0"   marginwidth="0"  scrolling="no" style="height:380px;width:300px;"></iframe>
          
 </div>
          
     

</div>

<script>
  $(function () {
    $('#myTab a:last').tab('show')
  })
</script>

    

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>