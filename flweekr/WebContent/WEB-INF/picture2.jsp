<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="en">
		 <head>
		 <title>Home</title>
		 <meta charset="utf-8">
		 <link rel="icon" href="images/favicon.ico">
		 <link rel="shortcut icon" href="images/favicon.ico" />
		 <link rel="stylesheet" href="css/style.css">
		 <link rel="stylesheet" href="css/slider2.css">
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
		 <body	class="page1" >
<!--==============================header=================================-->
 <header> 
	<div class="container_12">
		<div class="grid_12"> 
		<h1><a href="index.html"><img src="images/logo.png" alt="Gerald Harris attorney at law"></a> </h1>
					
				 
		  <div class="clear"></div>
			</div>
<div class="menu_block">
					 <nav	class="" >
						<ul class="sf-menu">
									 <li class="current"><a href="index.html">Home</a></li>
									 <li class="with_ul"><a href="index-1.html">About</a>
										 <ul>
												<li><a href="#"> Agency</a></li>
												<li><a href="#">News</a></li>
												<li><a href="#">Team</a></li>
										 </ul>
									 </li>
									 <li><a href="index-2.html">Gallery</a></li>
									 <li><a href="index-3.html">Tours</a></li>
									 <li><a href="index-4.html">Blog</a></li>
									 <li><a href="index-5.html">Contacts</a></li>
								 </ul>
							</nav>
					 <div class="clear"></div>
					 </div>
					 <div class="clear"></div>
					</div>
</header>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >Website Template</a></div>

<div class="main">

	
<!--=======content================================-->

<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - August 05, 2013!</div>
  <div class="container_12">
      <div class="grid_9">
        <div class="">
          <h3>Agency Profile</h3>
          <img src="images/page2_img1.jpg" alt="" class="img_inner fleft">
          <p class="text1"><a href="#">Gellentesque imperdiet gerti loki holewvelit neque. Ut vestibulum mi sit amet ornare. </a></p>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse jew wligulawe dolor, condimentum ac justo sed, tincidunt commodo molity wer massarete. Nulla non urnatr nisi. Donec varius lectus in vestibulum auctor. Spendisse magna veliternowe dignissim eu commodo ut vestibulum nectro quam. Pellentesque imperdiet velit neque. Ut vestibulum mi sit ametwertilo ornare consectetur. Quisque sed quamhy loi justo. Nulla congue sed turpis nec lacinia. Nulla facilisi. Ut sit amet gravidatylo wtellus. Morbi id wer nolit consequat eros. </p>
          <p>Vivamus imperdiet ante vitae lorem varius tristique meli. Phasellus tristique lectus id volutpat condimentum. Mauris quam lectus cursus at congue nec ultrices luctus orci quam lectus cursus at congue.</p>
          <div class="clear"></div>
          Duis ac iaculis odio, sed tristique arcu. Cras consequat semper augue. Praesent ut facilisis nisi. Pellentesque consequat felis leorew qwertil condimentumo placerat eros mollis vitae. Interdum et malesuada fames ac ante ipsum primis in faucibus. Praesent iaculis nisl mattis facilisis enim vitae dictumi magna. Pellentesque laoreet purus congue justo laoreet, blandit tempor leo molestie. Vivamus orci sem molestie actre pharetra non scelerisque sit amet orci. Nulla consequat neque pretium sagittis vulputate. Fusce dictum velit at diam facilisis consectetur. 
        </div>
      </div>
      
      
      <!----------->
      <div class="grid_3">
        <h3>Twitter</h3>
      <p>
		<a href="logout.do">Sign out</a>
	<p>${requestScope.result}</p>
	 ${sessionScope.user.name} @
		${sessionScope.user.screen_name }!</p>
	<c:forEach var="tweet" items="${requestScope.oembeds_list }">
		${tweet.html }
	</c:forEach>
	<form action="send_tweet.do" action="post">
		<input type="text" name="text" placeholder="your tweet"> <input
			type="submit" name="send_btn" value="send_tweet">
	</form>
	<form action="search_tweet.do" action="post">
		<input type="text" name="keyword" placeholder="your search"> <input
			type="submit" name="search_btn" value="search_tweet">
	</form>
	<form action="search_tweet.do" action="post">
		<input type="text" name="keyword" placeholder="your search"> <input
			type="submit" name="searchloc_btn" value="searchloc_tweet">
	</form>
	<script>
		!function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
					.test(d.location) ? 'http' : 'https';
			if (!d.getElementById(id)) {
				js = d.createElement(s);
				js.id = id;
				js.src = p + "://platform.twitter.com/widgets.js";
				fjs.parentNode.insertBefore(js, fjs);
			}
		}(document, "script", "twitter-wjs");
	</script>
      </div>
      <div class="clear"></div>
      <div class="grid_12">
        <div class="hor_sep"></div>
      </div>
      <div class="clear"></div>
      <div class="grid_9">
        <h3 class="head1">What We Offer</h3>
        <p class="text1 tx2">Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque vehicula eu nislew teget convallis. Vivamus sit amet fringilla nibh, et fringilla elit. Ut in lacus in nulla varius pulvinar. Donec eu magna pretiu yue facilisis sem a, rutrum magna.  Fet fringilla elit. Ut in lacus in nulla varius pulvinar.</p>
        <p>Sed dignissim est mauris. Praesent pulvinar vestibulum lorem tristique faucibus. Quisque at tincidunt sapien. Fusce scelerisque dolor nec justo tempus, sed cursus nisl interdum. Vivamus justo mi, semper non semper nec, commodo et ipsum. Integer a porta erat. Pellentesque eu egestas purus, vitae feugiat augue. Sed lobortis tristique convallis. Mauris in diam tempor, imperdiet massa ut, euismod risus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc sollicitudin pretium eros ac semper. Aenean nec bibendum mauris, eget luctus velit. Sed sodales lectus imperdiet neque pretium ultrices. Nulla nec urna nec erat elementum tempor.</p>
        <ul class="list2">
          <li><a href="#">Fgo psu dr sit amek </a></li>
          <li><a href="#">Sem psum dr sit ametre conse</a></li>
          <li><a href="#">Rame sum dr sit ame consec</a></li>
          <li><a href="#">Bem psum dr sit ameteko </a></li>
          <li><a href="#">Nem dsum dr sit amewas </a></li>
        </ul>
        <ul class="list2">
          <li><a href="#">Vcem psum dr sit </a></li>
          <li><a href="#">Zdfem psum dr sittr amewe </a></li>
          <li><a href="#">Game sum dr sit ame conse</a></li>
          <li><a href="#">Dem psum dr sit ametekot </a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <div class="grid_3">
        <h3 class="head1">testimonial</h3>
        <blockquote>
          <p class="text1"> " Nnatoque penatibus tkamet magnis dis parturient montes, nascetur ridiculus mustro lito. Quisque vehicula eu nisleweri teget convallis. Vivamus sit amet fringilla nibt fringilla. "</p>
          <div class="bq_bot">
            <div class="text1">Mark Johnson</div>Director of Product Management
          </div>
        </blockquote>
      </div>
      <div class="clear"></div>
  </div>
</div>

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
		 <div class="clear"></div>
	</div>

</footer>

</body>
</html>