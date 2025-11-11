// Move forward, left, right, then backward for testing and tuning.

#include <Servo.h> // Include servo library

// Declare left and right servos
Servo servoLeft;
Servo servoRight;

void setup()
{
  tone(4, 3000, 1000); // Play tone for 1 second
  delay(1000); // Delay to finish tone
  
  servoLeft.attach(13); // Attach left signal to pin 13
  servoRight.attach(12); // Attach right signal to pin 12

  // disableServos();  // Stay still indefinitely
}

void loop(){
  forward(2000); // Go forward for 2 seconds
  turnLeft(600); // Turn left for 0.6 seconds
  turnRight(600); // Turn right for 0.6 seconds
  backward(2000); // go backward for 2 seconds
}

// Forward function
void forward(int time) {
  servoLeft.writeMicroseconds(1700); // Left wheel counterclockwise
  servoRight.writeMicroseconds(1300); // Right wheel clockwise
  delay(time); // Maneuver for time ms
}

// Left turn function
void turnLeft(int time) {
  servoLeft.writeMicroseconds(1300); // Left wheel clockwise
  servoRight.writeMicroseconds(1300); // Right wheel clockwise
  delay(time); // Maneuver for time ms
}

// Right turn function
void turnRight(int time) {
  servoLeft.writeMicroseconds(1700); // Left wheel counterclockwise
  servoRight.writeMicroseconds(1700); // Right wheel counterclockwise
  delay(time); // Maneuver for time ms
}

// Backward function
void backward(int time) {
  servoLeft.writeMicroseconds(1300); // Left wheel clockwise
  servoRight.writeMicroseconds(1700); // Right wheel counterclockwise
  delay(time); // Maneuver for time ms
}

// Halt servo signals
void disableServos()
{
  // Stop sending servo signals
  servoLeft.detach();
  servoRight.detach();
}
