package es.uva.inf.tds.redmetro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;

public class RedMetroBlackBoxTest {
	private RedMetro redMetro;
	private Linea lineaPrimera, lineaSegunda, lineaTercera, lineaCuarta;
	private Estacion estacionInicial, estacionFinal, estacionInicial1, estacionFinal1;
	private Estacion estacionInicial2, estacionIntermedia2, estacionFinal2;
	@SuppressWarnings("unused")
	private CoordenadasGPS[] coordenadasInicial;
	@SuppressWarnings("unused")
	private CoordenadasGPS[] coordenadasFinal; 
	
	@BeforeEach
	public void setUp() {
			CoordenadasGPS entrada1 = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
			CoordenadasGPS salida1 = new CoordenadasGPS("045°38'06\"N","132°05'59\"E");
			CoordenadasGPS[] coordenadasInicial1 = {entrada1, salida1};
	 		estacionInicial1 = new Estacion("Primera Estacion L1", coordenadasInicial1);
			CoordenadasGPS entrada2 = new CoordenadasGPS("058°38'06\"N","136°05'59\"E");
			CoordenadasGPS salida2 = new CoordenadasGPS("064°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasFinal1 = {entrada2, salida2};
	 		estacionFinal1 = new Estacion("Segunda Estacion L1", coordenadasFinal1);
	 		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
	 		lineaPrimera = new Linea(1,"rojo",estaciones1);
	 		
			CoordenadasGPS coord_entrada1 = new CoordenadasGPS("080°38'06\"N","135°05'59\"E");
			CoordenadasGPS coord_salida1 = new CoordenadasGPS("085°38'06\"N","132°05'59\"E");
			CoordenadasGPS[] coordenadasInicial2 = {coord_entrada1, coord_salida1};
			estacionInicial2 = new Estacion("Primera Estacion L2", coordenadasInicial2);
			CoordenadasGPS coord_entrada2 = new CoordenadasGPS("090°38'06\"N","136°05'59\"E");
			CoordenadasGPS coord_salida2 = new CoordenadasGPS("095°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasIntermedio2 = {coord_entrada2, coord_salida2};
	 		estacionIntermedia2 = new Estacion("Segunda Estacion L2", coordenadasIntermedio2);
	 		CoordenadasGPS coord_entrada3 = new CoordenadasGPS("0100°38'06\"N","136°05'59\"E");
			CoordenadasGPS coord_salida3 = new CoordenadasGPS("098°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasFinal2 = {coord_entrada3, coord_salida3};
	 		estacionFinal2 = new Estacion("Tercera Estacion L2", coordenadasFinal2);
	 		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
	 		lineaSegunda = new Linea(2, "azul", estaciones2);
	 		
			Estacion[] estaciones3 = {estacionFinal1, estacionFinal2};
	 		lineaTercera = new Linea(3, "verde", estaciones3);
	 		
			Linea[] lineas = {lineaPrimera, lineaSegunda, lineaTercera};
			redMetro = new RedMetro(lineas);
			
			CoordenadasGPS entrada_1 = new CoordenadasGPS("030°38'06\"N","135°05'59\"E");
			CoordenadasGPS salida_1 = new CoordenadasGPS("035°38'06\"N","132°05'59\"E");
			CoordenadasGPS[] coordenadasInicial = {entrada_1, salida_1};
			estacionInicial = new Estacion("Cuarta Estacion L4", coordenadasInicial);
			CoordenadasGPS entrada_2 = new CoordenadasGPS("068°38'06\"N","136°05'59\"E");
			CoordenadasGPS salida_2 = new CoordenadasGPS("054°38'06\"N","135°05'59\"E");
			CoordenadasGPS[] coordenadasFinal = {entrada_2, salida_2};
			estacionFinal = new Estacion("Quinta Estacion L4", coordenadasFinal);
	 		Estacion[] estaciones4 = {estacionInicial, estacionFinal};
	 		lineaCuarta = new Linea(4,"negro",estaciones4);
	}
	
	@AfterEach
	public void tearDown() {
		redMetro = null; 		lineaPrimera = null;
		lineaSegunda = null;	lineaTercera = null;
		lineaCuarta = null;		estacionInicial = null;
		estacionFinal = null; 	estacionInicial1 = null;
		estacionFinal1 = null; 	estacionInicial2 = null;
		estacionIntermedia2 = null;	estacionFinal2 = null;
		coordenadasInicial = null; 	coordenadasFinal = null;
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroUnaLinea() {
		Linea[] linea = {lineaPrimera};
		assertThrows(IllegalArgumentException.class, () -> { @SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(linea);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroDosLineas() {
		Linea[] linea = {lineaPrimera, lineaSegunda};
		RedMetro red = new RedMetro(linea);
		assertNotNull(red);
		assertArrayEquals(linea, red.getLineas());
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroLineasIgualColor() {
		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
		lineaPrimera = new Linea(1,"rojo",estaciones1);
		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
		lineaSegunda = new Linea(2, "rojo", estaciones2);
		Linea[] lineasMismoColor = {lineaPrimera, lineaSegunda};
		assertThrows(IllegalArgumentException.class, () -> { @SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(lineasMismoColor);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroLineasIgualNum() {
		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
		lineaPrimera = new Linea(1,"rojo",estaciones1);
		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
		lineaSegunda = new Linea(1, "azul", estaciones2);
		Linea[] lineasMismoNumero = {lineaPrimera, lineaSegunda};
		assertThrows(IllegalArgumentException.class, () -> { @SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(lineasMismoNumero);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroJsonUnaLinea() {
		String json = "{lineaPrimera}";
		assertThrows(IllegalArgumentException.class, () -> { @SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(json);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroJsonDosLineas() {
		String json = "[lineaPrimera, lineaSegunda]";
		RedMetro red = new RedMetro(json);
		assertNotNull(red);
		Linea[] esperado = {lineaPrimera, lineaSegunda};
		assertArrayEquals(esperado, red.getLineas());
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroLineasIgualColorJSon() {
		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
		lineaPrimera = new Linea(1,"rojo",estaciones1);
		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
		lineaSegunda = new Linea(2, "rojo", estaciones2);
		String lineasMismoColor = "[lineaPrimera, lineaSegunda]";
		assertThrows(IllegalArgumentException.class, () -> { @SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(lineasMismoColor);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroLineasIgualNunJson() {
		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
		lineaPrimera = new Linea(1,"rojo",estaciones1);
		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
		lineaSegunda = new Linea(1, "azul", estaciones2);
		String lineasMismoNumero = "[lineaPrimera, lineaSegunda]";
		assertThrows(IllegalArgumentException.class, () -> { @SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(lineasMismoNumero);});
	}
}
