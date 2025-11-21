<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>
 
 <?php
   $servername = "localhost"; 
   $username = "root"; 
   $password = "";
   $dbname = "MyDatabase"; 

   $conn = mysqli_connect($servername, 
                        $username, 
                        $password, 
                        $dbname);

   if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
   }
   else
   {
     echo "Successfully Connected to Database<br/><br/>";
   }
	 
	

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