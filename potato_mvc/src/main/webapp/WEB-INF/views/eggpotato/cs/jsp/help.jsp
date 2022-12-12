<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도움말</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/cs/help.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style type="text/css">
html,
body {
 height: 100%;
}

body {
 font-family: 'Noto Sans KR', sans-serif;
 color: #666666;
}

ul,
ol {
 list-style: none;
}

dl {
 width: 600px;
 margin: 50px auto;
}

dt {
 font-size: 18px;
 height: 50px;
 line-height: 50px;
 text-indent: 30px;
 color: #000000;
 background-color: #fff;
 cursor: pointer;
}

body > dl > dt:first-child {
 background: rgb(50, 192, 145);
}

body > dl > dt:nth-child(3) {
 background: rgb(126, 126, 126);
}

dd {
 padding: 30px;
 background: #d4d0c8;
}

dd ul li {
 padding-bottom: 10px;
}
</style>
<script type="text/javascript">
$(function () {
	  $('dd:not(:first)').css('display', 'none');
	  $('dl dt').on('click', function () {
	    if ($('+dd', this).css('display') == 'none') {
	      $('dl dd').slideUp('slow');
	      $('+dd', this).slideDown('slow');
	    }
	  });
	});
</script>
</head>
<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../common/jsp/user_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container">
	<!-- Box -->
	<div class="box-main">
	<div class="title-top">도움말</div>
		<!-- menu -->
	<dl>
	<dt>Q. 사이트가 명칭이 알감자인 이유가 뭔가요?</dt>
	<dd>
		<ul>
			<li>휴게소에 가게 되면 먹게되는 대표 음식 중 하나에서 따오게 되었습니다.</li>
		</ul>
	</dd>
	<dt>Q. 휴게소 리뷰는 어떻게 작성하나요?</dt>
	<dd>
	<ul>
	<li>1. 리뷰를 남기고 싶은 휴게소를 선택합니다.</li>
   	<li> 2. 휴게소 상세 페이지에서 리뷰를 작성 후 등록합니다.</li>
   	<li></li>
    <li>* 사진을 통해 내가 다녀온 휴게소 음식을 생생하게 소개해주세요.</li>
    <li>* 부적절한 리뷰 또는 사진이 있는경우 02-3482-4632로 이 사실을 알려주세요.</li>
    <li>* 광고성 행위, 비방글과 리뷰는 최대한 삼가해주세요.</li>
	</ul>
    </dd>
    <dt>Q. 휴게소 즐겨찾기 하고 싶어요?</dt>
    <dd>
    <ul>
    	<li>1. 알감자에서 즐겨찾기를 하고 싶은 휴게소를 선택합니다.</li>
   		<li> 2. 휴게소 상세 페이지에서 즐겨찾기 아이콘을 클릭합니다.</li>
    </ul>
    </dd>
    <dt>Q. 즐겨찾기한 휴게소들은 어디서 확인하나요?</dt>
    <dd>
    <ul>
    <li>1. 즐겨찾기한 휴게소는 마이페이지>즐겨찾기에서 확인할 수 있습니다.</li>
    <li>2. 즐겨찾기는 삭제가 가능합니다.</li>
    </ul>
    </dd>
    <dt>Q. 마이페이지는 무엇인가요?</dt>
    <dd>
    <ul>
    <li>1. 마이페이지는 나의 프로필 수정, 리뷰, 즐겨찾기한 휴게소들을 관리할 수 있는 메뉴입니다.</li>
    <li>2. 이 외에도 내가 좋아요한 리뷰도 확인하실 수 있습니다.</li>
    </ul>
    </dd>
    <dt>Q. 회원 탈퇴를 하고 싶어요.</dt>
    <dd>
    <ul>
    <li>회원 탈퇴는 알감자 웹페이지에서 가능합니다.</li>
    <li>가입하신 계정으로 로그인 후 > 마이페이지 > 회원탈퇴 메뉴에서 이용할 수 있습니다.</li>
    <li>* 탈퇴 후에는 동일 계정으로 재가입이 불가능 하오니 신중하게 진행 부탁 드립니다.</li>
    </ul>
     </dd>
     <dt>Q. 서비스를 사용하면서 궁금한 점은 어디에 물어보나요?</dt>
     <dd>
     <ul>
     <li>알감자 서비스 이용 시 불편한 점 또는 궁금한 점은 02-3482-4632으로 연락주시면 친절하게 답변드리겠습니다.</li>
     </ul>
     </dd>
	</dl>
		</div>
		<!-- //menu -->
	</div>
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</body>
</html>