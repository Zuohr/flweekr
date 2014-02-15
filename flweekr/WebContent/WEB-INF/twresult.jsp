<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="logout.do">Sign out</a>
	<p>${requestScope.result}</p>
	<p>welcome to flweekr, ${sessionScope.user.name} @
		${sessionScope.user.screen_name }!</p>
	<c:forEach var="tweet" items="${requestScope.oembeds_list }">
		${tweet.html }
	</c:forEach>
	<p>${requestScope.status.html }</p>
	<form action="send_tweet.do" action="post">
		<input type="text" name="text" placeholder="your tweet"> <input
			type="submit" name="send_btn" value="send_tweet">
	</form>
	<form action="search_tweet.do" action="post">
		<input type="text" name="keyword" placeholder="your search"> <input
			type="submit" name="search_btn" value="search_tweet">
	</form>
	<form action="search_tweet_byloc.do" action="post">
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
</body>
</html>