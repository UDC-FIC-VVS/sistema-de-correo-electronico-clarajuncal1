package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {

	private String nombrePrueba = "TextoPrueba";
	private String contenido = "Texto de Prueba";
	
	@Test
	public void obtenerNombre() {
		
		Texto texto = new Texto(nombrePrueba, contenido);
		
		assertEquals(texto.obtenerNombre(), nombrePrueba);	
		
	}
	
	@Test
	public void obtenerContenido() {
		
		Texto texto = new Texto(nombrePrueba, contenido);
		
		assertEquals(texto.obtenerContenido(), contenido);
	}
	
	@Test
	public void obtenerTamaño() {
		
		Texto texto = new Texto(nombrePrueba, contenido);
		
		assertEquals(texto.obtenerTamaño(), contenido.length());
	}
	
	@Test
	public void obtenerPrevisualizacion() {
		
		Texto texto = new Texto(nombrePrueba, contenido);
		
		assertEquals(texto.obtenerPreVisualizacion(), nombrePrueba + "("+ contenido.length() + " bytes, " + "text/plain)");

	}
}
