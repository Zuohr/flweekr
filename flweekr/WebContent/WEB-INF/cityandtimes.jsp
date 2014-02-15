<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {'packages':['motionchart']});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'City');
        data.addColumn('date', 'Date');
        data.addColumn('number', 'times');
       
        data.addRows([
                      
          ['NewYork', new Date (2013,1,1), 1089],
          ['NewYork', new Date (2013,4,1), 625],
          ['NewYork', new Date (2013,12,1), 1430],

          ['Boston', new Date (2013,1,1), 1889],
          ['Boston', new Date (2013,5,6), 45],
          ['Boston', new Date (2013,7,4), 8830],

          ['Orlando', new Date (2013,1,1), 1989],
          ['Orlando', new Date (2013,7,6), 695],
          ['Orlando', new Date (2013,8,4), 1550],
          
          ['Honolulu', new Date (2013,5,3), 5989],
          ['Honolulu', new Date (2013,8,5), 895],
          ['Honolulu', new Date (2013,11,8), 1880],

          ['Seattle', new Date (2013,6,7), 5989],
          ['Seattle', new Date (2013,2,21), 895],
          ['Seattle', new Date (2013,3,5), 1880],
          
          ['Los Angels', new Date (2013,4,14), 5989],
          ['Los Angels', new Date (2013,1,11), 895],
          ['Los Angels', new Date (2013,2,22), 1880],

        ]);
        var chart = new google.visualization.MotionChart(document.getElementById('chart_div'));
        chart.draw(data, {width: 600, height:300});
      }
    </script>
  </head>

  <body>
    <div id="chart_div" style="width: 600px; height: 300px;"></div>
  </body>
</html>