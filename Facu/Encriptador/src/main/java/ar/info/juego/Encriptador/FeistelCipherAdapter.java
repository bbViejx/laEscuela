package ar.info.juego.Encriptador;

public class FeistelCipherAdapter extends Cifrado {
	
	private FeistelCipher cifrador;

	public FeistelCipherAdapter(String key) {
		super(key);
		this.cifrador = new FeistelCipher(key);
	}
	
	public String encrypt(String mensaje) {
		return this.cifrador.encode(mensaje);
	}
	
	public String decrypt(String mensaje) {
		return this.cifrador.encode(mensaje);
	}


}
