#define POT A4

int ValorPot;
void setup() {
  // put your setup code here, to run once:

  pinMode(POT, INPUT);
  Serial.begin(9600);
}

void loop() {
  ValorPot= analogRead(POT);
    Serial.print("Valor: ");
    Serial.println(ValorPot);
    delay(500);
}
