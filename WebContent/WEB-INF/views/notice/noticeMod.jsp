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
<h1>notice mod</h1>
<!--  form action ./pointAdd 해서 컨트롤러에서 받아옴  서브밋 버튼클릭하면 -->
  <form action="./noticeMod" method="post">
    <div class="form-group">
      <label for="No">NO:</label>
      <input type="text" value="${dto.no}" class="form-control" id="no" readonly="readonly" placeholder="Enter no" name="no">
      
    </div>
    <div class="form-group">
      <label for="Subject">제목:</label>
      <input type="text" value="${dto.subject}" class="form-control" id="subject" placeholder="Enter 제목" name="subject">
    </div>
    
    <div class="form-group">
      <label for="Content">내용:</label>
      <input type="text" value="${dto.content}" class="form-control" id="content" placeholder="Enter content" name="content">
    </div>
     <div class="form-group">
      <label for="Id">id:</label>
      <input type="text" class="form-control" id="id" readonly="readonly" value="${member.id}" name="id">
    </div>
    
    <!-- form 태그가 실행할려변 타입이 submit 이어야 가능 -->
	<button type="submit" class="btn btn-default">Submit</button>
	
	





</body>
</html>