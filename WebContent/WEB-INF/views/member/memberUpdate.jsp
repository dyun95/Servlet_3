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
  <h2>member update</h2>
  <form action="./memberUpdate" method="post">
    <div class="form-group">
      <label for="Id">Id:</label>
      <input type="text" value="${member.id}" class="form-control" readonly="readonly" id="id" placeholder="Enter Id" name="id">
    </div>
    
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" value="${member.name }" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    <div class="form-group">
      <label for="Email">Email:</label>
      <input type="text" value="${member.email }" class="form-control" id="email" placeholder="Enter Email" name="email">
    </div>
    <div class="form-group">
      <label for="Phone">Phone:</label>
      <input type="text" value="${member.phone }" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
    </div>
    <div class="form-group">
      <label for="Age">Age:</label>
      <input type="text" value="${member.age }" class="form-control" id="age" placeholder="Enter age" name="age">
    </div>
<button type="submit" class="btn btn-default">Submit</button>
</body>
</html>