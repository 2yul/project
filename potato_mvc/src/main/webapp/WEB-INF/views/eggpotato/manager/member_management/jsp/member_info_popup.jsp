<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainHome</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/m_common/manager_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/member_management/member_info_popup.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	//닫기 버튼 눌렀을 때
	$("#btn").click(function(){
		self.close();
	});
});


</script>
</head>
<body>
<div class="wrap">
<div class="title">회원정보 보기</div>

<div class="info-wrap">
		<div class="info">
			<label>아이디</label>
			<input type="text" value="${ memberData.id }" id="id" name="id" class="inputTxt" readonly="readonly"/>
		</div>
		<div class="info">
			<label>별명</label>
			<input type="text" value="${ memberData.nick }" id="name" name="name" class="inputTxt" readonly="readonly"/>
		</div>
		<div class="info">
			<label>생년월일</label>
			<input type="date" name="birth" id="birth" value="${ memberData.birth }" readonly="readonly"/>
		</div>
		<div class="info">
			<label>전화번호</label>
			<input type="text" name="phone" id="phone" value="${ memberData.phone }" class="inputTxt" readonly="readonly"/>
		</div>
		<div class="info">
			<label>이메일</label>
			<input type="text" name="email" id="email" value="${ memberData.email }" class="inputEmail" readonly="readonly"/>
		</div>
		<div class="info">
			<label>가입날짜</label>
			<input type="date" name="join_date" id="join_date" value="${ memberData.join_date }" readonly="readonly"/>
		</div>
	</div><!-- info-wrap -->
	
	<div class="infoBtn">
		<button type="button" class="closeBtn" id="btn">닫기</button>
	</div><!-- wrap end -->
</div>
</body>
</html>