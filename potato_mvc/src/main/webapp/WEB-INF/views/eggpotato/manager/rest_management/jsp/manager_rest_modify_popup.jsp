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
<link rel="stylesheet" type="text/css" href="css/manager/rest_management/manager_rest_modify_popup.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
<c:if test="${ result eq 'success' }">
alert("휴게소가 수정되었습니다!");
self.close();
</c:if>

$(function(){
	
	//기존 음식 개수 불러오기
	<c:set var="size" value="${ fn:length(food)}"/>
	var foodCnt = ${size} - 1;
	
	//반복될 음식추가영역
	var contents ="<div class='food-info'><span><input type='button' class='round-blue-btn' value='사진첨부' /><input type='file' class='fileup2'/></span>";
	    contents += "<div class='food-detail'><input type='hidden' name='food_idx'><div class='food-img-wrap'><img src='css/images/noImg.png' onerror=\"this.src='css/images/noImg.png'\"></div><div class='food-content'>";
	    contents +="<span><label>이름 : </label><input type='text' name='foodName' placeholder='음식명을 기입해주세요.'/></span><span class='priceSpan'><label>가격 : </label><input type='text' name='foodPrice' maxlength='6' placeholder='가격을 기입해주세요.'/></span>";
	    contents +="<span class='contSpan'><span><label>설명 : </label></span><textarea placeholder='음식설명을 기입해주세요.' class='conts'></textarea></span>";
	    contents +="<span class='ingSpan'><span><label>재료 : </label></span><textarea placeholder='재료를 기입해주세요.' class='ings'></textarea></span>";
	    contents +="<span class='radioSpan'><label>대표메뉴</label><input type='radio' value='main' onclick='return(false)'/><label>추천메뉴</label><input type='radio' value='good'/><label>선택안함</label><input type='radio' value='soso' checked='checked'/></span></div><div><input type='button' class='round-blue-btn' value='음식수정' name='foodChgBtn'></div></div></div>";
	    
	    //플러스 버튼눌렀을 시
	    $(".plus-btn").click(function(){
			if(foodCnt < 7) {
				++foodCnt;
				$(".appendBtn").before(contents);
				
				//사진올리기에 이름다르게명시
				$(".fileup2").each(function(i,file){
					$(this).attr("name","foodFile"+i);
				});
				
				//라디오 이름다르게 명시
				$(".radioSpan").each(function(i,span){
					$(span).children("input").attr("name","radio"+i);
				});
				
				//음식인데스 순서대로 생성
				$("[name='food_idx']").each(function(i,idx){
					$(idx).attr("value",i+1);
				});
				
			} else {
				alert("음식은 8개까지만 입력가능합니다.");
			}
		});
	    
	  	//빼기버튼 눌렀을 시
		$(".minus-btn").click(function(){
			if(foodCnt > 3) {
				var rIdx = ${ rest.restarea_idx };
				var fIdx = foodCnt+1
				$.ajax({
					type:"post",
					url:"ajax_food_delete.do",
					data:{restarea_idx:rIdx,food_idx:fIdx},
					dataType:"text",
					error: function(xhr) {
						alert("음식삭제 과정에서 문제가 발생했습니다.")
					},
					success: function(data) {
						/* console.log("성공"); */
					}
				});
				$("[name='foodFile"+foodCnt+"']").parent().parent().remove();
				--foodCnt;
			} else {
				alert("음식은 기본 4개이상 있어야합니다");
			}
		})
	    
	    
	//휴게소사진등록 버튼 클릭했을 때
	$("#uploadBtn").on("change", function(){
		 previewFile(this);
	});
	
	//수정버튼눌렀을 때
	$("#updateBtn").click(function(){
		if(confirm("주의 : 음식정보는 수정버튼을 누르지 않을 경우 반영되지 않습니다. 수정하시겠습니까?")){
			chkNull();
		}
	});
	
	//사진올리기에 이름다르게명시
	$(".fileup2").each(function(i,file){
		$(this).attr("name","foodFile"+i);
	});
	
	//라디오 이름다르게 명시
	$(".radioSpan").each(function(i,span){
		$(span).children("input").attr("name","radio"+i);
	});
	
	//음식인데스 순서대로 생성
	$("[name='food_idx']").each(function(i,idx){
		$(idx).attr("value",i+1);
	});
	
});//ready

//음식이미지선택시
$(document).on("change",".fileup2",function(){
	if(previewFoodFile(this,$(this))){
		return;
	}
	
 	var restIdx = ${ rest.restarea_idx };
	var foodIdx = $(this).parent().next().children("[name='food_idx']").val()
	
	var form = new FormData();
    form.append( "upFile", $(this)[0].files[0] );
    form.append( "restarea_idx", restIdx );
    form.append( "food_idx", foodIdx );
    
	$.ajax({
		type:"post",
		url:"ajax_foodImg_update.do",
		data:form,
		processData: false,
		contentType: false,
		dataType:"text",
		error: function(xhr) {
			alert("이미지 업로드 과정에서 문제가 발생했습니다.")
		},
		success: function(data) {
			/* console.log("성공"); */
		}
	}); 
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
	var returnFlag = false;
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
	     returnFlag = true;
	}
	return returnFlag;
}


//음식수정 눌렀을 시
$(document).on("click","[name='foodChgBtn']",function(){
		if(confirm("수정사항을 적용하시겠습니까?")){
			var rIdx = ${rest. restarea_idx};
			var fIdx = $(this).parent().prev().prev().prev().val();
			
			var name = $(this).parent().prev().children().children("input").val();
			if(name.trim()==""){
				alert("이름은 필수입니다");
				return;
			}
			
			var testPrice= /^[0-9]+$/;
			var price = $(this).parent().prev().children(".priceSpan").children("input").val();
			if(price.trim()=="" ||  !testPrice.test(price.trim()) ) {
				alert("가격을 숫자형태로 입력해주세요");
				return;
			}
			
			var contents = $(this).parent().prev().children(".contSpan").children("textarea").val();
			if(contents.trim() == ""){
				alert("음식설명을 입력해주세요");
				return;
			}
			
			var ingredient = $(this).parent().prev().children(".ingSpan").children("textarea").val();
			if(ingredient.trim() == "") {
				alert("음식재료를 입력해주세요");
				return;
			}
			
			var radioChk =  $("input[name='radio"+(fIdx-1)+"']:checked").val();
			
			$.ajax({
				type:"post",
				url:"ajax_foodInfo_update.do",
				data:{restarea_idx:rIdx,food_idx:fIdx,name:name,price:price,contents:contents,ingredient:ingredient,radioChk:radioChk},
				dataType:"text",
				error: function(xhr) {
					alert("수정과정에서 문제가 발생했습니다.")
				},
				success: function(data) {
					 console.log("성공"); 
				}
			});  
		}
});


//전화번호하이푼
const autoHyphen2 = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

function chkNull(){
	
	//////////////////////////////////휴게소관련 유효성//////////////////////////////////////
	
 	//휴게소명
 	if($("#restName").val().trim().length < 1) {
		alert("휴게소명은 필수입력입니다.");
		$("#restName").focus();
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
		var checkImg = $img.parent().next().children(".food-img-wrap").children().attr("src");
		if(checkImg.endsWith("noImg.png")) {
			foodImgFlag = true;
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
	
	
	
	$("#modiFrm").submit();
}

</script>
</head>
<body>
<form id="modiFrm" method="post" enctype="multipart/form-data" action="manager_rest_modify.do">
<input type="hidden" name="restarea_idx" value="${ rest.restarea_idx }">
<div class="wrap">
	<div class="popup-wrap">
		<div class="rest-name">
			<div class="name">
				<span>휴게소 명</span>
				<input type="text" id="restName" name="restName" placeholder="휴게소명을 기입하세요." value="${ rest.name }"/> 
			</div>
			<div class="tumbnail">
				<img src="css/images/${ rest.img }" id="restProfile" onerror="this.src='css/images/${ rest.img }'">
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
			<c:forEach var="food" items="${ food }">
			<div class="food-info">
				<span>
					<input type="button" class="round-blue-btn" value="사진첨부" />
					<input type="file" class="fileup2"/>
				</span>
				<div class="food-detail">
					<input type="hidden" name="food_idx">
					<div class="food-img-wrap">
						<img src="http://potato.sist.co.kr/css/images/${food.img}" onerror="this.src='css/images/${food.img}'"/>
					</div>
					<div class="food-content">
						<span>
							<label>이름 : </label>
							<input type="text" name="foodName" placeholder="음식명을 기입해주세요." value="${ food.name }"/>
						</span>
						<span class="priceSpan">
							<label>가격 : </label>
							<input type="text" name="foodPrice" maxlength="6" placeholder="가격을 기입해주세요." value="${ food.price }"/>
						</span>
						<span class="contSpan">
							<span>
								<label>설명 : </label>
							</span>
							<textarea placeholder="음식설명을 기입해주세요." class="conts"><c:out value="${ food.contents }"/></textarea>
						</span>
						<span class="ingSpan">
							<span >
								<label>재료 : </label>
							</span>
							<textarea placeholder="재료를 기입해주세요." class="ings"><c:out value="${ food.ingredient }"/></textarea>
						</span>
						<span class="radioSpan">
							<label>대표메뉴</label>
							<input type="radio" value="main"${ food.main_chk eq 'Y' ?" checked='checked'" : "" }${ food.main_chk eq 'N' ?" onclick='return(false)'" : "" }/>
							<label>추천메뉴</label>
							<input type="radio" value="good"${ food.rec_chk eq 'Y' ?" checked='checked'" : "" }${ food.main_chk eq 'Y' ?" onclick='return(false)'" : "" }/>
							<label>선택안함</label>
							<input type="radio" value="soso"${ food.main_chk ne 'Y' and food.rec_chk ne 'Y'  ?" checked='checked'" : "" }${ food.main_chk eq 'Y' ?" onclick='return(false)'" : "" }/>
						</span>
					</div>
					<div>
						<input type="button" class="round-blue-btn" value="음식수정" name="foodChgBtn">
					</div>
				</div>
			</div>
			</c:forEach>
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
					<input type="text" id="lat" name="lat" placeholder="위도" value="${ rest.lat }"/>
					<input type="text" id="lng" name="lng" placeholder="경도" value="${ rest.lng }"/>
				</div>
				<div>
					<span>
						<label>위치 : </label>
					</span>
					
					<select id="doSel">
						<option value="0">----도----</option>
						<c:forEach var="krdo" items="${ doList }">
						<option value="${ krdo.do_idx }"${ krdo.do_idx eq rest.do_idx ?" selected='selected'" : "" }><c:out value="${ krdo.kr_do }"/></option>
						</c:forEach>
					</select>
					<select id="lineSel">
						<option value="0">---노선---</option>
						<c:forEach var="line" items="${ lineList }">
						<option value="${ line.line_idx }"${ line.line_idx eq rest.line_idx ?" selected='selected'" : "" }><c:out value="${ line.line }"/></option>
						</c:forEach>
					</select>
					<input type="hidden" id="doIdx" name="doIdx">					
					<input type="hidden" id="lineIdx" name="lineIdx">					
				</div>
				<div>
					<span>
						<label>전화번호 : </label>
					</span>
					<input type="text" id="tel" name="tel" oninput="autoHyphen2(this)" maxlength="13" placeholder="전화번호" value="${rest.tel}"/>
				</div>
				<div class="amenity-wrap">
					<span>편의시설<br>(휴게소)</span>
					<div class="icon-wrap">
						<div class="icon-sector">
							<span>
								<img src="css/images/sleep.png" ><span>수면실</span>
								<input type="checkbox" name="restIcons" value="sleep.png"${ fn:contains(rest.retAmImgs,'sleep.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/shower.png" ><span>샤워실</span>
								<input type="checkbox" name="restIcons" value="shower.png"${ fn:contains(rest.retAmImgs,'shower.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/washing.png" ><span>세탁실</span>
								<input type="checkbox" name="restIcons" value="washing.png"${ fn:contains(rest.retAmImgs,'washing.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/rest.png" ><span>쉼터</span>
								<input type="checkbox" name="restIcons" value="rest.png"${ fn:contains(rest.retAmImgs,'rest.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/barber.png" ><span>이발소</span>
								<input type="checkbox" name="restIcons" value="barber.png"${ fn:contains(rest.retAmImgs,'barber.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/baby.png" ><span>수유실</span>
								<input type="checkbox" name="restIcons" value="baby.png"${ fn:contains(rest.retAmImgs,'baby.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/pharmacy.png" ><span>약국</span>
								<input type="checkbox" name="restIcons" value="pharmacy.png"${ fn:contains(rest.retAmImgs,'pharmacy.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/market.png" ><span>농산물 판매</span>
								<input type="checkbox" name="restIcons" value="market.png"${ fn:contains(rest.retAmImgs,'pharmacy.png') ?" checked='checked'" : "" }/>
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
								<input type="checkbox" name="gasIcons" value="sleep.png"${ fn:contains(rest.gasAmImgs,'sleep.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/shower.png" ><span>샤워실</span>
								<input type="checkbox" name="gasIcons" value="shower.png"${ fn:contains(rest.gasAmImgs,'shower.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/washing.png" ><span>세탁실</span>
								<input type="checkbox" name="gasIcons" value="washing.png"${ fn:contains(rest.gasAmImgs,'washing.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/rest.png" ><span>쉼터</span>
								<input type="checkbox" name="gasIcons" value="rest.png"${ fn:contains(rest.gasAmImgs,'rest.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/barber.png" ><span>이발소</span>
								<input type="checkbox" name="gasIcons" value="barber.png"${ fn:contains(rest.gasAmImgs,'barber.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/baby.png" ><span>수유실</span>
								<input type="checkbox" name="gasIcons" value="baby.png"${ fn:contains(rest.gasAmImgs,'baby.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/pharmacy.png" ><span>약국</span>
								<input type="checkbox" name="gasIcons" value="pharmacy.png"${ fn:contains(rest.gasAmImgs,'pharmacy.png') ?" checked='checked'" : "" }/>
							</span>
							<span>
								<img src="css/images/market.png" ><span>농산물 판매</span>
								<input type="checkbox" name="gasIcons" value="market.png"${ fn:contains(rest.gasAmImgs,'market.png') ?" checked='checked'" : "" }/>
							</span>
						</div>
					</div>
				</div>
				<div class="chk-list">
					<label>세차장</label>
					<input type="checkbox" name="washChk" value="Y"${ rest.carwash_chk eq 'Y' ?" checked='checked'" : "" }/>	
					<label>경정비소</label>
					<input type="checkbox" name="repairChk" value="Y"${ rest.repair_chk eq 'Y' ?" checked='checked'" : "" }/>
					<label>화물차라운지</label>
					<input type="checkbox" name="cargoChk" value="Y"${ rest.cargolounge_chk eq 'Y' ?" checked='checked'" : "" }/>		
				</div>
			</div>	
		</div>
		<div class="buttom">
			<button type="button" class="square-blue-btn" id="updateBtn">수정하기</button>
		</div>
	</div>
</div>
</form>
</body>
</html>