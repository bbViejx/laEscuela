import javax.sound.midi.*;
import ddf.minim.*;
import ddf.minim.ugens.*;

int beat = 1;
MidiReceiver receiver = new MidiReceiver();
MIDIOutput MIDIout;

void setup() {
  size(400, 400);
  background(0);
  textSize(16);

  MIDIReader reader = new MIDIReader(receiver);

  MIDIout = new MIDIOutput();
}

void draw() {
  if(receiver.pollMIDIMessage()!=null)
  {
    MIDIout.addNote(receiver.pollMIDIMessage()[1]);
    MIDIout.play();
  }
}
