<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>

  <?php
 
   include "databaseConfig.php";
   
   $year = rand(1,4);
   $strMake  = "";
   $strModel = "";
      
   switch($year)
   {
 	 case 1: $strMake = 'SUMMER';
             $strModel = 'BEAT';	break;
			 
     case 2: $strMake = 'AUTUMN';
             $strModel = 'LEAF';	break;
			 
	 case 3: $strMake = 'WINTER';
             $strModel = 'SNOW';	break;
			 
	 case 4: $strMake = 'SPRING';
             $strModel = 'TIDE';	
   }
   
   
  
   $sql = "INSERT INTO car
           VALUES ($year, '$strMake', '$strModel', 1990, 35000)";
   
   $qryResult = mysqli_query($conn, $sql);

   if ($qryResult == TRUE) 
   {
      echo "Record inserted successfully";
   } 
   else 
   {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn). "<br>";  
   }
   
   
    mysqli_close($conn);    
  ?>

  </body>
</html>