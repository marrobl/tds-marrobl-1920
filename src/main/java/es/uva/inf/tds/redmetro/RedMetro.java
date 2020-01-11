package es.uva.inf.tds.redmetro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import es.uva.inf.maps.CoordenadasGPS;
/**
 * Clase que representa una red de metro, formada por al menos dos lineas.
 * 
 * @author marrobl Maria Robles del Blanco
 *
 */
public class RedMetro {
	private ArrayList<Linea> lineas;
	private ArrayList<Linea> lineasInactivas;
	private ArrayList<Linea> lineasEliminadas;
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
		if(lineas == null) throw new IllegalArgumentException();
		if(lineas.length<2) throw new IllegalArgumentException();
		for(int i = 0; i<lineas.length; i++) {
			for(int j = 1; i<lineas.length; i++) {
				if(i!=j && lineas[i].getColor().equals(lineas[j].getColor())) throw new IllegalArgumentException();
				if(i!=j && lineas[i].getNumero() == lineas[j].getNumero()) throw new IllegalArgumentException();
			}
		}
		 
		this.lineas = (ArrayList<Linea>) Arrays.asList(lineas);	
	}

	/**
	 * Inicializador de una red de metro a partir de un objeto JSON 
	 * que contiene toda la informacion sobre las lineas. 
	 * Una red de metro tiene que tener al menos dos lineas. 
	 * Una linea esta univocamente identificada en la red por un numero consecutivo
	 * y un color que no puede coincidir con colores de otras lineas de esa red
	 * Las lineas se inicializan en servicio
	 * 
	 * @pre.condition {@code json != null}
	 * @pre.condition lineas tienen que ser al menos dos
	 * @pre.condition las lineas tienen numeros consecutivos
	 * @pre.condition las lineas tienen diferentes colores
	 * 
	 * @param json formato json que contiene toda la informacion sobre la red
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public RedMetro(String json) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Consulta las lineas que pertenecen a la red de metro, ya esten en servicio o fuera de servicio
	 * @return lineas que forman la red
	 */
	public Linea[] getLineas() {
		Linea[] linea = (Linea[]) lineas.toArray();
		return linea;
	}

	/**
	 * Añade a la red la linea introducida por parametro
	 * Esta linea no puede ser igual a ninguna de las que ya contiene la red
	 * Teniendo asi un diferente color a las lineas que contiene la red y un numero consecutivo a estas
	 * La linea se añade en servicio
	 * 
	 * @pre.condition {@code linea != null}
	 * @pre.condition el color de la linea no tiene que coincidir con alguno de las lineas existentes
	 * @pre.condition el numero de la linea tiene que ser consecutivo en la red
	 * @pre.condition el numero de la linea no puede coincidir con ninguno de los existentes
	 * 
	 * @param linea linea que se quiere añadir
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 * 
	 */
	public void addLinea(Linea linea) {
		if(linea == null) throw new IllegalArgumentException();
		for(int i = 0; i<lineas.size(); i++) {
			if(lineas.get(i).getColor().equals(linea.getColor())) throw new IllegalArgumentException();
			if(lineas.get(i).getNumero() == linea.getNumero()) throw new IllegalArgumentException();
		}
		int ultimoNumero = lineas.get(lineas.size()-1).getNumero();
		if(linea.getNumero()+1 != ultimoNumero) throw new IllegalArgumentException();
		
		lineas.add(linea);
	}
	
	/**
	 * Devuelve la linea que esta en la red a partir de su numero
	 * Si la linea no se encuentra en la red devuelve null
	 * 
	 * @param numero numero de identificacion de la linea
	 * @return linea contenida en la red
	 */
	public Linea getLinea(int numero) {
		Linea linea = null;
		for(int i = 0; i<lineas.size(); i++) {
			if(lineas.get(i).getNumero() == numero) linea = lineas.get(i);
		}
		return linea;
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
		if(color == null) throw new IllegalArgumentException();
		
		Linea linea = null;
		for(int i = 0; i<lineas.size(); i++) {
			if(lineas.get(i).getColor().equals(color)) linea = lineas.get(i);
		}
		return linea;
	}

	/**
	 * Devuelve si una linea perteneciente a la red de metro esta en servicio o no
	 * 
	 * @pre.condition {@code linea != null}
	 * @pre.condition linea tiene que pertenecer a la red
	 * @return true, si la linea se encuentra en servicio, false en cualquier otro caso
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public boolean enServicio(Linea linea) {
		if(linea == null) throw new IllegalArgumentException();
		if(!lineas.contains(linea)) throw  new IllegalArgumentException();
	
		boolean enServicio = true;
		if(lineasInactivas.contains(linea)) enServicio = false;
		if(lineasEliminadas.contains(linea)) enServicio = false;
		return enServicio;
	}

	/**
	 * Retira una linea de servicio temporalmente
	 * La linea tiene que estar en la red
	 * Para que se pueda retirar una linea de la red, al menos tienen
	 * que quedar dos lineas en servicio
	 * Si la linea ya se encuentra fuera de servicio, el metodo queda sin efecto
	 * 
	 * @pre.condition {@code linea != null}
	 * @pre.condition la linea tiene que formar parte de la red
	 * @pre.condition {@code getLineaEnServicio().size()>2}
	 * @param linea linea que se retira de servicio en la red de metro
	 * 
	 * @post.condition {@code getLineaEnServicio().size()>=2}
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void retirarLinea(Linea linea) {
		if(linea == null) throw new IllegalArgumentException();

	}

	/**
	 * Devuelve una lista de lineas de la red que pasan por la estacion indicada
	 * por su nombre introducido por parametro.
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
		// TODO Cambiar fake implementation
		Linea[] lineas = {};
		return lineas;
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
	 * Si se reactiva una que ya esta activa, queda sin efecto
	 * 
	 * @pre.condition {@code linea != null}
	 * @pre.condition {@code getLineas().contains(linea)}
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
	 * @param estacionPartida estacion de partida
	 * @param estacionDestino estacion de destino
	 * @return linea en la que se encuentran las dos estaciones, o ninguna
	 * si no se encuentran en la misma linea
	 * 
	 * @throws IllegalArgumentException si no se cumple la precondicion
	 */
	public Linea getConexionSinTrasbordo(Estacion estacionPartida, Estacion estacionDestino) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta si hay conexion entre las dos estaciones introducidas en la red.
	 * Si hay conexion entre las dos estaciones dadas devuelve la lista de lineas
	 * ordenadas, siendo la primera linea la que contiene la estacion de partida
	 * y la ultima linea, la estacion final.
	 * Si no se encuentra conexion devuelve vacio
	 * 
	 * @pre.condition {@code estacionInicial != null} y {@code estacionFinal != null}
	 * @param estacionPartida estacion de partida
	 * @param estacionDestino estacion de destino
	 * @return lista de lineas ordenadas que conectan las estaciones y vacio si no existe ninguna linea que las conecte
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public Linea[] getConexionTrasbordo(Estacion estacionPartida, Estacion estacionDestino) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve una estacion cercana a una coordenada GPS dada
	 * y en un radio menor o igual que la distancia indicada
	 * Solo devuelve estacion que se encuentren en lineas con servicio
	 * 
	 * @pre.condition {@code coordenada != null}
	 * @pre.condition {@code distanciaMax >= 0}
	 *  
	 * @param coordenada coordenadaGPS
	 * @param distanciaMax distancia maxima medida en metros para establecer la cercania
	 * @return estacion cercana si se ha encontrado alguna, nada en cualquier otro caso
	 */
	public Estacion getEstacionCercana(CoordenadasGPS coordenada, int distanciaMax) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve informacion en formato JSON sobre las lineas
	 * en la que se encuentra la estacion
	 * Devuelve una lista de lineas si hay mas de una coincidencia
	 * Si no hay ninguna linea que contenga la estacion, devuelve vacio
	 * @pre.condition {@code nombreEstacion!= null}
	 * @param nombreEstacion nombre de la estacion 
	 * @return JSONObject lista de lineas que contienen a la estacion, vacio en cualquier otro caso
	 */
	public JSONObject getInfoLineas(String nombreEstacion) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Devuelve la informacion de la red de metro en formato JSON
	 * Devuelve la informacion de todas, tanto en servicio como sin servicio,
	 * de las lineas que conforman esa red
	 * 
	 * @return objeto JSON que representa todas las lineas que tiene la red de metro
	 */

	public JSONObject getInfoRed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Linea[] getLineasEnServicio() {
		// TODO Auto-generated method stub
		return null;
	}


}
