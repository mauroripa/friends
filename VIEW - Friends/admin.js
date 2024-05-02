const initApp = () => {
    //selezionamo il div con classe droparea
    const droparea = document.querySelector('.droparea');
//funzione che fa diventare il bordo verde se viene messo un file
    const active = () => droparea.classList.add("green-border"); 
//funzione che rimuove la green area se non viene droppato file
    const inactive = () => droparea.classList.remove("green-border");
    //
    const prevents = (e) => e.preventDefault();
/*
dragenter: entri nell'area definita
dragover: controlla in ogni millisecondo se stiamo trascinando un file
dragleave: controlla ogni ms se non stiamo trascinando un file
drop: se lasciamo il file nella droparea 
*/
    ['dragenter', 'dragover', 'dragleave', 'drop'].forEach(evtName => {
        //per ognuno di questi eventi 
        droparea.addEventListener(evtName, prevents);
        //chiameremo la funzione prevents
    });
//se il file è nell'area e se lo stiamo mumovendo su quell'area
    ['dragenter', 'dragover'].forEach(evtName => {
//attiva la funzione active e cambia lo sfondo del droparea verde
        droparea.addEventListener(evtName, active);
    });
//se il file non c'è cambia lo sfondo in rosso
    ['dragleave', 'drop'].forEach(evtName => {
        droparea.addEventListener(evtName, inactive);
    });
    //attiva la funzione handleDrop se viene droppato un file
    droparea.addEventListener("drop", handleDrop);

}
//Arrow function - funzioni freccia: sono delle funzioni anonime scritte con una sintassi veloce
/*
document.getElementById("insert").addEventListener("click", inserisci);
const insertForm = document.getElementById("insertForm");
const options = document.getElementById("options");
function inserisci(){
    insertForm.style.display = "block";
    options.style.display = "none";
}
*/
document.addEventListener("DOMContentLoaded", initApp); //quando l'evento DOMContentLoaded si attiva parte la funzione initApp
// evento e dato da evento drop
const handleDrop = (e) => {

    const dt = e.dataTransfer;
    //otteniamo i nostri files
    const files = dt.files;
    //salviamo tutte le info del file in un array
    const fileArray = [...files];
    console.log(files); // FileList restituisce le info del file
    console.log(fileArray);//restituisce 
  if (fileArray.length > 0 && fileArray.length <=5) {
    document.querySelector(".droparea").innerHTML = ""; 
    document.querySelector(".droparea").innerHTML += "Ok! File caricato.";
  } //Da capire se implementare il limite di file di caricamento e se creare un'animazione di popup/blocco del caricamento
}

// const inserisci= document.querySelector
// document.addEventListener("onclick", inserisci);
function apri(){
    const categorie = document.querySelector(".carta");
    const pulsante = document.getElementById("pulsanteCat");
    const pulsanteX = document.getElementById("pulsanteX");
    const title = document.getElementById("title");
    categorie.classList.remove("hidden");
    categorie.classList.add("show");
    pulsante.style.display="none";
    pulsanteX.style.display = "block";
    title.style.display = "block";
}
function chiudi(){
    const categorie = document.querySelector(".carta");
    const pulsante = document.getElementById("pulsanteCat");
    const pulsanteX = document.getElementById("pulsanteX");
    const title = document.getElementById("title");

    categorie.classList.remove("show");
    categorie.classList.add("hidden");

    pulsante.style.display = "block";
    pulsanteX.style.display = "none";
    title.style.display = "none";

}
function apriins(){
    const categorie = document.querySelector(".cartaIns");
    const pulsante = document.getElementById("pulsanteIns");
    const pulsanteX = document.getElementById("pulsanteXIns");
    const title = document.getElementById("titleIns");
    console.log("ciao");
    categorie.classList.remove("hidden");
    console.log("come");
    categorie.classList.add("show");
    console.log("stai");
    pulsante.style.display="none";
    console.log("come");

    pulsanteX.style.display = "block";
    console.log("come");

    title.style.display = "block";
    console.log("bene")
}
function chiudiins(){
    const categorie = document.querySelector(".cartaIns");
    const pulsante = document.getElementById("pulsanteIns");
    const pulsanteX = document.getElementById("pulsanteXIns");
    const title = document.getElementById("titleIns");

    categorie.classList.remove("show");
    categorie.classList.add("hidden");

    pulsante.style.display = "block";
    pulsanteX.style.display = "none";
    title.style.display = "none";

}
function apriadm(){
    const categorie = document.querySelector(".cartaAdm");
    const pulsante = document.getElementById("pulsanteAdm");
    const pulsanteX = document.getElementById("pulsanteXAdm");
    const title = document.getElementById("titleAdmin");
    console.log("ciao");
    categorie.classList.remove("hidden");
    console.log("come");
    categorie.classList.add("show");
    console.log("stai");
    pulsante.style.display="none";
    console.log("come");

    pulsanteX.style.display = "block";
    console.log("come");

    title.style.display = "block";
    console.log("bene")
}
function chiudiadm(){
    const categorie = document.querySelector(".cartaAdm");
    const pulsante = document.getElementById("pulsanteAdm");
    const pulsanteX = document.getElementById("pulsanteXAdm");
    const title = document.getElementById("titleAdmin");

    categorie.classList.remove("show");
    categorie.classList.add("hidden");

    pulsante.style.display = "block";
    pulsanteX.style.display = "none";
    title.style.display = "none";

}
function mostra(){
    const password = document.getElementById("password");
    const occhio = document.getElementById("occhio");
    password.innerHTML = "abc";
    
   
}
