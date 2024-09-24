<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<c:out value = "hello"> </c:out>
	<c:out value = "value"> hey </c:out>
	
	<hr/>
	
	<h3> c:set </h3>
	<c:set var = "name" value="zee"/> ${name } <br>
	<c:set var = "name2"> zee2 </c:set> ${name2 } <br>
	
	<c:set var = "person" value = "<%=new com.ssafy.dto.Person() %>" />
	<c:set target = "${person }" property ="name" value="zee3" />
	${person }
</body>
</html>