void setup() {
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  // Set digital pin 13 -> output
  pinMode(12, OUTPUT);
  // Set digital pin 12 -> output
}

void loop() {
  digitalWrite(13, HIGH);
  // Pin 13 = 5 V, LED emits light
  digitalWrite(12, HIGH);
  // Pin 12 = 5 V, LED emits light
  delay(500); // ..for 0.5 seconds
  digitalWrite(13, LOW);
  // Pin 13 = 0 V, LED no light
  digitalWrite(12, LOW);
  // Pin 12 = 0 V, LED no light
  delay(500); // ..for 0.5 seconds
}
