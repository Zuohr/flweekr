<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
     <head>
     <title>Tours</title>
     <meta charset="utf-8">
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
     
      <script src="js/jquery.js"></script>
		 <script src="js/jquery-migrate-1.1.1.js"></script>
		 <script src="js/superfish.js"></script>
		 <script src="js/sForm.js"></script>
		 <script src="js/jquery.jqtransform.js"></script>
		 <script src="js/jquery.equalheights.js"></script>
		 <script src="js/jquery.easing.1.3.js"></script>
		 <script src="js/tms-0.4.1.js"></script>
		<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
		 <script src="js/jquery.ui.totop.js"></script>
     
     
     <script>
			$(window).load(function(){
			$('.slider')._TMS({
							show:0,
							pauseOnHover:false,
							prevBu:'.prev',
							nextBu:'.next',
							playBu:false,
							duration:800,
							preset:'random', 
							pagination:false,//'.pagination',true,'<ul></ul>'
							pagNums:false,
							slideshow:8000,
							numStatus:false,
							banners:true,
					waitBannerAnimation:false,
				progressBar:false
			})	;
			 $( "#tabs" ).tabs();
		 
		$().UItoTop({ easingType: 'easeOutQuart' });
			});
			
			
			
		 </script>
     <script>
     $(window).load(function(){
       $().UItoTop({ easingType: 'easeOutQuart' });
      });
      
      $(function() {
    //find all form with class jqtransform and apply the plugin
    $(".form1").jqTransform();
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
    <h1><a href=hotmap.jsp"><img src="images/logo.png" alt="Gerald Harris attorney at law"></a> </h1>
          
         
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



<form class="search" action="setmap.do" method="post" style="text-align:center;;padding:50px 50px 0px;margin-top:60px;">
			<input type="text" placeholder="Search City"  style="height:30px; border-radius: 10px 10px 10px 10px; width:500px;font-family:Cursive;font-size:20px ">
			<input type="submit" name="submit_btn" value="submit"  style="height:40px; border-radius: 10px 10px 10px 10px;width:100px;font-family:Cursive;font-size:20px"  >
		
				</form>
<div style="height:auto;margin:60px;display:block;border: 2px solid rgb(0, 100, 255);">


<jsp:include page="map.jsp" />


</div>
</div>

<!--=======new================================-->

<div class="container_12">
		<div class="grid_12">
			<h3>Let's go trip!</h3>
		</div>
		
				<div class="grid_8">
					 <div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
	<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
		<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-1" aria-labelledby="ui-id-1" aria-selected="false"><a href="#tabs-1" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">Top Trips</a></li>
		<li class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-2" aria-labelledby="ui-id-2" aria-selected="true"><a href="#tabs-2" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">Flights</a></li>
		<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-3" aria-labelledby="ui-id-3" aria-selected="false"><a href="#tabs-3" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">Hotels</a></li>
	</ul>
	<div class="clear"></div>
	<div class="tab_cont ui-tabs-panel ui-widget-content ui-corner-bottom" id="tabs-1" aria-labelledby="ui-id-1" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
		<img src="images/page1_img4.jpg" alt="">
		<div class="extra_wrapper">
			<div class="text1">Flights </div>
			<p class="style1"><a class="col2" href="http://www.cssmoban.com/" rel="nofollow">Click here</a> for more info about this free website template created by TemplateMonster.com </p>
			
Nulla facilisi. Ut ut tincidunt lacus, ut auctor libero. Duis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisiestibulum eutro.
<a href="#" class="btn">Details</a>
<div class="clear "></div>

		</div>
		<div class="clear cl1"></div>
		<img src="images/page1_img5.jpg" alt="">
		<div class="extra_wrapper">
			<div class="text1 tx1">Hem psuf abr sit dmety. </div>
			Julla facilisi. Ut ut tincidunt lacus, ut auctor libero. Fuis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisi. Vestibulum eu eleifend metus, ut ornare nibh. Vestibulumul tincidunt interdum libero vitae faucibus. Gonec dapibus feugiate auctor. In ac dapibus lacus. Maecenas in pharetra mim asellus a sagittis dui, eu adipiscinget nisi. 
			<div class="clear"></div>
			<a href="#" class="btn bt1">Details</a>
			<div class="clear "></div>

		</div>		
	</div>
	<div class="tab_cont ui-tabs-panel ui-widget-content ui-corner-bottom" id="tabs-2" aria-labelledby="ui-id-2" role="tabpanel" aria-expanded="true" aria-hidden="false" style="display: block;">
<img src="images/page1_img4.jpg" alt="">
		<div class="extra_wrapper">
			<div class="text1">Hotels </div>
			<p class="style1">Nulla facilisi. Ut ut tincidunt lacus, ut auctor libero. Duis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisiestibulum eutro.</p>
			
Nulla facilisi. Ut ut tincidunt lacus, ut auctor libero. Duis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisiestibulum eutro.
<a href="#" class="btn">Details</a>
<div class="clear "></div>

		</div>
		<div class="clear cl1"></div>
		<img src="images/page1_img5.jpg" alt="">
		<div class="extra_wrapper">
			<div class="text1 tx1">Hem psuf abr sit dmety. </div>
			Julla facilisi. Ut ut tincidunt lacus, ut auctor libero. Fuis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisi. Vestibulum eu eleifend metus, ut ornare nibh. Vestibulumul tincidunt interdum libero vitae faucibus. Gonec dapibus feugiate auctor. In ac dapibus lacus. Maecenas in pharetra mim asellus a sagittis dui, eu adipiscinget nisi. 
			<div class="clear"></div>
			<a href="#" class="btn bt1">Details</a>
			<div class="clear "></div>

		</div>
	</div>
 <div class="tab_cont ui-tabs-panel ui-widget-content ui-corner-bottom" id="tabs-3" aria-labelledby="ui-id-3" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
 
<img src="images/page1_img4.jpg" alt="">
		<div class="extra_wrapper">
			<div class="text1">Top Trips</div>
			<p class="style1">Nulla facilisi. Ut ut tincidunt lacus, ut auctor libero. Duis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisiestibulum eutro.</p>
			
Nulla facilisi. Ut ut tincidunt lacus, ut auctor libero. Duis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisiestibulum eutro.
<a href="#" class="btn">Details</a>
<div class="clear "></div>

		</div>
		<div class="clear cl1"></div>
		<img src="images/page1_img5.jpg" alt="">
		<div class="extra_wrapper">
			<div class="text1 tx1">Hem psuf abr sit dmety. </div>
			Julla facilisi. Ut ut tincidunt lacus, ut auctor libero. Fuis ommodo vel ipsum sed volutpat. Phasellus a sagittis dui, eu adipiscinget nisi. Vestibulum eu eleifend metus, ut ornare nibh. Vestibulumul tincidunt interdum libero vitae faucibus. Gonec dapibus feugiate auctor. In ac dapibus lacus. Maecenas in pharetra mim asellus a sagittis dui, eu adipiscinget nisi. 
			<div class="clear"></div>
			<a href="#" class="btn bt1">Details</a>
			<div class="clear "></div>

		</div>	
		
	</div>
</div>
		</div>
	
	<div class="grid_4">
	 <div class="newsletter_title">NewsLetter </div>
	 <div class="n_container">
			 <form id="newsletter">
									<div class="success" style="display: none;">Your subscribe request has been sent!</div>
									<div class="text1">Sign up to receive our newsletters </div>
									<label class="email">
											 <input type="email" value="email address">
												<span class="error">*This is not a valid email address.</span>
									</label> 
									<div class="clear"></div> <a href="#" class="" data-type="submit"></a> 
							</form> 
							<ul class="list">
								<li><a href="#">Fgo psu dr sit amek </a></li>
								<li><a href="#">Sem psum dr sit ametre </a></li>
								<li><a href="#">Rame sum dr sit ame </a></li>
								<li><a href="#">Bem psum dr sit ameteko </a></li>
								<li><a href="#">Nem dsum dr sit amewas </a></li>
								<li><a href="#">Vcem psum dr sit </a></li>
								<li><a href="#">Zdfem psum dr sittr amewe </a></li>
							</ul>
			</div>
	</div>
	
	<div class="clear"></div></div>
	<div class="clear" style="height:40px;"></div>



<!--=======new================================-->


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
     Journey &copy; 2013 | <a href="#">Privacy Policy</a>
     </div></div>
     <div class="clear"></div>
  </div>

</footer>

</body>
</html>