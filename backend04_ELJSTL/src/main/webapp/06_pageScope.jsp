<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

<% 
	pageContext.setAttribute("name", "page yang");
	request.setAttribute("name", "request yang");
	session.setAttribute("name", "session yang");
	application.setAttribute("name", "application yang");

%>

	JSP 페이지 영역 접근 : <%= pageContext.getAttribute("name") %> <br/>
	EL(page) : ${pageScope.name } <br/>
	EL(request) : ${requestScope.name } <br/>	
	EL(session) : ${sessionScope.name } <br/>	
	EL(application) : ${applicationScope.name } <br/>	

	그냥 속성을 작성하게 되는 경우, 가장 안쪽부터 갖고 오게 된다. <br/>
	${name }<br/>
	
	쿠키 : ${cookie["JSESSOIONID"].value } <br/>

</body>
</html>