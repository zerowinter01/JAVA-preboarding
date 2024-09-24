<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬고르기</title>
</head>
<body>
	<h2>반찬을 골라보자</h2>
	<form action="10_checkBoxResult.jsp">
		<input type = "checkbox" name = "dish" value="피자">피자
		<input type = "checkbox" name = "dish" value="타코">타코
		<input type = "checkbox" name = "dish" value="치킨">치킨 <br>
		<input type = "checkbox" name = "dish" value="떡볶이">떡볶이
		<input type = "checkbox" name = "dish" value="햄버거">햄버거
		<input type = "checkbox" name = "dish" value="제육">제육
		<button> 구매 </button>
	</form>
</body>
</html>