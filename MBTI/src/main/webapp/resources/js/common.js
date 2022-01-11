let list = document.querySelectorAll('#nav li');
function activeLink() {
    list.forEach((item) =>
        item.classList.remove('clicked'));
    this.classList.add('clicked');
}
list.forEach((item) =>
    item.addEventListener('click', activeLink));

let menuToggle = document.querySelector('#menuToggle ion-icon');
let nav = document.querySelector('#nav');
let main = document.querySelector('#main');
let login = document.querySelector('#login');
let addUser = document.querySelector('#addUser');
let profile = document.querySelector('#nav ul li:nth-child(1)');

menuToggle.addEventListener('click', function () {
    clickMenuToggle();
});

function clickMenuToggle() {
    menuToggle.classList.toggle('show');
    main.classList.toggle('extend');
    nav.classList.toggle('hiddenProfile');
    login.classList.toggle('hiddenProfile');
    addUser.classList.toggle('hiddenProfile');
    profile.classList.toggle('hiddenProfile');
}

