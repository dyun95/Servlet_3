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
		<div class="row">
			<h1>point Select List page</h1>
			<!--여기서 받아올려고 한다. EL활용 jstl.jar lib에복사     맨위에다가  링크올리기 -->
			<table class="table table-hover">
				<tr class="danger">
					<td>이름</td>
					<td>번호</td>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>총점</td>
					<td>평균</td>
				</tr>
				<!--반복문 할필요없음  -->
					<tr class="info">
						<td>${dto.name}</td>
						<td>${dto.num}</td>
						<td>${dto.kor}</td>
						<td>${dto.eng}</td>
						<td>${dto.math}</td>
						<td>${dto.total}</td>
						<td>${dto.avg}</td>
					</tr>
			</table>
			<!--수정할려면   -->
			<a href="./pointMod?num=${dto.num}" class="btn btn-primary">Update</a>
			<a href="./pointDelete?num=${dto.num}" class="btn btn-danger">Delete</a>
			
		</div>
	</div>


</body>
</html>