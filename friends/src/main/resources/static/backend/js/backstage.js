// Ottieni l'elemento dell'immagine principale
const mainImage = document.getElementById('mainImage');

// Funzione per cambiare l'immagine principale
function changeMainImage(thumbnail) {
  mainImage.src = thumbnail.src;
}