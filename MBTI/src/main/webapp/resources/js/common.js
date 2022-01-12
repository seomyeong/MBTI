let list = document.querySelectorAll('#nav li');
function activeLink() {
    list.forEach((item) =>
        item.classList.remove('clicked'));
    this.classList.add('clicked');
}


