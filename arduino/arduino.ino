int btnS = 7;
int btnD = 6;
int btnI = 5;


void setup() {
  pinMode(btnS,INPUT);
  pinMode(btnD,INPUT);
  pinMode(btnI,INPUT);
  Serial.begin(9600);
}

void loop() {
  if(digitalRead(btnS)==HIGH){
    Serial.println("HIGH");
    delay(500);
  }if(digitalRead(btnD)==HIGH){
    Serial.println("Der");
    delay(15);
  }if(digitalRead(btnI)==HIGH){
    Serial.println("Izq");
    delay(15);
  }
  
}
