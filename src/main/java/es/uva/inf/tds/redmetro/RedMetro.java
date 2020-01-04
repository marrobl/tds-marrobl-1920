package es.uva.inf.tds.redmetro;

import java.util.ArrayList;

public class RedMetro {

	/**
	 * Inicializador de una red de metro, formada por varias lineas. 
	 * Una red de metro tiene que tener al menos dos lineas. 
	 * Una linea esta univocamente identificada en la red por un numero consecutivo
	 * y un color que no puede coincidir con colores de otras lineas de esa red
	 * Las lineas estan en servicio
	 * 
	 * @pre.condition {@code lineas != null}
	 * @pre.condition {@code lineas.size()>=2}
	 * @pre.condition las lineas tienen numeros consecutivos
	 * @pre.condition las lineas tienen diferentes colores
	 * 
	 * @param lineas conjunto de Lineas que forman la red
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public RedMetro(Linea... lineas) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Consulta las lineas que pertenecen a la red de metro, ya esten en servicio o fuera de servicio
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
	 * @pre.condition {@code linea != null}
	 * @pre.condition cuando el color de la linea coincide con alguno de las lineas existentes
	 * @pre.condition cuando el numero de la linea no es consecutivo en la red
	 * 
	 * @param linea linea que se quiere añadir
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
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
	 * @pre.condition {@code color != null}
	 * @param color color de identificacion de la linea
	 * @return linea contenida en la red
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
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
	 * Retira una linea de servicio temporalmente
	 * La linea tiene que estar en la red
	 * 
	 * @pre.condition la linea tiene que formar parte de la red
	 * @pre.condition {@code getLineaEnServicio().size()>2}
	 * @param linea linea que se retira de servicio en la red de metro
	 * 
	 * @post.condition {@code getLineaEnServicio().size()>=2}
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void retirarLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Devuelve una lista de lineas de la red que pasan por la estacion indicada
	 * por su nombre metido por parametro.
	 * Solo se devuelven las lineas que esten en servicio.
	 * Si no se encuentra ninguna linea que pase por la estacion indicada, 
	 * se devuelve una lista vacia.
	 * 
	 * @pre.condition {@code nombreEstacion != null}
	 * 
	 * @param nombreEstacion nombre identificativo de la estacion
	 * @return lista de lineas en servicio que pasan por esa estacion
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public Linea[] getLineas(String nombreEstacion) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta la estacion o estaciones en las que tienen correspondencia 
	 * las dos lineas introducidas por parametro
	 * Si no tienen correspondencia devuelven una lista vacia
	 * Las lineas tienen que estar en servicio
	 * 
	 * @pre.condition {@code linea1 != null} y {@code linea2 != null}
	 * @pre.condition linea1 y linea2 tienen que estar en servicio en la red
	 * @param linea1 linea primera
	 * @param linea2 linea segunda
	 * @return estacion o estaciones en las que estas lineas tienen correspondecia, 
	 * o lista vacia si no tienen correspondencia
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public Estacion[] getCorrespondencia(Linea linea1, Linea linea2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Elimina la linea definitivamente de la red de metro.
	 * La linea tiene que formar parte de la red de metro
	 * 
	 * @pre.condition {@code linea != null}
	 * @pre.condition {@code getLinea.contains(linea)}
	 * @param linea linea que se quiere eliminar de la red de metro
	 *
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones 
	 */
	public void eliminarLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Reactiva el servicio de una linea de la red de metro
	 * que previamente tiene que estar en la red pero sin servicio.
	 * 
	 * @pre.condition {@code linea != null}
	 * @pre.condition {@code getLineas().contains(linea)}
	 * @pre.condition {@code !getLineaEnServicio().contains(linea)}
	 * @param linea linea que se quiere reactivar su servicio
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones 
	 */
	public void reactivarLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Consulta si hay conexion entre las dos estaciones introducidas 
	 * por parametro en la misma linea, es decir, sin trasbordo.
	 * Si hay conexion directa, devuelve la linea.
	 * Si no hay conexion, no devuelve ninguna.
	 * 
	 * @pre.condition {@code estacion1 != null} y {@code estacion2 != null}
	 * 
	 * @param estacion1 estacion primera
	 * @param estacion2 estacion segunda
	 * @return linea en la que se encuentran las dos estaciones, o ninguna
	 * si no se encuentran en la misma linea
	 * 
	 * @throws IllegalArgumentException si no se cumple la precondicion
	 */
	public Linea getConexionSinTrasbordo(Estacion estacion1, Estacion estacion2) {
		// TODO Auto-generated method stub
		return null;
	}


}
