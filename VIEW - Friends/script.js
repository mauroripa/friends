const card = document.querySelector('.card');

const image = card.querySelector('img');
const video = card.querySelector('video');

video.style.display = 'none'; 

// Transizione video
video.style.transition = "opacity 1s";

card.addEventListener('mouseover', () => {

  image.style.display = 'none';

  video.style.display = 'block';
  video.style.opacity = 0;

  video.play();

  // Dissolvenza solo sul video
  setTimeout(() => {
    video.style.opacity = 1;
  }, 100); 

});


card.addEventListener('mouseout', () => {

  video.style.display = 'none';
  image.style.display = 'block'; 

});






























