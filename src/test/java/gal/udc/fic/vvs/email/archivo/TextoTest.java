package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {

	private String nombrePrueba = "TextoPrueba";
	private String contenido = "Texto de Prueba";
	
	@Test
	public void obtenerNombre() {
		
		//Se crea un nuevo texto introduciendo un nombre y un contenido
		Texto texto = new Texto(nombrePrueba, contenido);
		
		//Se comprueba que el nombre introducido es el nombre definido previamente
		assertEquals(texto.obtenerNombre(), nombrePrueba);	
		
	}
	
	@Test
	public void obtenerContenido() {
		
		//Se crea un nuevo texto introduciendo un nombre y un contenido
		Texto texto = new Texto(nombrePrueba, contenido);
		
		//Se comprueba que el contenido introducido es el mismo definido previamente
		assertEquals(texto.obtenerContenido(), contenido);
	}
	
	@Test
	public void obtenerTamaño() {
		
		//Se crea un nuevo texto introduciendo un nombre y un contenido
		Texto texto = new Texto(nombrePrueba, contenido);
		
		//Se comprueba que el tamaño del texto coincida con la longitud de su contenido
		assertEquals(texto.obtenerTamaño(), contenido.length());
	}
	
	@Test
	public void obtenerPrevisualizacion() {
		
		//Se crea un nuevo texto introduciendo un nombre y un contenido
		Texto texto = new Texto(nombrePrueba, contenido);
		
		assertEquals(texto.obtenerPreVisualizacion(), nombrePrueba + "("+ contenido.length() + " bytes, " + "text/plain)");

	}
}
