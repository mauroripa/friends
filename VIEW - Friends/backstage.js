const mainVideoContainer = document.querySelector('.main-video-container');
const thumbnailList = document.querySelector('.thumbnail-list');

// Funzione per caricare il video o l'immagine principale
function loadMainContent(source, type) {
  mainVideoContainer.innerHTML = '';
  const element = type === 'video' ? document.createElement('video') : document.createElement('img');
  element.src = source;
  element.controls = type === 'video';
  mainVideoContainer.appendChild(element);
}

// Funzione per caricare le anteprime dei video/immagini
function loadThumbnails(sources) {
  thumbnailList.innerHTML = '';
  sources.forEach(source => {
    const li = document.createElement('li');
    const img = document.createElement('img');
    img.src = source.thumbnail;
    img.addEventListener('click', () => loadMainContent(source.url, source.type));
    li.appendChild(img);
    thumbnailList.appendChild(li);
  });
}

// Esempio di dati di prova
const sources = [
  { url: 'video1.mp4', type: 'video', thumbnail: 'thumb1.jpg' },
  { url: 'image1.jpg', type: 'image', thumbnail: 'thumb2.jpg' },
  { url: 'video2.mp4', type: 'video', thumbnail: 'thumb3.jpg' },
  // Aggiungi altri video/immagini qui
];

// Carica il primo video/immagine come contenuto principale
loadMainContent(sources[0].url, sources[0].type);

// Carica le anteprime dei video/immagini
loadThumbnails(sources);
