#include <Arduino.h>

// Estructura para guardar datos de cada sensor táctil
struct TouchSensor {
  uint8_t pin;             // GPIO usado
  const char* nombre;      // Nombre descriptivo (opcional)
  uint16_t baseValue;      // Valor base (sin tocar)
  uint16_t threshold;      // Umbral para detectar toque
};

// Lista de sensores táctiles que querés usar
TouchSensor sensores[] = {
  {4,  "T0 - GPIO4",  0, 0},
  {13, "T4 - GPIO13", 0, 0},
  {15, "T3 - GPIO15", 0, 0}
};

const int numSensores = sizeof(sensores) / sizeof(sensores[0]);

void calibrarSensores() {
  Serial.println("Calibrando sensores (no toques nada)...");
  delay(2000);

  for (int i = 0; i < numSensores; i++) {
    uint32_t total = 0;
    for (int j = 0; j < 10; j++) {
      total += touchRead(sensores[i].pin);
      delay(50);
    }
    sensores[i].baseValue = total / 10;
    sensores[i].threshold = sensores[i].baseValue * 0.8; // Ajustable

    Serial.print(sensores[i].nombre);
    Serial.print(" → Base: ");
    Serial.print(sensores[i].baseValue);
    Serial.print(" | Umbral: ");
    Serial.println(sensores[i].threshold);
  }

  Serial.println("Listo para detectar toques!");
}

void detectarToques() {
  for (int i = 0; i < numSensores; i++) {
    uint16_t valor = touchRead(sensores[i].pin);
    Serial.print(sensores[i].nombre);
    Serial.print(" → Valor: ");
    Serial.print(valor);

    if (valor < sensores[i].threshold) {
      Serial.println(" - TOCADO!");
    } else {
      Serial.println(" - No tocado");
    }
  }
  Serial.println();
}

void setup() {
  Serial.begin(9600);
  delay(1000);
  Serial.println("Test de sensores táctiles ESP32 (modularizado)");
  calibrarSensores();
}

void loop() {
  detectarToques();
  delay(1000);
}
