<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	\ 는 해당 식은 EL이 아니라고 알려주는 것이다. <br/>
	\${5+2 } : ${5+2 }<br>
	
	\${5/2 } : ${5/2 }<br>
<!-- 	\${5 div 2} : ${5 div 2 }<br> -->
	
	\${5 < 2} : ${5 < 2 }<br>
	\${5 gt 2} : ${5 gt 2 }<br>

</body>
</html>