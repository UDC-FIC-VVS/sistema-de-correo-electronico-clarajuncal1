package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

import org.junit.Test;

import com.pholser.junit.quickcheck.Property;

public class LogTest {
  private String nombreArchivador = "Archivador";
  private int espacioArchivador = 100;
  private String nombreTexto = "Texto";
  private String contenido = "Texto de prueba";
  Texto texto = new Texto(nombreTexto, contenido);

  /**
  * Descripción : Almacenar un correo correctamente en un Log.
  * Nivel : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * PiTest: Queda un mutante vivo pues no se ejecuta el mensaje de
  * println en el test.
  */
  @Test
  public void almacenarCorreo() {
    //Se crea un Log a partir de un Archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
	ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);

    Log log = new Log(archivador);

    log.establecerDelegado(archivadorDelegado);
    //Se crea un mensaje de correo nuevo
    Correo correo = new Mensaje(texto);

    //Se comprueba que el log es capaz de almacenar dicho mensaje de correo
    assertEquals(true, log.almacenarCorreo(correo));
  }
  
  /**
  * Descripción : Almacenar un correo incorrectamente en un Log.
  * Nivel : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, negativa, funcional.
  */
  @Test
  public void almacenarCorreoIncorrectamente() {
    //Se crea un Log a partir de un Archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, -10);
    Log log = new Log(archivador);

    //Se crea un mensaje de correo nuevo
    Correo correo = new Mensaje(texto);

    //Se comprueba que el log es capaz de almacenar dicho mensaje de correo
    assertEquals(false, log.almacenarCorreo(correo));
  }
  
  /**
  * Descripción : Obtener el nombre de un Log. 
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerNombreProperty() {

    //Se crea un Log a partir de un Archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Log log = new Log(archivador);

    assertEquals(archivador.obtenerNombre(), log.obtenerNombre());
  }

  /**
  * Descripción : Establecer y Obtener el delegado de un archivador.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void establecerYObtenerDelegadoProperty() {

    //Se crea un Log a partir de un Archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Delegado delegado = new Delegado(archivador);
    Log log = new Log(delegado);

    assertEquals(null, log.obtenerDelegado());

    log.establecerDelegado(archivador);
 
    assertEquals(archivador, log.obtenerDelegado());
  }

  /**
  * Descripción : Obtener el espacio total de un Log.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerEspacioTotalProperty() {
    
    //Se crea un Log a partir de un Archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Log log = new Log(archivador);

    assertEquals(archivador.obtenerEspacioTotal(), log.obtenerEspacioTotal());
  }

  /**
  * Descripción : Obtener el espacio disponible después de haber almacenado un correo.
  * Nivel : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerEspacioDisponibleProperty() {

    //Se crea un Log a partir de un Archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Log log = new Log(archivador);

    Correo correo = new Mensaje(new Texto(nombreTexto, contenido));

    log.almacenarCorreo(correo);

    assertEquals(log.obtenerEspacioTotal() - correo.obtenerTamaño(), 
                   log.obtenerEspacioDisponible());

  }
}
