<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_upload.jsp</title>
</head>
<body>
<!-- form 에서 파일을 업로드하려면 method 는 반드시 post 이어야 하며, enctype="multipart/form-data" 가
	반드시 포함되어야 합니다. -->
<form action="upload.do" method="post" enctype="multipart/form-data">
	글쓴이 : <input type="text" name="name"><br>
	제 &nbsp; 목 : <input type="text" name="title"><br>
	파일 : <input type="file" name="uploadFile"><br>
	<input type="submit" value="전송">
</form>

</body>
</html>