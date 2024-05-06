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

const column_fix_height = (container) => {

    const carta = container.querySelector('.carta')
    const fix_content_height = carta.querySelector('.carta-content-fix')

    carta.style.height = (
        container.classList.contains('open')
        ? (fix_content_height.offsetHeight + 10) + 'px'
        : 0
    )
}

const handle_column = (btn) => {

    const container = btn.closest('.col-content-manager')
    const carta = container.querySelector('.carta')

    container.classList.toggle('open')
    carta.scrollTop = 0;

    column_fix_height(container)
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


const drop_images = document.querySelector('.drop-images')
const thumbnails = document.querySelector('.thumbnails')

const build_close_btn = (item, file) => {

    const remove_btn = document.createElement('span')
    remove_btn.innerHTML = '<svg fill="#000000" width="20" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 460.775 460.775" xml:space="preserve"><path d="M285.08,230.397L456.218,59.27c6.076-6.077,6.076-15.911,0-21.986L423.511,4.565c-2.913-2.911-6.866-4.55-10.992-4.55 c-4.127,0-8.08,1.639-10.993,4.55l-171.138,171.14L59.25,4.565c-2.913-2.911-6.866-4.55-10.993-4.55 c-4.126,0-8.08,1.639-10.992,4.55L4.558,37.284c-6.077,6.075-6.077,15.909,0,21.986l171.138,171.128L4.575,401.505 c-6.074,6.077-6.074,15.911,0,21.986l32.709,32.719c2.911,2.911,6.865,4.55,10.992,4.55c4.127,0,8.08-1.639,10.994-4.55 l171.117-171.12l171.118,171.12c2.913,2.911,6.866,4.55,10.993,4.55c4.128,0,8.081-1.639,10.992-4.55l32.709-32.719 c6.074-6.075,6.074-15.909,0-21.986L285.08,230.397z"/></svg>'

    remove_btn.addEventListener('click', ev => {

        drop_images.files = [...drop_images.files]
            .reduce((dt, f, i) => (f.name !== file.name && dt.items.add(f) && 0) || dt, new DataTransfer())
            .files;

        item.remove();

    }, false)

    return remove_btn
}

const build_thumbnail_item = (reader, file) => {

    const item = document.createElement('span')

    if( file.type != "video/mp4" ) {

        const img = document.createElement('img')
        img.src = reader.result
        item.append(img)
        item.append(build_close_btn(item, file))
    } else {

        const video = document.createElement('video')
        const source = document.createElement('source')
        source.src = reader.result

        video.append(source)
        item.append(video)
        item.append(build_close_btn(item, file))
    }

    return item
}

const handle_upload_image = () => {

    const files = drop_images.files;

    Array.from(files).forEach(async file => {

        const reader = new FileReader()

        reader.onload = () => {

            thumbnails.append(
                build_thumbnail_item(reader, file)
            )

            column_fix_height(
                drop_images.closest('.col-content-manager')
            )
        }

        reader.readAsDataURL(file);
    })
}
drop_images.addEventListener('change', ev=>handle_upload_image(), false)