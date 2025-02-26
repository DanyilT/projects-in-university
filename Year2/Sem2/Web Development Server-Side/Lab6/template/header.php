<?php
// Part 6: Public Pages Without Login
$public_pages = ['public_page.php', 'login.php', 'register.php'];
$current_page = basename($_SERVER['PHP_SELF']);
if (!in_array($current_page, $public_pages)) {
    session_start();
    if(!isset($_SESSION['Active']) || $_SESSION['Active'] == false) { /* Redirects user to Login.php if not logged in. Remember, we set $_SESSION['Active'] == true in login.php */
        header("location: login.php");
        exit;
    }
}
/* the code inside these php tags (i.e. the 5 lines of code above) are required for every page you wish to be accessible only after login */
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/stylesheet.css">
