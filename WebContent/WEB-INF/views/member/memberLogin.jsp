<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BootStrap API -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- BootStrap API -->
</head>
<body>
	<!-- Nav -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a
					href="${pageContext.request.contextPath}/point/pointList">Point</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty member}">		<!-- memberdto가 널이면    -->
      <li><a href="${ pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${ pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </c:if>
    
    <c:if test="${not empty member}">		<!--memberdto가 널이 아니면  -->
      <li><a href="${ pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span>MyPage</a></li>
      <li><a href="${ pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </c:if>
			</ul>
		</div>
	</nav>
	<!-- Nav -->

	<div class="container">
		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<form class="form-horizontal" action="./memberLogin" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="id">ID:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="pw">Password:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="pw" placeholder="Enter Password" name="pw">
					</div>
				</div>
				
						
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label><input type="checkbox" name="remember">Remember me</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>

		</div>
	</div>







</body>
</html>