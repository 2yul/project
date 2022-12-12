<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/login/join_img.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	//사진등록 삭제버튼 클릭 시
	 $("#deleteBtn").click(function() {
		 deleteFile();
	});
	 $("#joinBtn").click(function(){
			//null 검사
			chkNull();
		});//click
	$("#imgBtn").click(function(e) {
		e.preventDefault();
		$("#file").click
	});//click
	$("#imgBtn").click(function(e) {
		e.preventDefault();
		$("uploadBtn").click();
	});//click
		
});//ready

function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('preview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
		  
	    document.getElementById('preview').src = "";
	  }
	  if(!/\.(jpeg|jpg|png|gif|bmp)$/i.test(input.value)){ 

	        alert('이미지 파일만 업로드 가능합니다.'); 

	        input.value = ''; 

	        input.focus(); 
	        return;
	    }
	}
function deleteFile() {
 	$("#preview").attr("src", "css/images/basic.png");
 	$("#uploadBtn").val("");
}

//null 검사
function chkNull(){
	$("#joinFrm").submit();
}//chkNull
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
			<div class="bar_navigation" style="width: 80%;">20%</div>
		</div>
		<!-- main -->
		<div class="main-container">
			<form action="signUp3.do" method="post" id="joinFrm" enctype="multipart/form-data">
			<h2 class="main-title">프로필 사진</h2><br/>
			<img src="css/images/basic.png" class="main-profile" id="preview"/><br/>
			<input type="file" name="upfile" id="uploadBtn" onchange="readURL(this);"/>
			<label for="uploadBtn" class="imgupBtn">사진등록</label>
			<input type="button" value="삭제" class="imgBtn" id="deleteBtn">
			<input type="button" value="가입하기" class="joinBtn" id="joinBtn">
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