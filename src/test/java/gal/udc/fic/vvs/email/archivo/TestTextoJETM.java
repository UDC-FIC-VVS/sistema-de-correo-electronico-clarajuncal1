package gal.udc.fic.vvs.email.archivo;

import org.junit.Assert;
import org.junit.Test;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;

public class TestTextoJETM {

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
   * Descripción : Obtener el nombre de un texto. 
   * Categoría : Prueba dinámica de caja negra, positiva, no funcional.
   */
  @Test
  public void obtenerNombre() {
    setup();
    final String nombrePrueba = "TextoPrueba";
    final String contenido = "Texto de Prueba";
    Texto texto = new Texto(nombrePrueba, contenido);
  
    monitor.render(new SimpleTextRenderer());
	  
    tearDown();
	  
    Assert.assertEquals(nombrePrueba, texto.obtenerNombre());
  }
}
