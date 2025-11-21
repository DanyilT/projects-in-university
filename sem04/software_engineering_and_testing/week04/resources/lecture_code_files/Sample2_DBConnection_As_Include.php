<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
 
  <?php

   include "databaseConfig.php";
   
   
   //Build Query
   $sql = "SELECT * FROM car;"; 
   $qryResult = mysqli_query($conn, $sql);
   
   
   while($row = mysqli_fetch_assoc($qryResult)) {
         echo "reg: " . $row["RegNumber"]. " - Make: " .
          $row["CarMake"]. " " . $row["CarModel"]. " - Reg Date: "
         . $row["RegDate"]." - Value: €" . $row["CarValue"]."<br>";
	     }
  
 
    mysqli_close($conn);
?>

</body>
</html>