<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>맙티</title>
<!-- <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon"> -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css">
<script src="<%=request.getContextPath()%>/resources/js/common.js" defer></script>
</head>
<body>
	<nav id="nav">
		<span id="menuToggle"> <ion-icon name="menu-outline"></ion-icon>
		</span>
		<ul>
			<li id="profile"><a href="#"> <span class="icon"> <ion-icon
							name="person-circle-outline"></ion-icon>
				</span> <span class="title">회원이신가요?</span>
				${sessionScope.nickName}
			</a></li>
			<a href="/myapp/member/login" id="login">로그인</a>
			<a href="/myapp/member/addMember" id="addUser">회원가입</a>
			<li><a href="/myapp/"> <span class="icon"> <ion-icon
							name="home-outline"></ion-icon>
				</span> <span class="title">홈으로</span>
			</a></li>
			<li><a href="/myapp/community/mainCommunity"> <span class="icon"> <ion-icon
							name="people-outline"></ion-icon>
				</span> <span class="title">커뮤니티</span>
			</a></li>
			<li><a href="#"> <span class="icon"> <ion-icon
							name="heart-outline"></ion-icon>
				</span> <span class="title">궁합도</span>
			</a></li>
			<li><a href="#"> <span class="icon"> <ion-icon
							name="ear-outline"></ion-icon>
				</span> <span class="title">상황별 심리</span>
			</a></li>
			<li><a href="#"> <span class="icon"> <ion-icon
							name="settings-outline"></ion-icon>
				</span> <span class="title">개인설정</span>
			</a></li>
			<li><a href="/myapp/member/logout"> <span class="icon"> <ion-icon
							name="log-out-outline"></ion-icon>
				</span> <span class="title">로그아웃</span>
			</a></li>
		</ul>
	</nav>
	<!-- <div id="main"></div> -->

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>