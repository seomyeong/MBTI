let pass = false;
let type01, type02;

// 비회원 및 로그인한 회원이 type01 버튼을 클릭할 경우
	$('.type01').on('click', function() {
		
		console.log("클릭");
		
		$('.type01').each(function() {
			$(this).prop("checked", "false");
		});
		
		$(this).prop("checked", "true");	
	});
	
	$('.type02').on('click', function() {
		
		console.log("클릭");
		
		$('.type02').each(function() {
			$(this).prop("checked", "false");
		});
		
		$(this).prop("checked", "true");
	});
	
	// 결과보기 버튼을 클릭할 경우
	
	$(".submitBtn").on("click", function() {
		
		checkSelectType();
		
		if(pass == true) {
			$('.type01').each(function() {
				if($(this).prop("checked") == true) {
					console.log("test1 : " + $(this).val());
					type01 = $(this).val();
				}
			});
			$('.type02').each(function() {
				if($(this).prop("checked") == true) {
					console.log("test2 : " + $(this).val());
					type02 = $(this).val();
				}	
			});
			
			location.href = "resultMbtiMatch?type01="+type01+"&type02="+type02;
		}
	});	
	
	
	function checkSelectType() {
		
		let state1 = false;
		let state2 = false;
	
		$(".type01").each(function() {
			
			if($(this).prop("checked") == true) {
				state1 = true;
			}
		
		});
		
		$(".type02").each(function() {
			
			if($(this).prop("checked") == true) {
				state2 = true;
			}
		});
		
		if(state1 == true && state2 == true) {
			pass = true;
		} else if(state1 == false && state2 == true) {
			alert("나의 타입을 선택해주세요.");
			pass = false;
		} else if(state1 == true && state2 == false) {
			alert("상대방의 타입을 선택해주세요.");
			pass = false;
		} else {
			alert("모든 타입을 선택해주세요.");
			pass = false;
		}
	}