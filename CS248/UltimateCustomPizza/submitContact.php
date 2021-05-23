<?php

$servername = "DB_HostName"; //
$database = "DB_Name"; // 
$username = "DB_User"; // SQL DB Login Credentials
$password = "DB_Password"; //


$conn = mysqli_connect($servername, $username, $password, $database); //Creates a SQL connection and stores in the conn variable

if (!$conn) //If conn is false
{

    die("Connection Failed: " . mysqli_connect_error()); //Feedback if connection fails

}

//echo "Connected Successfully"; //Check for successful SQL DB connection




//Real escape string to make sure respective data is inserted respectfully to its data type in the column
$first_name = mysqli_real_escape_string($conn, $_POST['fName']);
$last_name = mysqli_real_escape_string($conn, $_POST['lName']);
$addressOne = mysqli_real_escape_string($conn, $_POST['addOne']);
$addTwo = mysqli_real_escape_string($conn, $_POST['addTwo']);
$city = mysqli_real_escape_string($conn, $_POST['city']);
$state = mysqli_real_escape_string($conn, $_POST['state']);
$zip = mysqli_real_escape_string($conn, $_POST['zip']);
$orderedItems = mysqli_real_escape_string($conn, $_POST['orderedItems']);
$items = $_POST["items"];
$total = 0;

?>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="pizza.css" />

    <title>CustomPizza</title>

</head>

<body onload="">

    <!-- Static Heading -->

    <div class="container-md header-fix sticky-top" id="centered_container">

        <!-- Center Heading/Flow -->

        <h1 id="heading">UltimateCustomPizza</h1>


        <div class="progress">
            <div class="progress-bar" id="progressBar1" role="progressbar" style="width:100%; background-color: #22cf0b;" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Complete</div>
        </div>


        <h1><br>Thank you for your order, <?= $first_name //This section formats the order summary using Php vars ?></h1>
        <h3><br>Deliver to: <br> <?= $addressOne ?> <?= $addTwo ?> <br> <?= $city ?>, <?= $state ?> <?= $zip ?></h3>

        <?php
        foreach ($items as $item => $price) {
            //List the items selected and their prices
        ?>
            <br>
            <tr>
                <td class="left"><?= $item ?>--------------</td>
                <td class="right">$<?= $price ?></td>

            </tr>
        <?php

        //Add the prices into the total var and concatenate the name of the items to the ordered items string for DB post
            $total += $price;
            $orderedItems .= $item . ' ';
            
        }
        trim($orderedItems); //Remove whitespace on both sides of the string

        //Insert contact/form data into the database, including the selected items on the pizza
        $sql = "INSERT INTO contact (fName, lName, addOne, addTwo, city, state, zip, orderedItems) VALUES ('$first_name', '$last_name', '$addressOne', '$addTwo', '$city', '$state', '$zip', '$orderedItems')";
        if (mysqli_query($conn, $sql)) {

        ?>

        <br><br>
        <?php //echo "Connected Successfully to " . $servername //message for successful connection to database ?>
               
        <?php


        } else {
            echo "Error: $sql. " . mysqli_error($conn); //Message if there is an error in the SQL db connection process
        }

        ?>
        
        <h3><br><br>Total: $<?= $total //display the total of the items ?></h3>

    </div>
    </div>
</body>

<?php mysqli_free_result($result); unset($row); mysqli_close($conn); //Some lines in an attempt to fix small bugs regarding the fetch assoc method formatting/transfer?>

</html>