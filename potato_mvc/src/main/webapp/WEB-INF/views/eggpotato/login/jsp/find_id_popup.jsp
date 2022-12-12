<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 팝업창</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/login/find_id_popup.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function setLogin(){
	window.opener.moveLogin();
	window.close();
}
function setFind() {
	window.opener.moveFind();
	window.close();
}
</script>

</head>
<body>
<div class="wrap">
	<!-- box-main -->
	<div class="box-main">
		
		<div class="box-title">아이디</div>
		<!-- main -->
		<div class="main-container">
			<input type="text" class="text-read" value="${ sessionScope.findId }" readonly="readonly"><br/>
			<input type="button" value="로그인" class="loginBtn" onclick="setLogin(); return false;">
			<span class="line_or">
				::before
				<span class="txt_or">또는</span>
				::after
			</span>
			<input type="button" value="비밀번호 찾기" class="findBtn" onclick="setFind(); return false;">
		</div>
		<!-- //main -->
	</div>
	<!-- //box-main -->
</div>
</body>
</html>