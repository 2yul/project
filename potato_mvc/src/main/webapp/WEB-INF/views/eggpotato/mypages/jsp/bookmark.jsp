<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴게소 즐겨찾기</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_navi.css"/><%-- 네비바 필요한 사람만 --%>
<link rel="stylesheet" type="text/css" href="css/mypages/bookmark.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
});//ready

function removeBookmark( restarea_idx){
	//alert( "삭제할 키 " +  restarea_idx)	
	$("#restarea_idx").val( restarea_idx );
	//alert($("#restarea_idx").val()); //삭제하는 휴게소 인덱스 번호 안뜨게
	$("#delBookmarkFrm").submit();
}
	
</script>

</head>

<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../common/jsp/user_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container">
<div class="main">
<div class="wrap-navi">
	<div class="navi">
		<div class="profileWrap">
			<div class="img">
				<img src="css/images/${img}"  id="profileImg" name="profileImg" class="img" style="margin: 5px 30px; width: 150px; height: 150px; background: #f8edeb; border-radius: 50%;">
			</div>
			<div class="nickname"><c:out value="${nick}"/></div>
		</div>			
			<a class="navi-link" href="my_info_edit.do">내 정보 수정</a>
			<a class="navi-link2" href="password_edit.do">비밀번호 수정</a>
			<a class="navi-link2" href="unregister.do">회원탈퇴</a>
			<a class="navi-link" href="my_review.do">내가 쓴 리뷰</a>
			<a class="navi-link" href="like_review.do">좋아요한 리뷰</a>
			<a class="navi-link" href="bookmark.do">휴게소 즐겨찾기</a>
	</div>
</div>

<!-- 오 : 즐겨찾기  -->
<div class="review">
<div class="review-wrap">
	<div class="title">휴게소 즐겨찾기</div>

<%-- 네비바 끝 --%>
<!-- 작업시작 -->
<div class="listWrap">
<form id="delBookmarkFrm" method="post" action="delBookmark.do" >
<input type="hidden" value="${id }" name="id">
			<input type="hidden" id="restarea_idx" name="restarea_idx">
<c:forEach var="b" items="${bookmarklist}">
		<div class="list">
			<span class="list-item"><c:out value="${ b.name }"/></span>
			<button class="del" onclick="removeBookmark(${b.restarea_idx })">삭제</button>
		</div>
</c:forEach>
</form>

<!-- 북마크한 휴게소가 없을 경우 -->
<c:if test="${ empty bookmarklist }">
<div class="empty">
	<svg xmlns="http://www.w3.org/2000/svg" width="130" height="130" fill="currentColor" class="bi bi-bookmark-star" viewBox="0 0 16 16"  color="#593000">
  		<path d="M7.84 4.1a.178.178 0 0 1 .32 0l.634 1.285a.178.178 0 0 0 .134.098l1.42.206c.145.021.204.2.098.303L9.42 6.993a.178.178 0 0 0-.051.158l.242 1.414a.178.178 0 0 1-.258.187l-1.27-.668a.178.178 0 0 0-.165 0l-1.27.668a.178.178 0 0 1-.257-.187l.242-1.414a.178.178 0 0 0-.05-.158l-1.03-1.001a.178.178 0 0 1 .098-.303l1.42-.206a.178.178 0 0 0 .134-.098L7.84 4.1z"/>
  		<path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
	</svg>
	마음에 드는 휴게소를 찾아보세요 :)
</div>
</c:if>

	</div><!-- listWrap -->
	</div><!-- ewview wrap-->
	</div><!-- ewview -->
</div><!-- main -->

</div><!-- container -->
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>