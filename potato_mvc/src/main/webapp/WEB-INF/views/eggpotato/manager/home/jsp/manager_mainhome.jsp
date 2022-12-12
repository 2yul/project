<%@page import="potato.manager.dao.MgrHomeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager MainHome</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/m_common/manager_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/manager/home/manager_mainhome.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- 그래프/차트 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

</head>
<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../m_common/manager_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container" style="background-color: #F8F9FB;">
	<div class="main">
	<div style="display: flex;border-bottom: 1px solid grey;align-items: center; margin-bottom: 20px;">
		<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-house-heart-fill" viewBox="0 0 16 16">
	  	<path d="M7.293 1.5a1 1 0 0 1 1.414 0L11 3.793V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v3.293l2.354 2.353a.5.5 0 0 1-.708.707L8 2.207 1.354 8.853a.5.5 0 1 1-.708-.707L7.293 1.5Z"/>
	  	<path d="m14 9.293-6-6-6 6V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V9.293Zm-6-.811c1.664-1.673 5.825 1.254 0 5.018-5.825-3.764-1.664-6.691 0-5.018Z"/>
		</svg><span class="text">대시보드</span>
	</div>
		<div class="top-dash"><!-- 1 -->
		<div class="top">
		<div class="board"><span class="board-text-1">신규가입자 수</span><br><span class="board-text-2"><c:out value="${newMemCnt}"/>명</span></div>
		<div class="board"><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16" color="#E0E0E0">
  		<path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
 		<path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
		</svg></div>
		</div>
		<div class="top">
		<div class="board"><span class="board-text-1">누적신고 수</span><br><span class="board-text-2"><c:out value="${reportCnt}"/>건</span></div>
		<div class="board"><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-bell-fill" viewBox="0 0 16 16" color="#E0E0E0">
  		<path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zm.995-14.901a1 1 0 1 0-1.99 0A5.002 5.002 0 0 0 3 6c0 1.098-.5 6-2 7h14c-1.5-1-2-5.902-2-7 0-2.42-1.72-4.44-4.005-4.901z"/>
		</svg></div>
		</div>
		<div class="top">
		<div class="board"><span class="board-text-1">인기 휴게소</span><br><span class="board-text-2"><c:out value="${popOne}"/></span></div>
		<div class="board"><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-shop" viewBox="0 0 16 16" color="#E0E0E0">
  		<path d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z"/>
		</svg></div>
		</div>
		<div class="top">
		<div class="board"><span class="board-text-1">관심 휴게소</span><br><span class="board-text-2"><c:out value="${bookmark}"/></span></div>
		<div class="board"><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-bookmark-heart-fill" viewBox="0 0 16 16" color="#E0E0E0">
  		<path d="M2 15.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v13.5zM8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z"/>
		</svg></div>
		</div>
		</div><!-- 1 -->
	
		<div><!-- 그래프 -->
			<div class="graph1">
				<div style="margin: 20px 20px 40px 20px;">
				<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bar-chart-line-fill" viewBox="0 0 16 16" color="#5C3300">
  				<path d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1V2z"/>
				</svg><span class="label">주간 방문자 현황</span>
				</div>
				<div>
				<canvas id="mixed-chart" width="815" height="400"></canvas>
				<script type="text/javascript">
				new Chart(document.getElementById("mixed-chart"), {
				    type: 'bar',
				    data: {
						  labels: [${D6},${D5},${D4},${D3},${D2},${D1},${D0}],
				      datasets: [{
				          label: "일별 방문자 수",
				          type: "bar",
				          backgroundColor: "#e8c3b9",
				          data: [${V6},${V5},${V4},${V3},${V2},${yesvisit},${tovisit}],
				        }]
				    }
				});
				</script>
				</div>
			</div>
			<div class="graph2">
				<div style="margin: 20px 20px 30px 20px;">
				<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16" color="#5C3300">
				<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
 				<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
				</svg><span class="label">오늘의 회원 현황</span>
				</div>
				<div>
				<canvas id="doughnut-chart" width="450" height="400"></canvas>
				<script type="text/javascript">
				new Chart(document.getElementById("doughnut-chart"), {
				    type: 'doughnut',
				    data: {
					  labels: ["신규 회원 수", "탈퇴 회원 수"],
				      datasets: [{
				        label: "Population (millions)",
				        backgroundColor: ["#e8c3b9","#c45850"],
				        data: [${newMemCnt},${quitMemCnt}]
				      }]
				    },
				});
				</script>
				</div>
			</div>
		</div><!-- 그래프 -->
	
		<div><!-- 3 -->
			<div class="graph1-list">
				<div class="list-label-1">
				<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-bar-chart-line-fill" viewBox="0 0 16 16" color="#5C3300">
  				<path d="M11 2a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v12h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h1V7a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v7h1V2z"/>
				</svg><span class="label">방문자 현황</span>
				</div>
				<div class="list-text-1" style="padding-top: 20px">
					<p>어제 방문자 수</p><p><c:out value="${yesvisit}"/>명</p>
				</div>
				<div class="list-text-2">
					<p>오늘 방문자 수</p><p><c:out value="${tovisit}"/>명</p>
				</div>
				<div class="list-text-1">
					<p>총 방문자 수</p><p><c:out value="${visitorCnt}"/>명</p>
				</div>
			</div>
			<div  class="graph2-list">
				<div class="list-label-2">
				<p><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16" color="#5C3300">
			  	<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
 			 	<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
				</svg><span class="label">회원 현황</span></p>
				<a href="mgr_memberManagement.do"><p style="color:#333"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-box-arrow-up-right" viewBox="0 0 16 16">
 				<path fill-rule="evenodd" d="M8.636 3.5a.5.5 0 0 0-.5-.5H1.5A1.5 1.5 0 0 0 0 4.5v10A1.5 1.5 0 0 0 1.5 16h10a1.5 1.5 0 0 0 1.5-1.5V7.864a.5.5 0 0 0-1 0V14.5a.5.5 0 0 1-.5.5h-10a.5.5 0 0 1-.5-.5v-10a.5.5 0 0 1 .5-.5h6.636a.5.5 0 0 0 .5-.5z"/>
				<path fill-rule="evenodd" d="M16 .5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h3.793L6.146 9.146a.5.5 0 1 0 .708.708L15 1.707V5.5a.5.5 0 0 0 1 0v-5z"/>
				</svg></p></a>
				</div>
				<div class="list-text-1" style="padding-top: 20px">
					<p>오늘 신규 회원</p><p><c:out value="${newMemCnt}"/>명</p>
				</div>
				<div class="list-text-2">
					<p>오늘 탈퇴 회원</p><p><c:out value="${quitMemCnt}"/>명</p>
				</div>
				<div class="list-text-1">
					<p>전체 회원</p><p><c:out value="${allMemCnt}"/>명</p>
				</div>
			</div>
			<div  class="rank">
				<div class="list-label-3">
				<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trophy" viewBox="0 0 16 16" color="#5C3300">
  				<path d="M2.5.5A.5.5 0 0 1 3 0h10a.5.5 0 0 1 .5.5c0 .538-.012 1.05-.034 1.536a3 3 0 1 1-1.133 5.89c-.79 1.865-1.878 2.777-2.833 3.011v2.173l1.425.356c.194.048.377.135.537.255L13.3 15.1a.5.5 0 0 1-.3.9H3a.5.5 0 0 1-.3-.9l1.838-1.379c.16-.12.343-.207.537-.255L6.5 13.11v-2.173c-.955-.234-2.043-1.146-2.833-3.012a3 3 0 1 1-1.132-5.89A33.076 33.076 0 0 1 2.5.5zm.099 2.54a2 2 0 0 0 .72 3.935c-.333-1.05-.588-2.346-.72-3.935zm10.083 3.935a2 2 0 0 0 .72-3.935c-.133 1.59-.388 2.885-.72 3.935zM3.504 1c.007.517.026 1.006.056 1.469.13 2.028.457 3.546.87 4.667C5.294 9.48 6.484 10 7 10a.5.5 0 0 1 .5.5v2.61a1 1 0 0 1-.757.97l-1.426.356a.5.5 0 0 0-.179.085L4.5 15h7l-.638-.479a.501.501 0 0 0-.18-.085l-1.425-.356a1 1 0 0 1-.757-.97V10.5A.5.5 0 0 1 9 10c.516 0 1.706-.52 2.57-2.864.413-1.12.74-2.64.87-4.667.03-.463.049-.952.056-1.469H3.504z"/>
				</svg><span class="label">휴게소 랭킹</span>
				</div>
				<div style="text-align: center;">
					<c:forEach var="rank" items="${rank}" >
					<p class="list-text-3"><c:out value="${rank}"/></p>
					</c:forEach> 
				</div>
			</div>
		</div><!-- 3 -->
	</div>
</div>
<!-- container end -->
</div>
</body>
</html>