var progressBar = document.getElementById("progressBar");
var formContainer = document.getElementById("formContainer");
var createPizzaContainer = document.getElementById("createPizzaContainer");
var crustRadio = document.getElementsByClassName("crustRadioClass");
var sauceRadio = document.getElementsByClassName("sauceRadioClass");
var sauceRadioNone = document.getElementById("sauceRadiosNone");
var cheeseCheckNone = document.getElementById("cheeseCheckNone");
var cheeseCheck = document.getElementsByClassName("cheeseCheckClass");
var proteinCheck = document.getElementsByClassName("proteinCheckClass");
var proteinCheckNone = document.getElementById("proteinCheckNone");
var veggieCheckNone = document.getElementById("veggieCheckNone");
var veggieCheck = document.getElementsByClassName("veggieCheckClass");
var validateAlert = document.getElementById("validAlert");
var formFields = document.getElementsByClassName("formField");
var eatCheck = document.getElementById("eatCheck");
var eatLabel = document.getElementById("eatLabel");
var checkOut = document.getElementById("checkoutbutton");
var stateSelectedFlag = false;
var crustFlag = false;
var sauceFlag = false;
var cheeseFlag = false;
var proteinFlag = false;
var veggieFlag = false;
var formValid = false;
var contactFlags = [fName = false,lName = false,addOne = false,add2 = false,city = false,zip = false,eatFlag = false];

function backToCreate() {
    //this makes the first page keep its values and js when the user hits "go back"
    formContainer.classList.add("d-none");
    createPizzaContainer.classList.remove("d-none");
    progressBar.setAttribute("aria-value", "33");
    progressBar.style = "width: 33%; background-color: null;";
    progressBar.innerHTML = "Create";
    checkNoneProtein;
    checkNoneCheese;
    checkNoneVeggie;
    

}

//these are the referenced functions for making sure the checkboxes stay blurred if none is selected 
function checkNoneProtein() {

    if (proteinCheckNone.checked) {

        for (i = 0; i < numLinesProtein; i++) {

            proteinCheck[i].checked = false;
            proteinCheck[i].setAttribute("disabled", "");


        }

    }

    else {
        for (i = 0; i < numLinesProtein; i++) {

            proteinCheck[i].removeAttribute("disabled");


        }

    }



}

function checkNoneCheese() {

    if (cheeseCheckNone.checked) {

        for (i = 0; i < numLinesCheese; i++) {

            cheeseCheck[i].checked = false;
            cheeseCheck[i].setAttribute("disabled", "");


        }

    }

    else {
        for (i = 0; i < numLinesCheese; i++) {

            cheeseCheck[i].removeAttribute("disabled");


        }

    }



}

function checkNoneVeggie() {

    if (veggieCheckNone.checked) {

        for (i = 0; i < numLinesVeggies; i++) {

            veggieCheck[i].checked = false;
            veggieCheck[i].setAttribute("disabled", "");


        }

    }

    else {
        for (i = 0; i < numLinesVeggies; i++) {

            veggieCheck[i].removeAttribute("disabled");

        }

    }



}




//Validate function validates the custom pizza form
function validate() {

    for (i = 0; i < crustRadio.length; i++) {
        if (crustRadio[i].checked) {

            crustFlag = true;
            break;

        }

        else {
            crustFlag = false;

        }


    }

    for (i = 0; i < sauceRadio.length; i++) {

        if (sauceRadio[i].checked || sauceRadioNone.checked) {

            sauceFlag = true;
            break;

        }

        else {
            sauceFlag = false;

        }
    }

    for (i = 0; i < cheeseCheck.length; i++) {

        if (cheeseCheck[i].checked || cheeseCheckNone.checked) {

            cheeseFlag = true;
            break;

        }

        else {
            cheeseFlag = false;

        }

    }

    for (i = 0; i < proteinCheck.length; i++) {

        if (proteinCheck[i].checked || proteinCheckNone.checked) {

            proteinFlag = true;
            break;

        }

        else {

            proteinFlag = false;

        }


    }

    for (i = 0; i < veggieCheck.length; i++) {

        if (veggieCheck[i].checked || veggieCheckNone.checked) {

            veggieFlag = true;
            break;

        }

        else {

            veggieFlag = false;

        }


    }

    if(crustFlag == true && sauceFlag == true && cheeseFlag == true && proteinFlag == true && veggieFlag == true)
    {

        enableForm();

    }

    else {

        alert("Please make sure at least one field is selected in each section");

    }



    console.log("Crust Selected: " + crustFlag);
    console.log("Sauce Selected: " + sauceFlag);
    console.log("Cheese Selected: " + cheeseFlag);
    console.log("Protein Selected: " + proteinFlag);
    console.log("Veggies Selected: " + veggieFlag);


}
//This changes the progress bar at the top when the page goes to the contact page
function enableForm() {

    createPizzaContainer.classList.add("d-none");
    formContainer.classList.remove("d-none");
    progressBar.setAttribute("aria-value", "66");
    progressBar.style = "width: 66%; background-color: coral;";
    progressBar.innerHTML = "Contact";


}
//this function validates the multiple form textboxes
function validateContact() {

    //check if fields have value

    for (i=0; i < 6; i++)
    {

        if(formFields[i].value)
        {
            //Add classes because bootstrap has predefined graphical elements for error handling via classes
            formFields[i].classList.remove("is-invalid");
            formFields[i].classList.add("is-valid");
            contactFlags[i] = true; 
            
        }

        if(!formFields[i].value)
        {

            formFields[i].classList.remove("is-valid");
            formFields[i].classList.add("is-invalid");
            contactFlags[i] = false; 
        }
    }

    if (eatCheck.checked)
    {
        
        eatCheck.classList.add("is-valid");
        eatCheck.classList.remove("is-invalid");
        eatLabel.classList.add("is-valid");
        eatLabel.classList.remove("is-invalid");
        contactFlags[6] = true;
    }

     if (!eatCheck.checked)
    {
        
        eatCheck.classList.add("is-invalid");
        eatCheck.classList.remove("is-valid");
        eatLabel.classList.add("is-invalid");
        eatLabel.classList.remove("is-valid");
        contactFlags[6] = false; 
    }
    
    if(contactFlags[0] == true && contactFlags[1] == true && contactFlags[2] == true && 
        contactFlags[3] == true && contactFlags[4] == true && contactFlags[5] == true && contactFlags[6] == true)
        {

            
            
            checkOut.setAttribute("type", "submit");



        }

    else {

        console.log("not everything is filled out/selected");
        return;
    }
    
    
       
}





//Console log on some vars with values given by PHP
console.log(sauceRadio.length);
console.log(crustRadio.length);


//Sets the submit button to a button so it doesn't submit until the appropriate code calls the type attribute to be changed, so it doesn't submit willy nilly
checkOut.setAttribute("type", "button");
