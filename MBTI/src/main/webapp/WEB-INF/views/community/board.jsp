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
	href="<%=request.getContextPath()%>/resources/css/board.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"
	defer></script>
<script src="<%=request.getContextPath()%>/resources/js/board.js" defer></script>
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
					<span id="board_views">조회 ${board.views}</span> <span
						id="board_reportingDate">${board.reportingDate}</span>
				</div>
			</div>
			<div id="contentsWrap">
				<p id="board_contents">${board.contents}</p>
			</div>
			<a href="javascript:likes()" id="board_likes"><span><ion-icon
						name="thumbs-up-outline"></ion-icon></span><span id="likesCount">${board.likes}</span></a>
						<span id="errorMsg"></span>
			<a href="mainCommunity" id="contentsList">글목록</a>
			<div id="ad1">
				<a
					href="https://play.google.com/store/apps/details?id=com.varxyz.demofico"
					id="download"></a>
			</div>
			<div id="comments">
				<span>댓글</span> 총 <span>${board.commentsCount}</span> 개
			</div>

			<!-- 댓글 영역 -->
			<div id="commentsWrap">
				<c:forEach var="comment" items="${comments}">
					<div class="comment">
						<div class="commentInfo">
							<span class="comment_mbti">${comment.member.mbti}</span> <span
								class="comment_profile"><span class="comment_level">Lv.
									${comment.member.level}</span><span class="comment_nickName">${comment.member.nickName}</span></span>
							<span class="comment_reportingDate">${comment.reportingDate}</span><span
								class="commentInfo_right"><span>추천
									${comment.likes}</span> </span>
						</div>
						<p class="comment_text">${comment.comments}</p>
					</div>
				</c:forEach>
			</div>

			<hr>

			<!-- 댓글 작성 -->
			<div id="comment_write">
				<c:choose>
					<c:when test="${loginMemberInfo eq null}">
						<div id="comment_info">
							<span id="comment_write_plzLogin"><span>댓글작성</span>은 <span>로그인</span>
								후 이용가능합니다.</span>
						</div>
					</c:when>
					<c:otherwise>
						<div id="comment_info">
							<span id="comment_info_first">${loginMemberInfo.mbti}</span> <span
								id="comment_info_second">Lv. ${loginMemberInfo.level}</span> <span id="comment_info_third">${loginMemberInfo.nickName}</span><span id="typingCount"></span>
						</div>
						<form>
							<input type="text" id="comment_text" name="comment_text" placeholder="댓글을 달아보세요!" oninput="typingContents(this.form)"/>
							<input type="submit" value="등록"
								onclick="addComment(this.form); return false" />
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<script>
		// EL의 값을 써야하기때문에 아래에서 작성
		function likes() {
			if('${sessionScope.loginId}' == "" || '${sessionScope.loginId}' == null) {
				alert("추천기능은 로그인 후 이용이 가능합니다.");
				return;
			}
			
			var boardId = {
				'loginId' : '${sessionScope.loginId}',
				'boardId' : '${board.id}'
			};

			$.ajax({
				type : "post",
				data : JSON.stringify(boardId),
				url : "/myapp/community/likes",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					if(data["likeCheck"] == "false") {
						$('#likesCount').text(data["likes"]);						
					} else {
						$('#errorMsg').text("추천은 계정당 한 번만 가능합니다.");
					}
				}
			});
		}
		
		// 댓글 작성시
		function addComment(form) {
			var comment = form.comment_text.value;
			if(comment.length == 0 || comment == null) {
				alert("작성할 내용이 없습니다.");
				return;
			} else if(comment.length > 200) {
				alert("댓글은 최대 200자까지 입력이 가능합니다.");
				return;
			}
			
			var param = {
				'loginId' : '${sessionScope.loginId}',
				'boardId' : '${board.id}',
				'comment' : comment
			}

			$.ajax({
				type : "post",
				data : JSON.stringify(param),
				url : "/myapp/community/addComment",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					console.log(data["mbti"] + ", " + data["level"] + ", " + data["nickName"] + ", " + data["comment"]);
					$('#commentsWrap').append('<div class="comment"><div class="commentInfo"><span class="comment_mbti">' + data["mbti"] + '</span> <span class="comment_profile"><span class="comment_level">Lv.' + data["level"] + '</span><span class="comment_nickName">' + data["nickName"] + '</span></span><span class="comment_reportingDate">방금 전</span><span class="commentInfo_right"><span>추천 0</span> </span></div><p class="comment_text">' + data["comment"] + '</p></div>');
					$('#comment_text').val('');
				}
			});
		}
	</script>
</body>
</html>