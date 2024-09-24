<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬고르기</title>
</head>
<body>
	<!-- 여러 개가 넘어오면 param이 아닌 paramValues가 된다. -->
	<c:forEach items = "${paramValues.dish }" var = "dish" varStatus="status">
		${dish } <c:if test = "${not status.last }"> , </c:if>
	</c:forEach>

</body>
</html>