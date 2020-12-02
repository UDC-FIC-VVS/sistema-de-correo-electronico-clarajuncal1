package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {

	private String nombreCabecera = "Cabecera";
	private String valorCabecera = "Valor de la cabecera";
	
	Texto texto = new Texto("Texto", "Texto de prueba");
	Mensaje mensaje = new Mensaje(texto);
	
	/*
	 * Obtener el tamaño de una cabecera, para ello se crea una cabecera formada por un mensaje, 
	 * un nombre y un valor y se comprueba que el tamaño del mensaje mas la longitud del nombre
	 * de la cabecera mas la longitud del valor de la cabecera coincidan con el tamaño de la cabecera
	 */
	@Test
	public void obtenerTamaño() {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		
		assertEquals(mensaje.obtenerTamaño() + nombreCabecera.length() + valorCabecera.length(), cabecera.obtenerTamaño());
	}
	
	/*
	 * Obtener la visualización de una cabecera, para ello se crea una cabecera formada por un mensaje, 
	 * un nombre y un valor y se comprueba que la visualización del mensaje mas el nombre de la cabecera
	 *  mas el valor de la cabecera coincidan con la visualización de la cabecera
	 */
	@Test
	public void obtenerVisualizacion() {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(nombreCabecera + ": " + valorCabecera + "\n" + mensaje.obtenerVisualizacion(), cabecera.obtenerVisualizacion());
	}
	
	/*
	 * Obtener la ruta de una cabecera, para ello se crea una cabecera formada por un mensaje, el nombre de
	 * de la cabecera y el valor de la cabecera y se comprueba que el contenido del mensaje coincide con la
	 * ruta de la cabecera
	 */
	@Test
	public void obtenerRuta() {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		
		assertEquals("Texto de prueba...", cabecera.obtenerRuta());
	}
	
	/*
	 * Obtener la ruta de una cabecera, para ello se crea una cabecera formada por un mensaje, el nombre de
	 * de la cabecera y el valor de la cabecera y se comprueba que el contenido del mensaje coincide con la
	 * ruta de la cabecera
	 */
	@Test
	public void obtenerRutaConPadre() throws OperacionInvalida {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		Carpeta carpeta = new Carpeta("carpeta");
		
		carpeta.añadir(cabecera);
		assertEquals("carpeta (1) > Texto de prueba...", cabecera.obtenerRuta());
	}
	
	/*
	 * Se crea una cabecera y se comprueba que no ha sido leido, posteriormente se establece dicha cabecera como leido y
	 * se comprueba que ahora sí ha sido leido y en consecuencia no obtenemos ningún no leido
	 */
	@Test
	public void EstablecerYObtenerLeido() {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		
		assertEquals(1, cabecera.obtenerNoLeidos());
		
		cabecera.establecerLeido(true);
		
		assertEquals(0, cabecera.obtenerNoLeidos());
	}
	
	/*
	 * Obtener Icono, para ello se crea una cabecera y se comprueba que el icono de dicha cabecera corresponde
	 * con el icono de un mensaje nuevo
	 */
	@Test
	public void ObtenerIcono() {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		
		assertEquals(Cabecera.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());
	}
	
	/*
	 * Obtener Previsualizacion, para ello se crea una cabecera y se comprueba que el contenido del mensaje de dicha 
	 * cabecera corresponde con la previsualizacion de la cabecera
	 */
	@Test
	public void ObtenerPrevisualizacion() {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		
		assertEquals("Texto de prueba...", cabecera.obtenerPreVisualizacion());
	}
	
	/*
	 * Explorar una cabecera, se crea una cabecera y se intenta explorar pero no es posible
	 * puesto que es una operación invalida y se produce la excepcion OperacionInvaldia.class
	 */
	@Test(expected=OperacionInvalida.class)
	public void explorar() throws OperacionInvalida {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		
		cabecera.explorar();
	}
	
	/*
	 * Añadir , se intenta añadir un nuevo mensaje a la cabecera pero no es posible puesto que
	 * es una operación invalida y en consecuencia se devuelve la excepción OperaciónInvalida.class
	 */
	@Test(expected=OperacionInvalida.class)
	public void añadir() throws OperacionInvalida {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));
		
		cabecera.añadir(correo);
	}
	
	/*
	 * Eliminar , se intenta eliminar un mensaje en la cabecera pero no es posible puesto que
	 * es una operación invalida y en consecuencia se devuelve la excepción OperaciónInvalida.class
	 */
	@Test(expected=OperacionInvalida.class)
	public void eliminar() throws OperacionInvalida {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));
		
		cabecera.eliminar(correo);
	}
	
	/*
	 * ObtenerHijo , se intenta obtener el hijo de una cabecera pero no es posible puesto que
	 * es una operación invalida y en consecuencia se devuelve la excepción OperaciónInvalida.class
	 */
	@Test(expected=OperacionInvalida.class)
	public void obtenerHijo() throws OperacionInvalida {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		
		cabecera.obtenerHijo(0);
	}
	
	/*
	 * ObtenerPadre , para ello creamos una cabecera y una carpeta y se establece que dicha carpeta
	 * es padre de la cabecera y posteriormente se comprueba que la carpeta coincida con el padre de 
	 * la cabecera
	 */
	@Test
	public void obtenerPadre() throws OperacionInvalida {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		Carpeta carpeta = new Carpeta("Carpeta");
		
		carpeta.añadir(cabecera);
		
		assertEquals(carpeta, cabecera.obtenerPadre());
	}
	
	/*
	 * Buscar cabecera, para ello se crea una cabecera formado por un mensaje, el nombre de la cabecera y 
	 * su valor y se añade la cabecera a dicha carpeta y se comprueba que el correo contiene el mensaje
	 */
	@Test
	public void buscar() throws OperacionInvalida {
		
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		Carpeta carpeta = new Carpeta("Carpeta");
		
		carpeta.añadir(cabecera);
		
		assertEquals(true, cabecera.buscar("Texto").contains(cabecera));
	}
}
