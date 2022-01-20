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
	<script
	src="<%=request.getContextPath()%>/resources/js/index.js" defer></script>
</head>
<body>
	<!-- // 기본양식 -->
	<jsp:include page="/resources/incl/nav.jsp"></jsp:include>
	<div id="main">
		<!-- 작성 구역 -->
		<article id="banner">
            <h2 class="hidden">배너</h2>
            <p>국내 최고<span>no.1</span> MBTI 커뮤니티 <span>맙티</span></p>
            <p>당신을 가장 이해할 수 있는 당신만의 BEST TEAM을 찾으세요.</p>            <div id="bannerAvatar">
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ENFJ.png" alt="enfj" class="avatar avatar1 enfj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ENFP.png" alt="enfp" class="avatar avatar2 enfp"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ENTJ.png" alt="entj" class="avatar avatar3 entj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ENTP.png" alt="entp" class="avatar avatar4 entp"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ESFJ.png" alt="esfj" class="avatar avatar5 esfj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ESFP.png" alt="esfp" class="avatar avatar6 esfp"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ESTJ.png" alt="estj" class="avatar avatar7 estj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ESTP.png" alt="estp" class="avatar avatar8 estp"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_INFJ.png" alt="infj" class="avatar avatar9 infj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_INFP.png" alt="infp" class="avatar avatar10 infp"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_INTJ.png" alt="intj" class="avatar avatar11 intj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_INTP.png" alt="intp" class="avatar avatar12 intp"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ISFJ.png" alt="isfj" class="avatar avatar13 isfj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ISFP.png" alt="isfp" class="avatar avatar14 isfp"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ISTJ.png" alt="istj" class="avatar avatar15 istj"></img>
                <img src="<%=request.getContextPath()%>/resources/img/avatar/MBTI_ISTP.png" alt="istp" class="avatar avatar16 istp"></img>
            </div>
        </article>


	</div>
	<!-- 기본양식 // -->
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>