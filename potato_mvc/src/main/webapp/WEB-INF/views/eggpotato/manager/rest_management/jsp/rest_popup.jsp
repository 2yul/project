<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴게소 상세창</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/swiper-bundle2.min.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/rest_management/rest_popup.css"/>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f17857e30d029f485667a3cf426b0a8e"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	//수정버튼 클릭시
	$(".modi-btn").click(function(){
		$("#restarea_idx").val($(".modi-btn").val());
		open("","write_popup","width=950,height=900,top=311,left=560");
		$("#modifyFrm").submit();
	});
	
	//삭제버튼 클릭시
	$(".del-btn").click(function(){
		if(confirm("정말로 삭제하시겠습니까?")) {
			$("#rIdx").val($(".modi-btn").val());
			$("#delFrm").submit();
		}
	});
	
	// 음식 사진 슬라이드
    var swiper = new Swiper(".mySwiper", {
    	loop: 1,
    	slidesPerView: 4,
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
    });
    
	//////////////////////////////지도API///////////////////////////////////////
    var markerPosition  = new kakao.maps.LatLng(${detail.lat}, ${detail.lng}); 

    // 이미지 지도에 표시할 마커입니다
    // 이미지 지도에 표시할 마커는 Object 형태입니다
    var marker = {
        position: markerPosition,
        text: '${detail.name}'
    };
	
    var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
    staticMapOption = { 
        center: new kakao.maps.LatLng(${detail.lat}, ${detail.lng}), // 이미지 지도의 중심좌표
        level: 3, // 이미지 지도의 확대 레벨
        marker: marker // 이미지 지도에 표시할 마커 
    };

	// 이미지 지도를 표시할 div와 옵션으로 이미지 지도를 생성합니다
	var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption); 
    //////////////////////////////지도API///////////////////////////////////////
});//ready
</script>
</head>
<body>
<div class="wrap">


<!-- container -->
<div class="containers">
	<div class="title-wrap">
		<span><c:out value="${ detail.name }"/></span>
		<div class="rate-wrap">
			<div class="star-rate">
				<span class="star-blank"></span>
				<div class="star-wrap">
					<span class="star" style="width: ${ detail.totalRating*20 }%"></span>
				</div>
				<span class="rate-txt">
				<c:choose>
				<c:when test="${ detail.totalRating eq 0  }">
				0
				</c:when>
				<c:otherwise>
				<fmt:formatNumber pattern=".0" value="${ detail.totalRating }"/>
				</c:otherwise>
				</c:choose>
				</span>
			</div>
			<div class="bookmark-wrap">
				<div>
					<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bookmark" viewBox="0 0 16 16">
					  <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
					</svg>
				</div>
				<span class="bookmark-txt"><c:out value="${ detail.bookmark_cnt }"/></span>
			</div>
		</div>
	</div>
	
	<div class="slide-wrap">
		<div class="swiper mySwiper">
			<div class="swiper-wrapper">
				<c:forEach var="food" items="${ foodList }">
				<div class="swiper-slide">
					<img src="css/images/${ food.img }" alt="휴게소음식사진" class="foodimg">
					<div class="food-detailed-wrap">
						<span class="food-name"><c:out value="${ food.name }"/></span>
						<span class="food-price"><c:out value="${ food.price }"/></span>
						<p class="food-feature"><c:out value="${ food.contents }"/></p>
						<p class="food-ingredient"><c:out value="${ food.ingredient }"/></p>
					</div>
					<c:if test="${ food.main_chk eq 'Y' }">
					<p class="slide-img-title">
						대표
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
							<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
						</svg>
					</p>
					</c:if>
					<c:if test="${ food.rec_chk eq 'Y' }">
					<p class="slide-img-title">
						추천
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16">
							<path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a9.84 9.84 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733.058.119.103.242.138.363.077.27.113.567.113.856 0 .289-.036.586-.113.856-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.163 3.163 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.82 4.82 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
						</svg>
					</p> 
					</c:if>
				</div>
				</c:forEach>
			</div>
	    </div>
		<div class="swiper-button-prev"></div>
		<div class="swiper-button-next"></div>
	</div>
	
	<div class="map-bookmark">
		<div class="map-wrap">
			<span>지도</span>
			<div id="staticMap" class="kk-map"></div>
		</div>
	</div>
	
	<div class="amenities-icon-wrap">
		<span>편의시설 구분</span>
		<div class="icon-wrap">
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/sleep.png">
				<span>수면실</span>
			</div>
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/shower.png">
				<span>샤워실</span>
			</div>
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/washing.png">
				<span>세탁실</span>
			</div>
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/rest.png">
				<span>쉼터</span>
			</div>
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/barber.png">
				<span>이발소</span>
			</div>
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/baby.png">
				<span>수유실</span>
			</div>
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/pharmacy.png">
				<span>약국</span>
			</div>
			<div class="amenities-icon">
				<img alt="편의시설아이콘" src="css/images/market.png">
				<span>농산물판매장</span>
			</div>
		</div>
	</div>
	
	<div class="amenities-table-wrap">
		<table class="amenities-table">
			<tr>
				<th>위치</th>
				<td><c:out value="${ detail.line }"/></td>
				<th>전화번호</th>
				<td><c:out value="${ detail.tel }"/></td>
			</tr>
			<tr>
				<th>편의시설(휴게소)</th>
				<td>	
					<c:set var="restArr" value="${ fn:split(detail.retAmImgs,',') }"/>
					<div class="table-icon-wrap">
					<c:if test="${ not empty detail.retAmImgs }">
					<c:forEach var="rIcon" items="${ restArr }">
						<img alt="편의시설아이콘" src="css/images/${ rIcon }">
					</c:forEach>
					</c:if>
					</div>
				</td>
				<th>편의시설(주유소)</th>
				<td>
					<c:set var="gasArr" value="${ fn:split(detail.gasAmImgs,',') }"/>
					<div class="table-icon-wrap">
					<c:if test="${ not empty detail.gasAmImgs }">
					<c:forEach var="gIcon" items="${ gasArr }">
						<img alt="편의시설아이콘" src="css/images/${ gIcon }">
					</c:forEach>	
					</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<th>세차장</th>
				<td><c:out value="${ detail.carwash_chk }"/></td>
				<th>경정비소</th>
				<td><c:out value="${ detail.repair_chk }"/></td>
			</tr>
			<tr>
				<th>ex-화물차라운지</th>
				<td><c:out value="${ detail.cargolounge_chk }"/></td>
				<th>-</th>
				<td></td>
			</tr>
		</table>
	</div>
	<div class="btns">
		<button type="button" class="modi-btn" value="${detail.restarea_idx}">수정</button>
		<button type="button" class="del-btn" value="${detail.restarea_idx}">삭제</button>
	</div>
	
</div>
<!-- container end -->

</div>
<!-- 수정창 이동 frm -->
<form id="modifyFrm" method="post" action="manager_rest_modifyPopup.do" target="write_popup">
<input type="hidden" id="restarea_idx" name="restarea_idx">
</form>

<!-- 삭제 프로세스 -->
<form id="delFrm" method="post" action="manager_removeRest.do">
<input type="hidden" id="rIdx" name="restarea_idx">
</form>
</body>
</html>