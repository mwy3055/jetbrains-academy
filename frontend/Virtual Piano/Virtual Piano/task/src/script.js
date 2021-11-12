document.addEventListener("keydown", function (event) {
    if (event.key === 'a') {
        let audio = new Audio("sounds/A.mp3");
        audio.play();
    } else if (event.key === 's') {
        let audio = new Audio("sounds/S.mp3");
        audio.play();
    } else if (event.key === 'd') {
        let audio = new Audio("sounds/D.mp3");
        audio.play();
    } else if (event.key === 'f') {
        let audio = new Audio("sounds/F.mp3");
        audio.play();
    } else if (event.key === 'g') {
        let audio = new Audio("sounds/G.mp3");
        audio.play();
    } else if (event.key === 'h') {
        let audio = new Audio("sounds/H.mp3");
        audio.play();
    } else if (event.key === 'j') {
        let audio = new Audio("sounds/J.mp3");
        audio.play();
    } else if (event.key === 'w') {
        let audio = new Audio("sounds/W.mp3");
        audio.play();
    } else if (event.key === 'e') {
        let audio = new Audio("sounds/E.mp3");
        audio.play();
    } else if (event.key === 't') {
        let audio = new Audio("sounds/T.mp3");
        audio.play();
    } else if (event.key === 'y') {
        let audio = new Audio("sounds/Y.mp3");
        audio.play();
    } else if (event.key === 'u') {
        let audio = new Audio("sounds/U.mp3");
        audio.play();
    } else {
        console.log("Warning!")
    }
});