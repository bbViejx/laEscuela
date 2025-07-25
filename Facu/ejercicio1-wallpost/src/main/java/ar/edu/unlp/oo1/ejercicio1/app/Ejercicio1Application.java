package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {
	
	public static Logger loggerWallpost = Logger.getLogger("ejercicio1.wallpost");
	public static Logger loggerUI = Logger.getLogger("ejercicio1.ui");
	
	
	public static void main(String[] args) throws SecurityException, IOException {
		
		loggerWallpost.addHandler(new FileHandler("ejercicio1.log"));

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				loggerUI.info("La aplicación inició correctamente.");
				new WallPostUI();
			}
		});
	}

}
