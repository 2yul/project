<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/login/join.css"/>
<style type="text/css">
.id_ok{
color:#008000;
display: none;
}

.id_already{
color:#6A82FB; 
display: none;
}
.nick_ok{
color:#008000;
display: none;
}

.nick_already{
color:#6A82FB; 
display: none;
}

.phone_chk{
color:#008000;
display: none;
}

#keyShow {
  position: absolute;
  display: none;
  margin-left: -60px;
  margin-top: 24px;
  font-size: 13px;
  cursor: pointer;
  color: grey;
}

#keyShow2 {
  position: absolute;
  display: none;
  margin-left: -60px;
  margin-top: 24px;
  font-size: 13px;
  cursor: pointer;
  color: grey;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	$("#nextBtn").click(function(){
		//null 검사
		chkNull();
	});//click
	
	$("#pass").on("keyup", function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		    $("#checkKey").triggerHandler("click");
		  } else {
		    if (this.value) {
		      $("#keyShow").css("display", "inline-block");
		    } else {
		      $("#keyShow").hide();
		    }
		  }
		}).focus();

		$("#keyShow").on("click", function() {
		  if ($("#pass").attr("type") == "password") {
		    $("#pass").attr("type", "text");
		    $($(this)).text("H I D E");
		  } else {
		    $("#pass").attr("type", "password");
		    $($(this)).text("SHOW");
		  }
		});
		
	$("#passChk").on("keyup", function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		    $("#checkKey").triggerHandler("click");
		  } else {
		    if (this.value) {
		      $("#keyShow2").css("display", "inline-block");
		    } else {
		      $("#keyShow2").hide();
		    }
		  }
		}).focus();

		$("#keyShow2").on("click", function() {
		  if ($("#passChk").attr("type") == "password") {
		    $("#passChk").attr("type", "text");
		    $($(this)).text("H I D E");
		  } else {
		    $("#passChk").attr("type", "password");
		    $($(this)).text("SHOW");
		  }
		});
});//ready

//null 검사
function chkNull(){
	if( $("#id").val().trim() == "" ){
		alert("아이디를 입력하세요");
		$("#id").val("");
		$("#id").focus();
		return;
	} else {
			var idChk = $("#id").val(); 
			var regExp = /^[a-z]+[a-z0-9]{5,19}$/g;
		 
			if( !regExp.test(idChk) ) {
				alert("영문자로 시작하는 영문자 또는 숫자 6~20자로 아이디를 입력해주세요.");
				return;
			}
	}
	
	if( $("#idChk").attr("value") == "N" ){
		alert("사용 중인 아이디이거나 아이디 중복검사가 완료되지 않았습니다");
		$("#id").focus();
		return;
	}
	
	//비밀번호 필수 입력
	if( $("#pass").val().trim() == "" ){
		alert("비밀번호를 입력하세요");
		$("#pass").val("");
		$("#pass").focus();
		return;
	}
	//이름 필수 입력	
	if($("#name").val().trim()=="") {
			alert("이름을 입력하세요");
			$("#name").focus();
			return;
	}
		
	//별명 필수 입력	
	if($("#nick").val().trim()=="") {
			alert("별명을 입력하세요");
			$("#nick").focus();
			return;
	}//end if
	
	//8~20자의 영문,숫자, 특수문자를 혼합하여 입력
	var pw = $("#pass").val();
	 var num = pw.search(/[0-9]/g);
	 var eng = pw.search(/[a-z]/ig);
	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

	 if(pw.length < 8 || pw.length > 20){

	  alert("비밀번호를 8자리 ~ 20자리 이내로 입력해주세요.");
	  $("#pass").focus();
	  return false;
	 }else if(pw.search(/\s/) != -1){
	  alert("비밀번호는 공백 없이 입력해주세요.");
	  $("#pass").focus();
	  return false;
	 }else if(num < 0 || eng < 0 || spe < 0 ){
	  alert("비밀번호를 영문,숫자, 특수문자를 혼합하여 입력해주세요.");
	  $("#pass").focus();
	  return false;
	 }else {
		console.log("통과"); 
	 }
	 
	//비밀번호확인 필수 입력	
	if($("#passChk").val().trim() !== $("#pass").val().trim()) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#passChk").focus();
		return;
	}
	
	
 	if( $("#NickChk").attr("value") == "N" ){
		alert("사용 중인 닉네임이거나 닉네임 중복검사가 완료되지 않았습니다");
		$("#nick").focus();
		return;
	}
 	
 	//생년 필수 입력	
	if($("#year").val().trim()=="") {
		alert("생년을 입력하세요");
		$("#year").focus();
		return;
	}
 	
 	//년도 범위 제한
 	let date= new Date();
 	var maxYear= parseInt(date.getFullYear());
 	var minYear= 1900
 	var numYear = parseInt($("#year").val());
 	if( numYear < minYear || numYear > maxYear ){
 		alert("년도는 1900~"+maxYear+"년까지 입력가능합니다.");
		$("#year").focus();
		return;
 	}
 	
	//이메일 필수 입력	및 정규식
 	if($("#email").val().trim()=="") {
		alert("이메일을 입력하세요");
		$("#email").focus();
		return;
	} else {
 	var emailVal = $("#email").val();
 	let regex = new RegExp("([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\"\(\[\]!#-[^-~ \t]|(\\[\t -~]))+\")@([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\[[\t -Z^-~]*])");
		if( !regex.test(emailVal) ){
			alert("이메일 형식에 맞게 입력해주세요");
			return;
		}
	}
 	
	//번호 필수 입력	
	if($("#phone").val().trim()=="") {
		alert("휴대폰번호를 입력하세요");
		$("#phone").focus();
		return;
	}
	
	//번호 유효성
	if ($("#phone").val().length <= 11) {
		alert("전화번호를 정확히 입력해주세요");	
	return;
	}
	
	$("#joinFrm").submit();
}//chkNull

const autoNum = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '');
}

//전화번호 하이픈입력
const autoHyphen = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
	 
	 $("#phone_chk").css("display","inline-block");
	 if( target.value.length == 10 ) {
		 $("#phone_chk").css("display", "none");
	 }
}

//공백사용못하게
function noSpaceForm(obj) { 
    var str_space = /\s/;  // 공백체크
    if(str_space.exec(obj.value)) { //공백 체크
        alert("해당 항목에는 공백을 사용할수 없습니다.");
        obj.focus();
        obj.value = obj.value.replace(' ',''); // 공백제거
        return false;
    }
}

function checkId(){
    var id = $('#id').val(); //id값이 "id"인 입력란의 값을 저장
    $.ajax({
        url:"duplChkId.do", //Controller에서 요청 받을 주소
        type:"post", //POST 방식으로 전달
        data:{id:id},
        dataType: "json",
        error( xhr ) {
        	alert("에러입니다");
        	console.log(xhr.status);
        }, success:function( jsonObj ) { //컨트롤러에서 넘어온 cnt값을 받는다
        	var num=parseInt(jsonObj.idCnt);
            if(num == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                $("#id_ok").css("display","inline-block"); 
                $("#id_already").css("display", "none");
                $("#idChk").attr("value", "Y");
            } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                $("#id_already").css("display","inline-block");
                $("#id_ok").css("display", "none");
                alert("중복된 아이디입니다.");
                $("#idChk").attr("value", "N");
            }
        },
    
    });//ajax
    };//checkId
    
function checkNick(){
    var nick = $('#nick').val(); //id값이 "id"인 입력란의 값을 저장
    $.ajax({
        url:"duplChkNick.do", //Controller에서 요청 받을 주소
        type:"post", //POST 방식으로 전달
        data:{nick:nick},
        dataType: "json",
        error( xhr ) {
        	alert("에러입니다");
        	console.log(xhr.status);
        }, success:function( jsonObj ) { //컨트롤러에서 넘어온 cnt값을 받는다
        	var num=parseInt(jsonObj.nickCnt);
            if(num == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                $("#nick_ok").css("display","inline-block"); 
                $("#nick_already").css("display", "none");
                $("#NickChk").attr("value", "Y");
            } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                $("#nick_already").css("display","inline-block");
                $("#nick_ok").css("display", "none");
                alert("중복된 닉네임입니다");
                $("#NickChk").attr("value", "N");
            }
        },
    });//ajax
    };//checkId
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
			<div class="bar_navigation" style="width: 50%;">20%</div>
		</div>
		<!-- main -->
		<div class="main-container">
		<form action="signUp2.do" method="post" id="joinFrm">
			<h2 class="input-title">아이디</h2>
			<input type="text" placeholder="아이디" class="id" name="id" id="id" oninput = "checkId()" maxlength="20">
			<input type="hidden" name="idChk" id="idChk" value="N">
			<!-- id ajax 중복체크 -->
			<span class="id_ok" id="id_ok">사용 가능한 아이디입니다.</span>
			<span class="id_already" id="id_already">누군가 이 아이디를 사용하고 있어요.</span>
			<h2 class="input-title">비밀번호</h2>
			<input type="password" placeholder="비밀번호" class="pass" name="pass" id="pass" maxlength="20">
			<div id="keyShow">SHOW</div><br/>
			<h2 class="input-title">비밀번호 재확인</h2>
			<input type="password" placeholder="비밀번호 재확인" class="pass" name="passChk" id="passChk" maxlength="20">
			<div id="keyShow2">SHOW</div><br/>
			<h2 class="input-title">이름</h2>
			<input type="text" placeholder="이름" class="text-join" name="name" id="name" maxlength="20"><br/>
			<h2 class="input-title">별명</h2>
			<input type="text" placeholder="별명" class="text-join" name="nick" id="nick" oninput = "checkNick()" maxlength="20"><br/>
			<input type="hidden" name="NickChk" id="NickChk" value="N">
			<span class="nick_ok" id="nick_ok">사용 가능한 닉네임입니다.</span>
			<span class="nick_already" id="nick_already">누군가 이 닉네임를 사용하고 있어요.</span>
			<h2 class="input-title">생년월일</h2>
			<input type="text" placeholder="년(4자)" class="text-year" name="year" id="year" maxlength="4" oninput="autoNum(this)">
			<select class="text-year" name="month" id="month">
			<c:forEach var="i" begin="1" end="12">
				<option value="${ i }">${ i }월</option>
			</c:forEach>
			</select>
			<select class="text-year" name="day" id="day">
			<c:forEach var="i" begin="1" end="31">
				<option value="${ i }">${ i }일</option>
			</c:forEach>
			</select>
			<h2 class="input-title">이메일</h2>
			<input type="text" placeholder="이메일" class="text-join" name="email" id="email" maxlength="50" onkeyup="noSpaceForm(this)"><br/>
			<h2 class="input-title">휴대전화</h2>
			<input type="text" placeholder="전화번호 입력" class="text-join" name="phone" id="phone" oninput="autoHyphen(this)" maxlength="13"><br/>
			<span class="phone_chk" id="phone_chk"> 01012345678 식으로 입력해주시면 됩니다. </span>
			<input type="button" value="다음" class="nextBtn" id="nextBtn">
		</form>
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