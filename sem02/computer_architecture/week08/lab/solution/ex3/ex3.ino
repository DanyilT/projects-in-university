#include <Servo.h> // Include servo library

// Declare left and right servos
Servo servoLeft;
Servo servoRight;

void setup() {
  pinMode(5, INPUT); // Set right whisker pin to input
  pinMode(7, INPUT); // Set left whisker pin to input
  
  pinMode(8, OUTPUT); // Left LED indicator -> output
  pinMode(2, OUTPUT); // Right LED indicator -> output

  tone(4, 3000, 1000); // Play tone for 1 second
  delay(1000); // Delay to finish tone

  servoLeft.attach(13); // Attach left signal to pin 13
  servoRight.attach(12); // Attach right signal to pin 12
}

void loop() {
  byte wLeft = digitalRead(5); // Copy left result to wLeft
  byte wRight = digitalRead(7); // Copy right result to wRight

  if((wLeft == 0) && (wRight == 0)) {
    // If both whiskers 
    digitalWrite(8, HIGH); // Left LED on
    digitalWrite(2, HIGH); // Right LED on
    backward(1000); // Back up 1 second
    turnLeft(800); // Turn left about 120 degrees
  } else if(wLeft == 0) {
    // If only left whisker contact
    digitalWrite(8, HIGH); // Left LED on
    digitalWrite(2, LOW); // Right LED off
    backward(1000); // Back up 1 second
    turnRight(400); // Turn right about 60 degrees
  } else if(wRight == 0) {
    // If only right whisker contact
    digitalWrite(8, LOW); // Left LED off
    digitalWrite(2, HIGH); // Right LED on
    backward(1000); // Back up 1 second
    turnLeft(400); // Turn right about 60 degrees
  } else {
    // Otherwise, no whisker contact
    digitalWrite(8, LOW); // Left LED off
    digitalWrite(2, LOW); // Right LED off
    forward(20); // Forward 1/50 of a second
  }
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
