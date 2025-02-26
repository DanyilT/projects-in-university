<!-- Part 6: Create Registration Form & Save Registration Data to Database -->
<?php
require_once ('../src/DBconnect.php');
session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $Username = $_POST['Username'];
    $Password = $_POST['Password'];
    // Part 6: Server-Side Validation
    if (empty($Username) || empty($Password)) {
        echo "Both fields are required.";
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

        <form id="registrationForm" onsubmit="return validateRegistrationForm()" action="" method="post" name="Login_Form" class="form-signin">
            <h2 class="form-signin-heading">Please register</h2>
            <label for="inputUsername" >Username</label>
            <input name="Username" type="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
            <label for="inputPassword">Password</label>
            <input name="Password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <button name="Submit" value="Login" class="button" type="submit">Register</button>
        </form>
        <script>
            // Part 6: Client-Side Validation
            function validateRegistrationForm() {
                var username = document.getElementById('inputUsername').value;
                var password = document.getElementById('inputPassword').value;
                if (username === '' || password === '') {
                    alert('Both fields are required.');
                    return false;
                }
                return true;
            }
        </script>
    </div>
</body>
</html>
