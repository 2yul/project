<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Popup</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/m_common/manager_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/home/manager_mainhome.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/rest_management/manager_rest_write_popup.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
<c:if test="${ requestScope.result eq 'success' }">
	alert("휴게소가 추가되었습니다!");
	self.close();
</c:if>


$(function(){
	
	//추가버튼 누를시 
	var foodCnt = 3;
	var contents = "<div class='food-info'><span><input type='button' class='round-blue-btn' value='사진첨부' /><input type='file' class='fileup2'/></span>";
	    contents += "<div class='food-detail'><div class='food-img-wrap'><img src='css/images/noImg.png' onerror=\"this.src='css/images/noImg.png'\"></div><div class='food-content'>";
	    contents +="<span><label>이름 : </label><input type='text' name='foodName' placeholder='음식명을 기입해주세요.'/></span><span><label>가격 : </label><input type='text' name='foodPrice' maxlength='6' placeholder='가격을 기입해주세요.'/></span>";
	    contents +="<span><span><label>설명 : </label></span><textarea placeholder='음식설명을 기입해주세요.' class='conts'></textarea><input type='hidden' name='foodConts'></span>";
	    contents +="<span><span><label>재료 : </label></span><textarea placeholder='재료를 기입해주세요.' class='ings'></textarea><input type='hidden' name='foodIng'></span>";
	    contents +="<span class='radioSpan'><label>대표메뉴</label><input type='radio' value='main' onclick='return(false)'/><label>추천메뉴</label><input type='radio' value='good'/><label>선택안함</label><input type='radio' value='soso' checked='checked'/></span></div></div></div>";
	$(".plus-btn").click(function(){
		if(foodCnt < 7) {
			++foodCnt;
			$(".appendBtn").before(contents);
			
			//생성된 후에도 순서정렬
			$(".radioSpan").each(function(i,span){
				$(span).children("input").attr("name","radio"+i);
			});
			
			$(".fileup2").each(function(i,file){
				$(this).attr("name","foodFile"+i);
			});
			
		} else {
			alert("음식은 8개까지만 입력가능합니다.");
		}
	});
	
	//빼기버튼 눌렀을 시
	$(".minus-btn").click(function(){
		if(foodCnt > 3) {
			$("[name='foodFile"+foodCnt+"']").parent().parent().remove();
			--foodCnt;
		} else {
			alert("음식은 기본 4개이상 있어야합니다");
		}
	})
	
	
	//사진등록 버튼 클릭했을 때
	$("#uploadBtn").on("change", function(){
		 previewFile(this);
	});
	
	//등록버튼눌렀을 때
	$("#insertBtn").click(function(){
		chkNull();
	});
	
	//사진올리기에 이름다르게명시
	$(".fileup2").each(function(i,file){
		$(this).attr("name","foodFile"+i);
	});
	
	//라디오 이름다르게 명시
	$(".radioSpan").each(function(i,span){
		$(span).children("input").attr("name","radio"+i);
	});
	
	
	 
});//ready

//////////////////////////////이미지관련 유효성///////////////////////////////////////////////////

//음식이미지선택시
$(document).on("change",".fileup2",function(){
	previewFoodFile(this,$(this));
}); 


//프로필사진 등록 미리보기 & 확장자 유효성
function previewFile(input) {
	if (input.files && input.files[0]) {
	   var reader = new FileReader();
	   reader.onload = function (e) {
	   $("#restProfile").attr('src', e.target.result);
	   }
	   reader.readAsDataURL(input.files[0]);
	} 
	
    if(!/\.(jpeg|jpg|png|gif|bmp|"")$/i.test(input.value)){ 
		alert('이미지 파일만 업로드 가능합니다.');
		input.value = ''; 
		input.focus(); 
	}
}

//음식사진 등록 미리보기 & 확장자 유효성
function previewFoodFile(input,obj) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
        obj.parent().next().children().children().attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    } 
   
	if(!/\.(jpeg|jpg|png|gif|bmp|"")$/i.test(input.value)){ 
	     alert('이미지 파일만 업로드 가능합니다.');
	     input.value = ''; 
	     input.focus();
	}
}

////////////////////////////////////////// 이미지 유효성 끝////////////////////////////////////////////////////



function chkNull(){
	
	//////////////////////////////////휴게소관련 유효성//////////////////////////////////////
	
 	//휴게소명
 	if($("#restName").val().trim().length < 1) {
		alert("휴게소명은 필수입력입니다.");
		$("#restName").focus();
		return;
	}
	
	//이미지여부
	if($("#uploadBtn").val().indexOf("fakepath") == -1) {
		alert("휴게소이미지를 추가해주세요");
		return;
	} 
	
	//위도 경도 입력 여부
	var lat = $("#lat").val().trim();
	var lng = $("#lng").val().trim();
	if(lat == "" || lng == "") {
		alert("위도, 경도를 입력해 주세요");
		$("#lat").focus();
		return;
	}
	
	//정수여부
	var numTest=  /^\d*[.]\d*$/;
	if(!numTest.test(lat) || !numTest.test(lng) || lat.indexOf(".") == 0 || lng.indexOf(".") == 0 ) {
		alert("위도 경도는 정수만 입력 가능합니다.");
		$("#lat").focus();
		return;
	}  
	
	//노선, 도 선택여부
	if($("#doSel").val() == 0 || $("#lineSel").val() == 0) {
		$("#doSel").focus();
		alert("위치정보는 필수 입력입니다.");
		return;
	}  else {
		$("#doIdx").val($("#doSel").val());
		$("#lineIdx").val($("#lineSel").val());
	}
	
	//전화번호 여부
	if($("#tel").val().trim() == "") {
		alert("전화번호는 필수입력입니다."); 
		$("#tel").focus()
		return;
	}  
	
	
	/////////////////////////////////////음식관련 유효성////////////////////////////////////////
	/////////////////////////each함수 내부에서 return을 해봐야 결국 다음요소를 실행한다, 외부에서 리턴하게만들어준다///////////////////////////
	
  	//음식이미지
 	var foodImgFlag=false;
 	$(".fileup2").each(function(i,img){
		var $img = $(img);
		if($img.val().indexOf("fakepath") == -1){
			foodImgFlag=true;
		}
	});
	if(foodImgFlag){
		alert("음식이미지는 필수입니다.");
		return;
	}
	
 	//음식이름
 	var foodNameFlag = false;
	$('[name="foodName"]').each(function(i,name){
		if($(name).val().trim() == "") {
			foodNameFlag = true;
			$(name).focus();
		}
	}); 
	if(foodNameFlag){
		alert("음식이름을 입력해주세요");
		return;
	} 
	
	//음식가격
	var foodPriceFlag = false;
	$('[name="foodPrice"]').each(function(i,price){
		var $price = $(price);
		var testPrice= /^[0-9]+$/;
		if($price.val().trim() == "" || !testPrice.test($price.val().trim()) ) {
			foodPriceFlag = true;
			$price.focus();
		}
	});   
	if(foodPriceFlag) {
		alert("가격을 숫자형태로 입력해 주세요");
		return;
	}
	
	//음식설명
	var foodContsFlag = false;
	$(".conts").each(function(i,conts){
		var $conts = $(conts);
		if($conts.val().trim() == "") {
			foodContsFlag = true;
			$conts.focus();
		} else {
			$conts.next().val($conts.val().trim());
		}
	}); 
	if(foodContsFlag) {
		alert("음식설명을 입력해주세요");
		return;
	} 
	
	
	//음식재료
	var foodIngsFlag = false;
	$(".ings").each(function(i,ings){
		var $ings = $(ings);
		if($ings.val().trim() == "") {
			foodIngsFlag = true;
			$ings.focus();
		} else {
			$ings.next().val($ings.val().trim());
		}
	});
	if(foodIngsFlag){
		alert("음식재료를 입력해주세요");
		return;
	}
	
	//추천메뉴가 하나도 없을 시
	var goodCnt = 0;
	$("[value='good']").each(function(i,radio){
		var $radio = $(radio);
		if($radio.is(":checked")) {
			++goodCnt;
		}
	});
	if(goodCnt < 1) {
		alert("추천메뉴는 1개이상 있어야합니다.");
		return;
	}
	
	
	$("#insertFrm").submit();
}

//전화번호 하이푼추가
const autoHyphen2 = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

</script>
</head>
<body>
<form id="insertFrm" method="post" enctype="multipart/form-data" action="manager_rest_add.do">
<div class="wrap">
	<div class="popup-wrap">
		<div class="rest-name">
			<div class="name">
				<span>휴게소 명</span>
				<input type="text" id="restName" name="restName" placeholder="휴게소명을 기입하세요."/> 
			</div>
			<div class="tumbnail">
				<img src="css/images/noImg.png" id="restProfile" onerror="this.src='css/images/noImg.png'"/>
				<div class="tumbnail-btn-wrap">
					<span>썸네일</span>
					<div>
						<div class="file-btn-wrap">
							<input type="button" class="round-blue-btn" value="등록">
							<input type="file" id="uploadBtn" name="upFile" class="fileup"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<p class="sep"/>
		<div class="rest-food">
			<div class="food-head">
				<span>음식</span>
			</div>
			<div class="food-info">
				<span>
					<input type="button" class="round-blue-btn" value="사진첨부" />
					<input type="file" class="fileup2"/>
				</span>
				<div class="food-detail">
					<div class="food-img-wrap">
						<img src="css/images/noImg.png" onerror="this.src='css/images/noImg.png'"/>
					</div>
					<div class="food-content">
						<span>
							<label>이름 : </label>
							<input type="text" name="foodName"  placeholder="음식명을 기입해주세요."/>
						</span>
						<span>
							<label>가격 : </label>
							<input type="text" name="foodPrice" maxlength="6" placeholder="가격을 기입해주세요."/>
						</span>
						<span>
							<span>
								<label>설명 : </label>
							</span>
							<textarea placeholder="음식설명을 기입해주세요." class="conts"></textarea>
							<input type="hidden" name="foodConts">
						</span>
						<span>
							<span>
								<label>재료 : </label>
							</span>
							<textarea placeholder="재료를 기입해주세요." class="ings"></textarea>
							<input type="hidden" name="foodIng">
						</span>
						<span class="radioSpan">
							<label>대표메뉴</label>
							<input type="radio"  value="main" checked="checked"/>
							<label>추천메뉴</label>
							<input type="radio"  value="good" onclick="return(false)"/>
							<label>선택안함</label>
							<input type="radio"  value="soso" onclick="return(false)"/>
						</span>
					</div>
				</div>
			</div>
			<div class="food-info">
				<span>
					<input type="button" class="round-blue-btn" value="사진첨부" />
					<input type="file" class="fileup2"/>
				</span>
				<div class="food-detail">
					<div class="food-img-wrap">
						<img src="css/images/noImg.png" onerror="this.src='css/images/noImg.png'"/>
					</div>
					<div class="food-content">
						<span>
							<label>이름 : </label>
							<input type="text" name="foodName" placeholder="음식명을 기입해주세요."/>
						</span>
						<span>
							<label>가격 : </label>
							<input type="text" name="foodPrice" maxlength="6" placeholder="가격을 기입해주세요."/>
						</span>
						<span>
							<span>
								<label>설명 : </label>
							</span>
							<textarea placeholder="음식설명을 기입해주세요." class="conts"></textarea>
							<input type="hidden" name="foodConts">
						</span>
						<span>
							<span>
								<label>재료 : </label>
							</span>
							<textarea placeholder="재료를 기입해주세요." class="ings"></textarea>
							<input type="hidden" name="foodIng">
						</span>
						<span class="radioSpan">
							<label>대표메뉴</label>
							<input type="radio" value="main" onclick="return(false)"/>
							<label>추천메뉴</label>
							<input type="radio" value="good"/>
							<label>선택안함</label>
							<input type="radio" value="soso" checked="checked"/>
						</span>
					</div>
				</div>
			</div>
			<div class="food-info">
				<span>
					<input type="button" class="round-blue-btn" value="사진첨부" />
					<input type="file" class="fileup2"/>
				</span>
				<div class="food-detail">
					<div class="food-img-wrap">
						<img src="css/images/noImg.png" onerror="this.src='css/images/noImg.png'"/>
					</div>
					<div class="food-content">
						<span>
							<label>이름 : </label>
							<input type="text" name="foodName" placeholder="음식명을 기입해주세요."/>
						</span>
						<span>
							<label>가격 : </label>
							<input type="text" name="foodPrice" maxlength="6" placeholder="가격을 기입해주세요."/>
						</span>
						<span>
							<span>
								<label>설명 : </label>
							</span>
							<textarea placeholder="음식설명을 기입해주세요." class="conts"></textarea>
							<input type="hidden" name="foodConts">
						</span>
						<span>
							<span>
								<label>재료 : </label>
							</span>
							<textarea placeholder="재료를 기입해주세요." class="ings"></textarea>
							<input type="hidden" name="foodIng">
						</span>
						<span class="radioSpan">
							<label>대표메뉴</label>
							<input type="radio" value="main" onclick="return(false)"/>
							<label>추천메뉴</label>
							<input type="radio" value="good"/>
							<label>선택안함</label>
							<input type="radio" value="soso" checked="checked"/>
						</span>
					</div>
				</div>
			</div>
			<div class="food-info">
				<span>
					<input type="button" class="round-blue-btn" value="사진첨부" />
					<input type="file" class="fileup2"/>
				</span>
				<div class="food-detail">
					<div class="food-img-wrap">
						<img src="http://potato.sist.co.kr/css/images/noImg.png" onerror="this.src='css/images/noImg.png'"/>
					</div>
					<div class="food-content">
						<span>
							<label>이름 : </label>
							<input type="text" name="foodName" placeholder="음식명을 기입해주세요."/>
						</span>
						<span>
							<label>가격 : </label>
							<input type="text" name="foodPrice" maxlength="6" placeholder="가격을 기입해주세요."/>
						</span>
						<span>
							<span>
								<label>설명 : </label>
							</span>
							<textarea placeholder="음식설명을 기입해주세요." class="conts"></textarea>
							<input type="hidden" name="foodConts">
						</span>
						<span>
							<span>
								<label>재료 : </label>
							</span>
							<textarea placeholder="재료를 기입해주세요." class="ings"></textarea>
							<input type="hidden" name="foodIng">
						</span>
						<span class="radioSpan">
							<label>대표메뉴</label>
							<input type="radio" value="main" onclick="return(false)"/>
							<label>추천메뉴</label>
							<input type="radio" value="good"/>
							<label>선택안함</label>
							<input type="radio" value="soso" checked="checked"/>
						</span>
					</div>
				</div>
			</div>
			<div class="appendBtn">
				<button type="button" class="plus-btn">+</button>
				<button type="button" class="minus-btn">-</button>
			</div>
		</div>
		<p class="sep"/>
		<div class="rest-info">
			<span>기본정보</span>
			<div class="info-wrap">
				<div>
					<span>
						<label>지도좌표 : </label>
					</span>
					<input type="text" id="lat" name="lat" placeholder="위도"/>
					<input type="text" id="lng" name="lng" placeholder="경도"/>
				</div>
				<div>
					<span>
						<label>위치 : </label>
					</span>
					
					<select id="doSel">
						<option value="0">----도----</option>
						<c:forEach var="krdo" items="${ doList }">
						<option value="${ krdo.do_idx }"><c:out value="${ krdo.kr_do }"/></option>
						</c:forEach>
					</select>
					<select id="lineSel">
						<option value="0">---노선---</option>
						<c:forEach var="line" items="${ lineList }">
						<option value="${ line.line_idx }"><c:out value="${ line.line }"/></option>
						</c:forEach>
					</select>
					<input type="hidden" id="doIdx" name="doIdx">					
					<input type="hidden" id="lineIdx" name="lineIdx">					
				</div>
				<div>
					<span>
						<label>전화번호 : </label>
					</span>
					<input type="text" id="tel" name="tel" oninput="autoHyphen2(this)" maxlength="13" placeholder="전화번호"/>
				</div>
				<div class="amenity-wrap">
					<span>편의시설<br>(휴게소)</span>
					<div class="icon-wrap">
						<div class="icon-sector">
							<span>
								<img src="css/images/sleep.png" ><span>수면실</span>
								<input type="checkbox" name="restIcons" value="sleep.png"/>
							</span>
							<span>
								<img src="css/images/shower.png" ><span>샤워실</span>
								<input type="checkbox" name="restIcons" value="shower.png"/>
							</span>
							<span>
								<img src="css/images/washing.png" ><span>세탁실</span>
								<input type="checkbox" name="restIcons" value="washing.png"/>
							</span>
							<span>
								<img src="css/images/rest.png" ><span>쉼터</span>
								<input type="checkbox" name="restIcons" value="rest.png"/>
							</span>
							<span>
								<img src="css/images/barber.png" ><span>이발소</span>
								<input type="checkbox" name="restIcons" value="barber.png"/>
							</span>
							<span>
								<img src="css/images/baby.png" ><span>수유실</span>
								<input type="checkbox" name="restIcons" value="baby.png"/>
							</span>
							<span>
								<img src="css/images/pharmacy.png" ><span>약국</span>
								<input type="checkbox" name="restIcons" value="pharmacy.png"/>
							</span>
							<span>
								<img src="css/images/market.png" ><span>농산물 판매</span>
								<input type="checkbox" name="restIcons" value="market.png"/>
							</span>
						</div>
					</div>
				</div>
				<div class="amenity-wrap">
					<span>편의시설<br>(주유소)</span>
					<div class="icon-wrap">
						<div class="icon-sector">
							<span>
								<img src="css/images/sleep.png" ><span>수면실</span>
								<input type="checkbox" name="gasIcons" value="sleep.png"/>
							</span>
							<span>
								<img src="css/images/shower.png" ><span>샤워실</span>
								<input type="checkbox" name="gasIcons" value="shower.png"/>
							</span>
							<span>
								<img src="css/images/washing.png" ><span>세탁실</span>
								<input type="checkbox" name="gasIcons" value="washing.png"/>
							</span>
							<span>
								<img src="css/images/rest.png" ><span>쉼터</span>
								<input type="checkbox" name="gasIcons" value="rest.png"/>
							</span>
							<span>
								<img src="css/images/barber.png" ><span>이발소</span>
								<input type="checkbox" name="gasIcons" value="barber.png"/>
							</span>
							<span>
								<img src="css/images/baby.png" ><span>수유실</span>
								<input type="checkbox" name="gasIcons" value="baby.png"/>
							</span>
							<span>
								<img src="css/images/pharmacy.png" ><span>약국</span>
								<input type="checkbox" name="gasIcons" value="pharmacy.png"/>
							</span>
							<span>
								<img src="css/images/market.png" ><span>농산물 판매</span>
								<input type="checkbox" name="gasIcons" value="market.png"/>
							</span>
						</div>
					</div>
				</div>
				<div class="chk-list">
					<label>세차장</label>
					<input type="checkbox" name="washChk" value="Y"/>	
					<label>경정비소</label>
					<input type="checkbox" name="repairChk" value="Y"/>
					<label>화물차라운지</label>
					<input type="checkbox" name="cargoChk" value="Y"/>		
				</div>
			</div>	
		</div>
		<div class="buttom">
			<button type="button" class="square-blue-btn" id="insertBtn">등록하기</button>
		</div>
	</div>
</div>
</form>
</body>
</html>