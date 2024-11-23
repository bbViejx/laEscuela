int led = 9; 
int x=255;        // the PWM pin the LED is attached to
int brightness = 0;  // how bright the LED is
int fadeAmount = 5;
bool ledin =true; 
#define POT A4
#define POTB A3

void setup() {
 pinMode(4, INPUT); 
  pinMode(POT, INPUT);
  pinMode(POTB, INPUT);
  Serial.begin(9600);
}

void loop() {
  int velocidadStrobo = analogRead(POT);
  int potenciaLuz = analogRead(POTB);
  int potenciaMapeada = int(map(potenciaLuz,0,1024,0,255));
    int frameRateMapeado = int(map(velocidadStrobo,0,1024,1,300));
      if(ledin){
      analogWrite(3, 0);
      analogWrite(5, 0);
      }
      else{
      analogWrite(3,255-potenciaMapeada);
      analogWrite(5,255-potenciaMapeada);
      }
      ledin = !ledin;

       Serial.print(255-potenciaMapeada);
  Serial.print(",");
  Serial.println(frameRateMapeado);
    delay(300-frameRateMapeado);
   
}
