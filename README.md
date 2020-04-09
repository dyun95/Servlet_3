# Servlet_3

 ## 기능
 
 ### Member
 - 회원가입(insert {add})
 - 로그인 (select One)
 - 회원 수정(update {mod})
 - 회원 탈퇴 (Delete)
 - MyPage 
 
 ### JSP
 - /WEB-INF/views/member/...
 
 URL
 /member/memberJoin		memberJoin.jsp		GET
 /member/memberJoin							POST
 /member/memberLogin	memberLogin.jsp		GET
 /member/memberLogin 						POST
 /member/memberPage		memberPage.jsp		GET
 /member/memberUpdate	memberUpdate.jsp	GET
 /member/memberUpdate						POST
 /member/memberDelete						GET
 
 
 
 
 
 ### point
 - point list 출력
 - point 등록 
 - point 상세 정보 출력
 - point 수정 
 - point 삭제
 
 ## JSP
 - pointList.jsp		: List 출력
 - pointAdd.jsp			: 입력 폼
 - pointSelect.jsp		: point 상세 정보 출력
 - pointMod.jsp			: point 수정 폼
 
 
 ## URL 주소				/	JSP 			/	Method
### /WEB-INF-views/point/** 
 - /point/pointList		/	pointList.jsp	/	GET
 - /point/pointAdd		/	pointAdd.jsp	/	GET
 - /point/pointAdd		/	미정				/	POST 
 - /point/pointSelect	/ 	pointSelect.jsp	/	GET
 - /point/pointMod		/	pointMod.jsp	/	GET
 - /point/pointMod		/					/	POST
 - /point/pointDelete	/					/	GET
 

