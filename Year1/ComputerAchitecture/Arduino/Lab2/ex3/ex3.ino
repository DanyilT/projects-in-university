void setup() {
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  // Set digital pin 13 -> output
  pinMode(12, OUTPUT);
  // Set digital pin 12 -> output
}

void loop() {
  // Pin 13 - 3 short
  for(int i=0; i<3; i++) {
    digitalWrite(13, HIGH);
    delay(100); // ..for 0.1 seconds
    // Pin 13 = 5 V, LED emits light
    digitalWrite(13, LOW);
    delay(200); // ..for 0.2 seconds
    // Pin 13 = 0 V, LED no light
  }
  delay(800);  // ..for 0.8 seconds
  // Pin 12 - 3 long
  for(int i=0; i<3; i++) {
    digitalWrite(12, HIGH);
    delay(500); // ..for 0.5 seconds
    // Pin 12 = 5 V, LED emits light
    digitalWrite(12, LOW);
    delay(500); // ..for 0.5 seconds
    // Pin 12 = 0 V, LED no light
  }
  delay(300); // ..for 0.3 seconds
  // Pin 13 - 3 short
  for(int i=0; i<3; i++) {
    digitalWrite(13, HIGH);
    delay(100); // ..for 0.1 seconds
    // Pin 13 = 5 V, LED emits light
    digitalWrite(13, LOW);
    delay(200); // ..for 0.2 seconds
    // Pin 13 = 0 V, LED no light
  }
  delay(1000); // ..for 1 seconds
}
