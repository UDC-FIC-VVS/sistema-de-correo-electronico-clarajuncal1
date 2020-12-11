package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {

	Texto textoMensaje = new Texto("textoMensaje", "texto del mensaje abstracto");
	Mensaje mensajeAbstracto = new Mensaje(textoMensaje);
	
	Texto textoCorreo = new Texto("correo", "correo del reenvio");
	Correo correo = new Mensaje(textoCorreo);
	
	/*
	 * Obtener visualizacion de un reenvio, para ello se crea un renvio formado por un correo y un mensaje
	 * y posteriormente se comprueba que el tamaño del reenvio coincide con el tamaño del mensaje más
	 * el tamaño del correo
	 */
	@Test 
	public void obtenerTamaño() {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		
		assertEquals(mensajeAbstracto.obtenerTamaño() + correo.obtenerTamaño(), reenvio.obtenerTamaño());
	}
	
	/*
	 * Obtener visualizacion de un reenvio, para ello se comprueba que la visualizacion del mensaje más la 
	 * visualización del correo coinciden con la visualización del renvio
	 */
	@Test
	public void obtenerVisualizacion() {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		
		assertEquals(mensajeAbstracto.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n" + correo.obtenerVisualizacion() + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());
	}
	
	/*
	 * Obtener visualizacion de un reenvio
	 */
	@Test
	public void obtenerPrevisualizacion() {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

	}
	
	/*
	 * Obtener Icono, para ello se crea un reenvio y se comprueba que el icono del reenvio coincide 
	 * con el icono de un mensaje nuevo
	 */
	@Test
	public void obtenerIcono() {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);

		assertEquals(Reenvio.ICONO_NUEVO_MENSAJE, reenvio.obtenerIcono());
	}
	
	/*
	 * Establecer como leido un reenvio, para ello se crea un reenvio y se
	 * establece como leido y posteriormente se comprueba que no se obtiene
	 * ningún leido
	 */
	@Test 
	public void EstablecerLeido() throws OperacionInvalida {
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		
		assertEquals(1, reenvio.obtenerNoLeidos());
		
		reenvio.establecerLeido(true);

		assertEquals(0, reenvio.obtenerNoLeidos());
	}
	
	/*
	 * Obtener Ruta, para ello se crea un reenvio y se comprueba que la ruta
	 *  del mensaje coincide con la ruta del reenvio
	 */
	@Test
	public void obtenerRuta() {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		
		assertEquals(mensajeAbstracto.obtenerRuta(),reenvio.obtenerRuta());
	}
	
	/*
	 * Intentar Explorar un reenvio, para ello se crea un reenvio y una carpeta
	 * y se añade el reenvio a la carpeta y se intenta explorar dicho reenvio pero 
	 * no se puede pues es una operación Invalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorar() throws OperacionInvalida {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		Carpeta carpeta = new Carpeta("Carpeta");

		carpeta.añadir(reenvio);
		
		reenvio.explorar();
		
	}
	
	/*
	 * Intentar añadir un correo a un reenvio, pero no se puede pues es una 
	 * operación Invalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadir() throws OperacionInvalida {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		Correo correo = new Mensaje(new Texto("CorreoPrueba", "Añadir correo al reenvio"));
		
		reenvio.añadir(correo);
	}
	
	/*
	 * Intentar eliminar un correo en un reenvio, pero no se puede 
	 * pues es una operación Invalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminar() throws OperacionInvalida {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		Correo correo = new Mensaje(new Texto("CorreoPrueba", "Añadir correo al reenvio"));
		
		reenvio.eliminar(correo);
	}
	
	/*
	 * Intentar obtener un hijo en un reenvio, pero no se puede 
	 * pues es una operación Invalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijo() throws OperacionInvalida {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		
		reenvio.obtenerHijo(0);
	}
	
	/*
	 * Obtener el padre de un reenvio
	 */
	@Test
	public void EstablecerYObtenerPadre() throws OperacionInvalida {
		
		Reenvio reenvio = new Reenvio(mensajeAbstracto, correo);
		Carpeta carpeta = new Carpeta("carpeta");
		
		reenvio.establecerPadre(carpeta);
		
		assertEquals(carpeta, reenvio.obtenerPadre());
	}
}
