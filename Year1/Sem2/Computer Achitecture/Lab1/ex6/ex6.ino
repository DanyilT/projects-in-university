void setup() {
  Serial.begin(9600);
  
  for(int i = 5000; i <= 15000; i+=1000) {
    Serial.println(i);
    delay(500);
  }
  Serial.println("All done!");

  int i1 = 0;
  while(i1 < 10) {
    i1 = i1 + 1;
    Serial.println(i1); delay(500);
  }
 
  int i2 = 0;
  while(i2 < 10) {
    Serial.println(++i2);
    delay(500);
  }
 
  int i3 = 0;
  while(true) {
    Serial.println(++i3);
    delay(500);
  }
}

void loop() {
  // Empty, no repeating code.
}
