/** * * * * * * * * * *
        * * * Compare Passwords in form * * *
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