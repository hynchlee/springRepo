<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<img alt="" src="/app/resources/img/7e82cd90ca1e5aef7eaaece990c64061.webp">

	<h1>회원가입</h1>
	
	<form action="/app/member/join" method="post">
		<input type="text" name="id">
		<br>
		<input type="password" name="pwd">
		<br>
		<input type="text" name="nick">
		<br>
		<input type="submit" value="제출하기">
	</form>

</body>
</html>