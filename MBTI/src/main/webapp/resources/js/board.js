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

$('.comment_reportingDate').each(function() {
	let formatDate = timeForToday($(this).text());
	$(this).text(formatDate);

});

// date 표시 바꾸기 - 게시글 
let formatDate_board = timeForToday($('#board_reportingDate').text());
$('#board_reportingDate').text(formatDate_board);

// 댓글 글자수 세기
function typingContents(form) {
	var contents = form.comment_text.value;

	if (!(contents.length == 0)) {
		$('#typingCount').text(contents.length + " 자 / 200 자");
	} else {
		$('#typingCount').text('');
	}
}