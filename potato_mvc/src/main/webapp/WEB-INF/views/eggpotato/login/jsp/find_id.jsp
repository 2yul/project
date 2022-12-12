<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/login/find_id.css"/>
<style type="text/css">
.birth_chk{
color:#008000;
display: none;
}

.phone_chk{
color:#008000;
display: none;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#findBtn").click(function() {
		chkNull();
	});
});

function chkNull() {
	if( $("#name").val().trim() == "" ){
		alert("이름을 입력하세요");
		$("#name").val("");
		$("#name").focus();
		return;
	}//end if
	
	if( $("#birth").val().trim() == "" ){
		alert("생년월일을 입력하세요");
		$("#birth").val("");
		$("#birth").focus();
		return;
	}//end if
	
	if( $("#phone").val().trim() == "" ){
		alert("전화번호를 입력하세요");
		$("#phone").val("");
		$("#phone").focus();
		return;
	}//end if
	
	var name= $("#name").val();
	var birth= $("#birth").val();
	var phone= $("#phone").val();
	$.ajax({
		type:"post",
		url:"forgotIdChk.do",
		data:{"name":name, "birth":birth, "phone":phone},
		dataType:"json",
		error: function ( xhr ) {
			alert("아이디 찾기에 문제가 발생했습니다. 잠시 후 다시 시도해 주시기 바랍니다.");
			console.log( xhr.status );
		}, success: function( jsonObj ) {
			if( jsonObj.id !="" && jsonObj.id != null ) {
				window.open("forgotIdPop.do", "아이디 찾기", "width=350,height=320,top=220,left=700");
			} else{ 
				alert("입력하신 정보로 조회된 아이디가 없습니다. 다시 입력해주세요.");
			}//end else
				
		}//success
	});//ajax
}

function moveLogin(){
	location.href="login_page.do";
}
function moveFind() {
	location.href="forgotPw.do";
}

//전화번호 하이픈입력
const autoHyphen = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
	 
	 $("#phone_chk").css("display","inline-block");
	 if( target.value.length == 13 ) {
		 $("#phone_chk").css("display", "none");
	 }
}

//생년월일 하이픈입력
const autoBirth = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	   .replace(/^(\d{3,4})(\d{1,2})(\d{2})$/, `$1-$2-$3`);
	 
	 $("#birth_chk").css("display","inline-block");
	 if( target.value.length == 10 ) {
		 $("#birth_chk").css("display", "none");
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
	<!-- box-main -->
	<div class="box-main">
		
		<div class="box-title">아이디 찾기</div>
		
		<!-- main -->
		<div class="main-container">
			<form action="forgotIdChk.do" method="post" id="forgotIdFrm">
			<h2 class="input-title">이름</h2>
			<input type="text" placeholder="이름" class="text-box" name="name" id="name" maxlength="20"><br/>
			<h2 class="input-title">생년월일</h2>
			<input type="text" placeholder="생년월일" class="text-box" name="birth" id="birth" oninput="autoBirth(this)" maxlength="10"><br/>
			<span class="birth_chk" id="birth_chk">생년월일 19990101 식으로 입력해주시면 됩니다. </span>
			<h2 class="input-title">휴대전화</h2>
			<input type="text" placeholder="전화번호 입력" class="text-box" name="phone" id="phone" oninput="autoHyphen(this)" maxlength="13"><br/>
			<span class="phone_chk" id="phone_chk"> 01012345678 식으로 입력해주시면 됩니다. </span>
			</form>
			<input type="button" value="아이디 찾기" class="findBtn" id="findBtn">
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