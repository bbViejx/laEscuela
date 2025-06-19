package ar.info.juego.Encriptador;

public class RC4Adapter extends Cifrado {
	
	private RC4 cifrado = new RC4();

	public RC4Adapter(String key) {
		super(key);
	}
	
	public String encrypt(String mensaje) {
		return this.cifrado.encriptar(mensaje, this.key);
	}
	
	public String decrypt(String mensaje) {
		return this.cifrado.desencriptar(mensaje, this.key);
	}

}
