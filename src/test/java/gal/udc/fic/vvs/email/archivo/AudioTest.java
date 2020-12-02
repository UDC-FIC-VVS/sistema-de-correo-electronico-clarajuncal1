package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AudioTest {

	private String nombrePrueba = "AudioPrueba";
	private String contenido = "Audio de Prueba";
	
	@Test
	public void obtenerNombre() {
		
		Audio audio = new Audio(nombrePrueba, contenido);
		
		assertEquals(audio.obtenerNombre(), nombrePrueba);	
		
	}
	
	@Test
	public void obtenerContenido() {
		
		Audio audio = new Audio(nombrePrueba, contenido);

		assertEquals(audio.obtenerContenido(), contenido);
	}
	
	@Test
	public void obtenerTamaño() {
		
		Audio audio = new Audio(nombrePrueba, contenido);

		assertEquals(audio.obtenerTamaño(), contenido.length());
	}
	
	@Test
	public void obtenerPrevisualizacion() {
		
		Audio audio = new Audio(nombrePrueba, contenido);
		
		assertEquals(audio.obtenerPreVisualizacion(), nombrePrueba + "("+ contenido.length() + " bytes, " + "audio/ogg)");

	}
}
