package ar.edu.info.oo2.secuencias;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.info.oo2.filtros.ImageFilter;
import ar.edu.info.oo2.filtros.Monochrome;

public class SecuenciaMulticromatica extends SecuenciaFiltros {

	@Override
	public List<ImageFilter> generarSecuencia(List<ImageFilter> filtros) {
		return filtros.stream().filter(f -> f.getClass() != Monochrome.class).collect(Collectors.toList());
	}
	

}
