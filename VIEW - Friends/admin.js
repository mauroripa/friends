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