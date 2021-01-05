package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class TestArchivadorSimpleJETM {

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
   * Descripción : Obtener el espacio disponible después de almacenar un correo. 
   * Categoría : Prueba dinámica de caja negra, positiva, no funcional.
   */
  @Test
  public void obtenerEspacioDisponibleJETMTest() {
	  
	setup();
	
    final String nombrePrueba = "NombreDePrueba";
    final int espacioPrueba = 100;
    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, espacioPrueba);
    Mensaje mensajePrueba = new Mensaje(new Texto("textoPrueba", "Es un texto de prueba"));

	archivadorSimple.almacenarCorreo(mensajePrueba);
	
    monitor.render(new SimpleTextRenderer());
	  
    tearDown();
    
    assertEquals(archivadorSimple.obtenerEspacioTotal() - mensajePrueba.obtenerTamaño(), 
    		archivadorSimple.obtenerEspacioDisponible());
  }
	  
}
