<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!doctype html>
<html lang="en">
<head>
<title>Gallery</title>
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

<script type='text/javascript' src='https://www.google.com/jsapi'></script>
</head>
<body>
	<jsp:include page="nav.jsp" />

	<section id="wrapper">
		<div id="container">

			<script type='text/javascript'>
   google.load('visualization', '1', {packages: ['geomap']});

    function drawVisualization() {
      var data = google.visualization.arrayToDataTable([
        ['Country', 'Popularity'],
        ['Germany', 200],
        ['United States', 300],
        ['Brazil', 400],
        ['Canada', 500],
        ['France', 600],
        ['RU', 700],
      ]);
    
      var geomap = new google.visualization.GeoMap(
          document.getElementById('visualization'));
      geomap.draw(data, {width: 760, height: 450});
    }
    

    google.setOnLoadCallback(drawVisualization);
  </script>



			<div id="visualization"></div>

			<script type='text/javascript'>
   google.load('visualization', '1', {packages: ['geomap']});

    
    
	function drawA() {
      var data = google.visualization.arrayToDataTable([
        ['Country', 'Popularity'],
        ['Germany', 200],
        ['United States', 300],
        ['Brazil', 400],
        ['Canada', 500],
        ['France', 600],
        ['RU', 100],
      ]);
    
      var geomap = new google.visualization.GeoMap(
          document.getElementById('visualization1'));
      geomap.draw(data, {width: 760, height: 450});
    }
	
	
    
       function drawVisualization() {
               drawA();
               

            }

    google.setOnLoadCallback(drawVisualization);
	
	
	
  </script>


			<div id="visualization1"></div>


		</div>


	</section>



	

		
 <script type="text/javascript">
	google.load('visualization', '1', {
		packages : [ 'imagechart' ]
	});
</script>
			<script type="text/javascript">
	function drawVisualization() {
		// Create and populate the data table.
		var data = google.visualization.arrayToDataTable([
				[ 'Name', 'Height', 'Smokes' ], 
				<c:forEach var="it" items="${requestScope.rows }">
				['${it.name}', ${it.value}, true],
			</c:forEach>
				['a', 20, true],
				['a', 30, true],
				]);
		var options = {};

		// 'bhg' is a horizontal grouped bar chart in the Google Chart API.
		// The grouping is irrelevant here since there is only one numeric column.
		options.cht = 'bhg';

		// Add a data range.
		var min = 0;
		var max = 700;
		options.chds = min + ',' + max;

		// Now add data point labels at the end of each bar.

		// Add meters suffix to the labels.
		var meters = 'N** m';

		// Draw labels in pink.
		var color = 'ff3399';

		// Google Chart API needs to know which column to draw the labels on.
		// Here we have one labels column and one data column.
		// The Chart API doesn't see the label column.  From its point of view,
		// the data column is column 0.
		var index = 0;

		// -1 tells Google Chart API to draw a label on all bars.
		var allbars = -1;

		// 10 pixels font size for the labels.
		var fontSize = 10;

		// Priority is not so important here, but Google Chart API requires it.
		var priority = 0;

		options.chm = [ meters, color, index, allbars, fontSize, priority ]
				.join(',');

		// Create and draw the visualization.
		new google.visualization.ImageChart(document
				.getElementById('visualization2')).draw(data, options);
	}

	google.setOnLoadCallback(drawVisualization);
</script>
			<div id="visualization2" style="width: 280px; height: 160px;position:absolute;top:70px;right:100px;"></div>


	


</body>
</html>