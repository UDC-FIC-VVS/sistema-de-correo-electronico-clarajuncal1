package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AudioTest {

	private String nombrePrueba = "AudioPrueba";
	private String contenido = "Audio de Prueba";
	
	/*
	 * Obtener el nombre de un audio
	 */
	@Test
	public void obtenerNombre() {
		
		//Se crea un nuevo audio introduciendo un nombre y un contenido
		Audio audio = new Audio(nombrePrueba, contenido);
		
		//Se comprueba que el nombre introducido es el nombre definido previamente
		assertEquals(audio.obtenerNombre(), nombrePrueba);	
		
	}
	
	/*
	 * Obtener el contenido de un audio
	 */
	@Test
	public void obtenerContenido() {
		
		//Se crea un nuevo audio introduciendo un nombre y un contenido
		Audio audio = new Audio(nombrePrueba, contenido);

		//Se comprueba que el contenido introducido es el mismo contenido definido previamente
		assertEquals(audio.obtenerContenido(), contenido);
	}
	
	/*
	 * Obtener el tamaño de un audio
	 */
	@Test
	public void obtenerTamaño() {
		
		//Se crea un nuevo audio introduciendo un nombre y un contenido
		Audio audio = new Audio(nombrePrueba, contenido);

		//Se comprueba que el tamaño del audio coincida con la longitud de su contenido
		assertEquals(audio.obtenerTamaño(), contenido.length());
	}
	
	/*
	 * Obtener la previsualizacion de un audio
	 */
	@Test
	public void obtenerPrevisualizacion() {
		
		//Se crea un nuevo audio introduciendo un nombre y un contenido
		Audio audio = new Audio(nombrePrueba, contenido);
		
		assertEquals(audio.obtenerPreVisualizacion(), nombrePrueba + "("+ contenido.length() + " bytes, " + "audio/ogg)");

	}
}
