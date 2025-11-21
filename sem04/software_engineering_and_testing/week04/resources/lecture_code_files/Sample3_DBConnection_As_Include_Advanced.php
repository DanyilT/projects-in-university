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
   
    // What if no data in the Table ????
   if (mysqli_num_rows($qryResult) > 0) 
    {
	    while($row = mysqli_fetch_assoc($qryResult)) 
		{
         echo "Reg:" .$row["RegNumber"].$row["CarMake"]. " " .$row["CarModel"].$row["RegDate"]."Value: €". $row["CarValue"]."<br>";
	    }
    } 
   else 
    {
      echo "0 results";  
    }  
 
    mysqli_close($conn);
?>

</body>
</html>