<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/manager/m_common/manager_header.css"/>

<script type="text/javascript">
$(function() {
	 /* 스크롤시 헤더 그림자 */
	 var header = $('.header');

	 $(window).scroll(function(e){
	     if(header.offset().top !== 0){
	         if(!header.hasClass('shadow')){
	             header.addClass('shadow');
	         }
	     }else{
	         header.removeClass('shadow');
	     }
	 });
	})
</script>

<div class="header">

	<div class="wrap-banner">
		<div class="banner">
			<a href="user_mainhome.do"><img src="css/images/logo.png" class="header-logo-png"></a>
			<span class="head-text">관리</span>
		</div>
		<div class="wrap-login">
			<a href="logout.do">
			<svg class="logout-svg" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20" viewBox="0 0 32 32" fill="rgb(92, 51, 0)" data-svg-content="true"><g><path d="M 30,30L 30,14 c0-1.104-0.896-2-2-2L 7.99,12 L 8,11.152C 8,5.764, 11.328,2, 16.096,2c 3.49,0, 6.6,2.006, 8.118,5.236 c 0.234,0.5, 0.828,0.714, 1.33,0.478c 0.5-0.234, 0.714-0.83, 0.478-1.33C 24.172,2.448, 20.37,0, 16.096,0C 10.246,0, 6,4.69, 6,11.14 L 5.99,12L 4,12 C 2.896,12, 2,12.896, 2,14l0,16 c0,1.104, 0.896,2, 2,2l 24,0 C 29.104,32, 30,31.104, 30,30z M 4,14l 24,0 l0,16 L 4,30 L 4,14 zM 16,18c-2.21,0-4,1.79-4,4s 1.79,4, 4,4s 4-1.79, 4-4S 18.21,18, 16,18z M 16,24c-1.102,0-2-0.898-2-2s 0.898-2, 2-2 s 2,0.898, 2,2S 17.102,24, 16,24z"></path></g></svg>
			로그아웃</a>
		</div>
	</div>
</div>

	<!-- 네비바 -->
	<div class="wrap-navi">
		<div class="navi">
			<ul class="navibar">
				<li class="navi-item">
					<a class="navi-link" href="mgr_home.do">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-heart-fill" viewBox="0 0 16 16">
  					<path d="M7.293 1.5a1 1 0 0 1 1.414 0L11 3.793V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v3.293l2.354 2.353a.5.5 0 0 1-.708.707L8 2.207 1.354 8.853a.5.5 0 1 1-.708-.707L7.293 1.5Z"/>
  					<path d="m14 9.293-6-6-6 6V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V9.293Zm-6-.811c1.664-1.673 5.825 1.254 0 5.018-5.825-3.764-1.664-6.691 0-5.018Z"/>
					</svg>&nbsp;&nbsp;&nbsp;홈</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="mgr_memberManagement.do">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-hearts" viewBox="0 0 16 16" >
				 	<path fill-rule="evenodd" d="M11.5 1.246c.832-.855 2.913.642 0 2.566-2.913-1.924-.832-3.421 0-2.566ZM9 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm-9 8c0 1 1 1 1 1h10s1 0 1-1-1-4-6-4-6 3-6 4Zm13.5-8.09c1.387-1.425 4.855 1.07 0 4.277-4.854-3.207-1.387-5.702 0-4.276ZM15 2.165c.555-.57 1.942.428 0 1.711-1.942-1.283-.555-2.281 0-1.71Z"/>
					</svg>&nbsp;&nbsp;&nbsp;회원관리</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="manager_restarea.do">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-pin-map-fill" viewBox="0 0 16 16">
  					<path fill-rule="evenodd" d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8l3-4z"/>
 					<path fill-rule="evenodd" d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z"/>
					</svg>&nbsp;&nbsp;&nbsp;휴게소관리</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="manager_review.do">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-vector-pen" viewBox="0 0 16 16">
  					<path fill-rule="evenodd" d="M10.646.646a.5.5 0 0 1 .708 0l4 4a.5.5 0 0 1 0 .708l-1.902 1.902-.829 3.313a1.5 1.5 0 0 1-1.024 1.073L1.254 14.746 4.358 4.4A1.5 1.5 0 0 1 5.43 3.377l3.313-.828L10.646.646zm-1.8 2.908-3.173.793a.5.5 0 0 0-.358.342l-2.57 8.565 8.567-2.57a.5.5 0 0 0 .34-.357l.794-3.174-3.6-3.6z"/>
  					<path fill-rule="evenodd" d="M2.832 13.228 8 9a1 1 0 1 0-1-1l-4.228 5.168-.026.086.086-.026z"/>
					</svg>&nbsp;&nbsp;&nbsp;리뷰관리</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="mgrPassChange.do">
					<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
		  			<path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
					</svg>&nbsp;&nbsp;&nbsp;비밀번호변경</a>
				</li>
			</ul>
		</div>
	</div>
	<!-- 네비바 -->
