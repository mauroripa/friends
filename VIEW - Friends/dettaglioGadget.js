
function setImg(img){
var bigFoto = document.getElementById("bigFoto");
originalFoto = bigFoto.src;
bigFoto.src = img.src;
}
function setOldImg(){
    var smallfoto=document.getElementById("bigFoto");
    bigFoto.src = originalFoto;
}