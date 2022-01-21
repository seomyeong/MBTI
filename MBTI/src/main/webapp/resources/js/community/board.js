$('#nav li:nth-of-type(3)').addClass('clicked');

// date 표시 바꾸기

function timeForToday(value) {
	const today = new Date();
	const timeValue = new Date(value);

	const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
	if (betweenTime < 1) return '방금 전';
	if (betweenTime < 60) {
		return `${betweenTime}분 전`;
	}

	const betweenTimeHour = Math.floor(betweenTime / 60);
	if (betweenTimeHour < 24) {
		return `${betweenTimeHour}시간 전`;
	}

	const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
	if (betweenTimeDay < 365) {
		return `${betweenTimeDay}일 전`;
	}

	return `${Math.floor(betweenTimeDay / 365)}년 전`;
}


// date 표시 바꾸기 - 게시글, 댓글, 대댓글
function changeDate() {
	let formatDate_board = timeForToday($('#board_reportingDate').text());
	$('#board_reportingDate').text(formatDate_board);
	
	$('.comment_reportingDate').each(function() {
		let formatDate = timeForToday($(this).text());
		$(this).text(formatDate);
	
	});
	
	$('.plusCommentView_reportingDate').each(function() {
		let formatDate = timeForToday($(this).text());
		$(this).text(formatDate);
	
	});
}
function changeDate_comment() {
	
	$('.comment_reportingDate').each(function() {
		let formatDate = timeForToday($(this).text());
		$(this).text(formatDate);
	
	});
	
	$('.plusCommentView_reportingDate').each(function() {
		let formatDate = timeForToday($(this).text());
		$(this).text(formatDate);
	
	});
}
changeDate();

// 댓글 글자수 세기
function typingContents(form) {
	var contents = form.comment_text.value;

	if (!(contents.length == 0)) {
		$('#typingCount').text(contents.length + " 자 / 200 자");
	} else {
		$('#typingCount').text('');
	}
}

// 게시글 삭제

$('#board_delete a').on('click', function(e) {
	e.preventDefault();
	var boardId = $(this).attr("href");

	var answer = confirm("해당 게시글을 삭제할까요?");

	if (answer == true) {
		alert("삭제가 완료되었습니다.");
		location.href = "deleteBoard?boardId=" + boardId;
	}
});

// 댓글 부분만 다시 불러오기
function load_comments(data) {
	$('#commentsWrap').empty();
	
	var datacc = data["cc"];
	var dataccp = data["ccp"];
	var commentsWrap = "";

	if(datacc.length != 0) {
		for(var cc in datacc) {
			commentsWrap += '<div class="comment"><div class="commentInfo"><span class="comment_mbti"><span class="mbtiImg" style="background: url('
									+ datacc[cc].member.profileImg
									+ ') 0 0 / cover"></span>'
									+ datacc[cc].member.mbti
									+ '</span> <span class="comment_profile"><span class="comment_level">Lv.'
									+ datacc[cc].member.level
									+ '</span><span class="comment_nickName">'
									+ datacc[cc].member.nickName
									+ '</span></span><span class="comment_reportingDate">'
									+ datacc[cc].reportingDate
									+ '</span>';
			if('${board.member.id}' == datacc[cc].member.id) {
				commentsWrap += '<span class="comment_me">작성자</span>';
			}
			commentsWrap += '<span class="comment_plusCommentToggle"><a href="'
									+ datacc[cc].id
									+ '" class="comment_plusCommentToggleA">답글 쓰기</a></span><span class="commentInfo_right"><span class="comment_delete"><a href="'
									+ datacc[cc].id 
									+ '"><ion-icon name="close-outline"></ion-icon></a></span></span></div><p class="comment_text">'
									+ datacc[cc].comments
									+ '</p>';
			if(dataccp.length != 0) {
				for(var ccp in dataccp) {
					if(dataccp[ccp].communityComments.id == datacc[cc].id) {
						commentsWrap += '<div class="plusCommentView"><ion-icon name="return-down-forward-outline"></ion-icon><span class="plusCommentView_mbti"><span class="mbtiImg" style="background: url('
							+ dataccp[ccp].member.profileImg
							+ ') 0 0 / cover"></span>'
							+ dataccp[ccp].member.mbti
							+ '</span><span class="plusCommentView_profile"><span class="plusCommentView_level">Lv. '
							+ dataccp[ccp].member.level
							+ '</span><span class="plusCommentView_nickName">'
							+ dataccp[ccp].member.nickName
							+ '</span></span><span class="plusCommentView_reportingDate">'
							+ dataccp[ccp].reportingDate
							+ '</span>';
						if(dataccp[ccp].member.id == '${board.member.id}') {
							commentsWrap += '<span class="comment_me">작성자</span>';
						}
						commentsWrap += '<span class="plusCommentInfo_right"> ';
						if('${sessionScope.loginId}' == dataccp[ccp].member.id) {
							commentsWrap += '<span class="plusComment_delete"><a href="'
										+ dataccp[ccp].id
										+ '"><ion-icon name="close-outline"></ion-icon></a></span>';
										
						}
						commentsWrap += '</span><div class="plusCommentView_comments">'
									+ dataccp[ccp].comments
									+ '</div></div>';
					}
				}
			}
			commentsWrap += '</div></div>';
		}
	}
	$('#commentsWrap').append(commentsWrap);
	$('#board_commentsCount').html(data["cb"].commentsCount);
	changeDate_comment();
	
}


