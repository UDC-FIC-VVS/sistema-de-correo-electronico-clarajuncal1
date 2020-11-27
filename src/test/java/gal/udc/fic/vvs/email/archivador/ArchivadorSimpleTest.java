package gal.udc.fic.vvs.email.archivador;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class ArchivadorSimpleTest {
	
	private String nombrePrueba = "NombreDePrueba";
	private int espacioPrueba = 10;

	@Test
	public void ObtenerNombreTest() {
		
		//Creo un nuevo archivador, introduciendo un nombre y un espacio
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
		
		//Se compara que el nombre del archivador añadido sea el mismo que el que hemos definido
		assertEquals(nombrePrueba, archivadorSimple.obtenerNombre());
	}
	
	@Test
	public void ObtenerEspacioTotalTest() {
		
		//Se crea un nuevo archivador, introduciendo un nombre y un espacio
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
				
		//Se compara que el espacio total del archivador sea el mismo que el introducido
		assertEquals(espacioPrueba, archivadorSimple.obtenerEspacioTotal());
	}
	
	@Test
	public void ObtenerEspacioDisponibleTest() {
		
		//Se crea un nuevo archivador, introduciendo un nombre y un espacio
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
				
		//Se compara que el espacio disponible del archivador cuando se crea sea el mismo que el introducido
		assertEquals(espacioPrueba, archivadorSimple.obtenerEspacioDisponible());
	}
	
	@Test
	public void ObtenerDelegado() {
		//Se crea un nuevo archivador, introduciendo un nombre y un espacio
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
		
		//Se compara que el delegado del archivador que se acaba de crear es nulo
		assertEquals(null, archivadorSimple.obtenerDelegado());
	}
}
