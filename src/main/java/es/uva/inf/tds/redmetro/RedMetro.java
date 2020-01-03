package es.uva.inf.tds.redmetro;

import java.util.ArrayList;

public class RedMetro {

	/**
	 * Inicializador de una red de metro, formada por varias lineas. 
	 * Una red de metro tiene que tener al menos dos lineas. 
	 * Una linea esta univocamente identificada en la red por un numero consecutivo
	 * y un color que no puede coincidir con colores de otras lineas de esa red
	 * 
	 * @param lineas conjunto de Lineas que forman la red
	 * 
	 * @throws IllegalArgumentException cuando {@code lineas = null}
	 * @throws IllegalArgumentException cuando {@code lineas.size()<2}
	 * @throws IllegalArgumentException cuando las lineas no son univocamente identificadas en la red por numero consecutivo
	 * @throws IllegalArgumentException cuando las lineas no tienen un color unico en esa red
	 */
	public RedMetro(Linea... lineas) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Consulta las lineas que pertenecen a la red de metro, ya esten desactivadas o eliminadas
	 * @return lineas que forman la red
	 */
	public Linea[] getLineas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}

}
