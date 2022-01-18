$('#statistics').css({ opacity: 0 })
$('#answersSubmit').hide()
$('#memberMbti').hide()
$('#questionNum').hide()
$('#chooseNum').hide()
$('#isSubjective').hide()
$('#subjectiveContent').hide()
$('#answerCount').hide()


/* 선택한 보기에 이펙트 변경 */
//let objLength = $('#answers ul li').length;

/*$('#answers ul li').on('click', function () {
    $('#answersSubmit').show()
    $('#answers ul li').css({ background: '#eeeeee' })
    $(this).css({ background: 'var(--green)' })

})*/

/* 전송버튼 클릭 시 */
$('#answersSubmit').on('click', function (e) {
    $('#playContents').animate({ marginTop: 80 }, function () {

        $('#statistics').delay(300).animate({ opacity: 1 }, 2000)
    })
    $('#answersSubmit').hide()
    $('#answers li').off('click')
})


/*let state= true;
let subjectiveContentPath = document.querySelector('#subjectiveContent');
	
	submitBtn.addEventListener('click',function(e){
	if(subjectiveContentPath.val == null){
			alert('답변을 입력해주세요.')
			state = false;
			e.preventDefault()
		}else if (subjectiveContent.val != null) {
			state = true;
		}
		if(state == true){
			submitBtn.submit();
		}
	})//end of submitBtn.addEventListner
*/	

/*각 ul li클릭 시 변수값 담아오기 */

$('#answers ul li').on('click', function () {
    let memberMbti = $('#contentPk').text()
    let questionNum = $('#contentId').text()
    let chooseNum = $(this).text().charAt(0)
    let subjectiveContent = $(this).text().substring(3)
    let answerCount = 1

    //attr
    $('#memberMbti').attr('value', memberMbti)
    $('#questionNum').attr('value', questionNum)
    $('#chooseNum').attr('value', chooseNum)

    if ($('#chooseNum').val() == 4) {
        $('#isSubjective').attr('value', 'true')
        $('#subjectiveContent').attr('value', null)
        $('#subjectiveContent').show()
    } else {
        $('#isSubjective').attr('value', 'false')
        $('#subjectiveContent').attr('value', subjectiveContent)
        $('#subjectiveContent').hide()
    }
    $('#answerCount').attr('value', answerCount)

	//css
    $('#answersSubmit').show()
    $('#answers ul li').css({ background: '#eeeeee' })
    $(this).css({ background: 'var(--green)' })
})



/* statistics에 answer값 넣기 */
let answer01 = $('#answers ul li:eq(0)').text().substring(3)
let answer02 = $('#answers ul li:eq(1)').text().substring(3)
let answer03 = $('#answers ul li:eq(2)').text().substring(3)

$('.answer01').append(answer01)
$('.answer02').append(answer02)
$('.answer03').append(answer03)


/* 페이지 진입 시 애니메이션 */

function slideBar() {
    $('#questionBar').css({ left: 0 })
    $('#questionBar').animate({ width: "100%" }, 2500)
}
slideBar();

