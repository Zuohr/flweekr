<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Google Visualization API Sample</title>
<script type="text/javascript" src="//www.google.com/jsapi"></script>
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
				.getElementById('visualization')).draw(data, options);
	}

	google.setOnLoadCallback(drawVisualization);
</script>
</head>


<body style="font-family: Arial; border: 0 none;">
	<div id="visualization" style="width: 600px; height: 400px;"></div>
</body>

</html>