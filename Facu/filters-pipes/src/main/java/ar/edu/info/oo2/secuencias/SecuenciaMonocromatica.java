package ar.edu.info.oo2.secuencias;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.info.oo2.filtros.ImageFilter;
import ar.edu.info.oo2.filtros.Monochrome;
import ar.edu.info.oo2.filtros.Rainbow;

public class SecuenciaMonocromatica extends SecuenciaFiltros {

	@Override
	public List<ImageFilter> generarSecuencia(List<ImageFilter> filtros) {
		filtros = filtros.stream().filter(f -> f.getClass() != Rainbow.class).collect(Collectors.toList());
		if(filtros.getLast().getClass() != Monochrome.class) {
			filtros.add(new Monochrome());
		}
		return filtros;
	}


}
