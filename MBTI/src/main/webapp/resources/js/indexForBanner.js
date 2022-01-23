$('#nav li:nth-of-type(2)').addClass('clicked');

/* 각 mbti 캐릭터 랜덤 등장 */
let num = 0;
for (let i = 1; i <= 16; i++) {
    $('.avatar' + i + '').css({ opacity: 0 })
    num++;
    let random = Math.floor(Math.random() * 2000) + 500;
    for (let i = 0; i < 1; i++) {

        $('.avatar' + num + '').delay(random).animate({ opacity: 1 }, 500)
    }
}