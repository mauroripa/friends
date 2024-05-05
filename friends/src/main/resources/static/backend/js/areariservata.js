/*
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

*/



const handle_column = (btn) => {

    const container = btn.closest('.col-content-manager')
    const carta = container.querySelector('.carta')
    const fix_content_height = carta.querySelector('.carta-content-fix')

    container.classList.toggle('open')
    carta.scrollTop = 0;

    carta.style.height = (
        container.classList.contains('open')
            ? (fix_content_height.offsetHeight + 10) + 'px'
            : 0
    )
}

const open_column = document.querySelectorAll('.open-column')
open_column.forEach(btn => btn.addEventListener('click', ev => handle_column(btn), false))

const close_column = document.querySelectorAll('.close-column')
close_column.forEach(btn => btn.addEventListener('click', ev => handle_column(btn), false))


const handle_password_eyes = (btn) => {

    const container = btn.closest('.pwd-info')
    const pwd = container.querySelector('.password[pwd]')
    const password = pwd.getAttribute('pwd')

    container.classList.toggle('see')

    if (!container.classList.contains('see')) {
        pwd.textContent = password.replace(/\w/g, '*')
    } else {
        pwd.textContent = password
    }
}
const show_passwords = document.querySelectorAll('.container-eyes')
show_passwords.forEach(btn => btn.addEventListener('click', ev => handle_password_eyes(btn), false))