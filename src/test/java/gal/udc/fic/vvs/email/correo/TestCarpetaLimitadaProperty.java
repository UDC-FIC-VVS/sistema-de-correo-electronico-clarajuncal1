package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import static org.hamcrest.Matchers.greaterThan;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class TestCarpetaLimitadaProperty {
	
	/*
	 * Descripción : Establecer y obtener los leidos de una carpeta limitada.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void establecerYObtenerLeidoPropertyTest(String nombreCarpeta, int tamañoCarpeta, String nombreCorreo, String contenidoCorreo) throws OperacionInvalida{
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(1, carpetaLimitada.obtenerNoLeidos());
		
		carpetaLimitada.establecerLeido(true);
		
		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
	}
	
	/*
	 * Descripción : obtener el tamaño de una carpeta limitada.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void obtenerTamañoPropertyTest(String nombreCarpeta, int tamañoCarpeta , String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {
	
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
	}
	
	/*
	 * Descripción : Obtener la previsualización de una carpeta limitada.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void obtenerPrevisualización(String nombreCarpeta,int tamañoCarpeta, String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(nombreCarpeta + " (" + carpetaLimitada.obtenerNoLeidos() + ")", carpetaLimitada.obtenerPreVisualizacion());
	}
	
	/*
	 * Descripción : Obtener la visualizacion de una carpeta limitada.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void obtenerVisualizacion(String nombreCarpeta, int tamañoCarpeta, String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(nombreCarpeta + " (" + carpetaLimitada.obtenerNoLeidos() + ")", carpetaLimitada.obtenerPreVisualizacion());
	}
	
	/*
	 * Descripción : Explorar que una carpeta limitada contenga correos.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void explorarPropertyTest(String nombreCarpeta, int tamañoCarpeta, String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertTrue(carpetaLimitada.explorar().contains(correo));
	}
	
	/*
	 * Descripción : Añadir un correo a una carpeta limitada.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void añadirPropertyTest(String nombreCarpeta, String nombreCorreo, int tamañoCarpeta, String contenidoCorreo) throws OperacionInvalida {
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(correo.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
	}
	
	/*
	 * Descripción : Eliminar un correo de una carpeta limitada.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void eliminarPropertyTest(String nombreCarpeta, String nombreCorreo, int tamañoCarpeta, String contenidoCorreo) throws OperacionInvalida {
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		Correo correo2 = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		carpetaLimitada.añadir(correo2);
		
		carpetaLimitada.eliminar(correo);
		
		assertEquals(correo2.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
	}
	
	/*
	 * Descripción : Obtener el hijo de una carpeta limitada a partir de un correo previamente añadido.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void obtenerHijoPropertyTest(String nombreCarpeta, int tamañoCarpeta, String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(correo, carpetaLimitada.obtenerHijo(0));
	}
	
	/*
	 * Descripción : obtener la carpeta limitada padre de un correo previamente añadido.  
	 * Nivel : Prueba de Unidad.
	 * Categoría : Prueba dinámica de caja negra, positiva.
	 * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
	 * 		nombreCarpeta : un String cualquiera para el nombre de la carpetaLimitada,
	 * 		tamañoCarpeta : un integer mayor que 0 cualquiera para el tamaño de la carpetaLimitadas,
	 * 		nombreCorreo : un String cualquiera para el nombre del correo que se almacena en la carpetaLimitada,
	 * 		contenidoCorreo : un String cualquiera para el contenido del correo que se almacena en la carpetaLimitada.
	 */
	@Property
	public void obtenerPadrePropertyTest(String nombreCarpeta, int tamañoCarpeta, String nombreCorreo, String contenidoCorreo) throws OperacionInvalida {
		
		assumeThat(tamañoCarpeta, greaterThan(0));
		
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamañoCarpeta);
		
		Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));
		
		carpetaLimitada.añadir(correo);
		
		assertEquals(carpeta, correo.obtenerPadre());
	}
}
