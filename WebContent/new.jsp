<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<!-- 0 부터 10포함까지 변수 i  step "1"씩증가 (안쓰면 자동1)  -->
		<c:forEach begin="0" end="10" var="i" step="1">
			<h1>${i}</h1>
		
		</c:forEach>
	</body>
</html>