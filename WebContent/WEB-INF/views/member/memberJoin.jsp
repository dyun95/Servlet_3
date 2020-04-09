<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버조인JSP</title>
<!--BootStrap API  -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <!-- BootStrap API -->
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${ pageContext.request.contextPath }">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="${ pageContext.request.contextPath }/point/pointList">Point</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <c:if test="${empty member}">		<!-- memberdto가 널이면    -->
      <li><a href="${ pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${ pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </c:if>
    
    <c:if test="${not empty member}">		<!--memberdto가 널이 아니면  -->
      <li><a href="${ pageContext.request.contextPath}/member/memberPage"><span class="glyphicon glyphicon-user"></span>MyPage</a></li>
      <li><a href="${ pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </c:if>
    </ul>
  </div>
</nav>
<!--nav  -->
<div class="container">
  <div class="jumbotron">
    <h1>Bootstrap Tutorial</h1>      
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
  </div>
  <p>This is some text.</p>      
  <p>This is another text.</p>      
</div>
<h1>point Add form</h1>
	<div class="container">
  <h2>Point Input</h2>
  <form action="./memberJoin" method="post">
    <div class="form-group">
      <label for="Id">Id:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
    </div>
    <div class="form-group">
      <label for="Pw">Pw:</label>
      <input type="text" class="form-control" id="pw" placeholder="Enter Pw" name="pw">
    </div>
    
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    <div class="form-group">
      <label for="Email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
    </div>
    <div class="form-group">
      <label for="Phone">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
    </div>
    <div class="form-group">
      <label for="Age">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Enter age" name="age">
    </div>
    
    
    <!-- form 태그가 실행할려변 타입이 submit 이어야 가능 -->
	<button type="submit" class="btn btn-default">Submit</button>
	

  </form>


</body>
</html>