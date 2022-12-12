<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도별 휴게소</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_navi2.css"/><%-- 네비바 필요한 사람만 --%>
<link rel="stylesheet" type="text/css" href="css/list/do_list.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

</script>

</head>
<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../common/jsp/user_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container">
<%-- 휴게소리스트용 --%>
<div class="wrap-navi">
		<div class="navi">
			<ul class="navibar">
				<li class="navi-item">
					<a class="navi-link" href="allList.do">전체 휴게소</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="mapPin.do">고속도로별 휴게소</a>
				</li>
				<li class="blank"></li>
				<li class="navi-item">
					<a class="navi-link" href="doMap.do">도별 휴게소</a>
				</li>
				<li class="navi-item">
					<a class="navi-link" href="exFood.do">ex-FOOD</a>
				</li>
			</ul>
		</div>
</div> 
<%-- 네비바 끝 --%>
<!-- 건들지마 -->
			<!--메인 영역 -->
			<div class="main">
				<!-- 카테고리명 -->
				<div class="cat-name">도별 휴게소</div>
				<div>
  					<map id="do-map" name="do-map">
					<a href="doList.do?do_idx=1"><area target="_blank" class="effect" alt="수도권" title="수도권" coords="227,92,185,114,183,127,157,138,165,163,147,172,117,162,91,185,91,203,126,256,151,263,145,277,145,289,178,322,253,320,287,294,318,279,310,274,322,218,284,203,285,159,236,118" shape="poly"></a>
 				   	<a href="doList.do?do_idx=2"><area target="_blank" class="effect" alt="강원도" title="강원도" coords="232,93,293,101,355,89,365,73,391,70,397,56,411,60,537,259,520,288,435,294,375,268,325,279,313,271,323,215,287,199,286,155,234,116" shape="poly"></a>
				  	<a href="doList.do?do_idx=3"><area target="_blank" class="effect" alt="충청북도" title="충청북도" coords="422,294,410,336,382,331,332,371,335,380,326,420,347,439,331,475,296,482,293,462,283,418,262,392,253,361,264,341,252,321,289,292,319,281,374,271" shape="poly"></a>
  				  	<a href="doList.do?do_idx=4"><area target="_blank"  class="effect"alt="충청남도" title="충청남도" coords="161,306,125,294,77,334,77,370,83,387,97,387,100,405,104,427,131,440,131,464,161,480,189,470,217,474,236,458,252,461,267,479,296,478,293,465,281,420,259,392,247,354,259,343,251,317" shape="poly"></a>
  				  	<a href="doList.do?do_idx=5"><area target="_blank" class="effect" alt="경상북도" title="경상북도" coords="536,264,520,291,441,300,422,293,409,335,385,331,333,372,336,378,326,416,346,437,329,478,331,497,355,506,382,539,464,548,516,526,563,534,574,497,570,462,554,465,563,339,543,316" shape="poly"></a>
  				  	<a href="doList.do?do_idx=6"><area target="_blank" class="effect" alt="경상남도" title="경상남도" coords="563,535,521,525,467,548,383,538,358,507,326,499,290,542,303,570,289,584,320,656,327,691,341,692,335,708,358,717,366,701,395,696,410,709,441,713,468,669,531,632,552,604" shape="poly"></a>
				    <a href="doList.do?do_idx=7"><area target="_blank" class="effect" alt="전라북도" title="전라북도" coords="325,478,294,481,270,481,251,460,232,458,219,473,191,470,161,483,133,468,130,492,144,509,128,530,120,560,141,590,176,572,237,594,286,589,301,571,290,540,328,499" shape="poly"></a>
				    <a href="doList.do?do_idx=8"><area target="_blank" class="effect" alt="전라남도" title="전라남도" coords="287,589,298,623,319,661,327,691,335,706,282,729,278,758,267,764,255,755,230,771,223,785,111,771,81,778,81,794,46,809,33,787,32,768,55,733,42,730,43,714,56,662,71,648,70,625,99,613,97,601,119,566,141,589,176,571,235,596" shape="poly"></a>
  					</map>
  					<img src="css/images/k-map.jpg" style="display:block; margin:auto;" usemap="#do-map" class="effect">
				</div>
			</div>
<!-- 건들지마 -->
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div>
</body>
</html>