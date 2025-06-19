package ar.edu.unlp.info.oo2.biblioteca;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExporter extends VoorheesExporter {
	
	public String exportar(List<Socio> socios) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writerFor(ArrayList.class).writeValueAsString(socios);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
