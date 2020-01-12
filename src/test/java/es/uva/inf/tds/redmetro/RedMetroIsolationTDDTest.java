package es.uva.inf.tds.redmetro;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;



import es.uva.inf.maps.CoordenadasGPS;

/**
 * 
 * @author marrobl Maria Robles del Blanco
 *
 */
public class RedMetroIsolationTDDTest {
	private RedMetro redMetro;
	@Mock
	private Linea lineaPrimera, lineaSegunda, lineaTercera, lineaCuarta;
	private Estacion estacionInicial, estacionFinal, estacionInicial1, estacionFinal1;
	private Estacion estacionInicial2, estacionIntermedia2, estacionFinal2;
	@SuppressWarnings("unused")
	private CoordenadasGPS[] coordenadasInicial;
	@SuppressWarnings("unused")
	private CoordenadasGPS[] coordenadasFinal; 
	
	@BeforeEach
	public void setUp() {
			CoordenadasGPS entrada1 = mock(CoordenadasGPS.class);
			CoordenadasGPS salida1 = mock(CoordenadasGPS.class);
			CoordenadasGPS[] coordenadasInicial1 = {entrada1, salida1};
			estacionInicial1 = mock(Estacion.class);
			when(estacionInicial1.getNombre()).thenReturn("Primera Estacion L1");
			when(estacionInicial1.getCoordenadasGPS()).thenReturn(coordenadasInicial1);
			CoordenadasGPS entrada2 = mock(CoordenadasGPS.class);
			CoordenadasGPS salida2 = mock(CoordenadasGPS.class);
			CoordenadasGPS[] coordenadasFinal1 = {entrada2, salida2};
			estacionFinal1 = mock(Estacion.class);
			when(estacionFinal1.getNombre()).thenReturn("Segunda Estacion L1");
			when(estacionFinal1.getCoordenadasGPS()).thenReturn(coordenadasFinal1);
	 		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
	 		lineaPrimera = mock(Linea.class);
	 		when(lineaPrimera.getNumero()).thenReturn(1);
	 		when(lineaPrimera.getColor()).thenReturn("rojo");
	 		when(lineaPrimera.getEstaciones(true)).thenReturn(estaciones1);
	 		Estacion[] estacion1Inverso = {estacionFinal1, estacionInicial1};
	 		when(lineaPrimera.getEstaciones(false)).thenReturn(estacion1Inverso);
	
	 		CoordenadasGPS coord_entrada1 = mock(CoordenadasGPS.class);
	 		CoordenadasGPS coord_salida1 = mock(CoordenadasGPS.class);
	 		CoordenadasGPS[] coordenadasInicial2 = {coord_entrada1, coord_salida1};
	 		estacionInicial2  = mock(Estacion.class);
	 		when(estacionInicial2.getNombre()).thenReturn("Primera Estacion L2");
	 		when(estacionInicial2.getCoordenadasGPS()).thenReturn(coordenadasInicial2);
	 		CoordenadasGPS coord_entrada2 = mock(CoordenadasGPS.class);
	 		CoordenadasGPS coord_salida2 = mock(CoordenadasGPS.class);
	 		CoordenadasGPS[] coordenadasIntermedio2 = {coord_entrada2, coord_salida2};
	 		estacionIntermedia2 = mock(Estacion.class);
	 		when(estacionIntermedia2.getNombre()).thenReturn("Segunda Estacion L2");
	 		when(estacionIntermedia2.getCoordenadasGPS()).thenReturn(coordenadasIntermedio2);
	 		CoordenadasGPS coord_entrada3 = mock(CoordenadasGPS.class);
	 		CoordenadasGPS coord_salida3 = mock(CoordenadasGPS.class);
	 		CoordenadasGPS[] coordenadasFinal2 = {coord_entrada3, coord_salida3};
	 		estacionFinal2 = mock(Estacion.class);
	 		when(estacionFinal2.getNombre()).thenReturn("Tercera Estacion L2");
	 		when(estacionFinal2.getCoordenadasGPS()).thenReturn(coordenadasFinal2);
	 		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
	 		lineaSegunda = mock(Linea.class);
	 		when(lineaSegunda.getNumero()).thenReturn(2);
	 		when(lineaSegunda.getColor()).thenReturn("azul");
	 		when(lineaSegunda.getEstaciones(true)).thenReturn(estaciones2);
	 		Estacion[] estaciones2Inversa = {estacionFinal2, estacionIntermedia2, estacionInicial2};
	 		when(lineaSegunda.getEstaciones(false)).thenReturn(estaciones2Inversa);
	 		
	 		Estacion[] estaciones3 = {estacionFinal1, estacionFinal2};
	 		lineaTercera = mock(Linea.class);
	 		when(lineaTercera.getNumero()).thenReturn(3);
	 		when(lineaTercera.getColor()).thenReturn("verde");
	 		when(lineaTercera.getEstaciones(true)).thenReturn(estaciones3);
	 		Estacion[] estaciones3Inversa = {estacionFinal2, estacionFinal1};
	 		when(lineaTercera.getEstaciones(false)).thenReturn(estaciones3Inversa);
	 		
			Linea[] lineas = {lineaPrimera, lineaSegunda, lineaTercera};
			redMetro = new RedMetro(lineas);
			
			CoordenadasGPS entrada_1 = mock(CoordenadasGPS.class);
			CoordenadasGPS salida_1 = mock(CoordenadasGPS.class);
			CoordenadasGPS[] coordenadasInicial = {entrada_1, salida_1};
			estacionInicial = mock(Estacion.class);
			when(estacionInicial.getNombre()).thenReturn("Cuarta Estacion L4");
			when(estacionInicial.getCoordenadasGPS()).thenReturn(coordenadasInicial);
			CoordenadasGPS entrada_2 = mock(CoordenadasGPS.class);
			CoordenadasGPS salida_2 = mock(CoordenadasGPS.class);
			CoordenadasGPS[] coordenadasFinal = {entrada_2, salida_2};
			estacionFinal = mock(Estacion.class);
			when(estacionFinal.getNombre()).thenReturn("Quinta Estacion L4");
			when(estacionFinal.getCoordenadasGPS()).thenReturn(coordenadasFinal);
	 		Estacion[] estaciones4 = {estacionInicial, estacionFinal};
	 		Estacion[] estaciones4Inversa = {estacionFinal, estacionInicial};
	 		lineaCuarta = mock(Linea.class);
	 		when(lineaCuarta.getNumero()).thenReturn(4);
	 		when(lineaCuarta.getColor()).thenReturn("negro");
	 		when(lineaCuarta.getEstaciones(true)).thenReturn(estaciones4);
	 		when(lineaCuarta.getEstaciones(false)).thenReturn(estaciones4Inversa);
	 		when(lineaCuarta.estaConectada(estacionInicial, estacionFinal)).thenReturn(true);
	 		when(lineaPrimera.estaConectada(estacionInicial, estacionFinal)).thenReturn(false);
	 		when(lineaSegunda.estaConectada(estacionInicial, estacionFinal)).thenReturn(false);
	 		when(lineaTercera.estaConectada(estacionInicial, estacionFinal)).thenReturn(false);
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
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetro() {
		CoordenadasGPS coordEntrada1 = mock(CoordenadasGPS.class);
		CoordenadasGPS coordSalida1 = mock(CoordenadasGPS.class);
		CoordenadasGPS[] coordenadasInicial = {coordEntrada1, coordSalida1};
		Estacion estacionInicial = mock(Estacion.class);
		when(estacionInicial.getNombre()).thenReturn("Primera Estacion");
		when(estacionInicial.getCoordenadasGPS()).thenReturn(coordenadasInicial);
		CoordenadasGPS coordEntrada2 = mock(CoordenadasGPS.class);
		CoordenadasGPS coordSalida2 = mock(CoordenadasGPS.class);
		CoordenadasGPS[] coordenadasFinal = {coordEntrada2, coordSalida2};
		Estacion estacionFinal = mock(Estacion.class);
		when(estacionFinal.getNombre()).thenReturn("Segunda Estacion");
		when(estacionFinal.getCoordenadasGPS()).thenReturn(coordenadasFinal);
		Estacion[] estaciones = {estacionInicial, estacionFinal};
		Linea linea1 = mock(Linea.class);
		when(linea1.getNumero()).thenReturn(1);
		when(linea1.getColor()).thenReturn("rojo");
		when(linea1.getEstaciones(true)).thenReturn(estaciones);
		Linea linea2 = mock(Linea.class);
		when(linea2.getNumero()).thenReturn(2);
		when(linea2.getColor()).thenReturn("azul");
		when(linea2.getEstaciones(true)).thenReturn(estaciones);
		Linea linea3 = mock(Linea.class);
		when(linea3.getNumero()).thenReturn(3);
		when(linea3.getColor()).thenReturn("verde");
		when(linea3.getEstaciones(true)).thenReturn(estaciones);
		Linea[] lineas = {linea1, linea2, linea3};

		RedMetro redMetro = new RedMetro(lineas);
		
		assertNotNull(redMetro.getLineas());
		assertArrayEquals(lineas,redMetro.getLineas());
	}

	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroExcepcion() {
		Linea[] lineaNull = null;
		assertThrows(IllegalArgumentException.class, () -> { @SuppressWarnings("unused")
		RedMetro redDeMetro = new RedMetro(lineaNull);});
	}
	
	@Test
	@Tag("TDD")
	public void testRedMetroAnadirLinea() {
		redMetro.addLinea(lineaCuarta);
		Linea[] esperado = {lineaPrimera, lineaSegunda, lineaTercera, lineaCuarta};
		assertArrayEquals(esperado, redMetro.getLineas());
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroAnadirLineaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.addLinea(null);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetLineaNumero() {
		Linea lineaObtenida = redMetro.getLinea(1);
		assertEquals(1, lineaObtenida.getNumero());
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetLineaColor() {
		Linea lineaObtenida = redMetro.getLinea("rojo");
		assertEquals("rojo", lineaObtenida.getColor());
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetLineaColorExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		Linea linea = redMetro.getLinea(null);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroComprobarLineaEnServicio() {
		assertTrue(redMetro.enServicio(lineaPrimera));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroLineaEnServicioExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.enServicio(null);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroRetirarLinea() {
		redMetro.retirarLinea(lineaTercera);
		assertFalse(redMetro.enServicio(lineaTercera));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroRetirarLineaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.retirarLinea(lineaCuarta);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetLineasEstacion() {
		Linea[] esperado = {lineaPrimera, lineaTercera};
		assertArrayEquals(esperado,redMetro.getLineas("Segunda Estacion L1"));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetLineasEstacionExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getLineas(null);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetLineasEnServicio() {
		Linea[] esperado = {lineaPrimera, lineaSegunda, lineaTercera};
		assertArrayEquals(esperado, redMetro.getLineasEnServicio());
	}
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroConsultarCorrespondencia() {
		CoordenadasGPS coord_e = mock(CoordenadasGPS.class);
		CoordenadasGPS coord_s = mock(CoordenadasGPS.class);
		CoordenadasGPS[] coordenadas = {coord_e, coord_s};
		Estacion estacion = mock(Estacion.class);
		when(estacion.getNombre()).thenReturn("Tercera Estacion L2");
		when(estacion.getCoordenadasGPS()).thenReturn(coordenadas);
 		Estacion[] estacionReal = {estacion};
		Estacion[] esperado = {estacion};
		when(lineaSegunda.getCorrespondencias(lineaTercera)).thenReturn(estacionReal);
		assertArrayEquals(esperado,redMetro.getCorrespondencia(lineaSegunda, lineaTercera));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetCorrespondeciaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getCorrespondencia(null, lineaTercera);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroEliminarLinea() {
		Linea[] lineas = {lineaPrimera, lineaSegunda, lineaTercera};
		redMetro = new RedMetro(lineas);
		redMetro.eliminarLinea(lineaTercera);
		Linea[] esperado = {lineaPrimera, lineaSegunda};
		assertArrayEquals(esperado, redMetro.getLineasEnServicio());		
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroEliminarLineaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.eliminarLinea(null);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroReactivarLinea() {
		redMetro.retirarLinea(lineaTercera);
		redMetro.reactivarLinea(lineaTercera);
		assertTrue(redMetro.enServicio(lineaTercera));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroReactivarLineaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.reactivarLinea(null);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetConexionSinTrasbordo() {
 		Estacion[] estaciones = {estacionInicial, estacionFinal};
 		lineaCuarta = mock(Linea.class);
 		when(lineaCuarta.getNumero()).thenReturn(4);
 		when(lineaCuarta.getColor()).thenReturn("negro");
 		when(lineaCuarta.getEstaciones(true)).thenReturn(estaciones);
 		when(lineaCuarta.estaConectada(estacionInicial, estacionFinal)).thenReturn(true);
 		when(lineaPrimera.estaConectada(estacionInicial, estacionFinal)).thenReturn(false);
 		when(lineaSegunda.estaConectada(estacionInicial, estacionFinal)).thenReturn(false);
 		when(lineaTercera.estaConectada(estacionInicial, estacionFinal)).thenReturn(false);
 		Linea[] lineas = {lineaPrimera, lineaSegunda, lineaTercera,lineaCuarta};
 		redMetro = new RedMetro(lineas);
 		assertEquals(lineaCuarta.getColor(), redMetro.getConexionSinTrasbordo(estacionInicial, estacionFinal).getColor());
 		assertEquals(lineaCuarta.getNumero(), redMetro.getConexionSinTrasbordo(estacionInicial, estacionFinal).getNumero());
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetConexionSinTrasbordoExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getConexionSinTrasbordo(null, estacionFinal);});
	}
	
	@Test
	@Tag("TDD")	
	@Tag("Isolation")
	public void testRedMetroGetConexionTrasbordo() {
		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
		when(lineaPrimera.getColor()).thenReturn("rojo");
		when(lineaPrimera.getNumero()).thenReturn(1);
		when(lineaPrimera.getEstaciones(true)).thenReturn(estaciones1);
		
 		Estacion[] estaciones2 = {estacionInicial2, estacionIntermedia2, estacionFinal2};
		when(lineaSegunda.getColor()).thenReturn("azul");
		when(lineaSegunda.getNumero()).thenReturn(2);
		when(lineaSegunda.getEstaciones(true)).thenReturn(estaciones2);

		Estacion[] estaciones3 = {estacionFinal1, estacionFinal2};
		when(lineaTercera.getColor()).thenReturn("verde");
		when(lineaTercera.getNumero()).thenReturn(3);
		when(lineaTercera.getEstaciones(true)).thenReturn(estaciones3);

		when(lineaPrimera.hayCorrespondencia(lineaTercera)).thenReturn(true);
		when(lineaSegunda.hayCorrespondencia(lineaTercera)).thenReturn(true);
		Linea[] linea = {lineaPrimera,lineaSegunda,lineaTercera};
 		redMetro = new RedMetro(linea);
 		Linea[] esperado = {lineaPrimera, lineaTercera, lineaSegunda};
 		assertArrayEquals(esperado, redMetro.getConexionTrasbordo(estacionInicial1, estacionIntermedia2));
 	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetConexionTrasbordoExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getConexionTrasbordo(null, estacionFinal);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroHayEstacionCercana() {
		CoordenadasGPS coord1 = mock(CoordenadasGPS.class);
		when(coord1.getLatitudGMS()).thenReturn("041°38'06\"N");
		when(coord1.getLongitudGMS()).thenReturn("135°05'59\"E");
 		assertTrue(redMetro.hayEstacionCercana(coord1,400));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetEstacionCercanaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.hayEstacionCercana(null, 0);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetInfoLineas() throws JSONException {
		CoordenadasGPS entrada2 = mock(CoordenadasGPS.class);
		when(entrada2.getLatitudGMS()).thenReturn("058°38'06\"N");
		when(entrada2.getLongitudGMS()).thenReturn("136°05'59\"E");
		CoordenadasGPS salida2 = mock(CoordenadasGPS.class);
		when(entrada2.getLatitudGMS()).thenReturn("064°38'06\"N");
		when(entrada2.getLongitudGMS()).thenReturn("135°05'59\"E");
		CoordenadasGPS[] coordenadasFinal1 = {entrada2, salida2};
		estacionFinal1 = mock(Estacion.class);
		when(estacionFinal1.getNombre()).thenReturn("Segunda Estacion L1");
		when(estacionFinal1.getCoordenadasGPS()).thenReturn(coordenadasFinal1);
		Estacion[] estaciones1 = {estacionInicial1, estacionFinal1};
		lineaPrimera = mock(Linea.class);
		when(lineaPrimera.getNumero()).thenReturn(1);
		when(lineaPrimera.getColor()).thenReturn("rojo");
		when(lineaPrimera.getEstaciones(true)).thenReturn(estaciones1);
 		Estacion[] estaciones3 = {estacionFinal1, estacionFinal2};
 		lineaTercera = mock(Linea.class);
 		when(lineaTercera.getNumero()).thenReturn(3);
 		when(lineaTercera.getColor()).thenReturn("verde");
 		when(lineaTercera.getEstaciones(true)).thenReturn(estaciones3);
 		
 		JSONAssert.assertEquals("[lineaPrimera, lineaTercera]", redMetro.getInfoLineas("Segunda Estacion L1"),JSONCompareMode.STRICT);
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetInfoLineasExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getInfoLineas(null);});
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroGetInfoRedMetro() throws JSONException {
		Linea[] linea = {lineaPrimera, lineaSegunda};
		RedMetro red = new RedMetro(linea);
		JSONAssert.assertEquals("[lineaPrimera, lineaSegunda]", red.getInfoRed(),JSONCompareMode.STRICT);
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroCrearAPartirJson() {
		RedMetro red = new RedMetro("[lineaPrimera, lineaSegunda, lineaTercera]");
		assertArrayEquals(redMetro.getLineas(),red.getLineas());
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	public void testRedMetroCrearAPartirJsonExcepcion() {
		String jsonNull = null;
		assertThrows(IllegalArgumentException.class, () -> {@SuppressWarnings("unused")
		RedMetro red = new RedMetro(jsonNull);});
	}
}
