<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맙티</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/index.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"
	defer></script>
</head>
<body>
	<!-- // 기본양식 -->
	<jsp:include page="/resources/incl/nav.jsp"></jsp:include>
	<div id="main">
		<!-- 작성 구역 -->
		<article id="banner">
			<h2 class="hidden">배너</h2>
			<p>No.1</p>
			<p>국내 최고 MBTI 커뮤니티 <span>맙티</span></p>
			<p>당신을 가장 이해할 수 있는 당신만의 BEST TEAM을 찾으세요.</p>
			<div id="bannerImg"></div>
		</article>




	</div>
	<!-- 기본양식 // -->
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>