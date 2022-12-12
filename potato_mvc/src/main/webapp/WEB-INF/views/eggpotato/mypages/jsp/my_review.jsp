<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 리뷰</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/swiper-bundle2.min.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_navi.css"/><%-- 네비바 필요한 사람만 --%>
<link rel="stylesheet" type="text/css" href="css/mypages/my_review.css"/>

<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
		
	//리뷰 슬라이드 호출
	slider();
		
})//ready

function slider() {
	$(".re-mySwiper").each(function(index,element) {
		var $this = $(this);
		$this.addClass('instance-'+index);
		var $next = $(this).next();
		var $prev = $(this).prev();
		$next.addClass('next-'+index);
		$prev.addClass('prev-'+index);
		var $slide = $(this).children().children();
		
		 if($slide.length<=4) { //4개 이하일경우
			 var swiper = new Swiper(".instance-"+index, {
			        slidesPerView: 4,
			        spaceBetween: 3,
			        navigation: {
			            nextEl: '.next-'+index,
			            prevEl: '.prev-'+index,
			          },
			      });
		 }else { //4개 초과일경우 무한루프
			 var swiper = new Swiper(".instance-"+index, {
			    	loop: 1,
			        slidesPerView: 4,
			        spaceBetween: 3,
			        navigation: {
			            nextEl: '.next-'+index,
			            prevEl: '.prev-'+index,
			          },
			      });
		 }
	})
}

//하트아이콘
$(document).on("click", ".heart-btn", function() {
	
	var likeClass=$(this).attr("class");
	var $reviewidx=$(this).attr("value");
	var $restarea_idx=$(this).parent().next().children().attr("value");
	var hb=$(this);
	
	var jsonParam= { restarea_idx: $restarea_idx,
			id_clicker: "${id}",
			review_idx: $reviewidx,
			id_writer: "${id}" };
		
	 if(likeClass=="heart-btn hb-fill") { //좋아요 취소
		$(this).removeClass("hb-fill");
	
			$.ajax({
			url:"ajax_detailed_likeDel.do",
			data: jsonParam,
			type: "post",
			dataType: "text",
			error: function(xhr) {
				alert(xhr.responseText),
				alert(xhr.statusText),
				console.log(xhr.status);
				alert("에러")
			},
			success: function(data) {
				hb.next().children().text(parseInt(hb.next().children().text()) - 1);
				/* console.log("삭제성공"); */
			}
		}) 
				
		
	}else { //좋아요 등록
		$(this).addClass("hb-fill");
		
		 	$.ajax({
			url:"ajax_detailed_likeAdd.do",
			data:  jsonParam,
			type: "post",
			dataType: "text",
			error: function(xhr) {
				alert(xhr.responseText),
				alert(xhr.statusText),
				console.log(xhr.status);
				alert("에러")
			},
			success: function(data) {
				hb.next().children().text(parseInt(hb.next().children().text()) + 1);
				/* console.log("추가성공"); */
			}
		})
		
	}
	
	
})

	function deleteR(reviewIdx, restareaIdx) {
		
		var jsonParam= { restarea_idx: restareaIdx,
				review_idx: reviewIdx};
			
		var conFlag=confirm("리뷰를 삭제하시겠습니까?");
		
		if(conFlag==true) {
			$.ajax({
				url:"detailed_review_delete.do",
				data:  jsonParam,
				type: "post",
				dataType: "text",
				error: function(xhr) {
					alert(xhr.responseText),
					alert(xhr.statusText),
					console.log(xhr.status);
					alert("에러")
				},
				success: function(data) {
					alert("리뷰를 삭제했습니다.");
					location.reload();
				}
			})
			
		}
		
		
	}

//페이징
function movePage( page ) {
	$("#pageFlag").val( page );
	$("#reviewFrm").submit();
}

function editR(reviewIdx, restareaIdx) {
	$("#review_idx2").val(reviewIdx);
	$("#restarea_idx").val(restareaIdx);
	$("#editReview").submit();
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

<div class="review">
<div class="review-wrap">
<div class="title">내가 쓴 리뷰</div>
<!-- 북마크한 휴게소가 없을 경우 -->
<c:if test="${ empty mAll }">
<div class="empty">
	<svg xmlns="http://www.w3.org/2000/svg" width="130" height="130" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16" color="#593000">
  		<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  		<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
	</svg>
	리뷰를 작성해보세요 :)
</div>
</c:if>
<c:forEach var="my" items="${ mAll }">
		<div class="review-exist">
		<div class="re-left">
			<img src="css/images/${my.img}" alt="프로필사진">
		</div>
		
		<div class="re-right">
			<div style="margin-bottom: 10px;">
				<span style="font-size: 19px;color: white;padding: 5px 10px;background-color: #DCC1A0;
				border-radius: 7px;"><a href="user_detailed.do?restarea_idx=${my.restarea_idx }"><c:out value="${my.name}"/></a></span>
			</div>	
			<span><c:out value="${my.nick}"/></span>
			<div class="star-rate">
				<span class="star-blank"></span>
				<div class="re-star-wrap">
					<span class="star" style="width: ${my.rating*20}%"></span>
				</div>
				<span class="rate-txt"><c:out value="${my.rating}"/></span>
			</div>
			<p class="re-txt">
				<c:out value="${my.contents}" escapeXml="false"/>
			</p>
			<c:if test="${ not empty my.foodimg }">
			<div class="re-slider">
				<div class="swiper-button-prev re-swiper-button-prev"></div>
			    <div class="swiper re-mySwiper">
			    	<div class="swiper-wrapper re-swiper-wrapper">
			    	<c:forEach var="img" items="${my.foodimg }">
			   			<div class="swiper-slide re-swiper-slide">
			   				<img src="css/reviewImg/${img}" alt="리뷰사진" class="re-foodimg">
			   			</div>
 			   		</c:forEach>
			    	</div>
			    </div>
				<div class="swiper-button-next re-swiper-button-next"></div>
			</div>
			</c:if>
			<div class="etc-icon-wrap">
				<div class="etc-icon">
					<div class="heart-icon-wrap">
						<button type="button" class="${my.clickount eq 1? 'heart-btn hb-fill':'heart-btn'}" value="${my.review_idx}">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
							  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
							</svg>
						</button>
						<span>좋아요(<span><c:out value="${my.liked}"/></span>)</span>
					</div>
					<div class="edit-icon">
						<a href="javascript:editR(${my.review_idx},${my.restarea_idx});" value="${my.restarea_idx}">
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
							  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
							</svg>
						</a>
						<span>수정</span>
					</div>
					<div class="delete-icon">
						<button type="button" class="delete-btn" onclick='javascript:deleteR(${my.review_idx},${my.restarea_idx});'>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
							  <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
							</svg>
						</button>
						<span>삭제</span>
					</div>
				</div>
				<span class="date"><fmt:formatDate value="${my.post_date}" pattern="yyyy-MM-dd" /></span>
			</div>
			
		</div>
	</div>
</c:forEach>	
</div>
<!-- 페이징 -->
	<div class="page">
		<c:if test="${ not empty reviewList }">
			<c:if test="${ startNum ne 1 }">
				<a href="javascript:movePage(1)" class="page-num">&nbsp;&lt;&lt;&nbsp;</a>
				<a href="javascript:movePage(${startNum ne 1 ? startNum-1 : 1})" class="page-num">&nbsp;&lt;&nbsp;</a>
			</c:if>
			<c:forEach step="1" var="i" begin="0" end="${ isLast }">
				<a href="javascript:movePage(${ startNum+i })" ${ curPage eq startNum + i ?" class='page-num-click'" :" class='page-num'"}><c:out value="&nbsp;${ startNum+i }&nbsp;" escapeXml="false"/></a>
			</c:forEach>
			<c:if test="${ lastPage gt startNum+2 }">
				<a href="javascript:movePage(${ startNum+3 })" class="page-num">&nbsp;&gt;&nbsp;</a>
				<a href="javascript:movePage(${ lastPage })" class="page-num">&nbsp;&gt;&gt;&nbsp;</a>
			</c:if>
		</c:if>
	</div>

</div>
</div>
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->
</div>
<form id="reviewFrm" method="get">
	<input type="hidden" id="pageFlag" name="pageFlag" value="${ empty param.pageFlag ? 1 : param.pageFlag }">
	<input type="hidden" id="id" name="id" value="${ sessionScope.id }">
</form>

<form method="post" action="rewrite.do" id="editReview"> <!-- 리뷰수정창이동 -->
	<input type="hidden" name="review_idx" id="review_idx2" value="${param.review_idx}">
	<input type="hidden" name="restarea_idx" id="restarea_idx" value="${param.restarea_idx}">
</form>

</body>
</html>