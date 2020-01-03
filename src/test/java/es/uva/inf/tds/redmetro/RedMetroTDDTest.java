package es.uva.inf.tds.redmetro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;

public class RedMetroTDDTest {
	
	@Test
	@Tag("TDD")
	public void RedMetroTest() {
		CoordenadasGPS coordEntrada1 = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
		CoordenadasGPS coordSalida1 = new CoordenadasGPS("045°38'06\"N","132°05'59\"E");
		CoordenadasGPS[] coordenadasInicial = {coordEntrada1, coordSalida1};
 		Estacion estacionInicial = new Estacion("Primera Estacion", coordenadasInicial);
		CoordenadasGPS coordEntrada2 = new CoordenadasGPS("058°38'06\"N","136°05'59\"E");
		CoordenadasGPS coordSalida2 = new CoordenadasGPS("064°38'06\"N","135°05'59\"E");
		CoordenadasGPS[] coordenadasFinal = {coordEntrada2, coordSalida2};
 		Estacion estacionFinal = new Estacion("Segunda Estacion", coordenadasFinal);
 		Estacion[] estaciones = {estacionInicial, estacionFinal};
 		Linea lineaPrimera = new Linea(1,"rojo",estaciones);
 		Linea lineaSegunda = new Linea(2, "azul", estaciones);
 		Linea lineaTercera = new Linea(3, "verde", estaciones);
		ArrayList<Linea> lineas = new ArrayList<>();
		lineas.add(lineaPrimera);
		lineas.add(lineaSegunda);
		lineas.add(lineaTercera);
		RedMetro redMetro = new RedMetro(lineas);
		assertNotNull(redMetro.getLineas());
		assertArrayEquals(lineas.toArray(),redMetro.getLineas());
	}

	@Test
	@Tag("TDD")
	public void RedMetroExcepcionTest() {
		assertThrows(IllegalArgumentException.class, () -> { RedMetro redDeMetro = new RedMetro(null);});
	}
	
}
