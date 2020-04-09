<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--BootStrap API  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- BootStrap API -->
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${ pageContext.request.contextPath }">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a
					href="${ pageContext.request.contextPath }/point/pointList">Point</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty member}">
					<!-- memberdto가 널이면    -->
					<li><a
						href="${ pageContext.request.contextPath}/member/memberJoin"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a
						href="${ pageContext.request.contextPath}/member/memberLogin"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>

				<c:if test="${not empty member}">
					<!--memberdto가 널이 아니면  -->
					<li><a
						href="${ pageContext.request.contextPath}/member/memberPage"><span
							class="glyphicon glyphicon-user"></span>MyPage</a></li>
					<li><a
						href="${ pageContext.request.contextPath}/member/memberLogin"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
	<!--nav  -->
	<div class="container">
		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<p>This is some text.</p>
		<p>This is another text.</p>
	</div>

	<div class="container">
		<div class="row">
			<h1>point List page</h1>
			<!--여기서 받아올려고 한다. EL활용 jstl.jar lib에복사     맨위에다가  링크올리기 -->
			<table class="table table-hover">
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>평균</td>
				</tr>
				<!--   리퀘스트생략가능  키값           변수명-->
				<c:forEach items="${requestScope.list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="./pointSelect?num=${dto.num}">${dto.name}</a></td>
						<td>${dto.avg}</td>
					</tr>
				</c:forEach>

			</table>

			<a href="./pointAdd" class="btn btn-primary">Point Add</a>

		</div>
	</div>




</body>
</html>