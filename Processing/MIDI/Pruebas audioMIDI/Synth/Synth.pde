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
  MidiMessage msg 
  if(receiver.pollMIDIMessage()!=null)
  {
    MIDIout.addNote(receiver.pollMIDIMessage()[1]);
    MIDIout.play();
  }
}
