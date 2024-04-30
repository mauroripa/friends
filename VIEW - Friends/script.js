const card = document.querySelectorAll('.card');

/*
const image = card.querySelector('img'); 
const video = card.querySelector('video1');


*/
card.forEach(item => item.addEventListener('mouseover', () => {


  const image = item.querySelector('img');
  const video = item.querySelector('video');
  if (video) {
    console.log(image);
    console.log(video);
    // Nascondere l'immagine

    image.style.display = 'none';

    video.style.display = 'block';

    video.style.opacity = 0;

    video.play();

    // Dissolvenza solo sul video
    setTimeout(() => {
      video.style.opacity = 1;
    }, 100);
  }

}));


card.forEach(item => item.addEventListener('mouseout', () => {
  const image = item.querySelector('img');
  const video = item.querySelector('video');

  if (video) {

    video.style.display = 'none';

    // Transizione video
    video.style.transition = "opacity 1s";

    video.style.display = 'none';
    image.style.display = 'block';
  }

}));






































