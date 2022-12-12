<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/swiper-bundle.min.css"/>
<link rel="stylesheet" type="text/css" href="css/mainhome/user_mainhome.css"/>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f17857e30d029f485667a3cf426b0a8e"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	<!-- Initialize Swiper -->	
    var swiper = new Swiper(".mySwiper", {
    	loop: 1,
	    centeredSlides: true,
	     autoplay: {
	       delay: 4000,
	       disableOnInteraction: false,
	     },
        pagination: {
          el: ".swiper-pagination",
          type: "progressbar",
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(36.1752197169176, 127.7488279073141), // 지도의 중심좌표
	        level: 12 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	  
	// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
	var positions = [
			<c:forEach var="mapPin" items="${requestScope.mapPin }">
	    {
	        content: '<div>${mapPin.name}<br><a href="user_detailed.do?restarea_idx=${mapPin.restarea_idx }" style="color: #593000; font-weight: bold;">상세보기</a></div>', 
	        latlng: new kakao.maps.LatLng(${mapPin.lat}, ${mapPin.lng})
	    },
			</c:forEach>
	];

	for (var i = 0; i < positions.length; i ++) {
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng // 마커의 위치
	    });

	    // 마커에 표시할 인포윈도우를 생성합니다 
	    var infowindow = new kakao.maps.InfoWindow({
	        content: positions[i].content // 인포윈도우에 표시할 내용
	    });

	    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'click', clickListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	    kakao.maps.event.removeListener(marker, 'click', clickOutListener(infowindow));
	}

	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	        infowindow.open(map, marker);
	    };
	}
	
	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function clickListener(map, marker, infowindow) {
	    return function() {
	    	position, content
	    };
	}
	
	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}
	
	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function clickOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}
	
	// top 버튼 생성
	var header = $('.header');
	var topbtn = $('.topbtn-wrap');

	 $(window).scroll(function(e){
	     if(header.offset().top !== 0){
	         if(!topbtn.hasClass('topbtnwrap')){
	        	 topbtn.addClass('topbtnwrap');
	         }
	     }else{
	    	 topbtn.removeClass('topbtnwrap');
	     }
	 });
	 
})

function sidebar() {
	$(".side").toggleClass("side-add");
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
	<div class="top-wrap">
		<img src="css/images/mainphoto.jpg" class="main-photo"/>
		<div class="flip-wrap">
			<div class="flip">
				<div><div>"편안하고 맛있는 여행이 되세요"</div></div>
				<div><div>"장거리 여행은 든든한 알감자와 함께"</div></div>
				<div><div>"이제는 휴게소도 맛집시대"</div></div>
			</div>
			<p>휴게소에 대한 다양한 정보를</p>
			<p>이곳, <span>알감자</span>에서 얻어가세요.</p>
		</div>
		<button type="button" class="scroll-btn" onclick="$('html,body').stop().animate({scrollTop:'863'})">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
			  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
			</svg>
		</button>
	</div>
	
	<div class="middle-wrap">
		<span>핫플로 소개난 전국 휴게소를 찾아서!</span>
		<div class="swiper mySwiper">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<div class="slide-top">
						<span class="slide-title">전라남도</span>
						<p class="slide-content"> 우리나라의 맛의 고장이라면 어디일까요? 바로 전주 비빔밥, 영광 굴비 등 다양한 전라도 음식이 떠오르기 마련입니다. <br>
							추어탕, 전어회, 장어구이와 같은 맛있는 음식들이 정말 많은 고장인데요. <br> 
							옛부터 전라도는 땅과 바다 그리고 산에서 나는 재료가 다양하여 가문에 좋은 음식이 대대로 전해지는 풍류와 맛의 고장입니다. <br>
							기후가 따뜻하여 젓갈류, 고춧가루 등 양념을 강하게 하여 우리의 입맛을 더욱이 돋구기도 합니다. <br>
							이러한 맛의 고장 전라도 중 전라남도에 위치한 휴게소들의 특별한 음식들을 소개해드리려고 합니다. </p>
					</div>
					<div class="slide-bottom">
						<div class="img-display">
							<c:forEach var="link1" items="${requestScope.link1 }">
								<div class="sb-img-wrap">
									<img src="css/images/${link1.img }" alt="휴게소음식사진" class="foodimg">
									<div class="img-hover">
										<a href="user_detailed.do?restarea_idx=${link1.restarea_idx }" class="img-link">휴게소 보러가기</a>
									</div>
									<span class="foodimg-title"><c:out value="${link1.name }"/>-<c:out value="${link1.foodName }"/></span>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="slide-top">
						<span class="slide-title">수도권</span>
						<p class="slide-content"> 여행 계획을 세우는 것부터 이미 여행은 시작되었다고 하죠. <br>
							설레는 여행길에서 만나는 맛있는 휴게소! <br>
							수도권본부 휴게소의 특별한 메뉴를 맛보고, <br>
							휴게소 근처 관광지까지 방문한다면 즐거움은 두배가 될텐데요.<br>
							함께 떠나볼까요?</p>
					</div>
					<div class="slide-bottom">
						<div class="img-display">
							<c:forEach var="link2" items="${requestScope.link2 }">
								<div class="sb-img-wrap">
									<img src="css/images/${link2.img }" alt="휴게소음식사진" class="foodimg">
									<div class="img-hover">
										<a href="user_detailed.do?restarea_idx=${link2.restarea_idx }" class="img-link">휴게소 보러가기</a>
									</div>
									<span class="foodimg-title"><c:out value="${link2.name }"/>-<c:out value="${link2.foodName }"/></span>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="slide-top">
						<span class="slide-title">강원도</span>
						<p class="slide-content"> 여행에 대한 벅찬 기대와 맛있는 음식을 먹는 설렘은 정말 연휴만큼이나 저희를 짜릿하게 만들어줍니다. <br>
						특히 맛있는 음식들은 생각만해도 배 속에서 꼬르륵 소리가 나도록 만들어주는데요. <br>
						여름 레저 스포츠를 즐기러 많이들 떠나시는 그곳 바로 강원도 휴게소들의 맛있는 특산 메뉴를 소개해 드리려고 합니다. <br>
						그럼 굶주린 배를 부여잡고 함께 떠나볼까요!?</p>
					</div>
					<div class="slide-bottom">
						<div class="img-display">
							<c:forEach var="link3" items="${requestScope.link3 }">
								<div class="sb-img-wrap">
									<img src="css/images/${link3.img }" alt="휴게소음식사진" class="foodimg">
									<div class="img-hover">
										<a href="user_detailed.do?restarea_idx=${link3.restarea_idx }" class="img-link">휴게소 보러가기</a>
									</div>
									<span class="foodimg-title"><c:out value="${link3.name }"/>-<c:out value="${link3.foodName }"/></span>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="slide-top">
						<span class="slide-title">충청북도</span>
						<p class="slide-content"> 생각만 해도 설렘이 가득한 휴게소, 여러분은 휴게소를 어떤 이유로 들리시나요? <br>
							장시간 운전으로 지쳤을 때? 화장실을 가기 위하여? 다양한 이유들이 있을텐데요! <br> 
							최근까지 휴게소 맛집들이 미디어를 통해 전파되어 많은 사람들이 휴게소 맛집을 찾아가기 위해 들리는 경우도 일상다반사입니다. <br>
							이렇게 휴게소 맛집을 원하시는 분들을 위하여 지역만의 특색을 갖추어 지역 향기가 물씬 풍기는<br>
							충청북도 휴게소만의 특별한 음식들을 소개해드리겠습니다!</p>
					</div>
					<div class="slide-bottom">
						<div class="img-display">
							<c:forEach var="link4" items="${requestScope.link4 }">
								<div class="sb-img-wrap">
									<img src="css/images/${link4.img }" alt="휴게소음식사진" class="foodimg">
									<div class="img-hover">
										<a href="user_detailed.do?restarea_idx=${link4.restarea_idx }" class="img-link">휴게소 보러가기</a>
									</div>
									<span class="foodimg-title"><c:out value="${link4.name }"/>-<c:out value="${link4.foodName }"/></span>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
				<div class="swiper-button-next"></div>
				<div class="swiper-button-prev"></div>
				<div class="swiper-pagination"></div>
		</div>
		<button type="button" class="scroll-btn" onclick="$('html,body').stop().animate({scrollTop:'1776'})">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-circle" viewBox="0 0 16 16">
			  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
			</svg>
		</button>
		
	</div>
	
	<div class="bottom-wrap">
		<div id="map" class="kk-map"></div>
		<div class="map-right">
			<p class="map-txt"> 
				더 많은 휴게소의 <br>
				정보가 궁금하다면? <br>
			</p>
			<a href="allList.do" class="map-link">휴게소 더보기</a>
		</div>
	</div>
	
	<div class="side">
		<div class="yw-chk-wrap">
			<input type="checkbox" class="youtube-chk" id="youtubechk" onclick="sidebar();">
			<label class="chk-label" for="youtubechk">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-youtube" viewBox="0 0 16 16">
				  <path d="M8.051 1.999h.089c.822.003 4.987.033 6.11.335a2.01 2.01 0 0 1 1.415 1.42c.101.38.172.883.22 1.402l.01.104.022.26.008.104c.065.914.073 1.77.074 1.957v.075c-.001.194-.01 1.108-.082 2.06l-.008.105-.009.104c-.05.572-.124 1.14-.235 1.558a2.007 2.007 0 0 1-1.415 1.42c-1.16.312-5.569.334-6.18.335h-.142c-.309 0-1.587-.006-2.927-.052l-.17-.006-.087-.004-.171-.007-.171-.007c-1.11-.049-2.167-.128-2.654-.26a2.007 2.007 0 0 1-1.415-1.419c-.111-.417-.185-.986-.235-1.558L.09 9.82l-.008-.104A31.4 31.4 0 0 1 0 7.68v-.123c.002-.215.01-.958.064-1.778l.007-.103.003-.052.008-.104.022-.26.01-.104c.048-.519.119-1.023.22-1.402a2.007 2.007 0 0 1 1.415-1.42c.487-.13 1.544-.21 2.654-.26l.17-.007.172-.006.086-.003.171-.007A99.788 99.788 0 0 1 7.858 2h.193zM6.4 5.209v4.818l4.157-2.408L6.4 5.209z"/>
				</svg>
			</label>
		</div>
		<div class="youtube-wrap">
			<p>영상으로 보는 휴게소 맛집</p>
			<div class="youtube">
				<iframe width="560" height="315" src="https://www.youtube.com/embed/jp_Q11V-274" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				<iframe width="560" height="315" src="https://www.youtube.com/embed/Us4f2SqhkOM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				<iframe width="560" height="315" src="https://www.youtube.com/embed/x6Q7WTBKBSo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
			
		</div>
	</div>
	
	<div class="topbtn-wrap" onclick="$('html,body').stop().animate({scrollTop:'0'})">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-bar-up" viewBox="0 0 16 16">
		  <path fill-rule="evenodd" d="M8 10a.5.5 0 0 0 .5-.5V3.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 3.707V9.5a.5.5 0 0 0 .5.5zm-7 2.5a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 0 1h-13a.5.5 0 0 1-.5-.5z"/>
		</svg>
		<span>TOP</span>
	</div>
	
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>