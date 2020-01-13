package es.uva.inf.tds.redmetro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import es.uva.inf.maps.CoordenadasGPS;
/**
 * 
 * @author marrobl Maria Robles del Blanco
 */
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
		assertThrows(IllegalArgumentException.class, () -> { 
		@SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(lineasMismoNumero);});
	}
	
	
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroAnadirLineaMismoColor() {
 		Estacion[] estaciones = {estacionInicial1, estacionFinal1};
 		Linea linea = new Linea(4,"rojo",estaciones);
 		
 		assertThrows(IllegalArgumentException.class, () -> { redMetro.addLinea(linea);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroAnadirLineaMismoNumero() {
 		Estacion[] estaciones = {estacionInicial1, estacionFinal1};
 		Linea linea = new Linea(3,"morado",estaciones);
 		
 		assertThrows(IllegalArgumentException.class, () -> { redMetro.addLinea(linea);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroAnadirLineaNumeroNoConsecutivo() {
 		Estacion[] estaciones = {estacionInicial1, estacionFinal1};
 		Linea linea = new Linea(6,"morado",estaciones);
 		
 		assertThrows(IllegalArgumentException.class, () -> { redMetro.addLinea(linea);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroNoEnServicio() {
		redMetro.retirarLinea(lineaPrimera);
		assertFalse(redMetro.enServicio(lineaPrimera));
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroEnServicioNoPertenece() {
		assertThrows(IllegalArgumentException.class, () -> { redMetro.enServicio(lineaCuarta);});
	}
	@Test
	@Tag("BlackBox")
	public void testRedMetroRetirarLineaNull() {
 		assertThrows(IllegalArgumentException.class, () -> { redMetro.retirarLinea(null);;});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroRetirarLineaQuedarDosActivadas() {
		redMetro.retirarLinea(lineaTercera);
		
 		assertThrows(IllegalArgumentException.class, () -> { redMetro.retirarLinea(lineaSegunda);;});
	}

	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetCorrespondenciaNull2() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getCorrespondencia(lineaPrimera, null);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetCorrespondenciaLineaSinServicio1() {
		redMetro.retirarLinea(lineaSegunda);
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getCorrespondencia(lineaSegunda, lineaPrimera);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetCorrespondenciaLineaSinServicio2() {
		redMetro.retirarLinea(lineaPrimera);
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getCorrespondencia(lineaSegunda,lineaPrimera);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetCorrespondenciaSinEstacionesEnComun() {
		Estacion[] esperado = {};
		assertArrayEquals(esperado, redMetro.getCorrespondencia(lineaPrimera, lineaSegunda));
	}
	
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroEliminarLineaQueNoEstaEnLaRed() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.eliminarLinea(lineaCuarta);});
		
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroReactivarLineaQueNoEstaEnLaRed() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.reactivarLinea(lineaCuarta);});
		
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetLineaColorDevuelveNull() {
		Linea lineaVacia = redMetro.getLinea("morado");
		//TODO cambiar
		fail("not yet implemented");
		assertNull(lineaVacia);
	}
	
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetLineaNumeroDevuelveNull() {
		Linea lineaVacia = redMetro.getLinea(6);
		//TODO cambiar
		fail("Not yet implemented");
		assertNull(lineaVacia);
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetLineasEstacionDevuelveNull() {
		Linea[] lineaVacia = redMetro.getLineas("nombre estacion ninguna");
		assertNull(lineaVacia);
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetConexionSinTrasbordoExcepcion2() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getConexionSinTrasbordo(estacionFinal,null);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetConexionSinTrasbordoNoHay() {
		//TODO cambiar cuando se implemente
		fail("not yet implemented");
		assertNull(redMetro.getConexionSinTrasbordo(estacionInicial1, estacionInicial2));
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetConexionTrasbordoExcepcion2() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getConexionTrasbordo(null,estacionFinal);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetConexionTrasbordoNoHay() {
		//TODO cambiar cuando se implemente
		fail("not yet implemented");
		assertNull(redMetro.getConexionTrasbordo(estacionInicial1, estacionFinal));
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetEstacionCercanaDistanciaMenorQue0() {
		CoordenadasGPS coordenadas = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
		assertThrows(IllegalArgumentException.class, () -> {redMetro.hayEstacionCercana(coordenadas, -1);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetEstacionCercanaNoHay() {
		CoordenadasGPS coordenadas = new CoordenadasGPS("000°38'06\"N","000°05'59\"E");
		//TODO cambiar cuando se implemente
		fail("not yet implemented");
		assertFalse(redMetro.hayEstacionCercana(coordenadas, 40));
	}

}
