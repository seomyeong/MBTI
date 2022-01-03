$('.toggle-switch .switch').on('click', function() {
	if ($(this).parent().children('input:eq(0)').attr('checked') == false || $(this).parent().children('input:eq(0)').attr('checked') == null) {
		$(this).parent().children('input:eq(0)').attr('checked', true);
	} else {
		$(this).parent().children('input:eq(0)').attr('checked', false);
	}
});

// mbti filter
function checkMbti() {
	let type01;
	let type02;
	let type03;
	let type04;

	if ($('.toggle-switch input[name="type01"]').attr('checked') == false || $('.toggle-switch input[name="type01"]').attr('checked') == null) {
		type01 = 'E';
	} else {
		type01 = 'I';
	}

	if ($('.toggle-switch input[name="type02"]').attr('checked') == false || $('.toggle-switch input[name="type02"]').attr('checked') == null) {
		type02 = 'N';
	} else {
		type02 = 'S';
	}

	if ($('.toggle-switch input[name="type03"]').attr('checked') == false || $('.toggle-switch input[name="type03"]').attr('checked') == null) {
		type03 = 'F';
	} else {
		type03 = 'T';
	}

	if ($('.toggle-switch input[name="type04"]').attr('checked') == false || $('.toggle-switch input[name="type04"]').attr('checked') == null) {
		type04 = 'P';
	} else {
		type04 = 'J';
	}

	console.log(type01 + type02 + type03 + type04);
	let param = {
		"type01": type01,
		"type02": type02,
		"type03": type03,
		"type04": type04,
	};

	$.ajax({ // 비동기 방식 (페이지가 넘어가지 않고 그 페이지에서 바로 자료가 변경됨)
		type: "post",
		data: JSON.stringify(param),
		url: "/test/community/mainCommunity",
		contentType: "application/json; charset=UTF-8",
		success: function(data) {
			document.querySelector('#viewName').innerHTML = data["view"];
		}
	});

}

function allView() {
	let param = {
		"allView": "all"
	}

	$.ajax({ // 비동기 방식 (페이지가 넘어가지 않고 그 페이지에서 바로 자료가 변경됨)
		type: "post",
		data: JSON.stringify(param),
		url: "/test/community/mainCommunity",
		contentType: "application/json; charset=UTF-8",
		success: function(data) {
			if (data["view"] == "all") {
				document.querySelector('#viewName').innerHTML = "전체글";
			}
		}
	});
}

// search

function search() {
	console.log("submit success");
}