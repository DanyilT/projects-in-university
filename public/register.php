<!-- Part 6: Create Registration Form & Save Registration Data to Database -->
<?php
require_once ('../src/DBconnect.php');
require_once ('../src/common.php');
session_start();

/* Check if the registration form has been submitted (as in the lab sheet) */
if (isset($_POST['Submit'])) {
    // the user input is cleaned with the escape function of the lecture
    $Username = escape($_POST['Username']);
    $Password = escape($_POST['Password']);
    // Part 6: Server-Side Validation (the same rules as the attributes of the form below)
    if (empty($Username) || empty($Password)) {
        echo "Both fields are required.";
    } elseif (!preg_match('/^[A-Za-z0-9_.-]{3,50}$/', $Username)) {
        echo "The username must have 3 to 50 letters, numbers, dots, dashes or underscores.";
    } elseif (strlen($Password) < 4 || strlen($Password) > 72) {
        echo "The password must have 4 to 72 characters.";
    } else {
        $hashed_password = password_hash($Password, PASSWORD_DEFAULT);
        $statement = $connection->prepare("INSERT INTO users (username, password) VALUES (:username, :password)");
        $statement->bindValue(':username', $Username);
        $statement->bindValue(':password', $hashed_password);
        if ($statement->execute()) {
            echo "Registration successful.";
            header("location: login.php");
        } else {
            echo "Error: " . $statement->errorInfo()[2];
        }
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
    <link rel="stylesheet" type="text/css" href="../css/signin.css">
    <title>Register</title>
</head>
<body>
    <div class="container">
        <div class="header clearfix">
            <nav>
                <ul>
                    <li><a href="index.php">Home</a></li>
                    <li><a href="about.php">About</a></li>
                    <li><a href="contacts.php">Contact</a></li>
                    <li><a href="login.php">Login</a></li>
                    <li><a href="register.php">Register</a></li>
                    <li><a href="public_page.php">Public page</a></li>
                </ul>
            </nav>
            <h3 class="text-muted">PHP Login exercise - Home page</h3>
        </div>

        <!-- Part 6: Client-Side Validation with the HTML attributes required, minlength, maxlength and pattern (no JavaScript) -->
        <form id="registrationForm" action="" method="post" name="Login_Form" class="form-signin">
            <h2 class="form-signin-heading">Please register</h2>
            <label for="inputUsername" >Username</label>
            <input name="Username" type="username" id="inputUsername" class="form-control" placeholder="Username" required minlength="3" maxlength="50" pattern="[A-Za-z0-9_.\-]+" title="3 to 50 letters, numbers, dots, dashes or underscores" autofocus>
            <label for="inputPassword">Password</label>
            <input name="Password" type="password" id="inputPassword" class="form-control" placeholder="Password" required minlength="4" maxlength="72" title="4 to 72 characters">
            <button name="Submit" value="Login" class="button" type="submit">Register</button>
        </form>
    </div>
</body>
</html>
