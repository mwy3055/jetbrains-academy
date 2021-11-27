const showPopupButtons = document.getElementsByClassName('open-window')
for (const showPopupButton of showPopupButtons) {
    showPopupButton.addEventListener("click", () => {
        showPopup(showPopupButton.id);
    });
}

const closePopupButtons = document.getElementsByClassName('popup-close');
for (const closePopupButton of closePopupButtons) {
    closePopupButton.addEventListener("click", () => {
        closePopupButton.parentElement.style.display = 'none';
    });
}

function showPopup(name) {
    for (const elem of document.getElementsByClassName(name)) {
        if (elem.classList.contains('window')) {
            elem.style.display = 'block';
        }
    }
}


const hamburgerButton = document.getElementById('hamburger');
hamburgerButton.addEventListener("click", () => {
    const sideNav = document.getElementById('side-nav');
    console.log(sideNav.style.width);
    if (sideNav.style.width === '250px') {
        sideNav.style.width = '0px';
    } else {
        sideNav.style.width = '250px';
    }
});

const sideNav = document.getElementById('side-nav');
for (const a of sideNav.getElementsByTagName('a')) {
    a.addEventListener('click', closeSideNav);
}

const navCloseButton = document.getElementById('nav-close');
navCloseButton.addEventListener('click', closeSideNav);

function closeSideNav() {
    const sideNav = document.getElementById('side-nav');
    sideNav.style.width = '0px';
}