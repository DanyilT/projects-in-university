#include <Servo.h> // Include servo library

// Define pins for whiskers, LED, speaker, servos
const int leftWhiskerPin = 7;
const int rightWhiskerPin = 5;
const int leftledPin = 8;
const int rightledPin = 2;
const int speakerPin = 4;
const int leftServoPin = 13;
const int rightServoPin = 12;

// Declare left and right servos
Servo servoLeft;
Servo servoRight;

void setup() {
  pinMode(leftWhiskerPin, INPUT); // Set left whisker pin to input
  pinMode(rightWhiskerPin, INPUT); // Set right whisker pin to input
  
  pinMode(leftledPin, OUTPUT); // Left LED indicator -> output
  pinMode(rightledPin, OUTPUT); // Right LED indicator -> output

  servoLeft.attach(leftServoPin); // Attach left signal to pin 13
  servoRight.attach(rightServoPin); // Attach right signal to pin 12
  
  tone(4, 3000, 1000); // Play tone for 1 second
  delay(1000); // Delay to finish tone
}

void loop() {
  byte leftWhisker = digitalRead(leftWhiskerPin); // Copy left result to leftWhisker
  byte rightWhisker = digitalRead(rightWhiskerPin); // Copy right result to rightWhisker

  if (leftWhisker == LOW && rightWhisker == LOW) {
    // No obstacles detected, move forward
    moveForward(20);
  } else if (leftWhisker == HIGH && rightWhisker == HIGH) {
    turnLeft(600);
    if (leftWhisker == HIGH || rightWhisker == HIGH) {
      // If there's still an obstacle after turning left, turn right twice
      turnRight(600);
      delay(500); // Short delay to allow for a complete stop before turning again
      turnRight(600);
    }
  } else if (leftWhisker == HIGH) {
    // Only left whisker detects an obstacle
    adjustToPerpendicular(true); // True indicates left side
  } else if (rightWhisker == HIGH) {
    // Only right whisker detects an obstacle
    adjustToPerpendicular(false); // False indicates right side
  }

  // if((wLeft == 0) && (wRight == 0)) {
  //   // If both whiskers 
  //   digitalWrite(8, HIGH); // Left LED on
  //   digitalWrite(2, HIGH); // Right LED on
  //   moveBackward(1000); // Back up 1 second
  //   turnLeft(800); // Turn left about 120 degrees
  // } else if(wLeft == 0) {
  //   // If only left whisker contact
  //   digitalWrite(8, HIGH); // Left LED on
  //   digitalWrite(2, LOW); // Right LED off
  //   moveBackward(1000); // Back up 1 second
  //   turnRight(400); // Turn right about 60 degrees
  // } else if(wRight == 0) {
  //   // If only right whisker contact
  //   digitalWrite(8, LOW); // Left LED off
  //   digitalWrite(2, HIGH); // Right LED on
  //   moveBackward(1000); // Back up 1 second
  //   turnLeft(400); // Turn right about 60 degrees
  // } else {
  //   // Otherwise, no whisker contact
  //   digitalWrite(8, LOW); // Left LED off
  //   digitalWrite(2, LOW); // Right LED off
  //   moveForward(20); // Forward 1/50 of a second
  // }
}

void adjustToPerpendicular(bool isLeftWhisker) {
  if (isLeftWhisker) {
    // Minor turn to the right to adjust
    turnRight(100); // Short delay for slight adjustment
  } else {
    // Minor turn to the left to adjust
    turnLeft(100); // Short delay for slight adjustment
  }
  delay(200); // Adjust based on testing
}

// Forward function
void moveForward(int time) {
  servoLeft.writeMicroseconds(1700); // Left wheel counterclockwise
  servoRight.writeMicroseconds(1300); // Right wheel clockwise
  delay(time); // Maneuver for time ms
}

// Backward function
void moveBackward(int time) {
 servoLeft.writeMicroseconds(1300); // Left wheel clockwise
 servoRight.writeMicroseconds(1700); // Right wheel counterclockwise
 delay(time); // Maneuver for time ms
}

// Left turn function
void turnLeft(int time) {
  // This function assumes that a certain time duration corresponds to a 90-degree turn.
  // We calibrate this time based on your robot's speed and the surface. - [time = 600]
  servoLeft.writeMicroseconds(1300); // Left wheel clockwise
  servoRight.writeMicroseconds(1300); // Right wheel clockwise
  delay(time); // Maneuver for time ms
}

// Right turn function
void turnRight(int time) {
  // This function assumes that a certain time duration corresponds to a 90-degree turn.
  // We calibrate this time based on your robot's speed and the surface. - [time = 600]
  servoLeft.writeMicroseconds(1700); // Left wheel counterclockwise
  servoRight.writeMicroseconds(1700); // Right wheel counterclockwise
  delay(time); // Maneuver for time ms
}

void stop() {
  servoLeft.writeMicroseconds(1500); // Stop servo
  servoRight.writeMicroseconds(1500); // Stop servo
}
