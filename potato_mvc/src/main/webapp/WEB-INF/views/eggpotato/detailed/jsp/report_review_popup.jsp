<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고창</title>
<link rel="shortcut icon"  href="css/css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/detailed/report_review_popup.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	
if(${rpc}==1) {
	alert("신고가 접수되었습니다.");
	self.close();
}

function report() {
    var rridx= $("[name='report-radio']:checked").val();
    if(rridx==null){
       alert("차단사유를 선택해주세요.");
    }else{
       $("#report_idx").val(rridx);
       $("#id_reporter").val("${param.id}");
       $("#review_idx").val(${param.review_idx});
       $("#restarea_idx").val(${param.restarea_idx});
       $("#reportFrm").submit();
 	}
}
</script>

</head>
<body>
<div class="wrap">
	<div class="top">
		<img src="css/images/report.png" class="report-icon">
		<span>리뷰 신고하기</span>
	</div>
	<div class="middle">
		<p>신고대상자: <span>${param.nick }</span></p>
		<div class="radio-wrap">
			<c:forEach var="rp" items="${rp }">
				<div class="rr-wrap">
					<input type="radio" name="report-radio" class="rr" value="${rp.report_idx}">${rp.reason}
				</div>
			</c:forEach>
			<!-- 삭제 금지 -->
			<div class="rr-wrap"></div>
			<!-- 삭제금지 -->
		</div>
	</div>
	<div class="bottom">
		<button type="button" class="report-btn" onclick="report()">신고하기</button>
	</div>
</div>

<form method="get" id="reportFrm" action="detailed_report.do">
	<input type="hidden" id="id_reporter" name="id_reporter" value="${param.id }"/>
	<input type="hidden" id="id_writer" name="id_writer" value="${param.id_writer }"/>
	<input type="hidden" id="report_idx" name="report_idx" value="${param.report_idx }"/>
	<input type="hidden" name="review_idx" id="review_idx" value="${param.review_idx}">
	<input type="hidden" name="restarea_idx" id="restarea_idx" value="${param.restarea_idx}">
	<input type="hidden" name="rpc" id="rpc" value="${param.rpc}">
</form>

</body>
</html>