<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="en">
<head>
     <title>Travel</title>
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
</head> 

<body>
<jsp:include page="nav.jsp" />

<div class="container">	
	<div class="ez_left" style="float:left;position: absolute;
		display: inline-block; ">
		<jsp:include page="hotel.jsp" />
	
	</div>
	
	<div class="ez_right" style="float:left; margin-top:70px;display: inline-block;margin-left:810px;">		
		
<ul class="list-group" >
  <li class="list-group-item" style="width:290px;">
    <span class="badge" style="width:50px;">$40</span>
    1
  </li>
  
   <li class="list-group-item" style="width:290px;margin-right:35px;">
    <span class="badge" style="width:50px;">$40</span>
    2
  </li>
  
   <li class="list-group-item" style="width:290px;margin-right:35px;">
    <span class="badge" style="width:50px;">$40</span>
    3
  </li>
  
   <li class="list-group-item" style="width:290px;margin-right:35px;">
    <span class="badge" style="width:50px;">$40</span>
    4
  </li>
  
   <li class="list-group-item" style="width:290px;margin-right:35px;">
    <span class="badge" style="width:50px;">$40</span>
    5
  </li>
  
</ul>
 
 
 
 
 

</div>






</body>
</html>