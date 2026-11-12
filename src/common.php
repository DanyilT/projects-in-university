<?php
/** Cleans user input: the escape function of the lecture (lab 4, form sanitisation) */

function escape($data) {
    $data = htmlspecialchars($data, ENT_QUOTES | ENT_SUBSTITUTE, "UTF-8");
    $data = trim($data);
    $data = stripslashes($data);
    return ($data);
}
