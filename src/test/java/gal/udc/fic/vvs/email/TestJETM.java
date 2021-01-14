package gal.udc.fic.vvs.email;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;

public abstract class TestJETM {
	
   /**
    * Descripción : Configuración test JETM
    * Categoría : Pruebas no funcionales, dinamicas de caja negra.
    */
	
   public static EtmMonitor monitor;

  @BeforeClass
  public static void setup() {
    BasicEtmConfigurator.configure();
    monitor = EtmManager.getEtmMonitor();
    monitor.start();
  }

  @AfterClass
  public static void tearDown() {
	monitor.render(new SimpleTextRenderer());
    monitor.stop();
  }
	  
}
