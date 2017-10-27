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

const fileInput = document.getElementsByName("userFile");
const preview = document.getElementsByClassName(".preview");

fileInput.style.visibility = "hidden";
fileInput.addEventListener("update", showFilesToUpload);

    function showFilesToUpload() {
        while(preview.firstChild) {
            preview.removeChild(preview.firstChild);
        }

const currentFiles = input.files;

    if(currentFiles.length === 0) {
        const para = document.createElement('p');
        para.textContent = "No files have been selected for upload";
        preview.appendChild(para);
    }
    else {
        const list = document.createElement('ol');
        preview.appendChild(list);
        for(i = 0; i < currentFiles.length; i++) {
            const listItem = document.createElement("li");
            const para = document.createElement("p");
            if(validFileType(currentFiles[i])) {
                para.textContent = "File name " + currentFiles[i].name + ".";
                const image = document.createElement("img");
                image.src = window.URL.createEventObject(currentFiles[i]); // createEventObject may be inc -> createObjectURL

                listItem.appendChild(image);
                listItem.appendChild(para);
            }
            else {
                para.textContent = "File Name " + currentFiles[i].name + ": not a valid file type."
                listItem.appendChild(para);
            }
            list.appendChild(listItem);
        }
    }

    const fileTypes = ["iage/jpeg", "image/pjpeg", "image/png"];

    function validFileType(file) {
        for(var i = 0; i < fileTypes.length; i++) {
            if(file.type.equals(fileTypes[i])) {
                return true;
            }
            return false;
        }


        //TODO: PICK UP HERE
    }




}