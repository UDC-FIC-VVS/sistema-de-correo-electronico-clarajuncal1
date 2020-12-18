package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCarpetaLimitada {

	private String nombre = "carpetaPrueba";
	Carpeta carpeta = new Carpeta(nombre);
	private int tamaño = 50;
	
	private String nombreTexto = "Texto";
	private String contenidoTexto = "Texto de Prueba";
	Texto texto = new Texto(nombreTexto, contenidoTexto);
	
	/*
	 * Obtener el tamaño de una carpetaLimitada, para ello se crea una carpetaLimitada formada por una carpeta, 
	 * y un tamaño y se comprueba que el tamaño de la carpetaLimtiada coincidan con el tamaño de la carpeta
	 */
	@Test
	public void obtenerTamaño() {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		
		assertEquals(carpetaLimitada.obtenerTamaño(), carpeta.obtenerTamaño());
	}
	
	/*
	 * Establecer leido, Se crea una carpeta limitada y se establece como leida y se comprueba que ha sido leido y en 
	 * consecuencia no obtenemos ningún no leido
	 */
	@Test
	public void establecerLeido() {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		carpetaLimitada.establecerLeido(true);
		
		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
	}
	
	/*
	 * Obtener no leido, para ello se crea una carpeta limitada y se añade un correo a dicha carpeta y posteriormente
	 * se comprueba que se obtiene que no ha sido leida
	 */
	@Test
	public void obtenerNoLeido() throws OperacionInvalida {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		
		Correo correo = new Mensaje(texto);
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(1, carpetaLimitada.obtenerNoLeidos());
	}
	
	/*
	 * Obtener Icono, para ello se crea una carpeta limitada y se comprueba que el icono de dicha carpeta limitada
	 * corresponde con el icono de la carpeta que compone la carpeta limitada
	 */
	@Test
	public void obtenerIcono() {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(carpetaLimitada.obtenerIcono(), carpeta.obtenerIcono());
	}
	
	/*
	 * Obtener Previsualizacion, para ello se crea una carpeta limitada y se comprueba que la previsualizacion de la 
	 * carpeta limitada corresponde con la previsualizacion de la carpeta que la forma
	 */
	@Test
	public void obtenerPrevisualizacion() {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(carpetaLimitada.obtenerPreVisualizacion(), carpeta.obtenerPreVisualizacion());
	}
	
	/*
	 * Obtener Visualizacion, para ello se crea una carpeta limitada y se comprueba que la previsualizacion de la 
	 * carpeta limitada corresponde con la visualizacion de la carpeta que la forma
	 */
	@Test
	public void obtenerVisualizacion() {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(carpetaLimitada.obtenerVisualizacion(), carpeta.obtenerVisualizacion());
	}
	
	/*
	 * Obtener la ruta, para ello se crea una carpeta limitada formado por una carpeta y un tamaño
	 * y se comprueba que la ruta de una carpeta limitada coincide con la ruta de la carpeta que lo forma
	 */
	@Test
	public void obtenerRuta() {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(carpetaLimitada.obtenerRuta(), carpeta.obtenerRuta());
	}
	
	/*
	 * Explorar, para ello se crea una carpeta limitada formado por una carpeta y un tamaño
	 * y se comprueba que explorar una carpeta limitada coincide con explorar la carpeta que lo forma
	 */
	@Test
	public void explorar() throws OperacionInvalida {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		
		assertEquals(carpetaLimitada.explorar(), carpeta.explorar());
	}
	
	/*
	 * Añadir, para ello se crea una carpeta limitada formada por una carpeta y su tamaño y se
	 * crea un nuevo mensaje de correo, y posteriormente se añade dicho mensaje a la carpeta
	 */
	@Test
	public void añadir() throws OperacionInvalida {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Correo correo = new Mensaje(texto);
		
		carpetaLimitada.añadir(correo);
	}
	
	/*
	 * Eliminar, para ello se crea una carpeta limitada formada por una carpeta y su tamaño y se
	 * crea un nuevo mensaje de correo, y posteriormente se elimina dicho mensaje a la carpeta
	 */
	@Test
	public void eliminar() throws OperacionInvalida {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Correo correo = new Mensaje(texto);
		
		carpetaLimitada.eliminar(correo);
	}
	
	/*
	 * ObtenerHijo, para ello se crea una carpeta limitada formada por una carpeta y su tamaño y se
	 * crea un nuevo mensaje de correo, y posteriormente se añade dicho mensaje a la carpeta y se comprueba
	 * que el hijo de la carpeta limitada sea dicho correo añadido
	 */
	@Test
	public void obtenerHijo() throws OperacionInvalida {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Correo correo = new Mensaje(texto);
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(correo, carpetaLimitada.obtenerHijo(0));
		
	}
	
	/*
	 * ObtenerPadre, para ello se crea una carpeta limitada formada por una carpeta y su tamaño y se
	 * crea un nuevo mensaje de correo, y se añade dicho mensaje a la carpeta, posteriormente se 
	 * establece a la carpeta limitada como padre de dicho correo y comprobamos que eso sea verdad
	 */
	@Test
	public void establecerYObtenerPadre() {
		
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Correo correo = new Mensaje(texto);
		
		carpetaLimitada.establecerPadre(correo);
		
		assertEquals(correo, carpetaLimitada.obtenerPadre());
		
	}
	
	@Test
	public void obtenerPadreNull() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(null, carpetaLimitada.obtenerPadre());
	}
}
