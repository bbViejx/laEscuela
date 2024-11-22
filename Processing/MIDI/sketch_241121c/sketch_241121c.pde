import com.jsyn.JSyn;
import com.jsyn.midi.MidiTools;
import com.jsyn.midi.MidiConstants;
import com.jsyn.unitgen.LineOut;

void setup() {
    size(400, 400);
    println("Midi Tools cargado con éxito");
}

void draw() {
    background(0);
    fill(255);
    text("Midi funcionando con JSyn", 10, height / 2);
}
