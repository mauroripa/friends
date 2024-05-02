function scrollToSection(sectionId) {
    var section = document.getElementById(sectionId);
    section.scrollIntoView({ behavior: 'smooth' });
  }
function scrollArrowUp(id){
  var sectionTop = document.getElementById(id);
  sectionTop.scrollIntoView({ behavior:'smooth'});
}
const scrollToPersonaggio=(btn)=>{
    const personaggio=document.querySelector("section[personaggio='"+ btn.getAttribute('nome-personaggio') +"']")
    //personaggio.scrollIntoView({ behavior:'smooth'});
    window.scrollTo({
        top:personaggio.getBoundingClientRect().top + window.pageYOffset - 100,
        behavior:'smooth'
    })
}
const btn_personaggi = document.querySelectorAll(".btn-personaggio")
btn_personaggi.forEach(btn=>btn.addEventListener("click", ev => scrollToPersonaggio(btn)))