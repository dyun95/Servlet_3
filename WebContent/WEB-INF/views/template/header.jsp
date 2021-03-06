<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- html body 삭제해도 무방  -->
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
      <!--GET 방식 <a>태그   -->
      <!--POST 방식은 <form>태그에서 POST타입만  -->
      <li><a href="${ pageContext.request.contextPath }/point/pointList">Point</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
    <c:if test="${empty member}">		<!-- memberdto가 널이면    -->
      <li><a href="${ pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${ pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </c:if>
    
    <c:if test="${not empty member}">		<!--memberdto가 널이 아니면  -->
      <li><a href="${ pageContext.request.contextPath}/member/memberPage"><span class="glyphicon glyphicon-user"></span>MyPage</a></li>
      <li><a href="${ pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      <!--1. 로그아웃 요청하면  컨트롤러로 감  -->
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

