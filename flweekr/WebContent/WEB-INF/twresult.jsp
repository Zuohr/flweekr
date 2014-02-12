<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Insert title here</title>
</head>
<body>
	<p><a href="logout.do">Sign out</a>
	<p>${requestScope.result}</p>
	<p>welcome to flweekr, ${sessionScope.user.name} @ ${sessionScope.user.screen_name }!</p>
	<form action="send_tweet.do" action="post">
		<input type="text" name="text" placeholder="your tweet">
		<input type="submit" name="send_btn" value="send_tweet">
	</form>
	<form action="search_tweet.do" action="post">
		<input type="text" name="keyword" placeholder="your search">
		<input type="submit" name="search_btn" value="search_tweet">
	</form>
</body>
</html>