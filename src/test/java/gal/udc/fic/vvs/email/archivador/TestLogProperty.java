package gal.udc.fic.vvs.email.archivador;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class TestLogProperty {
  /**
  * Descripción : Almacenar un correo correctamente en un Log.
  * Nivel : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombreLog : un String cualquiera para el nombre del Log,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Log,
  *     nombreCorreo :  String cualquiera para el nombre del correo,
  *     contenido : String cualquiera para el contenido del correo.
  */
  @Property
  public void almacenarCorreoProperty(String nombreLog, int espacio, 
                String nombreCorreo, String contenido) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreLog, espacio);
    Log log = new Log(archivador);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenido));

    assertTrue(log.almacenarCorreo(correo));
  }

  /**
  * Descripción : Obtener el nombre de un Log. 
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombreLog : un String cualquiera para el nombre del Log,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Log.
  */
  @Property
  public void obtenerNombreProperty(String nombreLog, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreLog, espacio);
    Log log = new Log(archivador);

    assertEquals(nombreLog, log.obtenerNombre());
  }

  /**
  * Descripción : Establecer y Obtener el delegado de un archivador.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombreLog : un String cualquiera para el nombre del Log,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Log.
  */
  @Property
  public void establecerYObtenerDelegadoProperty(String nombreLog, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreLog, espacio);
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
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *    nombreLog : un String cualquiera para el nombre del Log,
  *    espacio : un integer mayor que 0 cualquiera para el espacio del Log.
  */
  @Property
  public void obtenerEspacioTotalProperty(String nombreLog, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreLog, espacio);
    Log log = new Log(archivador);

    assertEquals(espacio, log.obtenerEspacioTotal());
  }

  /**
  * Descripción : Obtener el espacio disponible después de haber almacenado un correo.
  * Nivel : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombreLog : un String cualquiera para el nombre del Log,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Log.
  */
  @Property
  public void obtenerEspacioDisponibleProperty(String nombre, int espacio, 
                String nombreTexto, String contenidoTexto) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
    Log log = new Log(archivador);

    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    log.almacenarCorreo(correo);

    assertEquals(espacio - correo.obtenerTamaño(), log.obtenerEspacioDisponible());

  }
}
