<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest Management</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/m_common/manager_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/home/manager_mainhome.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/rest_management/manager_rest_management.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//휴게소추가
	$(".write-btn").click(function(){
		open("manager_writePopup.do","write_popup","width=950,height=900,top=311,left=560")
	});
	
	//검색버튼클릭시
	$("#searchBtn").click(function(){
		
		$("#keyword").val($("#searchBox").val().trim());
		
		if($("#washChk").is(":checked")) {
			$("#carwash_chk").val("Y");
		} else {
			$("#carwash_chk").val("N");
		}
		
		if($("#repairChk").is(":checked")) {
			$("#repair_chk").val("Y");
		} else {
			$("#repair_chk").val("N");
		}
		
		if($("#cargoChk").is(":checked")) {
			$("#cargolounge_chk").val("Y");
		} else {
			$("#cargolounge_chk").val("N");
		}
		
		$("#lineFlag").val($("#lineSel").val());
		$("#pageFlag").val(1);
		$("#hidFrm").submit();	
	});
	
	//초기화버튼
	$("#reset-btn").click(function(){
		location.href="manager_restarea.do";
	});
	
});

//페이징
function movePage( page ) {
	$("#pageFlag").val( page );
	$("#hidFrm").submit();
}

//휴게소 새창열기
$(document).on("click",".popup-btn",function(){
	//open("","rest_popup","width=1900,height=900,top=311,left=560");
	var idx = $(this).val();
	$("#restarea_idx").val(idx);
	$("#openPopup").submit();
});

</script>
</head>
<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../m_common/manager_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container">
	<div class="main">
<!-- 건들지마세요 -->
		<div style="display: flex;border-bottom: 1px solid grey;align-items: center; margin-bottom: 20px;">
			<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-pin-map-fill" viewBox="0 0 16 16">
  			<path fill-rule="evenodd" d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8l3-4z"/>
 			<path fill-rule="evenodd" d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z"/>
			</svg><span class="text">휴게소관리</span>
		</div>
		<div class="rest_management-wrap">
			<div class="review_management">
				<div class="rm-top">
					<div class="search-wrap">
						<label>노선명 : </label>
						<select class="search-select" id="lineSel">
							<option value="0">----------전체----------</option>
							<c:forEach var="line" items="${ lineList }">
							<option value="${ line.line_idx }"${ line.line_idx eq param.lineFlag ?" selected='selected'" :"" }><c:out value="${ line.line }"/></option>
							</c:forEach>
						</select>
						<label>휴게소명 : </label>
						<input type="text" placeholder="휴게소명 입력" class="search-txt" id="searchBox" value="${ param.keyword }"/>
						<label>구분 : </label>
						<input type="checkbox" id="washChk"${ param.carwash_chk eq 'Y' ?" checked='checked'" :""  } >
						<label>세차장</label>
						<input type="checkbox" id="repairChk"${ param.repair_chk eq 'Y' ?" checked='checked'" :""  }>
						<label>경정비소</label>
						<input type="checkbox" id="cargoChk"${ param.cargolounge_chk eq 'Y' ?" checked='checked'" :""  }  >
						<label>화물차라운지</label>
						<button type="button" class="search-btn" id="searchBtn">검색</button>
						<button type="button" class="reset-btn" id="reset-btn">초기화</button>
						<button type="button" class="write-btn">휴게소 추가</button>
					</div>
					<div class="icon-wrap">
						<span>&lt;편의시설 구분&gt;</span>
						<div class="icon-sector">
							<span>
								<img src="css/images/sleep.png" ><span>수면실</span>
							</span>
							<span>
								<img src="css/images/shower.png" ><span>샤워실</span>
							</span>
							<span>
								<img src="css/images/washing.png" ><span>세탁실</span>
							</span>
							<span>
								<img src="css/images/rest.png" ><span>쉼터</span>
							</span>
							<span>
								<img src="css/images/barber.png" ><span>이발소</span>
							</span>
							<span>
								<img src="css/images/baby.png" ><span>수유실</span>
							</span>
							<span>
								<img src="css/images/pharmacy.png" ><span>약국</span>
							</span>
							<span>
								<img src="css/images/market.png" ><span>농산물 판매</span>
							</span>
						</div>
					</div>
				</div>
				<div class="table-wrap">
					<table class="table">
						<tr>
							<th rowspan="2">휴게소명</th><th rowspan="2">전화번호</th><th colspan="2">편의시설</th><th rowspan="2">세차장</th><th rowspan="2">경정비소</th><th rowspan="2">화물차라운지</th>
						</tr>
						<tr>
							<th>휴게소</th><th>주유소</th>
						</tr>
						<c:if test="${ empty restList }">
							<tr>
								<td colspan="7">조회된 데이터가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="rest" items="${ restList }">
						<tr>
							<td><button type="button" class="popup-btn" value="${ rest.restarea_idx }"><c:out value="${ rest.name }"/></button></td><td><c:out value="${ rest.tel }"/></td>
							<c:set var="restArr" value="${ fn:split(rest.retAmImgs,',') }"/>
							<c:set var="gasArr" value="${ fn:split(rest.gasAmImgs,',') }"/>
							<td>
								<c:if test="${ not empty rest.retAmImgs }">
								<c:forEach var="rIcon" items="${ restArr }">
								 <img src="css/images/${ rIcon }" style="width:20px;height:20px">
								</c:forEach>
								</c:if>
							</td>
							<td>
								<c:if test="${ not empty rest.gasAmImgs }">
								<c:forEach var="gIcon" items="${ gasArr }">
								 <img src="css/images/${ gIcon }" style="width:20px;height:20px">
								</c:forEach>
								</c:if>
							</td>
							<td><c:out value="${ rest.carwash_chk }"/></td><td><c:out value="${ rest.repair_chk }"/></td><td><c:out value="${ rest.cargolounge_chk }"/></td>
						</tr>
						</c:forEach>
						
					</table>
				</div>
				<div class="page">
					<c:if test="${ not empty restList }">
						<c:if test="${ startNum ne 1 }">
							<a href="javascript:movePage(1)" class="page-num">&nbsp;&lt;&lt;&nbsp;</a>
							<a href="javascript:movePage(${startNum ne 1 ? startNum-1 : 1})" class="page-num">&nbsp;&lt;&nbsp;</a>
						</c:if>
						<c:forEach step="1" var="i" begin="0" end="${ isLast }">
							<a href="javascript:movePage(${ startNum+i })" ${ curPage eq startNum + i ?" class='page-num-click'" :" class='page-num'"}><c:out value="&nbsp;${ startNum+i }&nbsp;" escapeXml="false"/></a>
						</c:forEach>
						<c:if test="${ lastPage gt startNum+2 }">
							<a href="javascript:movePage(${ startNum+3 })" class="page-num">&nbsp;&gt;&nbsp;</a>
							<a href="javascript:movePage(${ lastPage })" class="page-num">&nbsp;&gt;&gt;&nbsp;</a>
						</c:if>
					</c:if>
				</div>
			</div>
		</div>
<!-- 건들지마세요 -->
	</div>
</div>
<!-- container end -->
</div>
<!-- 휴게소 불러오기 -->
<form id="hidFrm" method="post">
	<input type="hidden" id="keyword" name="keyword" value="${ param.keyword }"/>
	<input type="hidden" id="carwash_chk" name="carwash_chk" value="${ param.carwash_chk }"/>
	<input type="hidden" id="repair_chk" name="repair_chk" value="${ param.repair_chk }"/>
	<input type="hidden" id="cargolounge_chk" name="cargolounge_chk" value="${ param.cargolounge_chk }"/>
	<input type="hidden" id="lineFlag" name="lineFlag" value="${ empty param.lineFlag ? 0 : param.lineFlag }"/>
	<input type="hidden" id="pageFlag" name="pageFlag" value="${ empty param.pageFlag ? 1 : param.pageFlag }"/>
</form>
<!-- 휴게소 상세 팝업 열기 -->
<form id="openPopup" method="post" action="manager_restdetailPopup.do" target="_blank">
	<input type="hidden" id="restarea_idx" name="restarea_idx"/>
</form>
</body>
</html>