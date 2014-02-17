

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
}

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

    <div id="map-canvas" style="width:290px;height:415px; margin-right:40px;"/></div>
</div>
  


