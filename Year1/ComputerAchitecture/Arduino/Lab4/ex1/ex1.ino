void setup() {
  Serial.begin(9600);

  Serial.println("Beep!");

  tone(4, 3000, 1000);
  delay(1000);
  tone(4, 3000, 1000); // Play tone for 1 second
  delay(1000); // Delay to finish tone
}

void loop() {
  Serial.println("Waiting for reset...");
  delay(1000);
}
