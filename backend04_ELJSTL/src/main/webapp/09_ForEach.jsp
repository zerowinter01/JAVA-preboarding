<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
	<%
		String[] dramaList = {"흑백요리사", "유어아너", "엄마친구아들", "굿파트너"};
		pageContext.setAttribute("dramalist", dramaList);
	%>
	
	<h3> c:forEach </h3>
	<ol>
		<c:forEach items="${dramalist }" var = "drama">
			<li>${drama }</li>
		</c:forEach>
	</ol>
	
	<hr/>
	
	<c:forEach items="${dramalist }" var = "drama" varStatus = "status">
		<li>${status.index } : ${drama }</li>
	</c:forEach>
	
</body>
</html>