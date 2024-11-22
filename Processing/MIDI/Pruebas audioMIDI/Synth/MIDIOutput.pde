
Minim minim;
AudioOutput out;

Oscil wave;
MelodyInstrument instrument;


class MIDIOutput{
  
  MIDIOutput(){
    minim = new Minim(this);
  out = minim.getLineOut(Minim.STEREO, 512);
  
 out.setTempo(144);
 out.setPan(1);
 
   // Crear un instrumento con una melodía
  instrument = new MelodyInstrument(out);
  
  // Reproducir la melodía
  
  }
  
  void play(){
    instrument.playNote();
  }
  
  void addNote(int val){
    
    instrument.addNote(map(val,0,200,300,400), map(val,0,200,0,1)); // A4 - 440 Hz
    
  }

}


// Clase personalizada para un instrumento con melodía integrada
class MelodyInstrument {
  AudioOutput output;
  Oscil wave;
  ArrayList<Note> melody; // Almacena las notas de la melodía
  
  MelodyInstrument(AudioOutput out) {
    this.output = out;
    this.wave = new Oscil(440, 0.5, Waves.SINE); // Configuración inicial del oscilador
    this.melody = new ArrayList<Note>();
  }
  
  // Método para agregar notas a la melodía
  void addNote(float frequency, float duration) {
    melody.add(new Note(frequency, duration));
  }
  
  // Reproducir una sola nota
  void playNote() {
    Note note = melody.remove(0);
    wave.setFrequency(note.frequency);
    wave.patch(output);
    delay((int)(note.duration * 1000)); // Esperar la duración de la nota
    wave.unpatch(output);
  }
}

// Clase para representar una nota musical
class Note {
  float frequency;
  float duration;
  
  Note(float frequency, float duration) {
    this.frequency = frequency;
    this.duration = duration;
  }
}
