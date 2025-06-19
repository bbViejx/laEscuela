package ar.info.juego.Encriptador;

abstract class Cifrado {
	
	protected String key;
	
	public Cifrado(String key) {
		this.key = key;
	}
	
	public String encrypt(String mensaje) {
		return "";
	}
	
	public String decrypt(String mensaje) {
		return "";
	}
	

}
