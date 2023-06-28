<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>갤러리 작성</h1>
	
	<form action="/app/gallery/write" method="post" enctype="multipart/form-data">
		<input type="text" name="title">
		<br>
		<input type="file" name="fList" multiple accept=".jpg, .png, .jpeg">
		<br>
		<input type="submit" value="제출">
	</form>

</body>
</html>