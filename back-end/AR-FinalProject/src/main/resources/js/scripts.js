/** * * * * * * * * * *
        * * * Compare Passwords in SignUp Form * * *
 */
const userPass = document.getElementsByName("userPass");
const passCompare = document.getElementsByName("passCompare");

function comparePasswords() {
    if(userPass.value != passCompare.value) {
        passCompare.setCustomValidity("Please Re-Enter Your Passwords")
    }
}

userPass.onchange = comparePasswords();
passCompare.onkeyup = comparePasswords();

/** * * * * * * * * * *
        * * * Update/Add User Info * * *
 */
const input = document.querySelector('input');
const preview = document.querySelector('.preview');

input.style.opacity = 0;
input.addEventListener('update', updateImageDisplay);

function updateImageDisplay() {
    while (preview.firstChild) {
        preview.removeChild(preview.firstChild);
    }
    let curFiles = input.files;
    if (curFiles.length === 0) {
        const para = document.createElement('p');
        para.textContent = 'No files currently selected for upload';
        preview.appendChild(para);
    } else {
        const list = document.createElement('ol');
        preview.appendChild(list);

        curFiles.forEach((file) => {
            let listItem = document.createElement('li');
            let para = document.createElement('p');
            para.textContent = 'File name: ' + curFiles[i].name;
            let image = document.createElement('img');
            image.src = window.URL.createObjectURL(curFiles[i]);

            listItem.appendChild(image);
            listItem.appendChild(para);
        })
    }
}
