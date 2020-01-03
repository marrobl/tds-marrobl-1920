package es.uva.inf.tds.redmetro;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;

public class RedMetroTDDTest {
	private RedMetro redMetro;
	private Linea lineaPrimera, lineaSegunda, lineaTercera, lineaCuarta;
	@BeforeEach
	public void setUp() {
			CoordenadasGPS entrada1 = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
			CoordenadasGPS salida1 = new CoordenadasGPS("045°38'06\"N","132°05'59\"E");
			CoordenadasGPS[] coordenadasInicial1 = {entrada1, salida1};
	 		Estacion estacionInicial1 = new Estacion("Primera Estacion L1", coordenadasInicial1);
			CoordenadasGPS entrada2 = new CoordenadasGPS("058°38'06\"N","136°05'59\"E");
			CoordenadasGPS salida2 = new CoordenadasGPS("064°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasFinal1 = {entrada2, salida2};
	 		Estacion estacionFinal1 = new Estacion("Segunda Estacion L1", coordenadasFinal1);
	 		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
	 		lineaPrimera = new Linea(1,"rojo",estaciones1);
	 		
			CoordenadasGPS coord_entrada1 = new CoordenadasGPS("080°38'06\"N","135°05'59\"E");
			CoordenadasGPS coord_salida1 = new CoordenadasGPS("085°38'06\"N","132°05'59\"E");
			CoordenadasGPS[] coordenadasInicial2 = {coord_entrada1, coord_salida1};
			Estacion estacionInicial2 = new Estacion("Primera Estacion L2", coordenadasInicial2);
			CoordenadasGPS coord_entrada2 = new CoordenadasGPS("090°38'06\"N","136°05'59\"E");
			CoordenadasGPS coord_salida2 = new CoordenadasGPS("095°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasIntermedio2 = {coord_entrada2, coord_salida2};
	 		Estacion estacionIntermedia2 = new Estacion("Segunda Estacion L2", coordenadasIntermedio2);
	 		CoordenadasGPS coord_entrada3 = new CoordenadasGPS("0100°38'06\"N","136°05'59\"E");
			CoordenadasGPS coord_salida3 = new CoordenadasGPS("098°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasFinal2 = {coord_entrada3, coord_salida3};
	 		Estacion estacionFinal2 = new Estacion("Tercera Estacion L2", coordenadasFinal2);
	 		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
	 		lineaSegunda = new Linea(2, "azul", estaciones2);
	 		
			Estacion[] estaciones3 = {estacionFinal1, estacionFinal2};
	 		lineaTercera = new Linea(3, "verde", estaciones3);
			Linea[] lineas = {lineaPrimera, lineaSegunda, lineaTercera};
			redMetro = new RedMetro(lineas);
			
			CoordenadasGPS entrada_1 = new CoordenadasGPS("030°38'06\"N","135°05'59\"E");
			CoordenadasGPS salida_1 = new CoordenadasGPS("035°38'06\"N","132°05'59\"E");
			CoordenadasGPS[] coordenadasInicial = {entrada_1, salida_1};
	 		Estacion estacionInicial = new Estacion("Cuarta Estacion L4", coordenadasInicial);
			CoordenadasGPS entrada_2 = new CoordenadasGPS("068°38'06\"N","136°05'59\"E");
			CoordenadasGPS salida_2 = new CoordenadasGPS("054°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasFinal = {entrada_2, salida_2};
	 		Estacion estacionFinal = new Estacion("Quinta Estacion L4", coordenadasFinal);
	 		Estacion[] estaciones4 = {estacionInicial, estacionFinal};
	 		lineaCuarta = new Linea(4,"negro",estaciones4);
	}
	
	@AfterEach
	public void tearDown() {
		redMetro = null;
	}

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
 		Linea linea1 = new Linea(1,"rojo",estaciones);
 		Linea linea2 = new Linea(2, "azul", estaciones);
 		Linea linea3 = new Linea(3, "verde", estaciones);
		Linea[] lineas = {linea1, linea2, linea3};
		RedMetro redMetro = new RedMetro(lineas);
		assertNotNull(redMetro.getLineas());
		assertArrayEquals(lineas,redMetro.getLineas());
	}

	@Test
	@Tag("TDD")
	public void RedMetroExcepcionTest() {
		assertThrows(IllegalArgumentException.class, () -> { RedMetro redDeMetro = new RedMetro(null);});
	}
	
	@Test
	@Tag("TDD")
	public void RedMetroAnadirLineaTest() {
		redMetro.addLinea(lineaCuarta);
		Linea[] esperado = {lineaPrimera, lineaSegunda, lineaTercera, lineaCuarta};
		assertArrayEquals(esperado, redMetro.getLineas());
	}
	
	@Test
	@Tag("TDD")
	public void RedMetroAnadirLineaExcepitionTest() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.addLinea(null);});
	}
	
	
}
