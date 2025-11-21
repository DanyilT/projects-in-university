<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>


    <form action="loginHandler.php" method="POST" >
   
      <label for = "firstname"> Please Enter Username:</label>
            <input type="text" name = "username" id = "firstname" placeholder = "Username" required>
     
      <label for = "password"> Please Enter Password:</label>
            <input type="password" name = "password" id ="password" placeholder = "Password" required>
            <input type="submit" id = "submit" value="Login" >
   
   </form>
   


  <?php
 
 
   if(isset($_POST['username']) && isset($_POST['password'])) 
     { 
        $username = $_POST['username'];
        $password = $_POST['password'];
        //$hashedPassword = password_hash($password, PASSWORD_DEFAULT);   // encrypt the password


        include "databaseConfig.php";
        $sql = "INSERT INTO user
         VALUES ('$username','$password')";
		 
		 
        $qryResult = mysqli_query($conn, $sql);
     
	    if ($qryResult == TRUE) 
	     {
          echo "New user created successfully";
         } 
	    else 
	     {
         echo "Error: " . $sql . "<br>" . mysqli_error($conn). "<br>";
         }
    } 
   else 
    {
         echo "Error, username or password missing!";
    }
		 
  ?>




  </body>
</html>