<?php
/** Configuration for database connection */

$host = "localhost"; // 127.0.0.1
$username = "root";
$password = "root";
$dbname = "webdev_build_a_nofrills_php_crud_app_with_routing_from_scratch";
$dsn = "mysql:host=$host;dbname=$dbname";
$options = array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION);
