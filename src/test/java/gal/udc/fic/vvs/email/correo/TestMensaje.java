package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestMensaje {

	/*
	 * Establecer un Mensaje como Leido y comprobar que posteriormente no se obtiene como no leido
	 */
	@Test
	public void establecerLeido() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());

	}
	
	/*
	 * Comprobar que se obtiene un mensaje no leido pues este no ha sido establecido previamente
	 */
	@Test
	public void obtenerNoLeidos() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		assertEquals(1, mensaje.obtenerNoLeidos());
	}
	
	/*
	 * Obtener el tamaño de un mensaje, para ello se comprueba que el 
	 * tamaño del mensaje coincida con el tamaño del texto que lo contiene
	 */
	@Test
	public void obtenerTamaño() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		assertEquals(mensaje.obtenerTamaño(), texto.obtenerTamaño());
	}
	
	/*
	 * Obtener el icono de un mensaje y comprobar que despues de
	 * haber sido leido cambia el icono de mensaje nuevo a mensaje
	 */
	@Test
	public void obtenerIcono() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());
		
		mensaje.establecerLeido(true);
		
		assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
	}
	
	/*
	 * Obtener visualización de un mensaje comprobando que coincide con el 
	 * contenido de dicho mensaje
	 */
	@Test
	public void obtenerVisualizacion() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		assertEquals("Texto de prueba", mensaje.obtenerVisualizacion());
	}
	
	/*
	 * Obtener previsualización de un mensaje, para ello se comprueba que 
	 * el contenido del mensaje sea el correcto
	 */
	@Test
	public void obtenerPrevisualizacion() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		assertEquals("Texto de prueba...", mensaje.obtenerPreVisualizacion());
	}
	
	/*
	 * buscar un mensaje por palabras clave y ver que  ha sido encontrado 
	 */
	@Test
	public void buscar() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		Collection resultado = mensaje.buscar("texto");
		
		assertEquals(1, resultado.size());
		assertEquals(true, resultado.contains(mensaje));
	}
	
	/*
	 * buscar un mensaje no existente y comprobar que no ha sido encontrado 
	 */
	@Test
	public void buscarNoExistente() {
		
		Texto texto = new Texto("textoPrueba", "Texto de prueba");
		Mensaje mensaje = new Mensaje(texto);
		
		Collection resultado = mensaje.buscar("audio");
		
		assertEquals(true, resultado.isEmpty());
	}
}
