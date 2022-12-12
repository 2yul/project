<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Management</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/m_common/manager_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/home/manager_mainhome.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/review_management/manager_review_management.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
//삭제후 알림
<c:if test="${ mulDelCnt gt 0 }"> 
alert("총 ${mulDelCnt}개 리뷰가 삭제되었습니다.");
</c:if>

<c:if test="${ oneDelCnt eq 1 }"> 
alert(" 1개의 리뷰가 삭제되었습니다."); // 팝업창을 닫고 메인창을 새로고침할 조건 물어보기
self.close();
</c:if>


$(function(){
	//검색어 입력시
	$("#searchBtn").click(function(){
		if($("#searchBox").val().trim().length < 2) {
			alert("검색어를 2자 이상 입력하세요!");
			return;
		}
		 $("#keyword").val($("#searchBox").val());
		 $("#searchType").val($("#keywordSel").val());
		 $("#hidFrm").submit();
	});
	
	
	//등록일순 내림차순
	$("#dateAsc").click(function(){
		$("#dateOrderFlag").val(2);
		$("#reportOrderFlag").val(0)
		$("#hidFrm").submit();
	});
	
	//등록일순 오름차순
	$("#dateDesc").click(function(){
		$("#dateOrderFlag").val(1);
		$("#reportOrderFlag").val(0)
		$("#hidFrm").submit();
	});
	
	//신고순 내림차순
	$("#reportDesc").click(function(){
		$("#reportOrderFlag").val(1);
		$("#dateOrderFlag").val(0)
		$("#hidFrm").submit();
	});
	
	//신고순 오름차순
	$("#reportAsc").click(function(){
		$("#reportOrderFlag").val(2);
		$("#dateOrderFlag").val(0)
		$("#hidFrm").submit();
	});
	
	//체크박스로 삭제
	$("#deleteBtn").click(function(){
		if(!$("[name=reviewChk]").is(":checked")) {
			alert("한개이상 선택해 주세요!");
			return;
		}
		
		//한개만 선택되었을 시
		if(confirm("정말로 삭제하시겠습니까?")) {
			var cnt= $("input:checkbox[name='reviewChk']:checked").length;
			if(cnt == 1) {
				var param =  $("[name=reviewChk]:checked").val();
				var arr = param.split(",");
				$("#delRevIdx").val(arr[0]);
				$("#delId").val(arr[1]);
				$("#delRsIdx").val(arr[2]);
				$("#deleteOneFrm").submit();
			//다중선택시	
			} else {
				$("#deleteFrm").submit();
			}
		}
	});
	
	
	//AJAX검색어
	$("#searchBox").keyup(function(evt){
		if($("#searchBox").val().trim().length > 0 && $("#keywordSel").val() == 1 ){
			$.ajax({
				url:"manager_review_ajax.do",
				type:"get",
				data:"keyword="+$("#searchBox").val(),
				async:"true",
				dataType:"json",
				error:function(xhr){
					alert("에러");
					console.log("에러발생 : "+xhr.status);
				},
				success:function(json) {
					if(json.isData) {
						$("#keywordList").show();
						var outData ="<table>";
						$(json.data).each(function(i,data){
							outData +="<tr onclick=\"getResult('"+data.keyword+"')\"><td>"+data.keyword+"</td></tr>"
						});
						outData +="</table>";
						$("#keywordList").html(outData);
					} else if($("#searchBox").val().trim().length > 0) {
						$("#keywordList").hide();
					}
				}
			});
		}// if end
	});//ajax end
	
});//ready

//리뷰상세창열기
$(document).on("click",".popup-btn",function(){
	open("","review_popup","width=1400,height=550,top=211,left=300");
    var param = $(this).val().split(",");
    $("#reIdx").val(param[0]);
    $("#id").val(param[1]);
    $("#rsIdx").val(param[2]);
    $("#popupFrm").submit();
});

//페이징
function movePage( page ) {
	$("#pageFlag").val( page );
	$("#hidFrm").submit();
}

//체크박스 설정
function allChk() {
	if($("#mainChk").is(":checked")){
		$("[name='reviewChk']").prop("checked", true);
	} else {
		$("[name='reviewChk']").prop("checked", false);
	}
}

function getResult( data ) {
	$("#searchBox").val(data);
	$("#keywordList").hide();
}
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
			<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-vector-pen" viewBox="0 0 16 16">
  			<path fill-rule="evenodd" d="M10.646.646a.5.5 0 0 1 .708 0l4 4a.5.5 0 0 1 0 .708l-1.902 1.902-.829 3.313a1.5 1.5 0 0 1-1.024 1.073L1.254 14.746 4.358 4.4A1.5 1.5 0 0 1 5.43 3.377l3.313-.828L10.646.646zm-1.8 2.908-3.173.793a.5.5 0 0 0-.358.342l-2.57 8.565 8.567-2.57a.5.5 0 0 0 .34-.357l.794-3.174-3.6-3.6z"/>
  			<path fill-rule="evenodd" d="M2.832 13.228 8 9a1 1 0 1 0-1-1l-4.228 5.168-.026.086.086-.026z"/>
			</svg><span class="text">리뷰관리</span>
		</div>
		<div class="review_management-wrap">
			<div class="review_management">
				<div class="rm-top">
					<select class="search-select" id="keywordSel"> 
						<option value="1"${ 1 eq param.searchType?" selected='selected'":"" }>휴게소명</option>
						<option value="2"${ 2 eq param.searchType?" selected='selected'":"" }>내용</option>
						<option value="3"${ 3 eq param.searchType?" selected='selected'":"" }>작성자</option>
					</select>
					<div class="search-wrap">
						<input autocomplete="off" type="text" class="search-txt" id="searchBox" value="${ param.keyword }">
						<button type="button" class="search-bar" id="searchBtn">
								<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
									 <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
								</svg>
						</button>
						<div class="keywordList" id="keywordList">
						</div>
					</div>
				</div>
				<div class="btn-line">
					<!-- 일괄삭제 버튼 -->
					<button type="button" class="delete-btn" id="deleteBtn">선택삭제</button>
					
					<!-- 정렬버튼 -->
					<c:if test="${ empty param.dateOrderFlag || param.dateOrderFlag eq 1 }">
						<button type="button" class="align-btn" id="dateAsc" value="2"${ param.reportOrderFlag eq 0 or empty param.reportOrderFlag ?" style='font-weight:bold;color:black'" : "" }>등록일순↑</button>
					</c:if>
					<c:if test="${  param.dateOrderFlag eq 2 || param.dateOrderFlag eq 0 }">
						<button type="button" class="align-btn" id="dateDesc" value="1"${ param.reportOrderFlag eq 0 ?" style='font-weight:bold;color:black'" : "" }>등록일순↓</button>
					</c:if>
					<c:if test="${ empty param.reportOrderFlag || param.reportOrderFlag eq 2 || param.reportOrderFlag eq 0}">
						<button type="button" class="align-btn" id="reportDesc" value="1"${ param.dateOrderFlag eq 0 ?" style='font-weight:bold;color:black'" : "" }>신고수순↓</button>
					</c:if>
					<c:if test="${ param.reportOrderFlag eq 1 }">
						<button type="button" class="align-btn" id="reportAsc" value="2"${ param.dateOrderFlag eq 0 ?" style='font-weight:bold;color:black'" : "" }>신고수순↑</button>
					</c:if>
				</div>
				<div class="table-wrap">
					<!-- 리뷰일괄삭제폼 -->
					<form id="deleteFrm" method="post" action="manager_multipleReviews_delete.do">
					<table class="table">
						<tr>
							<th><input type="checkbox" id="mainChk" name="mainChk" onclick="allChk()"/></th><th>휴게소명</th><th>내용</th><th>평점</th><th>작성자</th><th>작성일시</th><th>신고수</th>
						</tr>
						<c:if test="${ empty reviewList }">
							<tr>
								<td colspan="7">조회된 데이터가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="rev" items="${ reviewList }" >
							<tr>
								<!-- 버튼의 value에 리뷰를 식별할 수 있는 3가지 값을 넣고 스크립트에서 받아서 hidden form으로 넘겨준다. -->
								<td><input type="checkbox" name="reviewChk" value="${ rev.review_idx },${rev.id},${ rev.restarea_idx }"/></td>
								<td class="nameTd"><c:out value="${ rev.name }"/></td><td><button type="button" class="popup-btn" value="${ rev.review_idx },${rev.id},${ rev.restarea_idx }"><c:out value="${ rev.contents }" escapeXml="false"/></button></td>
								<td><c:out value="${ rev.rating }"/></td><td class="idTd"><c:out value="${ rev.id }"/></td><td class="dateTd"><fmt:formatDate value="${ rev.post_date }" pattern="yyyy-MM-dd hh:mm:ss"/></td><td><c:out value="${ rev.report_cnt }"/></td>
							</tr>
						</c:forEach> 
					</table>
					</form>
				</div>
				<!-- 페이징 -->
				<div class="page">
					<c:if test="${ not empty reviewList }">
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
<!-- 리뷰불러오기 -->
<form id="hidFrm" method="post" action="manager_review.do">
	<input type="hidden" id="keyword" name="keyword" value="${ param.keyword }"/>
	<input type="hidden" id="searchType" name="searchType" value="${ param.searchType }"/>
	<input type="hidden" id="dateOrderFlag" name="dateOrderFlag" value="${ empty param.dateOrderFlag ? 1 : param.dateOrderFlag }"/>
	<input type="hidden" id="reportOrderFlag" name="reportOrderFlag" value="${ empty param.reportOrderFlag ? 0 : param.reportOrderFlag }"/>
	<input type="hidden" id="pageFlag" name="pageFlag" value="${ empty param.pageFlag ? 1 : param.pageFlag }"/>
</form>

<!-- 리뷰상세팝업창 불러오기 -->
<form id="popupFrm" method="post" action="manager_open_reviewPopup.do" target="review_popup">
	<input type="hidden" id="reIdx" name="review_idx">
	<input type="hidden" id="id" name="id">
	<input type="hidden" id="rsIdx" name="restarea_idx">
</form>

<!-- 리뷰단일삭제 -->
<form id="deleteOneFrm" method="post" action="manager_singleReview_delete.do">
	<input type="hidden" id="delRevIdx" name="review_idx">
	<input type="hidden" id="delId" name="id">
	<input type="hidden" id="delRsIdx" name="restarea_idx">
</form>
</body>
</html>