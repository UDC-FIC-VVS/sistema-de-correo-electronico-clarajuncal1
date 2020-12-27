package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class TestMensajeProperty {

	/*
	 * Descripción : Establecer y Obtener si un Mensaje ha sido leido.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre del Mensaje,
	 * 		contenido : un String cualquiera para el contenido del Mensaje.
	 */
	@Property
	public void establecerYObtenerLeidoPropertyTest(String nombre, String contenido) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombre, contenido));
		
		assertEquals(1, mensaje.obtenerNoLeidos());
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}
	
	/*
	 * Descripción : Obtener el tamaño de un Mensaje.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre del Mensaje,
	 * 		contenido : un String cualquiera para el contenido del Mensaje.
	 */
	@Property
	public void obtenerTamañoPropertyTest(String nombre, String contenido) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombre, contenido));
		
		assertEquals(contenido.length(), mensaje.obtenerTamaño());
		
	}
	
	/*
	 * Descripción : Obtener el icono de un Mensaje.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre del Mensaje,
	 * 		contenido : un String cualquiera para el contenido del Mensaje.
	 */
	@Property
	public void obtenerIconoPropertyTest(String nombre, String contenido) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombre, contenido));
		
		assertEquals(Mensaje.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());
		
		mensaje.establecerLeido(true);
		
		assertEquals(Mensaje.ICONO_MENSAJE, mensaje.obtenerIcono());
	}
	
	/*
	 * Descripción : Obtener la visualización de un Mensaje.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombre : un String cualquiera para el nombre del Mensaje,
	 * 		contenido : un String cualquiera para el contenido del Mensaje.
	 */
	@Property
	public void obtenerVisualizacionPropertyTest(String nombre, String contenido) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombre, contenido));
		
		assertEquals(contenido, mensaje.obtenerVisualizacion());
	}
}
