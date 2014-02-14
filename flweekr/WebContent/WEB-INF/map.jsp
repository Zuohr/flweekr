

   <div>
   <style>
     #map-canvas {
        height: 500px;
       	overflow:hidden;

    
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
    

var lat='${map.latitude}';
var lon='${map.longitude}';

    
function initialize() {
  var mapOptions = {
    zoom: 12,
    center: new google.maps.LatLng(40.44, -79.999),
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
  
 /*  var southWest = new google.maps.LatLng(40, -80);
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
  } */
}

// The five markers show a secret message when clicked
// but that message is not within the marker's instance data
function attachSecretMessage(marker, num) {
 /*  var message = ['This', 'is', 'the', 'secret', 'message']; */
 var pic='${map.imgURL}';

  var infowindow = new google.maps.InfoWindow({
    content: '<img src="${map.imgURL}" style="width:200px;height:100px">'
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

  


