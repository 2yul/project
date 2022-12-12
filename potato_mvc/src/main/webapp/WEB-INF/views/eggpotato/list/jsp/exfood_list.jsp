<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX FOOD</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_navi2.css"/><%-- 네비바 필요한 사람만 --%>
<link rel="stylesheet" type="text/css" href="css/list/exfood_list.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function doMap(num){
	switch(num){
	case 1:
		$(".local-img").attr("src","css/images/seoul.jpg")
		break;
	case 2:
		$(".local-img").attr("src","css/images/gangwon.jpg")
		break;
	case 3:
		$(".local-img").attr("src","css/images/chung-cheong.jpg")
		break;
	case 4:
		$(".local-img").attr("src","css/images/daejeon.jpg")
		break;
	case 5:
		$(".local-img").attr("src","css/images/chonbuk.jpg")
		break;
	case 6:
		$(".local-img").attr("src","css/images/gwangju.jpg")
		break;
	case 7:
		$(".local-img").attr("src","css/images/daegu.jpg")
		break;
	case 8:
		$(".local-img").attr("src","css/images/busan.jpg")
		break;
		
	}
	
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
<%-- 휴게소리스트용 --%>
<div class="wrap-navi">
		<div class="navi">
			<ul class="navibar">
				<li class="navi-item">
					<a class="navi-link" href="allList.do">전체 휴게소</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="mapPin.do">고속도로별 휴게소</a>
				</li>
				<li class="blank"></li>
				<li class="navi-item">
					<a class="navi-link" href="doMap.do">도별 휴게소</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="exFood.do">ex-FOOD</a>
				</li>
			</ul>
		</div>
</div> 
<%-- 네비바 끝 --%>
<!-- 건들지마 -->
			<!--메인 영역 -->
			<div class="main">
				<!-- exfood 설명 -->
				<div class="top"> 
					<div class="logo"><img src="css/images/ex-food로고.png" class="top-img"></div>
					<div class="logo-text">: 한국 도로공사가 휴게소 이용자와 전문가의 평가를 거쳐 선정하여
					 맛과 질 모두 믿고 먹을 수 있는 고속도로 휴게소의 대표음식입니다. </div>
				</div>
				<!-- exfood 설명 -->
				<div class="content">
				<!-- 이미지 -->
				<div class="content-left">
				<img src="css/images/seoul.jpg" class="local-img">
				</div>
				<!-- 네비바 -->
				<div class="content-right">
					<div class="exfood-navi">
						<ul class="food-navibar">
							<li class="food-navi-item" onclick="doMap(1)">
								<div class="navi-do">수도권</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
							<li class="food-navi-item" onclick="doMap(2)">
								<div class="navi-do">강원</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
							<li class="food-navi-item" onclick="doMap(3)">
								<div class="navi-do">충북</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
							<li class="food-navi-item" onclick="doMap(4)">
								<div class="navi-do">대전 충남</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
							<li class="food-navi-item" onclick="doMap(5)">
								<div class="navi-do">전북</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
							<li class="food-navi-item" onclick="doMap(6)">
								<div class="navi-do">광주 전남</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
							<li class="food-navi-item" onclick="doMap(7)">
								<div class="navi-do">대구 경북</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
							<li class="food-navi-item" onclick="doMap(8)">
								<div class="navi-do">부산 경남</div>
								<div class="navi-logo"><img src="css/images/ex-food로고.png" class="img"></div>
							</li>
						</ul>
					</div>
				 </div>
				 </div>
			</div>
<!-- 건들지마 -->
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>