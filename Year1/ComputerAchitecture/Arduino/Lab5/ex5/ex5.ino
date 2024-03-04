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

  maneuver(200, 200, 2000); // Forward 2 seconds
  maneuver(-200, 200, 600); // Left 0.6 seconds
  maneuver(200, -200, 600); // Right 0.6 seconds
  maneuver(-200, -200, 2000); // Backward 2 seconds
  maneuver(0, 0, -1); // Disable servos
}

void loop(){
}

void maneuver(int speedLeft, int speedRight, int msTime) {
  // speedLeft, speedRight ranges: Backward Linear Stop Linear Forward
  // -200 -100 ...... 0 ...... 100 200
  servoLeft.writeMicroseconds(1500 + speedLeft);
  // Set Left servo speed
  servoRight.writeMicroseconds(1500 - speedRight);
  // Set right servo speed
  // if msTime = -1
  if(msTime==-1) {
    // Stop servo signals
    servoLeft.detach();
    servoRight.detach();
  }
  delay(msTime);
}
