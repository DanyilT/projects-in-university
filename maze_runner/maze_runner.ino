/*
  Created by: Dany
  Created on 08/04/2024
*/
/*
 * This Arduino program controls a robot equipped with whisker sensors, LEDs, a speaker, and servo motors to navigate obstacles.
 * The robot uses whisker sensors to detect nearby obstacles.
 * Depending on the whisker sensor input, the robot either moves forward, adjusts its position, or tries to find a clear path by turning.
 * 
 * - The robot moves forward if no obstacles are detected.
 * - If one whisker sensor detect an obstacle, the robot executes minor adjustments until a clear path is found.
 * - If both whisker sensors detect an obstacle, the robot executes left and right 90-degree turns until an obstacle is found,when it found and obstacle it starts moving in the opposite direction.
 * - LEDs and sound signals provide visual and auditory feedback for different actions, enhancing debugging and interaction.
 * 
 * The control logic includes:
 *   - `moveForward()`, `moveBackward()`: Commands to move the robot forward or backward.
 *   - `turnLeft()`, `turnRight()`: Functions to turn the robot left or right.
 *   - `adjust()`: Adjusts the robot's direction to avoid obstacles based on whisker input.
 *   - `tryTurning()`: Tries to find a clear path by turning and moving in alternating directions when both sensors are blocked.
 *   - `whisker(bool left)`: Returns the state of the left or right whisker sensor to simplify condition checks.
 */

#include <Servo.h> // Include the Servo library to control servo motors

// Define pins for whiskers, LED, speaker, servos
const int leftWhiskerPin = 5;
const int rightWhiskerPin = 7;
const int leftLedPin = 8;
const int rightLedPin = 2;
const int speakerPin = 4;
const int leftServoPin = 13;
const int rightServoPin = 12;

// Declare servo objects for left and right servos
Servo servoLeft;
Servo servoRight;

void setup() {
  // Set pin modes for whiskers as input to read whisker states (Initialize whisker pins)
  pinMode(leftWhiskerPin, INPUT);
  pinMode(rightWhiskerPin, INPUT);
  
  // Set pin modes for LEDs as output to indicate status (Initialize LED pins)
  pinMode(leftLedPin, OUTPUT);
  pinMode(rightLedPin, OUTPUT);

  // Attach the servo objects to their respective pins
  servoLeft.attach(leftServoPin);
  servoRight.attach(rightServoPin);
  
  // Play a tone on startup for 1 second to indicate the robot is ready
  tone(speakerPin, 3000, 1000);
  delay(1000);
}

void loop() {
  // Check whisker states to decide the robot's movement
  if (whisker(true) == 0 && whisker(false) == 0) {
    // Both whiskers detect obstacle, try to find a clear path
    tryTurning();
  } else if (whisker(true) == 0 || whisker(false) == 0) {
    // At least one whisker detects obstacle, adjust the position
    adjust();
  } else {
    // If no obstacles, move forward
    moveForward(100);
  }
}

void tryTurning() {
  bool leftClear = true;  // Flag to track if left side is clear
  bool rightClear = true; // Flag to track if right side is clear
  int distance = 100;     // Initial distance to move forward when checking

  moveBackward(200);
  while (true) {
    // Turn left and check for obstacles
    turnLeft(900);
    moveForward(distance);
    if (whisker(true) == 0 && whisker(false) == 0) {
      // Path is not clear
      leftClear = false;
    }

    // Return to the starting position
    moveBackward(distance);
    turnRight(900);
    moveBackward(100);

    // Turn right to check other direction
    turnRight(900);
    moveForward(distance);
    if (whisker(true) == 0 && whisker(false) == 0) {
      // Path is not clear
      rightClear = false;
    }
    
    // Return to the starting position
    moveBackward(distance);
    turnLeft(900);
    moveBackward(100);

    // Increases the distance
    distance += 100;
    
    // Decide on the next action based on which path was clear
    if (!leftClear) {
      // If left is not clear, turn right
      turnRight(900);
      break;
    } else if (!rightClear) {
      // If right is not clear, turn left
      turnLeft(900);
      break;
    }
  }
}

void adjust() {
  // Continuously adjust the robot's orientation until a clear path is found
  while (true) {    
    if (whisker(true) == 1 && whisker(false) == 1) {
      // Path is clear
      break;
    } else if (whisker(true) == 0 && whisker(false) == 0) {
      // Maybe stuck
      moveBackward(100);
      break;
    } else if (whisker(true) == 0) {
      // Minor turn to the right to adjust
      moveBackward(100);
      turnRight(100);
      moveForward(100);
    }else if (whisker(false) == 0) {
      // Minor turn to the left to adjust
      moveBackward(100);
      turnLeft(100);
      moveForward(100);
    }
    // Short delay for stability
    delay(100);
  }
}

// Forward function
void moveForward(int time) {
  servoLeft.writeMicroseconds(1700);
  servoRight.writeMicroseconds(1300);
  delay(time);
}

// Backward function
void moveBackward(int time) {
  // Beep while moving backward
  servoLeft.writeMicroseconds(1400);
  servoRight.writeMicroseconds(1600);
  for (int i = 0; i < time / 200; ++i) {
    tone(speakerPin, 1000, 100);
    delay(100);
    noTone(speakerPin);
    delay(100);
  }
  delay(time);
}

// Left turn function with visual and audio signals
void turnLeft(int time) {
  // This function assumes that a certain time duration corresponds to a 90-degree turn.
  // We calibrate this time based on our robot's speed and the surface. - [time = 1200]
  digitalWrite(leftLedPin, HIGH);
  tone(speakerPin, 1000, 200);
  delay(200);

  servoLeft.writeMicroseconds(1500);
  servoRight.writeMicroseconds(1300);
  delay(time);

  digitalWrite(leftLedPin, LOW);
}

// Right turn function with visual and audio signals
void turnRight(int time) {
  // This function assumes that a certain time duration corresponds to a 90-degree turn.
  // We calibrate this time based on our robot's speed and the surface. - [time = 1200]
  digitalWrite(rightLedPin, HIGH);
  tone(speakerPin, 1000, 200);
  delay(200);

  servoLeft.writeMicroseconds(1700);
  servoRight.writeMicroseconds(1500);
  delay(time);

  digitalWrite(rightLedPin, LOW);
}

// Function to read whisker input, simplifying the check
byte whisker(bool left) {
  return left ? digitalRead(leftWhiskerPin) : digitalRead(rightWhiskerPin);
}
