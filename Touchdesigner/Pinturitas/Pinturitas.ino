const int pinA0 = A0;
const int pinA1 = A1; 
const int pinA2 = A2; 
const int pinA3 = A3; 

void setup() {
  Serial.begin(9600); // Inicia la comunicación serial
}

void loop() {
  int valorA0 = normalizeValue(analogRead(pinA0));
  int valorA1 = normalizeValue(analogRead(pinA1));
  int valorA2 = normalizeValue(analogRead(pinA2));
  int valorA3 = normalizeValue(analogRead(pinA3));

 // Enviar valores en diferentes rangos para cada pin
  Serial.println(map(valorA0, 0, 1023, 0, 1024));  // Mapear valor a rango 0-1024
  Serial.println(map(valorA1, 0, 1023, 1025, 2048));  // Mapear a rango 1025-2048
  Serial.println(map(valorA2, 0, 1023, 2049, 3072));  // Mapear a rango 2049-3072
  Serial.println(map(valorA3, 0, 1023, 3073, 4095));  // Mapear a rango 3073-4095

  delay(50); // Ajusta el tiempo según tu necesidad
}

int normalizeValue(int valor){
    if (valor < 170) {
     return 0;
  }
  return valor;
}