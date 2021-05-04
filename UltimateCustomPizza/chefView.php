<?php //Noah Kamenick | C2-248 Section 2 | Pizza Project Final

//This page is suppose to retrieve the values from the db and display it for the the chef to know what to put on the pizza


$servername = "DB_HostName"; //
$database = "DB_Name"; // 
$username = "DB_User"; // SQL DB Login Credentials
$password = "DB_Password"; //

$conn = mysqli_connect($servername, $username, $password, $database); //Creates a SQL connection and stores in the conn variable

if (!$conn) //If conn is false
{

    die("Connection Failed: " .  mysqli_connect_error()); //Feedback if connection fails

}

//echo "Connected Successfully"; //Check for successful SQL DB connection

$sql = "SELECT fName, city, orderedItems FROM contact LIMIT 10";
$result = mysqli_query($conn, $sql);   //Create a new SQL query


if (mysqli_query($conn, $sql)) {
    //echo "Connected Successfully to " . $servername . "";
}
        else {      //run some checks and validation making sure connections were made to the server
        echo "Error when $sql. " . mysqli_error($conn);
        }

?>


    <!DOCTYPE html>

    <html lang="en">

    <head>

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

        <!-- Static Heading -->

        <div class="container-md header-fix sticky-top" id="centered_container">

            <!-- Center Heading/Flow -->

            <h1 id="heading">UltimateCustomPizza ChefView</h1>
            <h3>ChefView</h3>
        </div>

        <div class="container-md header-fix" id="order_heading">

            <div class="container">

                <div class="card-deck">
                   

                    <?php while ($row = mysqli_fetch_assoc($result)) {   //Set row to an associative array based on data from the query
                        $separateItems = array(); //Create a separate items array for split-string coming up shortly

                        $separateItems = explode(" ", $row['orderedItems']); //split the string retrieved from the db containing the order of that person in the respective row
                   ?>
                        

                        <div class="card text-white bg-danger mb-3" id="chefCards" style="max-width: 18rem;">
                            <div class="card-header"><?= $row['city'] ?></div>
                            <div class="card-body">
                                <h5 class="card-title">Order for <?= $row['fName'] ?></h5>
                                <p class="card-text">

                                    <?php for ($i = 0; $i < sizeof($separateItems); $i++) { ?>

                                        <li><?= $separateItems[$i]; ?> 

                                        <?php } //This block of code creates a new card from the exploded string
                                        // using HTML and the bootstrap framework ?>


                                </p>
                            </div>

                        </div>

                    <?php } ?>
                    



                </div>




            </div>

        


    </body>
    <?php mysqli_close($conn); mysqli_free_result($result); $separateItems = array(); $row; //An Attempt to tame the existent bugs that are beyond the scope of this course (stil fucntional) ?>

    </html>