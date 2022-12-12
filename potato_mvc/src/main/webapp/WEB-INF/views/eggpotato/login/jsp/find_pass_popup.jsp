<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 팝업창</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/login/find_pass_popup.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
function setLogin(){
	window.opener.moveLogin();
	window.close();
}
</script>

</head>
<body>
<div class="wrap">
	<!-- box-main -->
	<div class="box-main">
		
		<div class="box-title">비밀번호</div>
		<!-- main -->
		<div class="main-container">
			<input type="text" class="text-read" value="${ sessionScope.findPw }" readonly="readonly" ><br/>
			<input type="button" value="로그인" class="loginBtn" onclick="setLogin(); return false;">
		</div>
		<!-- //main -->
	</div>
	<!-- //box-main -->
</div>
<!-- container end -->
</body>
</html>