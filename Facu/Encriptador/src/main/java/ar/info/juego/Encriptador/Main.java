package ar.info.juego.Encriptador;

public class Main {
	
	public static void main (String[] args) {
		Mensajero mensajero = new Mensajero(new FeistelCipherAdapter("clave"));
		String mensaje = mensajero.enviar("Prueba1234");
		mensajero.recibir(mensaje);
		
		mensajero.setCifrado(new RC4Adapter("clave"));
		mensaje = mensajero.enviar("Prueba1234");
		mensajero.recibir(mensaje);
	}

}
