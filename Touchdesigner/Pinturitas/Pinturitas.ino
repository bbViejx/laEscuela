const int pinEntrada = A0; // Cambia al pin que usas
void setup() {
  Serial.begin(9600); // Inicia la comunicación serial
}

void loop() {
  int valor = analogRead(pinEntrada); // Lee el valor analógico
  if (valor < 90) {
    valor = 0;
  }

  Serial.println(valor); // Envía el valor al puerto serial
  delay(50); // Controla la frecuencia de envío
}