<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_navi.css"/><%-- 네비바 필요한 사람만 --%>
<link rel="stylesheet" type="text/css" href="css/mypages/unregister.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
<c:if test="${quitCount eq 1}">
	alert("회원 탈퇴가 완료되었습니다.");
	location.href="unregister_process2.do";
</c:if>

<c:if test="${quitCount eq 0 }">
	alert("입력된 비밀번호가 틀려 회원탈퇴가 완료되지 않았습니다.");
	<%
	session.setAttribute("quitCount", 2);
	%>
	location.href="unregister.do";
</c:if>


$(function() {
	$(".unregister_btn").click(function() {
			pass=$("#pass").val();
			
			if(pass != pass){
				alert("비밀번호가 일치하지 않습니다.");
			}else{
			$("#unregeisterFrm").submit();
			
			}
	});//click
});//ready
</script>

</head>
<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../common/jsp/user_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container">
	<%-- 마이페이지용 --%>
<div class="wrap-navi">
		<div class="navi">
			<div class="profileWrap">
				<div class="img">
					<img src="http://potato.sist.co.kr/css/images/${ img }"   id="profileImg" name="profileImg" class="img" style="margin: 5px 30px; width: 150px; height: 150px; background: #f8edeb; border-radius: 50%;">
				</div>
				<div class="nickname"><c:out value="${ nick }"/> </div>
			</div>			
			<a class="navi-link" href="my_info_edit.do">내 정보 수정</a>
			<a class="navi-link2" href="password_edit.do">비밀번호 수정</a>
			<a class="navi-link2" href="unregister.do">회원탈퇴</a>
			<a class="navi-link" href="my_review.do">내가 쓴 리뷰</a>
			<a class="navi-link" href="like_review.do">좋아요한 리뷰</a>
			<a class="navi-link" href="bookmark.do">휴게소 즐겨찾기</a>
		</div><!-- navi -->
<%-- 네비바 끝 --%>
<form action="unregister_process.do" method="post" id="unregeisterFrm">
	<div class="unregister_wrap">
	<div class="unregister_img">
		<img src="css/images/unregister.png">
	</div><!-- unregister_img -->
	
	<div class="msg">탈퇴를 하시면 회원님의 개인 정보가 삭제됩니다.</div>
	<div class="msg1">
	비밀번호 입력 후 탈퇴 신청이 진행됩니다.<br><br>
	그동안 저희 알감자를 이용해주셔서 진심으로 감사드립니다.	
	</div>
	
	<div class="pw_chk">
		<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="#C89E6C" class="bi bi-lock-fill" viewBox="0 0 16 16">
  		<path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/></svg>
		<input type="password" name="pass" placeholder="비밀번호를 입력해주세요." class="pw" size="30">
	</div>
	
		<button type="button" class="unregister_btn">회원 탈퇴</button>
	
	</div><!-- unregister_wrap -->
</form>
</div><!-- wrap-navi -->

</div><!-- container --><!-- 삭제하면 안돼~~ -->
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>