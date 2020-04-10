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
			<h1>notice Select List page</h1>
			<!--여기서 받아올려고 한다. EL활용 jstl.jar lib에복사     맨위에다가  링크올리기 -->
			<table class="table table-hover">
				<tr class="danger">
					<!-- <td>no</td> -->
					<td>내용</td>
				</tr>
				<!--반복문 할필요없음  -->
					<tr class="info">
						<%-- <td> ${dto.no} </td> --%>
						<td>${dto.content}</td>
						
					</tr>
			</table>
			
			
			 
			<a href="./noticeMod?no=${dto.no}" class="btn btn-primary">Update</a>
			<a href="./noticeDelete?no=${dto.no}" class="btn btn-danger">Delete</a>
			
			
		</div>
	</div>



</body>
</html>