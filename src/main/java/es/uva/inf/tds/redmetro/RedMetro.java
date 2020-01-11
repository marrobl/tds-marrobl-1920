package es.uva.inf.tds.redmetro;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
			for(int j = 1; i<lineas.length; j++) {
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
	 * @param jsonArray formato json que contiene toda la informacion sobre la red
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public RedMetro(String jsonArray) {
		if(jsonArray == null) throw new IllegalArgumentException();
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Linea>>(){}.getType();
		this.lineas = gson.fromJson(jsonArray, listType);
		
		if(lineas.size()<2) throw new IllegalArgumentException();
		for(int i = 0; i<lineas.size(); i++) {
			for(int j = 1; i<lineas.size(); j++) {
				if(i!=j && lineas.get(i).getColor().equals(lineas.get(j).getColor())) throw new IllegalArgumentException();
				if(i!=j && lineas.get(i).getNumero() == lineas.get(j).getNumero()) throw new IllegalArgumentException();
			}
		}
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
		if(this.getLineasEnServicio().length<=2) throw new IllegalArgumentException();
		if(!lineas.contains(linea)) throw new IllegalArgumentException();
		
		if(!lineasInactivas.contains(linea)) lineasInactivas.add(linea);
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
		if(nombreEstacion == null) throw new IllegalArgumentException();
		
		ArrayList<Linea> lineasEstacion = new ArrayList<>();
		Linea[] lineasEnServicio = this.getLineasEnServicio();
		for( int i = 0; i< lineasEnServicio.length; i++) {
			Estacion[] estacionesDirectas = lineasEnServicio[i].getEstaciones(true);
			for(int j = 0; j<estacionesDirectas.length; j++) {
				if(estacionesDirectas[i].getNombre().equals(nombreEstacion)) lineasEstacion.add(lineasEnServicio[i]); 
			}
			
			Estacion[] estacionesInversas = lineasEnServicio[i].getEstaciones(false);
			for(int j = 0; j<estacionesDirectas.length; j++) {
				if(estacionesInversas[i].getNombre().equals(nombreEstacion)) lineasEstacion.add(lineasEnServicio[i]); 
			}
		}
		Linea[] lineasConEstacion = (Linea[]) lineasEstacion.toArray();
		return lineasConEstacion;
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
		if(linea1== null || linea2 == null) throw new IllegalArgumentException();
		if(!this.enServicio(linea1) || !this.enServicio(linea2)) throw new IllegalArgumentException();
		
		Estacion[] correspondencias = linea1.getCorrespondencias(linea2);
		return correspondencias;
	}

	/**
	 * Elimina la linea definitivamente de la red de metro.
	 * La linea tiene que formar parte de la red de metro
	 * Si la linea ya estaba eliminada el metodo queda sin efecto
	 * 
	 * @pre.condition {@code linea != null}
	 * @pre.condition {@code getLinea.contains(linea)}
	 * @param linea linea que se quiere eliminar de la red de metro
	 *
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones 
	 */
	public void eliminarLinea(Linea linea) {
		if(linea == null) throw new IllegalArgumentException();
		if(!lineas.contains(linea)) throw new IllegalArgumentException();
		
		if(!lineasEliminadas.contains(linea)) lineasEliminadas.add(linea);
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
		if(linea == null) throw new IllegalArgumentException();
		if(!lineas.contains(linea)) throw new IllegalArgumentException();
		
		if(lineasInactivas.contains(linea)) lineasInactivas.remove(linea);		
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
		if(estacionPartida == null || estacionDestino == null) throw new IllegalArgumentException();
		
		Linea linea;
		for(int i = 0; i<lineas.size(); i++) {
			if(lineas.get(i).estaConectada(estacionPartida, estacionDestino) && this.enServicio(lineas.get(i))) {
				linea = lineas.get(i);
				return linea; 
			}
		}
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
		if(estacionPartida == null || estacionDestino == null) throw new IllegalArgumentException();
		
		Linea[] lineasActivas = this.getLineasEnServicio();
		ArrayList<Linea> lineasTrasb = new ArrayList<>();
		Linea lineaPartida = null;
		Linea lineaDestino = null;
		for(int i = 0;i < lineasActivas.length; i++) {
			Estacion[] estacionesPartida = lineasActivas[i].getEstaciones(true);
			for(int j = 0; j< estacionesPartida.length; j++) {
				if(estacionesPartida[j].getNombre().equals(estacionPartida.getNombre())) lineaPartida = lineasActivas[i];
			}
			
			Estacion[] estacionesLlegada = lineasActivas[i].getEstaciones(false);
			for(int j = 0; j< estacionesLlegada.length; j++) {
				if(estacionesLlegada[j].getNombre().equals(estacionDestino.getNombre())) lineaDestino = lineasActivas[i];
			}
		}
		
		if(lineaPartida != null && lineaDestino != null && lineaPartida.hayCorrespondencia(lineaDestino)) {
			lineasTrasb.add(lineaPartida);
	
		}
	//TODO
		return null;
	}

	/**
	 * Devuelve si hay una estacion cercana a una coordenada GPS dada
	 * en un radio menor o igual que la distancia indicada
	 * Solo devuelve si hay alguna estacion que se encuentren 
	 * en lineas con servicio
	 * 
	 * @pre.condition {@code coordenada != null}
	 * @pre.condition {@code distanciaMax >= 0}
	 *  
	 * @param coordenada coordenadaGPS
	 * @param distanciaMax distancia maxima medida en metros para establecer la cercania
	 * @return true si se ha encontrado alguna estacion cercana, false en cualquier otro caso
	 */
	public boolean hayEstacionCercana(CoordenadasGPS coordenada, int distanciaMax) {
		Linea[] lineasActivas = this.getLineasEnServicio();
		Estacion estacion = null;
		for(int i = 0; i<lineasActivas.length; i++) {
			
		}
		return false;
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
	public String getInfoLineas(String nombreEstacion) {
		if(nombreEstacion == null) throw new IllegalArgumentException();
		
		Linea[] lineasInfo = this.getLineas(nombreEstacion);
		Gson gson = new Gson();
		String jsonLineas = gson.toJson(lineasInfo);
		return jsonLineas;
	}
	/**
	 * Devuelve la informacion de la red de metro en formato JsonObject
	 * Devuelve la informacion de todas, tanto en servicio como sin servicio,
	 * de las lineas que conforman esa red
	 * 
	 * @return objeto JSON que representa todas las lineas que tiene la red de metro
	 */

	public String getInfoRed() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}

	/**
	 * Devuelve las lineas que estan activas en la red de metro
	 * @return todas las lineas activas
	 */
	public Linea[] getLineasEnServicio() {
		ArrayList<Linea> lineasServicio = new ArrayList<>();
		for(int i = 0; i < lineas.size(); i++) {
			if(!lineasInactivas.contains(lineas.get(i)) && !lineasEliminadas.contains(lineas.get(i))) lineasServicio.add(lineas.get(i));
		}
		Linea[] lineasEnServicio = (Linea[]) lineasServicio.toArray();
		return lineasEnServicio;
	}


}
