<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>

  <?php
 
   include "databaseConfig.php";
 

   $sql = "INSERT INTO car
           VALUES (888,'Bugatti','Model CAR', 2018, 2700000)";
		 
  
   $qryResult = mysqli_query($conn, $sql);
   
   
   if ($qryResult == TRUE) 
    {  
     echo "New record created successfully";
    } 
   else 
    {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn). "<br>";  
    }
   
    mysqli_close($conn);    
?>

</body>
</html>