const card = document.querySelectorAll('.card');


const open_card = (ev, item) => {

	ev.stopPropagation()

	const image = item.querySelector('img');
	const video = item.querySelector('video');
	const testo = item.querySelector('.titolocard');
	const paragrafo = item.querySelector('.paragrafo');

	if (video) {

		// Nascondere l'immagine
		image.style.display = 'none';
		paragrafo.style.display = 'block';
		testo.style.display = 'block';
		video.style.display = 'block';
		video.style.opacity = 0;
		video.play();

		// Dissolvenza solo sul video
		setTimeout(() => video.style.opacity = 1, 100);
		setTimeout(() => item.classList.add('show'), 500);

		// Aggiungi sfondo scuro
		document.body.classList.remove('bg-body-tertiary');
		document.getElementById('testo').classList.add('bg-body-tertiary');
		document.getElementById('testo').style.opacity = '5%';
		document.getElementById('divlocation').style.opacity = '50%';
		document.getElementById('divlocation').style.zIndex = '-1';
	}
}



const close_card = (ev, item) => {

	ev.stopPropagation()

	const image = item.querySelector('img');
	const video = item.querySelector('video');
	const testo = item.querySelector('.titolocard');
	const paragrafo = item.querySelector('.paragrafo');

	if (video && !item.classList.contains('show')) {
		video.style.display = 'none';
		testo.style.display = 'none';
		paragrafo.style.display = 'none';
		// Transizione video
		video.style.transition = "opacity 1s";
		video.style.display = 'none';
		image.style.display = 'block';

		// Rimuovi sfondo scuro
		document.body.classList.add('bg-body-tertiary');
		document.getElementById('testo').classList.remove('bg-body-tertiary');
		document.getElementById('testo').style.opacity = '100%';
		document.getElementById('divlocation').style.opacity = '100%';
	}
}


card.forEach(item => {

	item.addEventListener('click', (ev) => open_card(ev, item));

	const close = item.querySelector('.close-card')
	close && close.addEventListener('click', (ev) => {
		item.classList.remove('show')
		close_card(ev, item)
	})

	item.addEventListener('mouseleave', (ev) => close_card(ev, item));
});






































