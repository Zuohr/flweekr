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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="js/blocksit.min.js"></script>

<link rel="stylesheet" href="css/jquery.fancybox.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="js/jquery.fancybox.pack.js"></script>

</head>
<body>
	<jsp:include page="nav.jsp" />

	<form id="flickr-form" action="">
		<h1>jQuery Flickr Explorer</h1>
		<p id="flickr-error">Type a term and press enter.</p>
		<input type="text" value="" id="flickr-term" /> <input
			id="flickr-submit" type="button" type="submit" value="Get Images" />
	</form>
	<div id="flickr-results"></div>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.sonar.js"></script>
	<script type="text/javascript">
		(function($) {

			var $flickrTerm = $("#flickr-term"), $flickrError = $("#flickr-error"), $flickrResults = $("#flickr-results");

			$("#flickr-form")
					.submit(
							function(evt) {

								evt.preventDefault();

								var term = '${requestScope.term}', encode = encodeURIComponent, getFlickrUrl = function(
										term, perPage, pageNum) {
									return "http://api.flickr.com/services/rest/?api_key=d256a8d55ded700d9af3e4f7921c4ca4&format=json&method=flickr.photos.search&per_page="
											+ perPage
											+ "&page="
											+ pageNum
											+ "&tags="
											+ encode(term)
											+ "&jsoncallback=?";
								}, currPage = 1, $flickrPhotos, allPhotos,

								getNextPage = function() {

									$
											.getJSON(
													getFlickrUrl(term, 15,
															currPage),
													function(json) {

														// Remove sonar event binding from this image.
														$(this).unbind(
																"scrollin");

														var photos = json.photos.photo, photosLength = photos.length, photo, i, photoHtml = [];

														//				photoHtml.push('<ul id="flickr-photos">');
														for (i = 0; i < 15; i++) {
															try {
																photo = photos[i];

																photoHtml
																		.push([ '<li><img src="http://',
						'farm', photo.farm,
						'.static.flickr.com/',
						photo.server, '/',
						photo.id, '_',
						photo.secret,
						'_m.jpg" /></li>' ]
																				.join(''));
															} catch (e) {
															}
															;
														}
														//				photoHtml.push('</ul>');

														photoHtml = photoHtml
																.join('');

														$flickrPhotos
																.append(photoHtml);

														// Bind sonar to the last photo in the downloaded collection.
														$(
																allPhotos[allPhotos.length - 1])
																.bind(
																		"scrollin",
																		{
																			distance : 200
																		},
																		getNextPage);

													});

									currPage++;
								};

								if (term) {
									$flickrResults.empty().append(
											'<ul id="flickr-photos"></ul>');
									$flickrPhotos = $("#flickr-photos");
									allPhotos = $flickrPhotos[0]
											.getElementsByTagName("img");
									getNextPage();
								} else {
									$flickrError
											.html("Please enter a keyword.");
								}

							});
		})(jQuery);
	</script>
</body>
</html>