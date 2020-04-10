<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberPage</title>
<c:import url="../template/boot.jsp"></c:import>

</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<div class="row">
			<h1>회원정보페이지</h1>
			<!--여기서 받아올려고 한다. EL활용 jstl.jar lib에복사     맨위에다가  링크올리기 -->
			<table class="table table-hover">
				<tr class="danger">
					<td>아이디</td>
					<td>이름</td>
					<td>이메일</td>
					<td>폰번호</td>
					<td>나이</td>
				</tr>
				<!--반복문 할필요없음  -->
				<tr class="info">
					<td>${sessionScope.member.id}</td>
					<td>${sessionScope.member.name}</td>
					<td>${sessionScope.member.email}</td>
					<td>${sessionScope.member.phone}</td>
					<td>${sessionScope.member.age}</td>
				</tr>
			</table>
			<!--수정할려면   -->
			<button class="btn btn-primary" id="update">Update</button>
			<button class="btn btn-danger" id="del">Delete</button>
		</div>
	</div>
	<script type="text/javascript">
	// js document.getElementById
	// js document.quertSelector
	// Jquert $(선택자 )
	$("#del").click(function () {
			var result = confirm("탈퇴 할꺼야? ");
			console.log(result);
			if (result) {
				alert("탈퇴");
				//JS location.href : location.href = “URL주소?이름=값&이름=값”;	get
				 window.location.href="./memberDelete";

			} else {
				alert("취소");
			}
		});
	
	$("#update").on("click",function(){
		 window.location.href="./memberUpdate";
				
	});
		
	</script>

</body>
</html>