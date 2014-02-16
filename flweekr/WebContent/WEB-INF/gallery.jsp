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
			/*
			 *  Simple image gallery. Uses default settings
			 */

			$('.fancybox').fancybox();

			/*
			 *  Different effects
			 */

			// Change title type, overlay closing speed
			$(".fancybox-effects-a").fancybox({
				helpers: {
					title : {
						type : 'outside'
					},
					overlay : {
						speedOut : 0
					}
				}
			});

			// Disable opening and closing animations, change title type
			$(".fancybox-effects-b").fancybox({
				openEffect  : 'none',
				closeEffect	: 'none',

				helpers : {
					title : {
						type : 'over'
					}
				}
			});

			// Set custom style, close if clicked, change title type and overlay color
			$(".fancybox-effects-c").fancybox({
				wrapCSS    : 'fancybox-custom',
				closeClick : true,

				openEffect : 'none',

				helpers : {
					title : {
						type : 'inside'
					},
					overlay : {
						css : {
							'background' : 'rgba(238,238,238,0.85)'
						}
					}
				}
			});

			// Remove padding, set opening and closing animations, close if clicked and disable overlay
			$(".fancybox-effects-d").fancybox({
				padding: 0,

				openEffect : 'elastic',
				openSpeed  : 150,

				closeEffect : 'elastic',
				closeSpeed  : 150,

				closeClick : true,

				helpers : {
					overlay : null
				}
			});

			/*
			 *  Button helper. Disable animations, hide close button, change title type and content
			 */

			$('.fancybox-buttons').fancybox({
				openEffect  : 'none',
				closeEffect : 'none',

				prevEffect : 'none',
				nextEffect : 'none',

				closeBtn  : false,

				helpers : {
					title : {
						type : 'inside'
					},
					buttons	: {}
				},

				afterLoad : function() {
					this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
				}
			});


			/*
			 *  Thumbnail helper. Disable animations, hide close button, arrows and slide to next gallery item if clicked
			 */

			$('.fancybox-thumbs').fancybox({
				prevEffect : 'none',
				nextEffect : 'none',

				closeBtn  : false,
				arrows    : false,
				nextClick : true,

				helpers : {
					thumbs : {
						width  : 50,
						height : 50
					}
				}
			});

			/*
			 *  Media helper. Group items, disable animations, hide arrows, enable media and button helpers.
			*/
			$('.fancybox-media')
				.attr('rel', 'media-gallery')
				.fancybox({
					openEffect : 'none',
					closeEffect : 'none',
					prevEffect : 'none',
					nextEffect : 'none',

					arrows : false,
					helpers : {
						media : {},
						buttons : {}
					}
				});

			/*
			 *  Open manually
			 */

			$("#fancybox-manual-a").click(function() {
				$.fancybox.open('1_b.jpg');
			});

			$("#fancybox-manual-b").click(function() {
				$.fancybox.open({
					href : 'getplace.do',
					type : 'iframe',
					padding : 0
				});
			});

			$("#fancybox-manual-c").click(function() {
				$.fancybox.open([
					{
						href : '1_b.jpg',
						title : 'My title'
					}, {
						href : '2_b.jpg',
						title : '2nd title'
					}, {
						href : '3_b.jpg'
					}
				], {
					helpers : {
						thumbs : {
							width: 75,
							height: 50
						}
					}
				});
			});


		});
     
     
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
<jsp:include page="nav.jsp" />

       <section id="wrapper">
       <div id="container">
       <c:forEach var="plist" items="${requestScope.flk_plist}">
	      
			<div class="grid">
				<div class="imgholder">
					
					<a class="fancybox" title="${plist.title}" href="${plist.imgUrl}"><img src="${plist.imgUrl}" /></a>
				</div>
				<strong></strong>
				<form id="${plist.id}" action="" method="post">
				<p><a href="getdetail.do?photo_id=${plist.id}" onclick="document.getElementById('form1').submit();" style="color:#000; font-weight:bold; font-size:14px">${plist.title}</a></p>
				<input type="hidden" name="imgUrl_b" value="${plist.imgUrl}_b">
				</form>
				<button type="button" class="btn btn-primary btn-xs" >Explore</button>
				<a href="https://twitter.com/share" class="twitter-share-button" data-dnt="true" data-count="none" data-via="twitterapi">Tweet</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
				
			</div>
	   </c:forEach>
	   </div>
	   </section>
 
</body>
</html>