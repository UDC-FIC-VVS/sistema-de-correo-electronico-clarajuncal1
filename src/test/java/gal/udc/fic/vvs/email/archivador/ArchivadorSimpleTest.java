package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.TestJETM;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class ArchivadorSimpleTest extends TestJETM{
  
  private String nombrePrueba = "NombreDePrueba";
  private int espacioPrueba = 100;

  /**
   * Descripción : Obtener el nombre de un archivador  
   * Nivel : Prueba de Unidad.
   * Categoría : Prueba dinámica de caja negra, positiva, funcional.
   * PiTest : Sobrevive un mutante pues no se comprueba el point creado
   * por el monitor de JETM
   */
  @Test
  public void obtenerNombreTest() {
	EtmPoint point = monitor.createPoint("ArchivadorSimple:ArchivadorSimpleTest_obtenerNombreTest");

    //Creo un nuevo archivador, introduciendo un nombre y un espacio
    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, espacioPrueba);

    //Se compara que el nombre del archivador añadido sea el mismo que el que hemos definido
    assertEquals(nombrePrueba, archivadorSimple.obtenerNombre());
    point.collect();
  }

  /**
  * Descripción : Almacenar un correo en un Archivador Simple correctamente  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * PiTest : No se puede matar el mutante pues no es posible obtener el 
  * array de elementos.
  */
  @Test
  public void almacenarCorreoCorrectamente() {

    //Creo un nuevo archivador, introduciendo un nombre y un espacio
    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, espacioPrueba);

    //Creo un mensaje , introduciendo un texto(nombre del texto, y contenido del texto)
    Texto texto = new Texto("textoPrueba", "Es un texto de prueba");
    Correo correo = new Mensaje(texto);

    //Compruebo que es posible almacenar el mensaje en el archivador
    assertTrue(archivadorSimple.almacenarCorreo(correo));
  }
  
  /**
  * Descripción : Almacenar un correo en un Archivador Simple incorrectamente  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void almacenarCorreoIncorrectamente() {

    //Creo un nuevo archivador, introduciendo un nombre y un espacio
    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, -10);
    //Creo un mensaje , introduciendo un texto(nombre del texto, y contenido del texto
    Correo correo = new Mensaje(new Texto("textoPrueba", "Es un texto de prueba"));

    //Compruebo que no es posible almacenar el mensaje, el archivador no tiene espacio suficiente
    assertFalse(archivadorSimple.almacenarCorreo(correo));
  }

  /**
  * Descripción : Obtener el nombre de un archivador  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerEspacioTotalTest() {
    //Se crea un nuevo archivador, introduciendo un nombre y un espacio
    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, espacioPrueba);

    //Se compara que el espacio total del archivador sea el mismo que el introducido
    assertEquals(espacioPrueba, archivadorSimple.obtenerEspacioTotal());
  }

  /**
   * Descripción : Obtener el espacio disponible después de almacenar un correo. 
   * Nivel : Prueba de Integración.
   * Categoría : Prueba dinámica de caja negra, positiva, funcional.
   */ 
  @Test
  public void obtenerEspacioDisponibleTest() {
    //Se crea un nuevo archivador, introduciendo un nombre y un espacio
    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, espacioPrueba);
    //Creo un mensaje , introduciendo un texto(nombre del texto, y contenido del texto)
    Mensaje mensajePrueba = new Mensaje(new Texto("textoPrueba", "Es un texto de prueba"));

    //Introduzco el mensaje en el archivador y obtengo el espacio restante disponible
    archivadorSimple.almacenarCorreo(mensajePrueba);
    
    assertEquals(archivadorSimple.obtenerEspacioTotal() - mensajePrueba.obtenerTamaño(), 
    		archivadorSimple.obtenerEspacioDisponible());
  }

  /**
   *  Descripción : Establecer y obtener el delegado de un archivador.
   *  Nivel : Prueba de Unidad.
   *  Categoría : Prueba dinámica de caja negra, positiva, funcional.
   */
  @Test
  public void establecerYObtenerDelegado() {
    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombrePrueba, espacioPrueba);

    archivadorSimple.establecerDelegado(archivadorSimple);
   
    assertEquals(null, archivadorSimple.obtenerDelegado());
  }
}
