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
<h1>notice add</h1>
  <form action="./noticeAdd" method="post">
    <div class="form-group">
      <label for="No">NO:</label>
      <input type="text" class="form-control" id="no" readonly="readonly" placeholder="Enter no" name="no">
    </div>
    <div class="form-group">
      <label for="Subject">제목:</label>
      <input type="text" class="form-control" id="subject" placeholder="Enter 제목" name="subject">
    </div>
    
    <div class="form-group">
      <label for="Content">내용:</label>
      <input type="text" class="form-control" id="content" placeholder="Enter content" name="content">
    </div>
    <div class="form-group">
      <label for="Id">id:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    <div class="form-group">
      <label for="Date">date:</label>
      <input type="text" class="form-control" id="ndate" readonly="readonly" placeholder="Enter date" name="ndate">
    </div>
       <div class="form-group">
      <label for="Hit">hit:</label>
      <input type="text" class="form-control" id="hit" placeholder="Enter hit" name="hit">
    </div>
      
    
    <!-- form 태그가 실행할려변 타입이 submit 이어야 가능 -->
	<button type="submit" class="btn btn-default">Submit</button>
	
	

  </form>





</body>
</html>