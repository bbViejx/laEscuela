// Example by Tom Igoe

import processing.serial.*;

// The serial port:
Serial myPort;
boolean tuki = false;

void setup(){
  
  String portName = Serial.list()[1]; 
  myPort = new Serial(this, portName, 9600);
  frameRate(20);
}

void draw(){
if(tuki){
  myPort.write('1');
}
else{
  myPort.write('0');
}
frameRate(frameRate-1);
tuki = !tuki;
}
