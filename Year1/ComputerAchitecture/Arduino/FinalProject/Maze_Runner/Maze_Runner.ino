#include <Servo.h> // Include servo library

// Define pins for whiskers, LED, speaker, servos
const int leftWhiskerPin = 7;
const int rightWhiskerPin = 5;
const int leftLedPin = 8;
const int rightLedPin = 2;
const int speakerPin = 4;
const int leftServoPin = 13;
const int rightServoPin = 12;

// Declare left and right servos
Servo servoLeft;
Servo servoRight;

// This variable define when turn right and when turn left
bool shouldTurnLeft = true;

void setup() {
  // Initialize whisker pins
  pinMode(leftWhiskerPin, INPUT); // Set left whisker pin to input
  pinMode(rightWhiskerPin, INPUT); // Set right whisker pin to input
  
  // Initialize LED pins
  pinMode(leftLedPin, OUTPUT); // Left LED indicator -> output
  pinMode(rightLedPin, OUTPUT); // Right LED indicator -> output

  // Attach servos
  servoLeft.attach(leftServoPin); // Attach left signal to pin 13
  servoRight.attach(rightServoPin); // Attach right signal to pin 12
  
  tone(speakerPin, 3000, 1000); // Play tone for 1 second
  delay(1000); // Delay to finish tone
}

void loop() {
  detectAndRespond();
}

void detectAndRespond() {
  bool leftWhisker = digitalRead(leftWhiskerPin) == HIGH;
  bool rightWhisker = digitalRead(rightWhiskerPin) == HIGH;

  if (leftWhisker || rightWhisker) {
    // Light up the corresponding LED and emit a beep
    if (leftWhisker) {
      digitalWrite(leftLedPin, HIGH);
    }
    if (rightWhisker) {
      digitalWrite(rightLedPin, HIGH);
    }
    tone(speakerPin, 1000, 200); // Emit a beep
    delay(200); // Delay to ensure beep is heard

    // Decision making for turning or adjusting
    if (leftWhisker && rightWhisker) {
      // If both whiskers detect an obstacle, reverse and turn
      if (shouldTurnLeft) {
        reverseWithBeeps(1000); // Reverse with beeps
        turnLeft(600);
      } else {
        // If there's still an obstacle after turning left, turn right twice
        reverseWithBeeps(1000); // Reverse with beeps
        turnRight(600);
        delay(500); // Short delay to allow for a complete stop before turning again
        reverseWithBeeps(1000); // Reverse with beeps
        turnRight(600);
      }
      shouldTurnLeft = !shouldTurnLeft;
    } else if (leftWhisker) {
      // Only left whisker detects, adjust to stand perpendicular or turn
      adjustToPerpendicular(true);
    } else if (rightWhisker) {
      // Only right whisker detects, adjust to stand perpendicular or turn
      adjustToPerpendicular(false);
    }
    
    // Turn off LEDs after action
    digitalWrite(leftLedPin, LOW);
    digitalWrite(rightLedPin, LOW);
  } else {
    // If no obstacles, move forward
    moveForward(20);
  }
}

void adjustToPerpendicular(bool isLeftWhisker) {
  if (isLeftWhisker) {
    // Minor turn to the right to adjust
    reverseWithBeeps(500);
    turnRight(100); // Short delay for slight adjustment
  } else {
    // Minor turn to the left to adjust
    reverseWithBeeps(500);
    turnLeft(100); // Short delay for slight adjustment
  }
  delay(200); // Adjust based on testing
}

void reverseWithBeeps(int time) {
  for (int i = 0; i < time / 200; ++i) {
    tone(speakerPin, 1000, 100); // Emit a beep
    delay(100);
    noTone(speakerPin); // Stop the tone
    delay(100);
  }
  moveBackward(time);
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
