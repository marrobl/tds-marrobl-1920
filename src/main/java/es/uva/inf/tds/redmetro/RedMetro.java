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
	 * @throws IllegalArgumentException cuando {@code lineas == null}
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

	/**
	 * Añade a la red la linea introducida por parametro
	 * Esta linea no puede ser igual a ninguna de las que contiene la red
	 * Teniendo asi un diferente color a las lineas que contiene la red y un numero consecutivo a estas
	 * 
	 * @param linea linea que se quiere añadir
	 * 
	 * @throws IllegalArgumentException {@code linea == null}
	 * @throws IllegalArgumentException cuando el color de la linea coincide con algun color
	 * de los que ya contiene red
	 * @throws IllegalArgumentException si el numero de la linea no es consecutivo en la red
	 * 
	 */
	public void addLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Devuelve la linea que esta en la red a partir de su numero
	 * Si la linea no se encuentra en la red devuelve null
	 * 
	 * @param numero numero de identificacion de la linea
	 * @return linea contenida en la red
	 */
	public Linea getLinea(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve la linea que esta en la red a partir de su color
	 * Si la linea no se encuentra en la red devuelve null
	 * 
	 * @param color color de identificacion de la linea
	 * @return linea contenida en la red
	 * @throws IllegalArgumentException cuando {@code color == null}
	 */
	public Linea getLinea(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve todas las lineas de la red de metro que estan en servicio
	 * @return lista de lineas en servicio de la red
	 */
	public Linea[] getLineaEnServicio() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retira una linea de servicio temporalmente, introduciendo su numero
	 * de identificacion
	 * @param numero numero que identifica a la linea en la red de metro
	 */
	public void retirarLinea(int numero) {
		// TODO Auto-generated method stub
		
	}

}
