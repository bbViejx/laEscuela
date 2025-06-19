package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class BibliotecaTest {

	 private Biblioteca biblioteca;
	    private Socio socio1;
	    private Socio socio2;

	    @BeforeEach
	    public void setUp() {
	        biblioteca = new Biblioteca();
	        socio1 = new Socio("Robocop", "robocop@gmail.com", "12345678");
	        socio2 = new Socio("Panchita", "panchita@mail.com", "87654321");
	    }

	    @Test
	    public void testExportarSocios() {
	        biblioteca.agregarSocio(socio1);
	        biblioteca.agregarSocio(socio2);

	        String exportado = biblioteca.exportarSocios();

	        assertTrue(exportado.contains("\"nombre\": \"Robocop\""));
	        assertTrue(exportado.contains("\"legajo\": \"12345678\""));
	        assertTrue(exportado.contains("\"email\": \"robocop@gmail.com\""));
	        
	        assertTrue(exportado.contains("\"nombre\": \"Panchita\""));
	        assertTrue(exportado.contains("\"legajo\": \"87654321\""));
	        assertTrue(exportado.contains("\"email\": \"panchita@mail.com\""));
	        
	    }
	    
	    @Test
	    public void testExportarSociosVacia() {

	        String exportado = biblioteca.exportarSocios();
	        assertTrue(exportado.equals("[]"));
	        
	    }
	    
	    @Test
	    public void testExportarSociosJSONSimple() throws ParseException {
	    	biblioteca.setExporter(new MartitaExporter());
	        biblioteca.agregarSocio(socio1);
	        biblioteca.agregarSocio(socio2);

	        String exportado = biblioteca.exportarSocios();
	        
	        JSONParser parser = new JSONParser();
	        Object jsonObj = parser.parse(exportado);

	        assertTrue(jsonObj.toString().contains("\"nombre\":\"Robocop\""));
	        assertTrue(jsonObj.toString().contains("\"legajo\":\"12345678\""));
	        assertTrue(jsonObj.toString().contains("\"email\":\"robocop@gmail.com\""));
	    }
	    
	    @Test
	    public void testExportarSociosMartitaVacia() {
	    	biblioteca.setExporter(new MartitaExporter());
	        String exportado = biblioteca.exportarSocios();
	        assertTrue(exportado.equals("[]"));
	        
	    }
	    
	    @Test
	    public void testExportarSociosJackson() throws ParseException {
	    	biblioteca.setExporter(new JacksonExporter());
	        biblioteca.agregarSocio(socio1);
	        biblioteca.agregarSocio(socio2);

	        String exportado = biblioteca.exportarSocios();
	        
	        JSONParser parser = new JSONParser();
	        Object jsonObj = parser.parse(exportado);

	        assertTrue(jsonObj.toString().contains("\"nombre\":\"Robocop\""));
	        assertTrue(jsonObj.toString().contains("\"legajo\":\"12345678\""));
	        assertTrue(jsonObj.toString().contains("\"email\":\"robocop@gmail.com\""));
	    }
	    
	    @Test
	    public void testExportarSociosJacksonVacia() {
	    	biblioteca.setExporter(new JacksonExporter());
	        String exportado = biblioteca.exportarSocios();
	        assertTrue(exportado.equals("[]"));
	        
	    }

}
