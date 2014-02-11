<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

   <div style="height:300px;width:1000px;margin-left:auto;margin-right:auto; ">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
   <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
function initialize() {
  var mapOptions = {
    zoom: 1,
    center: new google.maps.LatLng(40, -80)
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  // Add 5 markers to the map at random locations

  var southWest = new google.maps.LatLng(40, -80);
  var northEast = new google.maps.LatLng(42, -78);
  
  var bounds = new google.maps.LatLngBounds(southWest, northEast);
  map.fitBounds(bounds);
  

  var lngSpan = northEast.lng() - southWest.lng();
  var latSpan = northEast.lat() - southWest.lat();

 for (var i = 0; i < 5; i++) {
   var position = new google.maps.LatLng(
       southWest.lat() + latSpan * Math.random(),
       southWest.lng() + lngSpan * Math.random());
   var marker = new google.maps.Marker({
      position: position,
	  draggable:true,
      animation: google.maps.Animation.DROP,
      map: map
    });
 
    marker.setTitle((i + 1).toString());
    attachSecretMessage(marker, i);
  }
}

// The five markers show a secret message when clicked
// but that message is not within the marker's instance data
function attachSecretMessage(marker, num) {
  var message = ['This', 'is', 'the', 'secret', 'message'];
  var infowindow = new google.maps.InfoWindow({
    content: message[num]
  });

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
 
    <div id="map-canvas"/>
	</div>
  


