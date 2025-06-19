package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MartitaExporter extends VoorheesExporter {
	
	public String exportar(List<Socio> socios) {
		JSONArray sociosJson = new JSONArray();
		socios.stream().forEach((s) -> sociosJson.add(this.getSocioJSON(s)));
		return sociosJson.toJSONString();
	}
	
	private JSONObject getSocioJSON(Socio socio) {
		JSONObject socioJson = new JSONObject();
		socioJson.put("nombre", socio.getNombre());
		socioJson.put("email", socio.getEmail());
		socioJson.put("legajo", socio.getLegajo());
		return socioJson;
	}
}
