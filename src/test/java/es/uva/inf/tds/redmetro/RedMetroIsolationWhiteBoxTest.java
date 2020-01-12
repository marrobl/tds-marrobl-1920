package es.uva.inf.tds.redmetro;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import es.uva.inf.maps.CoordenadasGPS;

/**
 * 
 * @author marrobl Maria Robles del Blanco
 *
 */
public class RedMetroIsolationWhiteBoxTest {
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
	@Tag("WhiteBox")
	@Tag("Isolation")
	public void testRedMetroNoEnServicioPorEliminacion() {
		redMetro.eliminarLinea(lineaPrimera);
		assertFalse(redMetro.enServicio(lineaPrimera));
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	public void testRedMetroRetirarLineaInactiva() {
		Linea[] lineas = {lineaPrimera,lineaSegunda,lineaTercera,lineaCuarta};
		RedMetro red = new RedMetro(lineas);
		red.retirarLinea(lineaPrimera);
		assertFalse(red.enServicio(lineaPrimera));
		red.retirarLinea(lineaPrimera);
		assertFalse(red.enServicio(lineaPrimera));
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	public void testRedMetroEliminarLineaEliminada() {
		Linea[] lineas = {lineaPrimera,lineaSegunda,lineaTercera,lineaCuarta};
		RedMetro red = new RedMetro(lineas);
		red.eliminarLinea(lineaPrimera);
		Linea[] esperado = {lineaSegunda,lineaTercera,lineaCuarta};
		assertArrayEquals(esperado, red.getLineasEnServicio());
		red.eliminarLinea(lineaPrimera);
		assertArrayEquals(esperado, red.getLineasEnServicio());
		assertFalse(red.enServicio(lineaPrimera));
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	public void testRedMetroReactivarLineaActiva() {
		Linea[] lineas = {lineaPrimera,lineaSegunda,lineaTercera,lineaCuarta};
		RedMetro red = new RedMetro(lineas);
		assertTrue(red.enServicio(lineaPrimera));
		red.reactivarLinea(lineaPrimera);
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	public void testRedMetroGetConexionSinTrasbordoLineaInactiva() {
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
 		redMetro.retirarLinea(lineaCuarta);
 		assertNull(redMetro.getConexionSinTrasbordo(estacionInicial, estacionFinal));
	}
	
	@Test
	@Tag("WhiteBox")
	@Tag("Isolation")
	public void testRedMetroGetConexionTrasbordoExcepcion2() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getConexionTrasbordo(null,null);});
	}
	
}

