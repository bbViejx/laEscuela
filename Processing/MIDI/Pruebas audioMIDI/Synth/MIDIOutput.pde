import ddf.minim.*;

Minim minim;
AudioOutput out;

Oscil wave;
MelodyInstrument instrument;

class MIDIOutput {
  
  MIDIOutput() {
    minim = new Minim(this);
    out = minim.getLineOut(Minim.STEREO, 512);
    
    out.setTempo(144);
    out.setPan(1);
    
    // Crear un instrumento con una melodía
    instrument = new MelodyInstrument(out);
  }
  
  void play() {
    instrument.playNote();
  }
  
  void addNote(int val) {
    instrument.addNote(map(val, 0, 200, 300, 400), map(val, 0, 200, 0, 1)); // A4 - 440 Hz
  }
}

// Clase personalizada para un instrumento con envolventes y modulación
class MelodyInstrument {
  AudioOutput output;
  Oscil wave;
  ArrayList<Note> melody; // Almacena las notas de la melodía
  float amplitude = 0.0;  // Amplitud dinámica
  float attack = 0.5;     // Tiempo de ataque (segundos)
  float decay = 0.3;      // Tiempo de decaimiento (segundos)
  float sustain = 0.7;    // Nivel de sustain (0-1)
  float release = 0.5;    // Tiempo de liberación (segundos)
  boolean isNoteOn = false;
  
  MelodyInstrument(AudioOutput out) {
    this.output = out;
    this.wave = new Oscil(440, 0.0, Waves.SINE); // Inicialmente sin sonido
    this.melody = new ArrayList<Note>();
    wave.patch(output);
  }
  
  // Método para agregar notas a la melodía
  void addNote(float frequency, float duration) {
    melody.add(new Note(frequency, duration));
  }
  
  // Reproducir una sola nota
  void playNote() {
    if (melody.size() > 0) {
      Note note = melody.remove(0);
      wave.setFrequency(note.frequency);
      isNoteOn = true;
      float startTime = millis() / 1000.0;
      
      while (isNoteOn) {
        updateEnvelope(startTime, note.duration);
        delay(16); // 60 fps ~ 16 ms
      }
    }
  }
  
  // Método para actualizar la envolvente ADSR
  void updateEnvelope(float startTime, float noteDuration) {
    float currentTime = millis() / 1000.0;
    float elapsedTime = currentTime - startTime;
    
    if (elapsedTime < attack) {
      // Fase de ataque
      amplitude = map(elapsedTime, 0, attack, 0, 1);
    } else if (elapsedTime < attack + decay) {
      // Fase de decaimiento
      float decayTime = elapsedTime - attack;
      amplitude = map(decayTime, 0, decay, 1, sustain);
    } else if (elapsedTime < noteDuration) {
      // Fase de sustain
      amplitude = sustain;
    } else {
      // Fase de liberación
      float releaseTime = elapsedTime - noteDuration;
      amplitude = map(releaseTime, 0, release, sustain, 0);
      
      if (amplitude <= 0) {
        amplitude = 0;
        isNoteOn = false;
      }
    }
    wave.setAmplitude(amplitude);
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
