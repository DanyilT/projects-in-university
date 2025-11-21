<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
 
  <?php

   include "databaseConfig.php";
   include "Car.php";
   
   //Build Query
   $sql = "SELECT * FROM car;"; 
   $qryResult = mysqli_query($conn, $sql);
      
   // NOW LET'S USE OUR CAR CLASS TO OUTPUT
   $carA = new Car();  // MAKE A CAR OBJECT TO TAKE CAR DATA
   
   if (mysqli_num_rows($qryResult) > 0) 
    {
	  
		while($row = mysqli_fetch_assoc($qryResult)) 
		{
         $carA->setCarMake($row["CarMake"]);
		 $carA->setCarModel($row["CarModel"]);
		 $carA->setCarPrice($row["CarValue"]);
		 $carA->setCarRegNumber($row["RegNumber"]);
		 
		 /// black friday
		 if ($carA->getCarPrice() > 200000) 
			 echo "   ****   CONGRATS  25% DISCOUNT BLACK FRIDAY ***";

		 $carA->displayCar();
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