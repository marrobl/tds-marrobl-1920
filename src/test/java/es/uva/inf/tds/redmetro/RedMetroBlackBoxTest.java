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

public class RedMetroBlackBoxTest {
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
	public void testRedMetroJsonUnaLinea() {
		String json = "{lineaPrimera}";
		assertThrows(IllegalArgumentException.class, () -> { 
		@SuppressWarnings("unused")
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
		assertThrows(IllegalArgumentException.class, () -> { 
		@SuppressWarnings("unused")
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
		assertNull(redMetro.getCorrespondencia(lineaPrimera, lineaSegunda));
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
		assertNull(lineaVacia);
	}
	
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetLineaNumeroDevuelveNull() {
		Linea lineaVacia = redMetro.getLinea(6);
		assertNull(lineaVacia);
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetLineasEstacionDevuelveNull() {
		assertNull(redMetro.getLineas("nombre estacion ninguna"));
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetConexionSinTrasbordoExcepcion2() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getConexionSinTrasbordo(estacionFinal,null);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetConexionSinTrasbordoNoHay() {
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
		assertNull(redMetro.getConexionTrasbordo(estacionInicial1, estacionFinal));
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetEstacionCercanaDistanciaMenorQue0() {
		CoordenadasGPS coordenadas = mock(CoordenadasGPS.class);
		assertThrows(IllegalArgumentException.class, () -> {redMetro.hayEstacionCercana(coordenadas, -1);});
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetEstacionCercanaNoHay() {
		CoordenadasGPS coordenadas = mock(CoordenadasGPS.class);
		
		CoordenadasGPS entrada1 = mock(CoordenadasGPS.class);
		CoordenadasGPS salida1 = mock(CoordenadasGPS.class);
		CoordenadasGPS[] coordenadasInicial1 = {entrada1};
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
 		Linea linea1 = mock(Linea.class);
 		when(linea1.getNumero()).thenReturn(1);
 		when(linea1.getColor()).thenReturn("rojo");
 		when(linea1.getEstaciones(true)).thenReturn(estaciones1);
 		when(entrada1.getDistanciaA(coordenadas)).thenReturn(100.00);
 		when(salida1.getDistanciaA(coordenadas)).thenReturn(100.00);
 		when(entrada2.getDistanciaA(coordenadas)).thenReturn(100.00);
 		when(salida2.getDistanciaA(coordenadas)).thenReturn(100.00);
 		
 		CoordenadasGPS coord_entrada1 = mock(CoordenadasGPS.class);
 		CoordenadasGPS coord_salida1 = mock(CoordenadasGPS.class);
 		CoordenadasGPS[] coordenadasInicial2 = {coord_entrada1, coord_salida1};
 		estacionInicial2  = mock(Estacion.class);
 		when(estacionInicial2.getCoordenadasGPS()).thenReturn(coordenadasInicial2);
 		CoordenadasGPS coord_entrada3 = mock(CoordenadasGPS.class);
 		CoordenadasGPS coord_salida3 = mock(CoordenadasGPS.class);
 		CoordenadasGPS[] coordenadasFinal2 = {coord_entrada3, coord_salida3};
 		estacionFinal2 = mock(Estacion.class);
 		when(estacionFinal2.getCoordenadasGPS()).thenReturn(coordenadasFinal2);
 		Estacion[] estaciones2 = {estacionInicial2, estacionFinal2};
 		Linea linea2 = mock(Linea.class);
 		when(linea2.getEstaciones(true)).thenReturn(estaciones2);
 		when(linea2.getNumero()).thenReturn(2);
 		when(linea2.getColor()).thenReturn("azul");
 		when(coord_entrada1.getDistanciaA(coordenadas)).thenReturn(100.00);
 		when(coord_salida1.getDistanciaA(coordenadas)).thenReturn(100.00);
 		when(coord_entrada3.getDistanciaA(coordenadas)).thenReturn(100.00);
 		when(coord_salida3.getDistanciaA(coordenadas)).thenReturn(100.00);
 		Linea[] lineaDeRed = {linea1, linea2};
 		RedMetro red = new RedMetro(lineaDeRed);
		assertFalse(red.hayEstacionCercana(coordenadas, 40));
	}
	
	@Test
	@Tag("BlackBox")
	public void testRedMetroGetInfoLineasPorNombreEstacionNohay() {
		assertThrows(IllegalArgumentException.class, () -> {redMetro.getInfoLineas("nombre de estacion que no existe");});
	}
}
