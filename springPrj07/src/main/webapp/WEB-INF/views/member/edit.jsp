<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원정보수정</h1>
	
	<form action="/app/member/edit">
		<input type="text" name="id" disabled="disabled" style="cursor: none;">
		<br>
		<input type="password" name="pwd">
		<br>
		<input type="text" name="nick">
		<br>
		<input type="submit" value="수정하기">
	</form>
	
</body>
</html>