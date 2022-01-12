let list = document.querySelectorAll('#nav li');
function activeLink() {
    list.forEach((item) =>
        item.classList.remove('clicked'));
    this.classList.add('clicked');
}

function navErrorMsg() {
	alert("로그인이 필요한 서비스입니다.");
}