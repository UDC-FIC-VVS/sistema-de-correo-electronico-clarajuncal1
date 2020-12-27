package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class TestAdjuntoProperty {
	
	/*
	 * Descripción : Obtener el tamaño de un Adjunto.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto.
	 */
	@Property
	public void ObtenerTamañoPropertyTest(String nombreMensaje, String contenidoMensaje, String nombreArchivo, String contenidoArchivo) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
		Archivo archivo = new Texto(nombreArchivo, contenidoArchivo);
		
		Adjunto adjunto = new Adjunto(mensaje, archivo);
		
		assertEquals(archivo.obtenerTamaño()+mensaje.obtenerTamaño(), adjunto.obtenerTamaño());
	}
	
	/*
	 * Descripción : Obtener la visualización de un Adjunto.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto.
	 */
	@Property
	public void ObtenerVisualizacionPropertyTest(String nombreMensaje, String contenidoMensaje, String nombreArchivo, String contenidoArchivo) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
		Archivo archivo = new Texto(nombreArchivo, contenidoArchivo);
		
		Adjunto adjunto = new Adjunto(mensaje, archivo);
		
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + archivo.obtenerPreVisualizacion(), adjunto.obtenerVisualizacion());
	}
	
	/*
	 * Descripción : Obtener la visualización de un Adjunto.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto.
	 */
	@Property
	public void ObtenerPreVisualizacionPropertyTest(String nombreMensaje, String contenidoMensaje, String nombreArchivo, String contenidoArchivo) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
		Archivo archivo = new Texto(nombreArchivo, contenidoArchivo);
		
		Adjunto adjunto = new Adjunto(mensaje, archivo);
		
		assertEquals(mensaje.obtenerPreVisualizacion() , adjunto.obtenerPreVisualizacion());
	}
	
	/*
	 * Descripción : Obtener la ruta de un Adjunto.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto.
	 */
	@Property
	public void ObtenerRutaPropertyTest(String nombreMensaje, String contenidoMensaje, String nombreArchivo, String contenidoArchivo) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
		Archivo archivo = new Texto(nombreArchivo, contenidoArchivo);
		
		Adjunto adjunto = new Adjunto(mensaje, archivo);
		
		assertEquals(mensaje.obtenerPreVisualizacion(), adjunto.obtenerRuta());
	}
	
	/*
	 * Descripción : Establecer y Obtener si un Adjunto ha sido leido.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto.
	 */
	@Property
	public void EstablecerYObtenerLeidoTest(String nombreMensaje, String contenidoMensaje, String nombreArchivo, String contenidoArchivo) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
		Archivo archivo = new Texto(nombreArchivo, contenidoArchivo);
		
		Adjunto adjunto = new Adjunto(mensaje, archivo);
		
		assertEquals(1, adjunto.obtenerNoLeidos());
		
		adjunto.establecerLeido(true);

		assertEquals(0, adjunto.obtenerNoLeidos());
	}
	
	/*
	 * Descripción : Obtener el icono de un Adjunto.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto.
	 */
	@Property
	public void ObtenerIconoPropertyTest(String nombreMensaje, String contenidoMensaje, String nombreArchivo, String contenidoArchivo) {
		
		Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
		Archivo archivo = new Texto(nombreArchivo, contenidoArchivo);
		
		Adjunto adjunto = new Adjunto(mensaje, archivo);
		
		assertEquals(Adjunto.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());
	}
	
	/*
	 * Descripción : Obtener el padre de un Adjunto.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto,
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpeta que contiene el Adjunto.
	 */
	@Property
	public void ObtenerPadrePropertyTest(String nombreMensaje, String contenidoMensaje, String nombreArchivo, String contenidoArchivo, String nombreCarpeta) throws OperacionInvalida {
		
		Mensaje mensaje = new Mensaje(new Texto(nombreMensaje, contenidoMensaje));
		Archivo archivo = new Texto(nombreArchivo, contenidoArchivo);
		
		Adjunto adjunto = new Adjunto(mensaje, archivo);
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		
		carpeta.añadir(adjunto);
		
		assertEquals(carpeta, adjunto.obtenerPadre());
	}
	
	/*
	 * Descripción : Búsqueda de un Adjunto.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreMensaje : un String cualquiera para el nombre del mensaje del Adjunto,
	 * 		contenidoMensaje : un String cualquiera para el contenido del mensaje del Adjunto,
	 * 		nombreArchivo : un String cualquiera para el nombre del archivo del Adjunto,
	 * 		contenidoArchivo : un String cualquiera para el contenido del Archivo del adjunto,
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpeta que contiene el Adjunto.
	 */
	@Property
	public void buscarPropertyTest() {
		
	}

}
