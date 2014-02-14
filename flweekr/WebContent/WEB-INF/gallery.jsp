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
     <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/touchTouch.css">
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
    				offsetX: 8,
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
     
     <!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
         </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <link rel="stylesheet" media="screen" href="css/ie.css">

    <![endif]-->
     </head>
     <body  class="">
<!--==============================header=================================-->
 <header> 
  <div class="container_12">
    <div class="grid_12"> 
    <h1><a href="index.html"><img src="images/logo.png" alt="Gerald Harris attorney at law"></a> </h1>
          
         
           <div class="clear"></div>
      </div>
<div class="menu_block">
			
			
			<jsp:include page="nav.jsp" />
			
			
           <div class="clear"></div>
           </div>
           <div class="clear"></div>
          </div>
</header>

<div class="main">
<!--=======content================================-->

<div class="content">
  <div class="container_12">
      <div class="grid_12">
        <h3>Our Gallery</h3>
      </div>
      <div class="clear"></div>
       <div class="gallery">
       
       <section id="wrapper">
       <div id="container">
       <c:forEach var="plist" items="${requestScope.flk_plist}">
	      
	<div class="grid">
		<div class="imgholder">
			<img src="${plist.imgUrl}" />
		</div>
		<strong>${plist.title}</strong>
		<p>A peaceful sunset view...</p>
		<div class="meta">by j osborn</div>
	</div>
	      
	   </c:forEach>
	   </div>
	   </section>
	   
    </div>
      <div class="clear"></div>
  </div>
</div>

<!--=======bottom================================-->
<div class="bottom_block">
  <div class="container_12">
    <div class="grid_2 prefix_2">
      <ul>
        <li><a href="#">FAQS Page</a></li>
        <li><a href="#">People Say</a></li>
      </ul>
    </div>
    <div class="grid_2">
      <ul>
        <li><a href="#">Useful links</a></li>
        <li><a href="#">Partners</a></li>
      </ul>
    </div>
    <div class="grid_2">
      <ul>
        <li><a href="#">Insurance</a></li>
        <li><a href="#">Family Travel</a></li>
      </ul>
    </div>
    <div class="grid_2">
      <h4>Contact Us:</h4>
      TEL: 1-800-234-5678<br><a href="#">info@demolink.org</a>
     
    </div>
    <div class="clear"></div>
    </div>
  </div>
<!--==============================footer=================================-->

</div>
<footer>    
  <div class="container_12">
  <div class="grid_12">
    <div class="socials">
      <a href="#"></a>
      <a href="#"></a>
      <a href="#"></a>
      <a href="#"></a>
    </div>
      <div class="copy">
     Journey &copy; 2013 | <a href="#">Privacy Policy
     </div></div>
     <div class="clear"></div>
  </div>

</footer>

</body>
</html>