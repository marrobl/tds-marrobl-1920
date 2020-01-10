package es.uva.inf.tds.redmetro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;

/**
 * Clase de test de secuencia para la clase RedMetro
 * @author marrobl Maria Robles del Blanco
 *
 */
public class RedMetroSequenceTest {
	private RedMetro redMetro;
	
	@Test
	@Tag("Sequence")
	public void testRedMetro() {
		CoordenadasGPS coordEntrada1 = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
		CoordenadasGPS coordSalida1 = new CoordenadasGPS("045°38'06\"N","132°05'59\"E");
		CoordenadasGPS[] coordenadasInicial = {coordEntrada1, coordSalida1};
 		Estacion estacionInicial = new Estacion("Primera Estacion", coordenadasInicial);
		CoordenadasGPS coordEntrada2 = new CoordenadasGPS("058°38'06\"N","136°05'59\"E");
		CoordenadasGPS coordSalida2 = new CoordenadasGPS("064°38'06\"N","135°05'59\"E");
		CoordenadasGPS[] coordenadasFinal = {coordEntrada2, coordSalida2};
 		Estacion estacionFinal = new Estacion("Segunda Estacion", coordenadasFinal);
 		Estacion[] estaciones = {estacionInicial, estacionFinal};
 		Linea linea1 = new Linea(1,"rojo",estaciones);
 		Linea linea2 = new Linea(2, "azul", estaciones);
 		Linea linea3 = new Linea(3, "verde", estaciones);
		Linea[] lineas = {linea1, linea2, linea3};
		
		redMetro = new RedMetro(lineas);
		assertNotNull(redMetro.getLineas());
		assertArrayEquals(lineas,redMetro.getLineas());
	}

}
