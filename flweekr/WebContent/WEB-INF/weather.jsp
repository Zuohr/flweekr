
<html>
 
    <meta charset="utf-8">

    <style>
      html, body, #map-canvas {
        height: 400px;
        width:300px;
       
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=weather"></script>
    <script>
    var lat='${requestScope.map.latitude}';
	var lon='${requestScope.map.longitude}';
	
function initialize() {
  var mapOptions = {
    zoom: 12,
    center: new google.maps.LatLng(lat,lon),
    scrollwheel: false,
   
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var weatherLayer = new google.maps.weather.WeatherLayer({
    temperatureUnits: google.maps.weather.TemperatureUnit.FAHRENHEIT
  });
  weatherLayer.setMap(map);

  var cloudLayer = new google.maps.weather.CloudLayer();
  cloudLayer.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  
  <body>
    <div id="map-canvas"></div>
  </body>
</html>