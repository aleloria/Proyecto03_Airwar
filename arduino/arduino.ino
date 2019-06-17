int btn = 7;

void setup() {
  pinMode(btn,INPUT);
  Serial.begin(9600);
}

void loop() {
  while(digitalRead(btn)==LOW){
    Serial.println("LOW");
    delay(500);
  }
/*  Keyboard.press(KEY_LEFT_GUI);
  Keyboard.press('n');
  delay(100);
  Keyboard.releaseAll();
  // wait for new window to open:
  delay(1000);
  */
  Serial.println("HIGH");
  delay(200);
  
}
