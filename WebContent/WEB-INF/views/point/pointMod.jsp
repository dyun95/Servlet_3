<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import> 
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

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