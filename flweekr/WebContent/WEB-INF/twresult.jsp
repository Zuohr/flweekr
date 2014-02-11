<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Insert title here</title>
</head>
<body>
	<p><a href="logout.tw">Sign out</a>
	<p>${requestScope.result}</p>
	<p>welcome to flweekr, ${sessionScope.user.name} @ ${sessionScope.user.screen_name }!</p>
	<form action="send_tweet.tw" action="post">
		<input type="text" name="text" placeholder="your tweet">
		<input type="submit" name="send_btn" value="send_tweet">
	</form>
</body>
</html>