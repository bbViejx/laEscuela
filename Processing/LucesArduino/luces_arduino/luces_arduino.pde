// Example by Tom Igoe

import processing.serial.*;

// The serial port:
Serial myPort;
boolean tuki = false;
char modo = '1';
int brightness = 255;

void setup() {
  size(600, 600);
  String portName = Serial.list()[1];
  myPort = new Serial(this, portName, 9600);
  frameRate(10);
}

void draw() {
  myPort.write(modo);
  myPort.write(brightness);
}

void keyPressed() {
  switch(key) {
  case 'i':
    modo = '2';
    break;
  case 'o':
    modo = '1';
    break;
  case 'q':
    brightness = brightness-5 <= 0 ? 0 :  brightness - 5;
    break;
  case 'w':
    brightness = brightness+5 >=255 ? 255 : brightness + 5;
  case 'a':
    frameRate(frameRate -5 <= 1 ? 1 :  frameRate - 5);
    break;
  case 's':
    frameRate(frameRate + 5 >= 255 ? 255 :  frameRate + 5);
    break;
  default:
    break;
  }
}
