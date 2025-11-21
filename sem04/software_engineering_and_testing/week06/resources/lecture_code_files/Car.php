<?php
class Car{
    // property declaration - PUBLIC FOR THE PURPOSES OF THIS EXAMPLE
	
	// *******************************************************************
	// FOR FORMALISED TESTING - USE PROTECTED OR PRIVATE
	// *******************************************************************
	
    public $carMake;
    public $carModel;
    public $carPrice;
    public $carRegNumber;
     
  
    // ACCESS AND MODIFIER METHODS
	public function setCarMake($carMake) {
      $this->carMake = $carMake;
    }
    public function getCarMake() {
      return $this->carMake;
    }
	
	public function setCarModel($carModel) {
      $this->carModel = $carModel;
    }
    public function getCarModel() {
      return $this->carModel;
    }
	
	public function setCarPrice($carPrice) {
      $this->carPrice = $carPrice;
    }
    public function getCarPrice() {
      return $this->carPrice;
    }
    
	public function setCarRegNumber($carRegNumber) {
      $this->carRegNumber = $carRegNumber;
    }
    public function getCarRegNumber() {
      return $this->carRegNumber;
    }
    
	
	// Display method declaration
    public function displayCar() {
		echo "<br>-------------" ;
		echo "<br>-- C A R   --" ;
		echo "<br>-------------" ;
        echo "<br>Make:  " . $this->getCarMake();
		echo "<br>  Model: " . $this->getCarModel();
			echo "<br>  Price: " . $this->getCarPrice();
		echo "<br>  Reg:   " . $this->getCarRegNumber() . "<br>";
    }
	

}
// RUN IN ANOTHER CLASS FROM HERE ON IN
?>