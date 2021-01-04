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
public class TestArchivadorSimpleProperty {

  /**
   * Descripción : Obtener el nombre de un archivador  
   * Nivel : Prueba de Unidad.
   * Categoría : Prueba dinámica de caja negra, positiva, funcional.
   * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
   *   nombre : un String cualquiera para el nombre del Archivador Simple,
   *   espacio : un integer mayor que 0 cualquiera para el espacio del Archivador.
   */
  @Property
  public void obtenerNombreProperty(String nombre, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);

    assertEquals(nombre, archivadorSimple.obtenerNombre());
  }

  /**
  * Descripción : Almacenar un correo en un Archivador Simple correctamente  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *   nombre : un String cualquiera para el nombre del Archivador Simple,
  *   espacio : un integer mayor que 0 cualquiera para el espacio del Archivador,
  *   nombreTexto : un String cualquiera para el nombre del Correo que se va a almacenar,
  *   contenidoTexto :  un String cualquiera para el contenido del Correo.
  */
  @Property
  public void almacenarCorreoProperty(String nombre, int espacio, 
                 String nombreTexto, String contenidoTexto) {

    assumeThat(espacio, greaterThan(0));
    assumeThat(espacio, greaterThan(contenidoTexto.length()));

    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);

    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    assertTrue(archivadorSimple.almacenarCorreo(correo));
  }

  /**
  * Descripción : Obtener el nombre de un archivador  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Archivador Simple,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Archivador.
  */
  @Property
  public void obtenerEspacioTotalProperty(String nombre, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);

    assertEquals(espacio, archivadorSimple.obtenerEspacioTotal());
  }

  /**
   * Descripción : Obtener el espacio disponible después de almacenar un correo. 
   * Nivel : Prueba de Unidad.
   * Categoría : Prueba dinámica de caja negra, positiva, funcional.
   * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
   *    nombre : un String cualquiera para el nombre del Archivador Simple,
   *    espacio : un integer mayor que 0 cualquiera para el espacio del Archivador,
   *    nombreTexto : un String cualquiera para el nombre del Correo que se va a almacenar,
   *    contenidoTexto :  un String cualquiera para el contenido del Correo.
   */    
  @Property
  public void obtenerEspacioDisponibleProperty(String nombre, int espacio,
                String nombreTexto, String contenidoTexto) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);

    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    archivadorSimple.almacenarCorreo(correo);

    assertEquals(espacio - correo.obtenerTamaño(), archivadorSimple.obtenerEspacioDisponible());

  }

  /**
   *  Descripción : Establecer y obtener el delegado de un archivador.
   *  Nivel : Prueba de Unidad.
   *  Categoría : Prueba dinámica de caja negra, positiva, funcional.
   *  Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
   *    nombre : un String cualquiera para el nombre del Archivador Simple,
   *    espacio : un integer mayor que 0 cualquiera para el espacio del Archivador.
   */
  @Property
  public void establecerYObtenerDelegadoProperty(String nombre, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombre, espacio);

    archivadorSimple.establecerDelegado(archivadorSimple);

    assertEquals(null, archivadorSimple.obtenerDelegado());

  }
}
