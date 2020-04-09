<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--BootStrap API  -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <!-- BootStrap API -->
</head>
<body><nav class="navbar navbar-inverse">
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
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
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

	<div class="container">
  <h2>Point MOD</h2>
  <!--  form action ./pointAdd 해서 컨트롤러에서 받아옴  서브밋 버튼클릭하면 -->
  <form action="./pointMod" method="post">
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" value="${dto.name}" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    <div class="form-group">
      <label for="Num">Num:</label>
      <!--readonly 읽기전용  데이터 넘거가게 -->
      <input type="text" value="${dto.num }" readonly="readonly" class="form-control" id="num" placeholder="Enter Num" name="num">
    </div>
    
    <div class="form-group">
      <label for="Kor">Kor:</label>
      <input type="text" value="${dto.kor }" class="form-control" id="kor" placeholder="Enter Kor" name="kor">
    </div>
    <div class="form-group">
      <label for="Eng">Eng:</label>
      <input type="text" value="${dto.eng }" class="form-control" id="eng" placeholder="Enter Eng" name="eng">
    </div>
    <div class="form-group">
      <label for="Math">Math:</label>
      <input type="text" value="${dto.math }" class="form-control" id="math" placeholder="Enter Math" name="math">
    </div>
    
    <!-- form 태그가 실행할려변 타입이 submit 이어야 가능 -->
	<button type="submit" class="btn btn-default">Submit</button>
	
</body>
</html>