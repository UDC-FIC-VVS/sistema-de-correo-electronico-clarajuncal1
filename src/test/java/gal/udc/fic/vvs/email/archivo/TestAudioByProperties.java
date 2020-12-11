package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class TestAudioByProperties {

	/*
	 * Nivel de la prueba : Unitaria
	 * Categoría : Prueba dinámica de caja negra positiva
	 * Mecanismo de selección de datos : Generación automática de datos, se obtienen
	 * dos String cualesquiera.
	 */
	@Property public void obtenerNombreProperties(String nombre, String contenido) {
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(nombre, audio.obtenerNombre());
	}
	
	/*
	 * Nivel de la prueba : Unitaria
	 * Categoría : Prueba dinámica de caja negra positiva
	 * Mecanismo de selección de datos : Generación automática de datos, se obtienen
	 * dos String cualesquiera.
	 */
	@Property public void obtenerContenidoProperties(String nombre, String contenido) {
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(contenido, audio.obtenerContenido());
	}
	
	/*
	 * Nivel de la prueba : Unitaria
	 * Categoría : Prueba dinámica de caja negra positiva
	 * Mecanismo de selección de datos : Generación automática de datos, se obtienen
	 * dos String cualesquiera.
	 */
	@Property public void obtenerTamañoProperties(String nombre, String contenido) {
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(contenido.length(), audio.obtenerTamaño());
		
	}
	
	/*
	 * Nivel de la prueba : Unitaria
	 * Categoría : Prueba dinámica de caja negra positiva
	 * Mecanismo de selección de datos : Generación automática de datos, se obtienen
	 * dos String cualesquiera.
	 */
	@Property public void obtenerVisualizacionProperties(String nombre, String contenido) {
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(audio.obtenerPreVisualizacion(), nombre + "(" + contenido.length() + " bytes, " + "audio/ogg)");
	}
}

