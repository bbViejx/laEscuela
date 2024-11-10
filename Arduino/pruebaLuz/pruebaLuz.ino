int led = 9;         // the PWM pin the LED is attached to
int brightness = 0;  // how bright the LED is
int fadeAmount = 5;

void setup() {
  Serial.begin(9600);
  pinMode(7, OUTPUT);
}

void loop() {
  for(int fadeValue = 129; fadeValue<=255; fadeValue+-5){
    analogWrite(8, fadeValue);
    analogWrite(7, fadeValue);
    delay(5);
  }

  for(int fadeValue = 255 ; fadeValue >= 129 ; fadeValue -= 5){
    analogWrite(7, fadeValue);
    delay(5);
  }


  //   char led = Serial.read();
  //   if (led == '1') {
  //     digitalWrite(8, HIGH);
  //   } else if (led == '0') {
  //     digitalWrite(8, LOW);
  //   }
   //}
}
