package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImagenTest {

	private String nombrePrueba = "ImagenPrueba";
	private String contenido = "Imagen de Prueba";
	
	@Test
	public void obtenerNombre() {
		
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		assertEquals(imagen.obtenerNombre(), nombrePrueba);	
		
	}
	
	@Test
	public void obtenerContenido() {
		
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		assertEquals(imagen.obtenerContenido(), contenido);
	}
	
	@Test
	public void obtenerTamaño() {
		
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		assertEquals(imagen.obtenerTamaño(), contenido.length());
	}
	
	@Test
	public void obtenerPrevisualizacion() {
		
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		assertEquals(imagen.obtenerPreVisualizacion(), nombrePrueba + "("+ contenido.length() + " bytes, " + "image/png)");

	}
}
