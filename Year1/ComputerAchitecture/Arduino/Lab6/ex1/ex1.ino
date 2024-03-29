void setup() {
  tone(4, 3000, 1000); // Play tone for 1 second
  delay(1000); // Delay to finish tone

  pinMode(7, INPUT); // Set right whisker pin to input
  pinMode(5, INPUT); // Set left whisker pin to input

  Serial.begin(9600); // Set data rate to 9600 bps
}

void loop() {
  byte wLeft = digitalRead(5); // Copy left result to wLeft
  byte wRight = digitalRead(7); // Copy right result to wRight

  Serial.print(wLeft); // Display left whisker state
  Serial.println(wRight); // Display right whisker state
  
  delay(50); // Pause for 50 ms
}
