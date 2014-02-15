<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
     <script src="js/blocksit.min.js"></script>
     
     <link rel="stylesheet" href="css/jquery.fancybox.css" type="text/css" media="screen" />
     <script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>

     <script>     
     
     $(document).ready(function() {
    		//vendor script
    		$('#header')
    		.css({ 'top':-50 })
    		.delay(1000)
    		.animate({'top': 0}, 800);
    		
    		$('#footer')
    		.css({ 'bottom':-15 })
    		.delay(1000)
    		.animate({'bottom': 0}, 800);
    		
    		//blocksit define
    		$(window).load( function() {
    			$('#container').BlocksIt({
    				numOfCol: 4,
    				offsetX: 1,
    				offsetY: 8
    			});
    		});
    		
    		//window resize
    		var currentWidth = 1100;
    		$(window).resize(function() {
    			var winWidth = $(window).width();
    			var conWidth;
    			if(winWidth < 660) {
    				conWidth = 440;
    				col = 2
    			} else if(winWidth < 880) {
    				conWidth = 660;
    				col = 3
    			} else if(winWidth < 1100) {
    				conWidth = 880;
    				col = 4;
    			} else {
    				conWidth = 1100;
    				col = 5;
    			}
    			
    			if(conWidth != currentWidth) {
    				currentWidth = conWidth;
    				$('#container').width(conWidth);
    				$('#container').BlocksIt({
    					numOfCol: col,
    					offsetX: 8,
    					offsetY: 8
    				});
    			}
    		});
    	});
     </script>
     </head>
<body>

<!--navgation -->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header" style="margin-left:26px;">
          <a class="navbar-brand" href="home.do" style="font-family:arial; font-size:24px; color:#fff;">EasyTrip</a>
        </div>
        <div class="navbar-collapse collapse">
        
         <ul class="nav navbar-nav">
         <li ><a href="home.do">Home</a></li>
            <li class="active"><a href="#">Gallery</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
          
            <div class="input-group" style="margin-top:8px; margin-right:40px; width:300px; float:right;">
              <input type="text" class="form-control">
              <span class="input-group-btn">
                <button class="btn btn-default" type="button">search</button>
              </span>
            </div><!-- /input-group -->
              
        </div><!--/.nav-collapse -->
      </div>
    </div>

       <section id="wrapper">
       <div id="container">
       <c:forEach var="plist" items="${requestScope.flk_plist}">
	      
			<div class="grid">
				<div class="imgholder">
					<a class="fancybox" href="getdetail.do"><img src="${plist.imgUrl}" /></a>
				</div>
				<strong></strong>
				<p style="font-weight:bold; font-size:14px;">${plist.title}</p>
			</div>
	   </c:forEach>
	   </div>
	   </section>
 
</body>
</html>