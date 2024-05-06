var originalFoto;
var originalFotoWidth;
var originalFotoHeigth;

function setImg(img) {
    var bigFoto = document.getElementById("bigFoto");
    originalFoto = bigFoto.src;
    originalFotoWidth = bigFoto.width;
    originalFotoHeigth = bigFoto.height;
    bigFoto.src = img.src;
    bigFoto.style.width = originalFotoWidth + "px";
    bigFoto.style.height = originalFotoHeigth + "px";
}

function setOldImg() {
    var bigFoto = document.getElementById("bigFoto"); // Correzione: definisci bigFoto all'interno di questa funzione
    bigFoto.src = originalFoto;
    bigFoto.style.width = originalFotoWidth + "px";
    bigFoto.style.height = originalFotoHeigth + "px";
}
