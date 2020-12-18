package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCarpeta {

	private String nombre = "nombreCarpeta";
	private String nombreTexto = "TextoPrueba";
	private String contenido = "Texto de prueba";
	Texto texto = new Texto(nombreTexto, contenido);
	
	/*
	 * Añadimos un correo a una carpeta y comprobamos que sus mensajes no han
	 * sido leidos aún
	 */
	@Test
	public void ObtenerNoLeido() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(1, carpeta.obtenerNoLeidos());
	}
	
	/*
	 * Añadimos un correo a una carpeta y posteriormente la establecemos
	 * como leida por lo que dicho correo pasar a estar leido tambien
	 */
	@Test
	public void EstablecerYObtenerLeido() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		carpeta.establecerLeido(true);
		
		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	/*
	 * Obtenemos el tamaño de una carpeta a la cual se le ha añadido un único correo
	 * y ambos deben coincidir
	 */
	@Test
	public void ObtenerTamaño() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
	}
	
	/*
	 * Obtenemos el icono de una carpeta a la cual se le ha añadido un correo
	 * por lo que el icono del correo ha de coincidir con el de la carpeta
	 */
	@Test
	public void ObtenerIcono() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
	}
	
	/*
	 * Se obtiene la previsualización de una carpeta que ha de coincidir
	 * con su visualización
	 */
	@Test
	public void obtenerPreVisualizacion() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));
		
		carpeta.añadir(mensaje);
		
		assertEquals("nombreCarpeta (1)", carpeta.obtenerPreVisualizacion());
	}
	
	/*
	 * Se obtiene la visualización de la carpeta la cual contiene un mensaje dentro
	 * que ha sido añadido previamente
	 */
	@Test
	public void ObtenerVisualizacion() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(carpeta.obtenerVisualizacion(), nombre + " (" + carpeta.obtenerNoLeidos() + ")" );
	}
	
	/*
	 * Se añade un mensaje a la carpeta y se comprueba que la carpeta
	 * contenga dicho mensaje 
	 */
	@Test
	public void explorar() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(true, carpeta.explorar().contains(correo));
	}
	
	/*
	 * Se busca dentro de una carpeta un mensaje añadido previamente y se comprueba
	 * el tamaño de la busqueda para ver que se ha obtenido un elemento
	 */
	@Test
	public void buscar() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(true, carpeta.buscar("Texto").contains(correo));
		assertEquals(1, carpeta.buscar("Texto").size());
	}
	
	/*
	 * Añadimos un mensaje a una carpeta y comprobamos posteriormente que el tamaño de
	 * la carpeta es el mismo que el del mensaje añadido cerciorandonos así
	 * de que ha sido añadido correctamente
	 */
	@Test
	public void añadir() throws OperacionInvalida {
	
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
	}
	
	/*
	 * Añadimos dos mensajes a una carpeta y posteriormente eliminamos uno y comprobamos
	 * que si buscamos dichos mensajes solo aparece uno cerciorandonos de que ha sido 
	 * eliminado correctamente
	 */
	@Test
	public void eliminar() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo1 = new Mensaje(texto);
		Correo correo2 = new Mensaje(new Texto("correoPrueba", "correo de prueba"));
		
		carpeta.añadir(correo1);
		carpeta.añadir(correo2);
		
		carpeta.eliminar(correo1);
		
		assertEquals(1, carpeta.buscar("Prueba").size());	
	}
	
	/*
	 * Añadimos un mensaje a una carpeta y posteriormente
	 * comparamos que ese mensaje sea hijo de dicha carpeta
	 */
	@Test
	public void obtenerHijo() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta(nombre);
		Correo correo = new Mensaje(texto);
		
		carpeta.añadir(correo);
		
		assertEquals(correo, carpeta.obtenerHijo(0));
	}
}
