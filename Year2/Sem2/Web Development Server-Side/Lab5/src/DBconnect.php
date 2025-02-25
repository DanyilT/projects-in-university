<?php
/** Establishes a connection to the database using PDO */

require_once '../config.php';

try {
    $connection = new PDO($dsn, $username, $password, $options);
    echo 'DB connected';
} catch (\PDOException $e) {
    throw new \PDOException($e->getMessage(), (int)$e->getCode());
}
