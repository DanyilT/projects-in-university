<!-- Part 6: Connect to the Database -->
<?php
require_once ('../src/DBconnect.php');
session_start();

/* Check if login form has been submitted */
/* isset — Determine if a variable is declared and is different than NULL */
if (isset($_POST['Submit'])) {
    $Username = $_POST['Username'];
    $Password = $_POST['Password'];
    // Part 6: Server-Side Validation
    if (empty($_POST['Username']) || empty($_POST['Password'])) {
        echo "Both fields are required.";
    } else {
        /* Check if the form's username and password matches */
        // Database connection
        $statement = $connection->prepare("SELECT password FROM users WHERE username = :username");
        $statement->bindValue(':username', $Username);
        $statement->execute();
        $user = $statement->fetch(PDO::FETCH_ASSOC);

        if ($user && password_verify($Password, $user['password'])) {
            /* Success: Set session variables and redirect to protected page */
            $_SESSION['Username'] = $Username; // store Username to the session
            $_SESSION['Active'] = true; // remember we can call a session what
            header("location: index.php"); /* 'header() is used to redirect the browser */
            exit; // we’ve just used header() to redirect to another page but we must terminate all current code so that it doesn’t run when we redirect
        } else
            echo 'Incorrect Username or Password';
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
    <title>Sign in</title>
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

        <form id="loginForm" onsubmit="return validateLoginForm()" action="" method="post" name="Login_Form" class="form-signin">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputUsername" >Username</label>
            <input name="Username" type="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
            <label for="inputPassword">Password</label>
            <input name="Password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox"><label><input type="checkbox" value="remember-me">Remember me</label></div>
            <button name="Submit" value="Login" class="button" type="submit">Sign in</button>
        </form>
        <script>
            // Part 6: Client-Side Validation
            function validateLoginForm() {
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
