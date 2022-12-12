<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manager_login</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/m_common/manager_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/home/login.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#loginBtn").click(function(){
		//null 검사
		chkNull();
	});//click
});//ready

//null 검사
function chkNull(){
	if( $("#manager_id").val().trim() == "" ){
		alert("아이디를 입력하세요");
		$("#manager_id").val("");
		$("#manager_id").focus();
		return;
	}//end if
	if( $("#pass").val().trim() == "" ){
		alert("비밀번호를 입력하세요");
		$("#pass").val("");
		$("#pass").focus();
		return;
	}//end if
	
	var manager_id = $("#manager_id").val();
	var pass= $("#pass").val();
	$.ajax({
		type:"post",
		url:"managerlogin.do",
		data:{"manager_id":manager_id, "pass":pass},
		dataType:"json",
		error: function ( xhr ) {
			alert("로그인에 문제가 발생했습니다. 잠시 후 다시 시도해 주시기 바랍니다.");
			console.log( xhr.status );
		}, success: function( jsonObj ) {
			cnt=parseInt(jsonObj.cnt);
			if( cnt == 1 ) {
				location.href="mgr_home.do";
			} else{ 
				alert("아이디나 비밀번호가 틀렸습니다. 로그인에 실패하셨습니다.");
			}//end else
		}//success
	});//ajax
}//chkNull
</script>

</head>
<body>
<div class="wrap">

<!-- container -->
<div class="container">
		<!-- loginBox -->
		<div class="box-login">
			<div class="logo">
				<a href="user_mainhome.do"><img src="css/images/logo.png"></a>
			</div>
			<div class="login-top">관리자 로그인</div>
			<!-- main -->
			<div class="login-main">
				<form action="managerlogin.do" method="post" id="managerloginFrm">
				<input type="text" placeholder="아이디" class="id" id="manager_id" name="manager_id"><br/>
				<input type="password" placeholder="비밀번호" class="pass" id="pass" name="pass"><br/>
				<input type="button" value="로그인" class="loginBtn" id="loginBtn">
				</form>
			</div>
			<!-- //main -->
		</div>
		<!-- //loginBox -->
</div>
<!-- container end -->

</div>
</body>
</html>