package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class TestImagenProperty {

	/*
	 * Descripción : Obtener el nombre de una Imagen  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre de la Imagen,
	 * 		contenido : un String cualquiera para el contenido de la Imagen.
	 */
	@Property 
	public void ObtenerNombreProperty(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		
		assertEquals(nombre, imagen.obtenerNombre());
	}
	
	/*
	 * Descripción : Obtener el contenido de una Imagen  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre de la Imagen,
	 * 		contenido : un String cualquiera para el contenido de la Imagen.
	 */
	@Property 
	public void ObtenerContenidoProperty(String nombre, String contenido) {
		Audio audio = new Audio(nombre, contenido);
		
		assertEquals(contenido, audio.obtenerContenido());
	}
	
	/*
	 * Descripción : Obtener el tamaño de una Imagen  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre de la Imagen,
	 * 		contenido : un String cualquiera para el contenido de la Imagen.
	 */
	@Property 
	public void ObtenerTamañoProperty(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		
		assertEquals(contenido.length(), imagen.obtenerTamaño());
		
	}
	
	/*
	 * Descripción : Obtener la Visualización de una Imagen  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre de la Imagen,
	 * 		contenido : un String cualquiera para el contenido de la Imagen.
	 */
	@Property
	public void ObtenerVisualizacionProperty(String nombre, String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);
		
		assertEquals(imagen.obtenerPreVisualizacion(), nombre + "(" + contenido.length() + " bytes, " + "image/png)");
	}
}
