package gal.udc.fic.vvs.email.archivador;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ArchivadorSimpleTest {
	
	private String nombrePrueba = "NombreDePrueba";
	private int espacioPrueba = 100;

	/*
	 * Obtener el nombre de un archivador
	 */
	@Test
	public void ObtenerNombreTest() {
		
		//Creo un nuevo archivador, introduciendo un nombre y un espacio
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
		
		//Se compara que el nombre del archivador añadido sea el mismo que el que hemos definido
		assertEquals(nombrePrueba, archivadorSimple.obtenerNombre());
	}
	
	/*
	 * Comprobar que el correo se almacena correctamente
	 */
	@Test
	public void almacenarCorreoCorrectamente() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, espacioPrueba);
		Texto texto = new Texto("textoPrueba", "Es un texto de prueba");
		Mensaje mensajePrueba = new Mensaje(texto);
	
		assertTrue(archivadorSimple.almacenarCorreo(mensajePrueba));
	}
	
	/*
	 * Probar el caso en el que el correo no se almacene correctamente
	 */
	@Test
	public void almacenarCorreoIncorrectamente() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, 10);
		Mensaje mensajePrueba = new Mensaje( new Texto("textoPrueba", "Es un texto de prueba"));
	
		assertFalse(archivadorSimple.almacenarCorreo(mensajePrueba));
	}
	
	/*
	 * Comprobar el espacio total del Archivador
	 */
	@Test
	public void ObtenerEspacioTotalTest() {
		
		//Se crea un nuevo archivador, introduciendo un nombre y un espacio
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
				
		//Se compara que el espacio total del archivador sea el mismo que el introducido
		assertEquals(espacioPrueba, archivadorSimple.obtenerEspacioTotal());
	}
	
	/*
	 * Comprobar el disponible del Archivador después de haber añadido Correo
	 */
	@Test
	public void ObtenerEspacioDisponibleTest() {
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
		Mensaje mensajePrueba = new Mensaje( new Texto("textoPrueba", "Es un texto de prueba"));

		archivadorSimple.almacenarCorreo(mensajePrueba);
		assertEquals(79, archivadorSimple.obtenerEspacioDisponible());
	}
	
	/*
	 * Comprobar que despues de establecer el delegado no se obtiene
	 */
	@Test
	public void EstablecerYObtenerDelegado() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba,espacioPrueba);
		
		archivadorSimple.establecerDelegado(archivadorSimple);
		
		assertEquals(null, archivadorSimple.obtenerDelegado());
	}
}
