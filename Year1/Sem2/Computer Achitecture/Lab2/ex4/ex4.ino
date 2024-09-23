void setup() {
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  // Set digital pin 13 -> output
}

void loop() {
  for(int i=0; i<5; i++) {
    digitalWrite(13, HIGH);
    delay(50); // ..for 0.05 seconds
    // Pin 13 = 5 V, LED emits light
    digitalWrite(13, LOW);
    delay(150); // ..for 0.15 seconds
    // Pin 13 = 0 V, LED no light
  }
    delay(1000); // ..for 1 seconds
}
