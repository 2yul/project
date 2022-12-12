<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""  isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_navi.css"/><%-- 네비바 필요한 사람만 --%>
<link rel="stylesheet" type="text/css" href="css/mypages/my_info_edit.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
<c:if test="${updateInfoCnt eq 1 }">
	alert("정보가 성공적으로 수정되었습니다.");
	location.href="my_info_edit.do";
</c:if>

<c:if test="${updateInfoCnt eq 0 }">
	location.href="my_info_edit.do";
</c:if>


		$(function() {
			//사진등록 삭제버튼 클릭 시
			 $("#img_del_btn").click(function() {
				 deleteFile();
			});
			 $("#imgBtn").click(function(e) {
					e.preventDefault();
					$("#file").click
				});//click
				$("#imgBtn").click(function(e) {
					e.preventDefault();
					$("uploadBtn").click();
				});//click
			$(".edit_btn").click(function() {
				if(confirm("수정하시겠습니까?")){
					$("#MyInfoEditFrm").submit();
				}
			});//click
		});//ready
		
function readURL(input) {
	// alert("이미지");
		 if (input.files && input.files[0]) {
			 var reader = new FileReader();
			   reader.onload = function(e) {
					    document.getElementById('preview').src = e.target.result;
					    $("#imgChk").attr("value","N");
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
		
//전화번호 하이픈입력
const autoHyphen = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}

		function deleteFile() {
			//alert("삭제");
			 $("#preview").attr("src", "http://potato.sist.co.kr/css/images/basic.png");
			 $("#uploadBtn").val("");
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
<%-- 마이페이지용 --%>
<div class="wrap-navi">
		<div class="navi">
			<div class="profileWrap">
				<div class="img">
					<img src="http://potato.sist.co.kr/css/images/${ img }"  id="img" name="profileImg" class="img" style="margin: 5px 30px; width: 150px; height: 150px; background: #f8edeb; border-radius: 50%;">
				</div>
				<div class="nickname"><c:out value="${ nick }"/></div>
			</div>			
			<a class="navi-link" href="my_info_edit.do">내 정보 수정</a>
			<a class="navi-link2" href="password_edit.do">비밀번호 수정</a>
			<a class="navi-link2" href="unregister.do">회원탈퇴</a>
			<a class="navi-link" href="my_review.do">내가 쓴 리뷰</a>
			<a class="navi-link" href="like_review.do">좋아요한 리뷰</a>
			<a class="navi-link" href="bookmark.do">휴게소 즐겨찾기</a>
		</div><!-- navi -->
	

<%-- 네비바 끝 --%>

<!-- 내 정보 수정 -->
<div class="info_edit">
	<div class="title">내 정보 수정</div>
	<form action="my_info_edit_process.do" method="post" id="MyInfoEditFrm" enctype="multipart/form-data">
		<c:forEach var="mil" items="${ MyInfoList }">
	<table>
		<tr>
			<th scope="row">
				<label for="img">프로필 사진</label>
			</th>
			<td>
				<div class="profile_img">
					<img src="http://potato.sist.co.kr/css/images/${mil.img }"  id="preview" name="img" class="profileImg" style="margin: 5px 30px 5px 0; width: 70px; height: 70px; background: #f8edeb; border-radius: 50%;">
				<div class="upload-button">
					<input type="button" value="사진 등록" class="img_btn" id="imgBtn">
					<input type="file" name="upfile" id="uploadBtn" onchange="readURL(this)"/>
					<input type="button" value="삭제" class="img_del_btn" id="img_del_btn">
				</div><!-- upoad-button -->
				</div>
			</td>
		</tr>
		<tr>
			<th><label>성명</label></th>
			<td><input type="text" value="<c:out value="${ mil.name }"/>" id="name" readonly="readonly" style="background-color: #EEEEEE"></td>
		</tr>
		<tr>
			<th><label>닉네임</label></th>
			<td><input type="text" value="<c:out value="${ mil.nick }"/>" id="nick"  readonly="readonly" style="background-color: #EEEEEE"></td>
		</tr>
		<tr>
			<th><label>아이디</label></th>
			<td><input type="text" value="<c:out value="${ mil.id }"/>" id="id" readonly="readonly"style="background-color: #EEEEEE"></td>
		</tr>
		<tr>
			<th><label>생년월일</label></th>
				<td>
					<input type="date" name="birth" id="birth"  value="<c:out value="${ mil.birth }"/>"  class="birth" >
				</td>
		</tr>
		<tr>
			<th><label>휴대폰</label></th>
				<td>
					<input type="text" name="phone"  oninput="autoHyphen(this)" maxlength="13" value="<c:out value="${ mil.phone }"/>" >
				</td>
		</tr>
		<tr>
			<th><label>이메일</label></th>
			<td><input type="text"  value="<c:out value="${ mil.email }"/>" name="email" id="email" maxlength="100"></td>
		</tr>
	</table>
		</c:forEach>
</form>
	<button class="edit_btn">확인</button>



</div><!-- info_edit -->
</div><!-- wrap-navi -->

</div><!-- container 건들면 안돼 '0' -->
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>