#include <BluetoothSerial.h>
#include "TouchSensor.h"

BluetoothSerial SerialBT;

// Lista de sensores táctiles que querés usar
TouchSensor sensores[] = {
  TouchSensor(15, "T3 - GPIO15", 0, 30, &SerialBT),
  TouchSensor(13, "T4 - GPIO13", 0, 30, &SerialBT),
  TouchSensor(4, "T0 - GPIO4", 0, 50, &SerialBT)
};

void setup() {
  Serial.begin(9600);
  SerialBT.begin("ESP32Sensor"); 
  delay(1000);
  calibrateSensors();
}

void loop() {
  for (int i = 0; i < 3; i = i + 1) {
      sensores[i].read();
    }

  int t1 = sensores[0].isTouched() ? 1 : 0;
  int t2 = sensores[1].isTouched() ? 1 : 0;

  // Invertimos la señal del modulador (más toque = más valor)
  int touchStrength = constrain(sensores[2].getThreshold() - sensores[2].getValue(), 0, sensores[2].getThreshold());
  int modVal = map(touchStrength, 0, sensores[2].getThreshold(), 0, 100);

  SerialBT.print("T1:"); SerialBT.print(t1);
  SerialBT.print(" T2:"); SerialBT.print(t2);
  SerialBT.print(" M:");  SerialBT.println(modVal);

  delay(50);
}

void calibrateSensors() {
  Serial.println("ESP32 Touch Sensor Test - OOP Version");
  Serial.println("Calibrando sensores...");

  // Calibrate all sensors
  for (int i = 0; i < 3; i++) {
    sensores[i].calibrate();
  }

  Serial.println("Calibración completa");
}
