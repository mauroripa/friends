function scrollToSection(sectionId) {
    var section = document.getElementById(sectionId);
    section.scrollIntoView({ behavior: 'smooth' });
  }
function scrollArrowUp(id){
  var sectionTop = document.getElementById(id);
  sectionTop.scrollIntoView({ behavior:'smooth'});
}