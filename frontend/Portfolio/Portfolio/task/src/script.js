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