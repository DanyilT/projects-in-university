void setup() {
  Serial.begin(9600);

  int a = 89;
  int b = 42;

  if(a > b) {
    Serial.println("a is greater than b");
  } else if(a < b) {
    Serial.println("b is greater than a");
  } else {
    Serial.println("a is equal to b");
  }

  if((a > 50) && (b < 50)) {
    Serial.print("Values in normal range");
  }
  if((a > 100) || (b < 0)) {
    Serial.print("Danger Will Robinson!");
  }
  if(a == b) {
    Serial.print("a and b are equal");
  }
}

void loop() {
  // Empty, no repeating code.
}
