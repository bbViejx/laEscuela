int led = 9;         // the PWM pin the LED is attached to
int brightness = 0;  // how bright the LED is
int fadeAmount = 5;
bool ledin =true; 

void setup() {
  Serial.begin(9600);
  pinMode(8, OUTPUT);
}

void loop() {
  //  // set the brightness of pin 9:
  // analogWrite(9, brightness);
  // analogWrite(6, brightness);

  // // change the brightness for next time through the loop:
  // brightness = brightness + fadeAmount;

  // // reverse the direction of the fading at the ends of the fade:
  // if (brightness <= 0 || brightness >= 255) {
  //   fadeAmount = -fadeAmount;
  // }
  // // wait for 30 milliseconds to see the dimming effect
  // delay(30);

    char led = Serial.read();
    if (led == '1') {
      analogWrite(9, 255);
      analogWrite(6, 255);
    } else if (led == '2') {
      if(ledin){
      analogWrite(9, 0);
      analogWrite(6, 0);
      }
      else{
      analogWrite(9, 255);
      analogWrite(6,255);
      }
      ledin = !ledin;
    }
   
}
