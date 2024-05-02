
const list_category = document.querySelector('.list-category')
const new_category_form = document.querySelector('.category-container form.needs-validation')
const new_category_btn = document.querySelector('.new-category')
const new_category_btn_close = document.querySelector('.new-category .close')
const new_category_btn_pencil = document.querySelector('.new-category .pencil')


const hundle_click = () => {

    if( new_category_btn_pencil && new_category_btn.classList.contains('routed') ) {
        new_category_btn_pencil.classList.remove('d-none')
        new_category_btn_close.classList.add('d-none')
    }

    list_category.classList.toggle('d-none')
    new_category_form.classList.toggle('d-none')
    new_category_btn.classList.toggle('routed')
}

new_category_btn.addEventListener('click', ev=>hundle_click(), false)