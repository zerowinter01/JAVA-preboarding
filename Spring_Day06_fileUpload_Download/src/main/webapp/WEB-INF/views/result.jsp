<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "/img/${fileName }">${fileName }</a><br/>
	<img src ="/img/${fileName }"><br/>
	<a href = "/download?fileName=${fileName }"> img download</a>
</body>
</html>