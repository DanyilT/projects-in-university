#include <Servo.h> // Include servo library

Servo servoLeft; // Declare left servo signal
Servo servoRight; // Declare right servo signal

void setup() {
  Serial.begin(9600);

  tone(4, 3000, 1000); // Play tone for 1 second
  delay(1000); // Delay to finish tone

  servoLeft.attach(13); // Attach left signal to pin 13
}

void loop() {
  // Loop counts with pulseWidth from 1300 to 1700 in increments of 20.
  for(int pulseWidth = 1300; pulseWidth <= 1700; pulseWidth += 20) {
    Serial.print("pulseWidth = "); // Display pulseWidth value
    Serial.println(pulseWidth);
    Serial.println("Press a key and click"); // User prompt
    Serial.println("Send to start servo...");
    
    while(Serial.available() == 0); // Wait for character
    Serial.read(); // Clear character
    Serial.println("Running...");
    servoLeft.writeMicroseconds(pulseWidth); // Pin 13 servo speed=pulse
    delay(6000); // ..for 6 seconds

    servoLeft.writeMicroseconds(1500); // Pin 13 servo speed = stop
  }
}
