package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;
import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCarpetaJETM {

	  private static EtmMonitor monitor;

	  private static void setup() {
	    BasicEtmConfigurator.configure();
	    monitor = EtmManager.getEtmMonitor();
	    monitor.start();
	  }

	  private static void tearDown() {
	    monitor.stop();
	  }
	  
	  /**
	   * Descripción : Obtener el tamaño de una Carpeta.  
	   * Nivel : Prueba de Unidad.
	   * Categoría : Prueba dinámica de caja negra, positiva, no funcional.
	   */
	   @Test
	   public void obtenerTamano() throws OperacionInvalida {

		setup();
		
		final String nombre = "nombreCarpeta";
		final String nombreTexto = "TextoPrueba";
		final String contenido = "Texto de prueba";
		Texto texto = new Texto(nombreTexto, contenido);
			
	    Carpeta carpeta = new Carpeta(nombre);
	    Correo correo = new Mensaje(texto);

	    carpeta.añadir(correo);

		monitor.render(new SimpleTextRenderer());
		tearDown();
	    assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño());
	   }
	   
	  /**
	  * Descripción : Añadir un correo a una Carpeta.  
	  * Nivel : Prueba de Unidad.
	  * Categoría : Prueba dinámica de caja negra, positiva, no funcional.
	  * @throws OperacionInvalida
	  */
	  @Test
	  public void anadir() throws OperacionInvalida {

		setup();
		
		final String nombre = "nombreCarpeta";
		final String nombreTexto = "TextoPrueba";
		final String contenido = "Texto de prueba";
		Texto texto = new Texto(nombreTexto, contenido);
		  
	    Carpeta carpeta = new Carpeta(nombre);
	    Correo correo = new Mensaje(texto);
	    Correo correo2 = new Mensaje(texto);
	    Correo correo3 = new Mensaje(texto);
	    Correo correo4 = new Mensaje(texto);
	    
	    carpeta.añadir(correo);
	    carpeta.añadir(correo2);
	    carpeta.añadir(correo3);
	    carpeta.añadir(correo4);
	    
	    monitor.render(new SimpleTextRenderer());
	    
	    tearDown();
	    assertEquals(carpeta.obtenerTamaño(), correo.obtenerTamaño()
	    		+ correo2.obtenerTamaño() + correo2.obtenerTamaño() + correo4.obtenerTamaño());
	  }
}
