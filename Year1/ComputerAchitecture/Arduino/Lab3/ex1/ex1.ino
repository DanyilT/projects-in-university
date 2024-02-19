#include <Servo.h> // Include servo library

Servo servoLeft; // Declare left servo signal
Servo servoRight; // Declare right servo signal

void setup() {
  Serial.begin(9600);

  servoLeft.attach(13); // Attach left signal to pin 13
  servoRight.attach(12); // Attach left signal to pin 12
  servoLeft.writeMicroseconds(1700); // 1.5 ms stay-still signal, pin 13
  servoRight.writeMicroseconds(1300); // 1.5 ms stay still signal, pin 12 
}

void loop() {
}
