<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 약관</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/login/service_check.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function popUp1() {
	
	//창 크기 지정
	var width = 600;
	var height = 600;
	
	//pc화면기준 가운데 정렬
	var left = (window.screen.width / 2) - (width/2);
	var top = (window.screen.height / 4);
	
    	//윈도우 속성 지정
	var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=no, status=yes, resizable=yes, titlebar=yes';
	
    	//연결하고싶은url
    	const url = "tos2.do";

	//등록된 url 및 window 속성 기준으로 팝업창을 연다.
	window.open(url, "알감자 약관사항", windowStatus);
}

function popUp2() {
	
	//창 크기 지정
	var width = 800;
	var height = 600;
	
	//pc화면기준 가운데 정렬
	var left = (window.screen.width / 2) - (width/2);
	var top = (window.screen.height / 4);
	
    	//윈도우 속성 지정
	var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=no, status=yes, resizable=yes, titlebar=yes';
	
    	//연결하고싶은url
    	const url = "tos1.do";

	//등록된 url 및 window 속성 기준으로 팝업창을 연다.
	window.open(url, "알감자 개인정보 수집 및 이용 동의", windowStatus);
}

$(function() {
	$("#chkAll").click(function() {
		if($("#chkAll").is(":checked")) {
			$("input[name=chk]").prop("checked", true);
		} else {
			$("input[name=chk]").prop("checked", false);
		}//end else
	});//click
	
	$("input[name=chk]").click(function() {
		var total=$("input[name=chk]").length;
		var checked=$("input[name=chk]:checked").length;
		
		if(total != checked) {
			$("#chkAll").prop("checked", false);
		} else {
			$("#chkAll").prop("checked", true);
		}//end else
	});//click
	
	$("#nextBtn").click(function() {
		if($("#chkAll").is(":checked")) {
			location.replace("signUp.do");
		} else {
			alert("[필수]서비스 약관을 동의해주세요.");
			$("input[name=chk]").prop("checked", false);
		}//end else
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
	<!-- box-main -->
	<div class="box-main">
		<div class="navigation_wrap">
			<div class="bar_navigation" style="width: 20%;">20%</div>
		</div>
		<h2 class="main-title">
		알감자
		<br>
		서비스 약관에 동의해 주세요.
		</h2>
		<!-- main -->
		<div class="main-container">
			<div class="check_all">
			<span class="check_wrap">
  				<input type="checkbox" id="chkAll"/>
  				<label class="text-s">모두 동의합니다.</label>
			</span>
			</div>
			<span class="line_or">
				::before
			</span>
			<div class="check_agree">
				<span class="form-check">
  				<input type="checkbox" name="chk"/>
  				<label class="text-s"><a href="javascript:popUp1()">[필수] 서비스 약관 동의</a></label>
				</span>
			<div class="interval"></div>
				<span class="form-check">
  				<input type="checkbox" name="chk"/>
  				<label class="text-s"><a href="javascript:popUp2()">[필수] 개인정보 수집 및 이용 동의</a></label>
				</span>
			</div>
			<input type="button" value="다음" class="nextBtn" id="nextBtn">
		</div>
		<!-- //main -->
	</div>
	<!-- //box-main -->
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>