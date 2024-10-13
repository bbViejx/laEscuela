String backspace(String s) {
  return (s == null || s.length() == 0) //<>//
    ? ""
    : (s.substring(0, s.length()-1));
}

String write(String s){
  return key != CODED?
    s + key:
    s;
}
