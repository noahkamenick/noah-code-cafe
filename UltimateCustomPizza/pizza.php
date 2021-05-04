<?php //Noah Kamenick | C2-248 Section 2 | Pizza Project Final //THIS FILE IS NOT USED, FIRST ATTEMPT




?>


<!DOCTYPE html>

<html lang="en">

<head>
<!-- Utilized the bootstrap framework for clean UI design and mobile optimization, some of those references and settings are below -->
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <link rel="stylesheet" href="pizza.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>


    <title>CustomPizza</title>

</head>

<body>
    <?php

    $statesFileLength = 0;
    $crustFileLength = 0;
    $sauceFileLength = 0;
    $proteinFileLength = 0;
    $veggieFileLength = 0;
    $cheeseFileLength = 0;

    //PHP var declarations


    ?>

    <!-- Static Heading -->

    <div class="container-md header-fix sticky-top" id="centered_container">

        <!-- Center Heading/Flow -->

        <h1 id="heading">UltimateCustomPizza</h1>


        <div class="progress">
            <div class="progress-bar animate__animated animate__slideInLeft" id="progressBar" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">Create</div>
        </div>

    </div>



    <!-- Create Pizza Container -->

    <div class="container-md animate__animated animate__fadeInLeftBig" id="createPizzaContainer">

        <!-- Create Pizza Heading -->

        <h3 id="createPizzaHeading">Create your Pizza</h3>

        <fieldset id="fieldset">

            <!-- Crust Accordion -->

            <div class="accordion" id="pizzaCreation">
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Crust
                            </button>
                        </h2>
                    </div>
                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#pizzaCreation">
                        <div class="card-body">

                            <!-- Crust Options -->
                            <h4>Choose your crust | $5</h4>
                            <?php
                            //Extract crust values delimited by dash from crust.txt for crust radio creation
                            foreach (file("pizzaConfig/crust.txt") as $crustType) {
                                list($short, $crustType) = explode("-", $crustType); //This was supposed to automate the display of options 
                                //from a textfile to add a more dynamic, modular feel to managing to website
                            ?>

                                <div class="form-check">
                                    <input class="form-check-input crustRadioClass" type="radio" name="crustRadios" id="crustRadios<?= $short ?>" value="5">
                                    <label class="form-check-label" for="crustRadios<?= $short ?>">
                                        <?= $crustType ?>
                                    </label>
                                </div>

                            <?php $crustFileLength += 1; //Add 1 to the file length variable
                            } ?>

                        </div>
                    </div>
                </div>

                <!-- Sauce Card -->

                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                Sauce
                            </button>
                        </h2>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#pizzaCreation">
                        <div class="card-body">
                            <!-- Sauce Options -->
                            <h4>Choose your sauce | $2</h4>

                            <?php
                            //Extract sauce values delimited by dash from sauce.txt for sauce radio creation
                            foreach (file("pizzaConfig/sauce.txt") as $sauceType) {
                                list($short, $sauceType) = explode("-", $sauceType);//This was supposed to automate the display of options 
                                //from a textfile to add a more dynamic, modular feel to managing to website
                            ?>

                                <div class="form-check">
                                    <input class="form-check-input sauceRadioClass" type="radio" name="sauceRadios" id="sauceRadios<?= $short ?>" value="2">
                                    <label class="form-check-label" for="sauceRadios<?= $short ?>">
                                        <?= $sauceType //grab value ?>
                                    </label>
                                </div>

                            <?php $sauceFileLength += 1; //Again, add to the sauceFileLength Var to indicate the size of file
                            } ?>

                            <!-- One checkbox outside of loop for different value -->

                            <div class="form-group form-check">
                                <input class="form-check-input" type="radio" name="sauceRadios" id="sauceRadiosNone" value="0">
                                <label class="form-check-label" for="sauceRadiosNone">None</label>

                            </div>
                        </div>
                    </div>
                </div>

                <!-- Cheese Card -->

                <div class="card">
                    <div class="card-header" id="headingThree">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                Cheese
                            </button>
                        </h2>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#pizzaCreation">
                        <div class="card-body">
                            <!-- Cheese Options -->
                            <h4>Choose your Cheese | $5</h4>

                            <?php
                            //Extract cheese values delimited by dash from cheese.txt for cheese checkbox creation
                            foreach (file("pizzaConfig/cheese.txt") as $cheeseType) {
                                list($short, $cheeseType) = explode("-", $cheeseType);

                            ?>
                                <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input cheeseCheckClass" id="cheeseCheck<?= $short ?>" value="5">
                                    <label class="form-check-label" for="cheeseCheck<?= $short ?>"><?= $cheeseType ?></label>
                                </div>

                            <?php $cheeseFileLength += 1;
                            } ?>

                            <!-- One checkbox outside of loop for different value -->

                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="cheeseCheckNone" onclick="checkNoneCheese()" value="0">
                                <label class="form-check-label" for="cheeseCheckNone">None</label>
                            </div>

                        </div>
                    </div>
                </div>

                <!-- Protein Card -->

                <div class="card">
                    <div class="card-header" id="headingFour">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                Protein
                            </button>
                        </h2>
                    </div>
                    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#pizzaCreation">
                        <div class="card-body">

                            <h4>Choose your protein | $3 per</h4>

                            <?php
                            //Extract protein values delimited by dash from protein.txt for protein radio creation
                            foreach (file("pizzaConfig/protein.txt") as $proteinType) {
                                list($short, $proteinType) = explode("-", $proteinType);

                            ?>
                                <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input proteinCheckClass" id="proteinCheck<?= $short ?>" value="3">
                                    <label class="form-check-label" for="proteinCheck<?= $short ?>"><?= $proteinType ?></label>
                                </div>

                            <?php $proteinFileLength += 1;
                            } ?>

                            <!-- One checkbox outside of loop for different value -->

                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="proteinCheckNone" value="0" onclick="checkNoneProtein()">
                                <label class="form-check-label" for="proteinCheckNone">None</label>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Veggies Card -->

                <div class="card">
                    <div class="card-header" id="headingFive">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                Veggies
                            </button>
                        </h2>
                    </div>
                    <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#pizzaCreation">
                        <div class="card-body">

                            <h4>Choose your Veggies | $4 per</h4>

                            <?php
                            //Extract protein values delimited by dash from protein.txt for protein radio creation
                            foreach (file("pizzaConfig/veggies.txt") as $veggieType) {
                                list($short, $veggieType) = explode("-", $veggieType);

                            ?>
                                <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input veggieCheckClass" id="veggieCheck<?= $short ?>" value="4">
                                    <label class="form-check-label" for="veggieCheck<?= $short ?>"><?= $veggieType ?></label>
                                </div>

                            <?php $veggieFileLength += 1;
                            } ?>

                            <!-- One checkbox outside of loop for different value -->

                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="veggieCheckNone" onclick="checkNoneVeggie()" value="0">
                                <label class="form-check-label" for="veggieCheckNone">None</label>
                            </div>

                            <button type="button" class="btn btn-success" onclick="validate()">Next</button>

                        </div>
                    </div>
                </div>

            </div>

        </fieldset>
    </div>

    <!-- Form Container -->

    <div class="container-md animate__animated animate__fadeInRightBig d-none" id="formContainer">
        <form action="" class="row g-3 form-floating" id="form-class" method="post">
            <div class="col-md-6">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control formField" id="firstName" name="fName">
            </div>
            <div class="col-md-6">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control formField" id="lastName" name="lName">
            </div>
            <div class="col-12">
                <label for="inputAddress" class="form-label">Address</label>
                <input type="text" class="form-control formField" id="inputAddress" name="addOne">
            </div>
            <div class="col-12">
                <label for="inputAddress2" class="form-label">Address 2</label>
                <input type="text" class="form-control formField" id="inputAddress2" name="addTwo">
            </div>
            <div class="col-md-6">
                <label for="inputCity" class="form-label">City</label>
                <input type="text" class="form-control formField" id="inputCity" name="city">
            </div>
            <div class="col-md-4 align-self-center" id="state_col">
                <label for="inputState" class="form-label">State</label>
                <select id="inputState" class="form-select">
                    <?php
                    //Extract state values delimited by dash from states.txt for state form dropdown
                    foreach (file("pizzaConfig/states.txt") as $state) {
                        list($short, $name) = explode("-", $state);
                    ?>
                        <option value="<?= $short ?>"><?= $name ?></option>

                    <?php $statesFileLength += 1;
                    } ?>

                </select>
                <div class="invalid-feedback">Please Select a State</div>
            </div>
            <div class="col-md-2">
                <label for="inputZip" class="form-label">Zip</label>
                <input type="text" class="form-control formField" id="inputZip" name="zip">
            </div>
            <div class="col-12">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="eatCheck">
                    <label class="form-check-label" for="eatCheck" id="eatLabel">
                        I agree to eat this pizza
                    </label>
                </div>
            </div>
            <div class="col-12">
                <button type="submit" id="checkoutbutton" onclick="validateContact()" class="btn btn-primary formValidateButtons">Check out</button>

                <?php

                $servername = "sql5.freemysqlhosting.net"; //
                $database = "sql5408429"; //
                $username = "sql5408429"; // SQL DB Login Credentials
                $password = "haMunnTIay"; //

                $conn = mysqli_connect($servername, $username, $password, $database); //Creates a SQL connection and stores in the conn variable

                if (!$conn) //If conn is false
                {

                    die("Connection Failed: " . mysqli_connect_error()); //Feedback if connection fails

                }

                //echo "Connected Successfully"; //Check for successful SQL DB connection

                mysqli_close($conn); //Close the SQL DB connection

                $first_name = mysqli_real_escape_string($conn, $_REQUEST['fName']);
                $last_name = mysqli_real_escape_string($conn, $_REQUEST['lName']);
                $addressOne = mysqli_real_escape_string($conn, $_REQUEST['addOne']);
                $addTwo = mysqli_real_escape_string($conn, $_REQUEST['addTwo']); 
                $city = mysqli_real_escape_string($conn, $_REQUEST['city']);
                $zip = mysqli_real_escape_string($conn, $_REQUEST['zip']);


                $sql = "INSERT INTO contact (fName, lName, addOne, addTwo, city,zip) VALUES ('$first_name', '$last_name', '$addressOne', '$addTwo', '$city','$zip')";
                if (mysqli_query($conn, $sql)) {
                    echo "Records added successfully.";
                } else {
                    echo "ERROR: Could not " . mysqli_error($conn);
                }


                mysqli_close($conn);






                ?>

                <button type="button" id="backbutton" onclick="backToCreate()" class="btn btn-secondary formValidateButtons">Go Back</button>
            </div>
        </form>


    </div>

    <script>
        var numLinesInStates = "<?= $statesFileLength ?>"; //
        var numLinesCrust = "<?= $crustFileLength ?>"; //
        var numLinesSauce = "<?= $sauceFileLength ?>"; ////////// Copy variables initialized and incremented by PHP to JS
        var numLinesProtein = "<?= $proteinFileLength ?>"; //
        var numLinesVeggies = "<?= $veggieFileLength ?>"; //
        var numLinesCheese = "<?= $cheeseFileLength ?>"; //
    </script>
    <script src="pizza.js"></script>
</body>

</html>