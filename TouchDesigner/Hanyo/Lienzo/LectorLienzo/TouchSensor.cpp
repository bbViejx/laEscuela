#include "TouchSensor.h"

TouchSensor::TouchSensor(uint8_t _pin, String _name, uint16_t _value, uint16_t _threshold, BluetoothSerial* _bt) {
  pin = _pin;
  name = _name;
  value = _value;
  threshold = _threshold;
  bt = _bt;
}

void TouchSensor::read() {
  value = touchRead(pin);
}

void TouchSensor::display() {
  bt->print(value);
    bt->println();
}

void TouchSensor::calibrate() {
  uint32_t total = 0;
  for (int i = 0; i < 10; i++) {
    total += touchRead(pin);
    delay(100);
  }
  uint16_t baseValue = total / 10;
  threshold = baseValue * 0.8;

  bt->print("Sensor ");
  bt->print(name);
  bt->print(" - Base: ");
  bt->print(baseValue);
  bt->print(", Umbral: ");
  bt->println(threshold);
}

uint16_t TouchSensor::getValue() {
  return value;
}

uint16_t TouchSensor::getThreshold(){
  return threshold;
}

bool TouchSensor::isTouched() {
  return (value < threshold && threshold > 0);
}

String TouchSensor::getName() {
  return name;
}