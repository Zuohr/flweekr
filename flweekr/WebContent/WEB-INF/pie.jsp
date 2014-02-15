<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([

          
          ['Month', 'Times'],
          ['Janurary', 1232],
          ['Feburary', 2343],
          ['March', 5456],
          ['April', 3278],
          ['May',  3490],
          ['June', 6632],
          ['July', 743],
          ['August', 56],
          ['September', 78],
          ['October', 9090],
          ['November', 1990],
          ['December', 90]

        ]);

        var options = {
          title: 'Most Popular Visiting Month',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
  </body>
</html>