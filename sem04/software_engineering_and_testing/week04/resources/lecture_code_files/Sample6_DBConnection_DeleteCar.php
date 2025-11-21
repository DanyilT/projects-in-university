<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>

  <?php
 
   include "databaseConfig.php";
   
   
   
   $sql = "DELETE FROM car 
   WHERE CarMake = 'MAZDA'";
   
   
   $qryResult = mysqli_query($conn, $sql);

   if ($qryResult == TRUE) 
   {
      echo "Record deleted successfully";
   } 
   else 
   {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn). "<br>";  
   }
   
   
    mysqli_close($conn);    
  ?>

  </body>
</html>