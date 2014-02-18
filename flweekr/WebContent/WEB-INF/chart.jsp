<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!doctype html>
<html lang="en">
<head>
<title>Trend</title>
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

 <script type="text/javascript">
	google.load('visualization', '1', {
		packages : [ 'imagechart' ]
	});
</script>
<script type="text/javascript">
	function drawVisualization() {
		// Create and populate the data table.
		var data = google.visualization.arrayToDataTable([
				[ 'Name', '${top_search_title}'], 
				<c:forEach var="it" items="${requestScope.top_search_data }">
				['${it.keyword}', ${it.number}],
			</c:forEach>]);
		var options = {};

		// 'bhg' is a horizontal grouped bar chart in the Google Chart API.
		// The grouping is irrelevant here since there is only one numeric column.
		options.cht = 'bhg';

		// Add a data range.
		var min = 0;
		var max = 10;
		options.chds = min + ',' + max;

		// Now add data point labels at the end of each bar.

		// Add meters suffix to the labels.
		var meters = 'N** ';

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
		var fontSize = 15;

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

			<script type='text/javascript'>
   google.load('visualization', '1', {packages: ['geomap']});

    function drawVisualization() {
      var data = google.visualization.arrayToDataTable([
        ['Country', 'Popularity'],
        <c:forEach var="it" items="${requestScope.wish_list}">
        ['${it.name}', ${it.been}],
       </c:forEach>
       
      ]);
    
      var geomap = new google.visualization.GeoMap(
          document.getElementById('visualization'));
      geomap.draw(data, {width: 760, height: 450});
    }
    

    google.setOnLoadCallback(drawVisualization);
  </script>
  
 <script type='text/javascript'>
   google.load('visualization', '1', {packages: ['geomap']});

    
    
	function drawA() {
      var data = google.visualization.arrayToDataTable([
        ['Country', 'Popularity'],
        <c:forEach var="it" items="${requestScope.wish_list }">
        ['${it.name}', ${it.wished}],
       </c:forEach>
        
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
 

</head>
<body>
	<jsp:include page="nav.jsp" />


<div id="container" style="margin-top:60px; height:1400px;">


<div class = "ez_map_left" style="float:left; width:780px;">
	<h3>${wish_title}</h3>
			<div class="img-thumbnail"  id="visualization"></div>

	<h3>${been_title} </h3>
			<div class="img-thumbnail"  id="visualization1"></div>
	<h3>${requestScope.top_search_title }</h3>
	<div class="img-thumbnail"  id="visualization2" style=" margin-top:10px; margin-right:20px; width: 760px;"></div>
	
</div>
<div class="ez_map_right" style="float:right; width:300px;">
	<h3>Top 5 Viewed Photos</h3>
	<c:forEach var="plist" items="${requestScope.topViewPhoto }">
	<div style="margin-bottom:5px;">
		<a href="getdetail.do?photo_id=${plist.photo.id}"><img class="img-thumbnail" src="${plist.photo.imgUrl}" width="280"></a>
	</div>
	</c:forEach>
</div>


</div>





	




	


</body>
</html>