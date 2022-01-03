<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맙티</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/write.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"
	defer></script>
<script src="<%=request.getContextPath()%>/resources/js/write.js" defer></script>
</head>
<body>
	<jsp:include page="/resources/incl/nav.jsp"></jsp:include>
	<div id="main">
		<div id="boardInfoWrap">
			<h2 id="board_title">${board.title}</h2>
			<div id="board_info">
				<span id="board_mbti">${board.member.mbti}</span> <span
					id="board_level">Lv. ${board.member.level}</span> <span
					id="board_nickName">${board.member.nickName}</span>
				<div id="rightInfo">
					<span id="board_views">조회 : ${board.views}</span> <span
						id="board_reportingDate">${board.reportingDate}</span>
				</div>
			</div>
			<div id="contentsWrap">
				<p id="board_contents">${board.contents}</p>
			</div>
			<a href="javascript:likes()" id="board_likes"><span>추천</span><span id="likesCount">${board.likes}</span></a>
			<a href="mainCommunity" id="contentsList">글목록</a>
			<div id="ad1">
				<a href="https://play.google.com/store/apps/details?id=com.varxyz.demofico" id="download"></a>
			</div>
			<div id="comments">
				<span>댓글</span> 총 <span>${board.commentsCount}</span> 개
			</div>
		</div>
	</div>

	<script>
	// EL의 값을 써야하기때문에 아래에서 작성
		function likes() {
			var boardId = {
					'id': '${board.id}'
			};
			
			$.ajax({
				type: "post",
				data: JSON.stringify(boardId),
				url: "/myapp/community/likes",
				contentType: "application/json; charset=UTF-8",
				success:function(data) {
					$('#likesCount').html(data.likes);
				}
			});
		}
	</script>
</body>
</html>