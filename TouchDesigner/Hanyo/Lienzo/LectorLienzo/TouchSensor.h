#ifndef TOUCH_SENSOR_H
#define TOUCH_SENSOR_H

#include <Arduino.h>
#include <BluetoothSerial.h> 

class TouchSensor {
  public:
    TouchSensor(uint8_t _pin, String _name, uint16_t _value, uint16_t _threshold, BluetoothSerial* _bt);
    void read();
    void display();
    void calibrate();
    uint16_t getValue();
    uint16_t getThreshold();
    bool isTouched();
    String getName();

  private:
    uint8_t pin;
    String name;
    uint16_t value;
    uint16_t threshold;
    BluetoothSerial* bt;
};

#endif