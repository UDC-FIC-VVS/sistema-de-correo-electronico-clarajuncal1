package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestImagen {

	private String nombrePrueba = "ImagenPrueba";
	private String contenido = "Imagen de Prueba";
	
	/*
	 * Obtener el nombre de una imagen
	 */
	@Test
	public void obtenerNombre() {
		
		//Se crea una nueva imagen introduciendo un nombre y un contenido
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		//Se comprueba que el nombre introducido es el mismo que el definido previamente
		assertEquals(imagen.obtenerNombre(), nombrePrueba);	
		
	}
	
	/*
	 * Obtener el contenido de una imagen
	 */
	@Test
	public void obtenerContenido() {
		
		//Se crea una nueva imagen introduciendo un nombre y un contenido
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		//Se comprueba que el contenido introducido es el mismo que el definido previamente
		assertEquals(imagen.obtenerContenido(), contenido);
	}
	
	/*
	 * Obtener el tamaño de una imagen
	 */
	@Test
	public void obtenerTamaño() {
		
		//Se crea una nueva imagen introduciendo un nombre y un contenido
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		//Se comprueba que el tamaño de la imagen sea igual a la longitud de su contenido
		assertEquals(imagen.obtenerTamaño(), contenido.length());
	}
	
	/*
	 * Obtener la previsualizacion de una imagen
	 */
	@Test
	public void obtenerPrevisualizacion() {
		
		//Se crea una nueva imagen introduciendo un nombre y un contenido
		Imagen imagen = new Imagen(nombrePrueba, contenido);
		
		assertEquals(imagen.obtenerPreVisualizacion(), nombrePrueba + "("+ contenido.length() + " bytes, " + "image/png)");

	}
}
