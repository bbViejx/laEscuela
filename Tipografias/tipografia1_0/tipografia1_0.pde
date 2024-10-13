String word = "d";
PFont helvetica;
float[] size;

void setup() {
  size(900, 900);
  helvetica = createFont("Helvetica.ttf", 100);
  frameRate(8);
}

void draw() {
  background(#1F1F1F);
  fill(#f1f1f1);
  textFont(helvetica);
  float lineHeight = frameCountMaping(200);


  textSize(100);
  textLeading(lineHeight);
  textAlign(LEFT, TOP);
  text(word, 0, 0, mouseX, height);


  noFill();
  stroke(#00ff33);
  strokeWeight(5);
  rect(0, 0, mouseX, height);
}

float frameCountMaping(int max) {
  return map(sin(frameCount), -10, 10, 0, max);
}



void keyPressed() {
  if (keyCode==BACKSPACE) {
    word = backspace(word);
  } else {
    word = write(word);
  }
}
