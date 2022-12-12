<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타사용자 리뷰</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/swiper-bundle2.min.css"/>
<link rel="stylesheet" type="text/css" href="css/other_profiles/other_user_profiles.css"/>

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
	var $id_writer=$(this).parent().parent().attr("value");
	var $restarea_idx=$(this).parent().attr("value");
	var $reviewidx=$(this).attr("value");
	var hb=$(this);
	
	var jsonParam= { restarea_idx: $restarea_idx,
			id_clicker: "${id}",
			review_idx: $reviewidx,
			id_writer: $id_writer };

	if("${id}"=="") {
		alert("로그인이 필요한 동작입니다.")
	}else if(likeClass=="heart-btn hb-fill") { //좋아요 취소
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
			}
		})
		
	}
	
	
})
	
//페이징
function movePage( page ) {
	$("#pageFlag").val( page );
	$("#reviewFrm").submit();
}

function reportMove(reviewIdx, restareaIdx, nick, id) {
	
	if("${id}"=="") {
		alert("로그인이 필요한 동작입니다.");
	}else {
	var frmPop=document.reportPop;
	window.open("","report_popup",
			"width=520,height=470,top=203,left=706");
	frmPop.action = "report_review_popup.do?";
	frmPop.target = "report_popup";
	frmPop.id_writer.value = id;
	frmPop.nick.value = nick;
	frmPop.restarea_idx.value = restareaIdx;
	frmPop.review_idx.value = reviewIdx;
	frmPop.submit();
	}
}

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

function editR(reviewIdx, restareaIdx) {
$("#review_idx2").val(reviewIdx);
$("#restarea_idx2").val(restareaIdx);
$("#editReview").submit();
}
	
</script>
</head>
<body>
<div class="wrap">
<!-- header -->
<%@ include file="../../common/jsp/user_header.jsp" %>
<!-- header end-->

<div class="container">
<div class="main">
<div class="profile">
	<img src="css/images/${img}" class="photo">
	<span class="nick"><c:out value="${nick}"/></span>
	<span class="cnt">(리뷰 수 : <c:out value="${rCnt}"/>건)</span>
</div>
<!-- 리뷰 -->
<div class="review-wrap">
<c:forEach var="rev" items="${rAll}">
	<div class="review-exist">
		<div class="re-left">
			<img src="css/images/${rev.img}" alt="프로필사진">
		</div>
		
		<div class="re-right">
		<div style="margin-bottom: 10px;">
			<span style="font-size: 19px;color: white;padding: 5px 10px; background-color: #DCC1A0;
			border-radius: 7px;"><a href="user_detailed.do?restarea_idx=${rev.restarea_idx }"><c:out value="${rev.name}"/></a></span>
		</div>	
		<span><c:out value="${rev.nick}"/></span>
			<div class="star-rate">
				<span class="star-blank"></span>
				<div class="re-star-wrap">
					<span class="star" style="width:${rev.rating*20}%"></span>
				</div>
				<span class="rate-txt"><c:out value="${rev.rating}"/></span>
			</div>
			<p class="re-txt">
				<c:out value="${rev.contents}" escapeXml="false"/>
			</p>
			<c:if test="${ not empty rev.foodimg }">
			<div class="re-slider">
				<div class="swiper-button-prev re-swiper-button-prev"></div>
			    <div class="swiper re-mySwiper">
			    	<div class="swiper-wrapper re-swiper-wrapper">
			    	<c:forEach var="img" items="${ rev.foodimg }">
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
				<div class="etc-icon" value="${rev.id }">
					<div class="heart-icon-wrap" value="${rev.restarea_idx}">
						<button type="button" class="${rev.clickcount eq 1? 'heart-btn hb-fill':'heart-btn'}" value="${rev.review_idx}">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
							  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
							</svg>
						</button>
						<span>좋아요(<span><c:out value="${rev.liked}"/></span>)</span>
					</div>
					<c:if test="${rev.id ne id }">
						<div class="report-icon">
							<button type="button" class="report-btn" onclick='javascript:reportMove(${rev.review_idx},${rev.restarea_idx},"${rev.nick}","${rev.id}");'>
								<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bell-fill" viewBox="0 0 16 16">
								  <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zm.995-14.901a1 1 0 1 0-1.99 0A5.002 5.002 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901z"/>
								</svg>
							</button>
							<span>신고</span>
						</div>
					</c:if>
					<c:if test="${rev.id eq id }">
						<div class="edit-icon">
							<a href="javascript:editR(${rev.review_idx},${rev.restarea_idx});"  value="${rev.restarea_idx}">
								<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
								  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
								</svg>
							</a>
							<span>수정</span>
						</div>
						<div class="delete-icon">
							<button type="button" class="delete-btn" onclick='javascript:deleteR(${rev.review_idx},${rev.restarea_idx});'>
								<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
								  <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
								</svg>
							</button>
							<span>삭제</span>
						</div>
					</c:if>
				</div>
				<span class="date"><fmt:formatDate value="${rev.post_date}" pattern="yyyy-MM-dd" /></span>
			</div>
			
		</div><!-- re-right -->
	</div>
</c:forEach>
</div>	

<!-- 페이지 -->
	<div class="page">
		<c:if test="${ not empty rAll }">
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

</div><!-- main -->
</div><!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->
</div>

<form id="reviewFrm" method="get">
	<input type="hidden" id="pageFlag" name="pageFlag" value="${ empty param.pageFlag ? 1 : param.pageFlag }">
	<input type="hidden" id="id" name="otherPid" value="${ param.otherPid }">
</form>

<form method="post" id="reportPop" name="reportPop"> <!-- 신고창이동 -->
	<input type="hidden" name="id" id="id" value="${id}">
	<input type="hidden" name="id_writer" id="id_writer" value="${param.id_writer}">
	<input type="hidden" name="review_idx" id="review_idx" value="${param.review_idx}">
	<input type="hidden" name="restarea_idx" id="restarea_idx" value="${param.restarea_idx}">
	<input type="hidden" name="nick" id="nick" value="${param.nick}">
</form>

<form method="post" action="rewrite.do" id="editReview"> <!-- 리뷰수정창이동 -->
	<input type="hidden" name="review_idx" id="review_idx2" value="${param.review_idx}">
	<input type="hidden" name="restarea_idx" id="restarea_idx2" value="${param.restarea_idx}">
</form>

</body>
</html>