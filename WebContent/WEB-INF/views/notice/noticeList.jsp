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


<h1>notice List page</h1>
			<!--여기서 받아올려고 한다. EL활용 jstl.jar lib에복사     맨위에다가  링크올리기 -->
			<table class="table table-hover">
				<tr>
					<td>no</td>
					<td>subject</td>
					<td>id</td>
					<td>date</td>
					<td>hit</td>
					
				</tr>
				<!--   리퀘스트생략가능  키값           변수명-->
				<c:forEach items="${requestScope.list}" var="dto">
					<tr>
						<td> ${dto.no} </td>
						<td> <a href="./noticeSelect?no=${dto.no }" > ${dto.subject}  </a></td>
						<td> ${dto.id}</td>
						<td> ${dto.ndate}</td>
						<td> ${dto.hit}</td>
						
					</tr>
				</c:forEach>

			</table>
			
 			<c:if test="${member.id eq 'admin'}">	
			<a href="./noticeAdd" class="btn btn-primary">글쓰기</a>
			</c:if>
		
	


</body>
</html>