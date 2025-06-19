package ar.info.juego.Encriptador;

public class Mensajero {
	
	private Cifrado cifrado;
	
	public Mensajero(Cifrado cifrado) {
		this.cifrado = cifrado;
	}
	
	public String enviar(String mensaje) {
		String mensajeEncriptado = this.cifrado.encrypt(mensaje);
		//Envia el mensaje encriptado
		System.out.println ("Mensaje enviado: " + mensajeEncriptado);
		return mensajeEncriptado;
	}
	
	public void recibir(String mensaje) {
		System.out.println("Mensaje recibido: " + this.cifrado.decrypt(mensaje));
		
	}
	
	public void setCifrado(Cifrado cifrado) {
		this.cifrado = cifrado;
	}

}
