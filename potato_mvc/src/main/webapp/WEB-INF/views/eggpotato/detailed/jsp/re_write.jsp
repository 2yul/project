<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰작성</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/detailed/write.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
var file_Arr=[];
var index=0;
var tete;

$(function() {
	
	<c:forEach var="reImg" items="${mri }">
	var tete="<div class='review-img-wrap' id='riw-"+index+"'>"+
			"<img src='css/reviewImg/${reImg.img}' class='review-img' alt='리뷰사진'>"+
			"<a href='javascript:deleteImage("+index+");' class='img-a'>"+
			"<svg xmlns='http://www.w3.org/2000/svg' width='1' height='16' fill='currentColor' class='bi bi-x-square-fill' viewBox='0 0 16 16'>"+
			"<path d='M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z'/></svg></a></div>"
	index++;
	$(tete).appendTo(".photo-preview-wrap");
	file_Arr.push({name:"${reImg.img}", num:index-1});
	/* console.log(file_Arr) */
	</c:forEach>
	
	//사진파일클릭
	$("#filebtn").on("change", uploadFileImg);
	
})

function starRate(rate) {
 	switch(rate) {
		case 5: $(".rate-txt").addClass("rate-add"); $(".rate-txt").text("최고에요!"); break;
		case 4: $(".rate-txt").addClass("rate-add"); $(".rate-txt").text("좋아요"); break;
		case 3: $(".rate-txt").addClass("rate-add"); $(".rate-txt").text("보통이에요"); break;
		case 2: $(".rate-txt").addClass("rate-add"); $(".rate-txt").text("조금 아쉬워요"); break;
		case 1: $(".rate-txt").addClass("rate-add"); $(".rate-txt").text("별로에요!"); break;
	} 
}

function uploadFileImg(e) {
	
	var files = e.target.files; //이벤트가 일어난 대상=input file
	var fileArr= Array.prototype.slice.call(files);
	
	 //고유인덱스 부여
	fileArr.forEach(function(f) {
		if(!f.type.match("image/*")) { // 확장명 검사
			alert("이미지 파일을 선택해주세요.");
			return;
		}//end if 
		
		var previewAdd=new FileReader(); //파일 데이터 읽기
		previewAdd.onload=function(e) {
			
			var preimg=
				"<div class='review-img-wrap' id='riw-"+index+"'><img src='"+ e.target.result +"' data-file='"+ f.name +"' class='review-img' alt='리뷰사진'>"+
				"<a href='javascript:deleteImage("+index+");' class='img-a'><svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-x-square-fill' viewBox='0 0 16 16'>"+
			  	"<path d='M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z'/></svg></a></div>"
			$(preimg).appendTo(".photo-preview-wrap");
			index++;	 
			
			if($(".review-img-wrap").length > 6 ) {
				alert("이미지는 6개까지만 보여줄 수 있습니다.");	
				$(".review-img-wrap").last().remove(); // 화면에서 초과된 이미지 자동 삭제
				index--;
				deleteImage(index); // 데이터에 초과된 이미지정보 자동 삭제
				return;
			}
			
			file_Arr.push({name: f.name, num:index-1}); //배열에 담기
		}
		
		previewAdd.readAsDataURL(f); //데이터 url만들기 인코딩
		
	})
	
	var formData = new FormData(document.getElementById("writeFrm"));
			
			$.ajax({
				type:"post",
				enctype: "multipart/form-data",
				url:"ajax_img_upload.do",
				data: formData,
				processData: false,
				contentType: false,
				error: function(xhr) {
					alert(xhr.responseText),
					alert(xhr.statusText),
					console.log(xhr.status);
					alert("에러")
				},
				success: function(data) {
					/* console.log("성공"); */
				}
			
			})
		/* console.log(files);
		console.log(fileArr);
		console.log(file_Arr); */
}

function deleteImage(index) {
	
 	for(var i=0; i<file_Arr.length; i++) { //num이 일치하는 배열을 찾아서 삭제
		if(file_Arr[i].num==index) {
			file_Arr.splice(i, 1); //index에 해당하는 배열[index] 삭제
		}
	}
	
	var delImage="#riw-"+index;
	$(delImage).remove(); //선택 이미지 삭제
	console.log(file_Arr);
}

function okReview() {
	
	//별점 선택
	if($("input[name=ratingBtn]:checked").val()==undefined){
		alert("별점을 선택해주세요.");
		return;
	}
	
	var $rating=$('input:radio[name="ratingBtn"]:checked').val();
	$("#rating").val($rating);
	 
	//내용 입력
	if($(".review-txtarea").val().trim()==""){
		alert("휴게소가 어떠셨나요?");
		$(".review-txtarea").focus();
		return;
	}
	
	var comTxt=$(".review-txtarea").val().replace(/(?:\r\n|\r|\n)/g, "<br>");
	
	/* alert(comTxt); */
	$("#contents").val(comTxt);
	
	for(var i=0; i<file_Arr.length; i++) {
		var imghidden="<input type='hidden' name='img-"+i+"' value='"+file_Arr[i].name+"'>";
		$(imghidden).appendTo("#writeAllFrm");
	}
	
	$("#imglen").val(file_Arr.length);
	
	$("#writeAllFrm").submit();
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
	<div class="write-wrap">
		<div class="top">
			<button type="button" class="cancle-btn" onclick="javascript:history.back();">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
				  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
				</svg>
			</button>
			<span><c:out value="${mrw.name }"/></span>
			<button type="button" class="ok-btn" onclick="okReview();">완료</button>
		</div>
		
		<div class="write-box">
			<div class="wb-top">
				<div class="rate-wrap">
				  <input name="ratingBtn" type="radio" id="st1" value="5" onclick="starRate(5)" ${mrw.rating eq 5 ? 'checked="checked"':''}/>
				  <label for="st1">
				  	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
					  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
					</svg>
				  </label>
				  <input name="ratingBtn" type="radio" id="st2" value="4" onclick="starRate(4)" ${mrw.rating eq 4 ? 'checked="checked"':''}/>
				  <label for="st2">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
					  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
					</svg>			  
				  </label>
				  <input name="ratingBtn" type="radio" id="st3" value="3" onclick="starRate(3)" ${mrw.rating eq 3 ? 'checked="checked"':''}/>
				  <label for="st3">
				  	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
					  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
					</svg>
				  </label>
				  <input name="ratingBtn" type="radio" id="st4" value="2" onclick="starRate(2)" ${mrw.rating eq 2 ? 'checked="checked"':''}/>
				  <label for="st4">
				  	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
					  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
					</svg>
				  </label>
				  <input name="ratingBtn" type="radio" id="st5" value="1" onclick="starRate(1)" ${mrw.rating eq 1 ? 'checked="checked"':''}/>
				  <label for="st5">
				  	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
					  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
					</svg>				  
				  </label>
				</div>
				<div class="rate-txt">별점을 선택해주세요!</div>
			</div>
			
			<div class="wb-middle">
				<p class="wb-text">여기서 보여지는 이미지의 크기는 실제 리뷰에서 보여지는 이미지 크기와 동일합니다.</p>
				<div class="wbm-wrap">
					<div class="photo-add-wrap">
						<form id="writeFrm" method="post" enctype="multipart/form-data">
							<input type="file" name="img" id="filebtn" class="file-class" multiple="multiple" accept="image/*">
						</form>
						<label for="filebtn" class="file-add">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-images" viewBox="0 0 16 16">
							  <path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>
							  <path d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2zM14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1zM2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1h-10z"/>
							</svg>
						</label>
					</div>
					<div class="photo-preview-wrap">
						
					</div>
				</div>
			</div>
			<%
		   				pageContext.setAttribute("crcn", "\r\n");
		   				pageContext.setAttribute("br", "<br>");
		   	%>
			<div class="wb-bottom">
				<textarea rows="15" class="review-txtarea" placeholder="휴게소가 어떠셨나요?"><c:out value="${fn:replace(mrw.contents,br,crcn) }" escapeXml="false"/></textarea>
			</div>
			<form id="writeAllFrm" method="post" action="re_review_write.do">
				<input type="hidden" name="restarea_idx" id="restarea_idx" value="${param.restarea_idx }"/>
				<input type="hidden" name="review_idx" id="review_idx" value="${param.review_idx }"/>
				<input type="hidden" name="id" id="id" value="${id }"/>
				<input type="hidden" name="rating" id="rating" value="${param.rating }"/>
				<input type="hidden" name="contents" id="contents" value="${param.contents }"/>
				<input type="hidden" name="imglen" id="imglen" value="${param.imglen }"/>
			</form> 
		</div>
		
	</div>
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>