
/**
 * The function `column_fix_height` adjusts the height of a container element based on its child
 * elements.
 * @param container - The `container` parameter is a reference to the parent element that contains the
 * elements with the classes `.carta` and `.carta-content-fix`. The function `column_fix_height`
 * calculates and sets the height of the `.carta` element based on whether the container has the class
 * `open`
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

// fix column on edit content or edit column mode
const pre_opened_columns = document.querySelector('.col-content-manager.open')
pre_opened_columns && column_fix_height(pre_opened_columns)

/**
 * The `handle_column` function toggles the 'open' class on a container element and scrolls the content
 * to the top.
 * @param btn - The `btn` parameter in the `handle_column` function is a reference to the button
 * element that triggered the event.
 */
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


/**
 * The function `handle_password_eyes` toggles between displaying a password as plain text or masked
 * with asterisks.
 * @param btn - The `btn` parameter in the `handle_password_eyes` function is a reference to the button
 * element that triggered the function.
 */
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
const drop_area = document.querySelector('.droparea')
const thumbnails = document.querySelector('.thumbnails .thumbnails-content')

/**
 * The function `drag_image_in` adds a class of 'hover' to the drop area element.
 */
const drag_image_in = () => {
    drop_area.classList.add('hover')
}

/**
 * The function `drag_image_out` removes the classes 'hover' and 'is-invalid' from the drop area
 * element and adds the class 'droped'.
 */
const drag_image_out = () => {
    drop_area.classList.remove('hover')
    drop_area.classList.remove('is-invalid')
    drop_area.classList.add('droped')
}

drop_area.addEventListener('dragenter', ev => drag_image_in(), false)
drop_area.addEventListener('dragover', ev => drag_image_in(), false)
drop_area.addEventListener('dragleave', ev => drag_image_out(), false)
drop_area.addEventListener('drop', ev => drag_image_out(), false)


/**
 * The function `remove_item_btn` creates a remove button with an SVG icon and functionality to remove
 * an item from a list and update the display accordingly.
 * @param item - The `item` parameter in the `remove_item_btn` function represents the HTML element
 * that you want to remove when the remove button is clicked. This element is typically an image or a
 * file preview that you want to delete from a list or display area. When the remove button is clicked,
 * the associated
 * @param file - The `file` parameter in the `remove_item_btn` function represents the file object that
 * is being removed when the remove button is clicked. This file object is used to identify the
 * specific file that needs to be removed from the list of files displayed in the user interface.
 * @returns The `remove_item_btn` function is returning a dynamically created `<span>` element with a
 * delete icon in SVG format. This element has a click event listener attached to it that removes the
 * specified item from a list of files and updates the UI accordingly.
 */
const remove_item_btn = (item, file) => {

    const remove_btn = document.createElement('span')
    remove_btn.classList.add('remove-image')
    remove_btn.innerHTML = '<svg fill="#000000" width="20" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 460.775 460.775" xml:space="preserve"><path d="M285.08,230.397L456.218,59.27c6.076-6.077,6.076-15.911,0-21.986L423.511,4.565c-2.913-2.911-6.866-4.55-10.992-4.55 c-4.127,0-8.08,1.639-10.993,4.55l-171.138,171.14L59.25,4.565c-2.913-2.911-6.866-4.55-10.993-4.55 c-4.126,0-8.08,1.639-10.992,4.55L4.558,37.284c-6.077,6.075-6.077,15.909,0,21.986l171.138,171.128L4.575,401.505 c-6.074,6.077-6.074,15.911,0,21.986l32.709,32.719c2.911,2.911,6.865,4.55,10.992,4.55c4.127,0,8.08-1.639,10.994-4.55 l171.117-171.12l171.118,171.12c2.913,2.911,6.866,4.55,10.993,4.55c4.128,0,8.081-1.639,10.992-4.55l32.709-32.719 c6.074-6.075,6.074-15.909,0-21.986L285.08,230.397z"/></svg>'

    remove_btn.addEventListener('click', ev => {

        drop_images.files = [...drop_images.files]
            .reduce((dt, f, i) => (f.name !== file.name && dt.items.add(f) && 0) || dt, new DataTransfer())
            .files;

        item.remove();

        if( drop_images.files.length <= 0 && thumbnails.children.length <= 0 ) {
            drop_area.classList.remove('droped')
        }

        column_fix_height(
            drop_images.closest('.col-content-manager')
        )
    }, false)

    return remove_btn
}

/**
 * The function `build_thumbnail_item` creates a thumbnail element for an image or video file with a
 * remove button.
 * @param reader - The `reader` parameter in the `build_thumbnail_item` function is typically an
 * instance of the `FileReader` object in JavaScript. This object allows you to read the contents of
 * files asynchronously. In this context, it is used to read the contents of a file and generate a
 * thumbnail item based on
 * @param file - The `file` parameter in the `build_thumbnail_item` function represents the file that
 * is being processed to create a thumbnail item. The function checks the type of the file to determine
 * whether to create an image element or a video element for the thumbnail item.
 * @returns The `build_thumbnail_item` function returns a dynamically created HTML element (either an
 * image or a video element) based on the type of file being processed. If the file is not a video file
 * (type is not "video/mp4"), an image element is created and returned. If the file is a video file, a
 * video element with a source element is created and returned.
 */
const build_thumbnail_item = (reader, file) => {

    const item = document.createElement('span')
    item.classList.add('image-item')
    item.classList.add('position-relative')

    if( file.type != "video/mp4" ) {

        const img = document.createElement('img')
        img.src = reader.result
        item.append(img)
        item.append(remove_item_btn(item, file))
    } else {

        const video = document.createElement('video')
        const source = document.createElement('source')
        source.src = reader.result

        video.append(source)
        item.append(video)
        item.append(remove_item_btn(item, file))
    }

    return item
}

/**
 * The function `handle_upload_image` reads and displays uploaded image files as thumbnails in a
 * container.
 */
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
drop_images.addEventListener('change', ev => handle_upload_image(), false)


// required all fields before sumbit
const submit_columns = document.querySelectorAll('.col-content-manager [type="submit"]')

/**
 * The function `check_empty_fields` checks for empty fields in a form and adds a CSS class to mark
 * them as invalid.
 * @param form - The `form` parameter in the `check_empty_fields` function is expected to be a
 * reference to an HTML form element. This function is designed to check for empty fields within this
 * form, including input fields, select elements, and textareas. It iterates over these form elements
 * and checks if they
 * @returns The function `check_empty_fields` returns a boolean value indicating whether there are any
 * empty fields in the form. If there are empty fields, it returns `true`, otherwise it returns
 * `false`.
 */
const check_empty_fileds = (form) => {

    let has_empty_fields = false

    const inputs = form.querySelectorAll('input, select, textarea')
    inputs.forEach(el => {
        if(
            el.value == '' ||
            ( el.nodeName == 'SELECT' && el.options[el.selectedIndex].hasAttribute('hidden') )
        ) {
            if(el.nodeName === 'INPUT' && el.type === 'file' && thumbnails.children.length <= 0) {
                el.parentNode.classList.add('is-invalid')
                has_empty_fields = true
            } else if(el.nodeName !== 'INPUT' || (el.nodeName === 'INPUT' && el.type !== 'file')) {
                el.classList.add('is-invalid')
                has_empty_fields = true
            }
        }
    })

    return has_empty_fields
}

/**
 * The function `handle_submit` checks for empty fields in a form and prevents form submission if any
 * are found.
 * @param ev - The `ev` parameter typically represents the event object that is passed to an event
 * handler function in JavaScript. It contains information about the event that occurred, such as the
 * type of event, the target element, and any additional data related to the event. In this case, it is
 * being used in the
 * @param form - The `form` parameter in the `handle_submit` function likely refers to the HTML form
 * element that triggered the submit event. This parameter allows the function to access the form's
 * data and perform validation or other actions based on the form's content.
 */
const handle_submit = (ev, form) => {

        console.log(check_empty_fileds(form))
    if( check_empty_fileds(form) ) {
        ev.stopPropagation()
        ev.preventDefault()
    }
}

submit_columns.forEach(btn => btn.addEventListener('click', ev => handle_submit(ev, btn.closest('form')), false))