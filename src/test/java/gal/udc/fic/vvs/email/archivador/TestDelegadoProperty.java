package gal.udc.fic.vvs.email.archivador;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class TestDelegadoProperty {
  /*
  * Descripción : Almacenar un correo correctamente en un delegado.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Delegado,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Delegado,
  *     nombreTexto :  String cualquiera para el nombre del correo a almacenar,
  *     contenidoTexto : String cualquiera para el contenido del texto.
  */
  @Property
  public void almacenarCorreoProperty(String nombreDelegado, int espacio, 
               String nombreCorreo, String contenidoCorreo) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreDelegado, espacio);
    Delegado delegado = new Delegado(archivador);

    Correo correo = new Mensaje(new Texto(nombreCorreo, contenidoCorreo));

    assertTrue(delegado.almacenarCorreo(correo));
  }

  /*
  * Descripción : Establecer y Obtener el delegado de un archivador.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Delegado,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Delegado.
  */
  @Property
  public void establecerYObtenerDelegadoProperty(String nombreDelegado, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreDelegado, espacio);
    Delegado delegado = new Delegado(archivador);

    assertEquals(null, delegado.obtenerDelegado());

    delegado.establecerDelegado(archivador);

    assertEquals(archivador, delegado.obtenerDelegado());
  }

  /*
  * Descripción : Obtener el nombre de un delegado.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Delegado,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Delegado.
  */
  @Property
  public void obtenerNombreProperty(String nombreDelegado, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreDelegado, espacio);
    Delegado delegado = new Delegado(archivador);

    assertEquals(nombreDelegado, delegado.obtenerNombre());
  }

  /*
  * Descripción : Obtener el espacio total de un delegado una vez se crea
  * Nivel  : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Delegado,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Delegado.
  */
  @Property
  public void obtenerEspacioTotalProperty(String nombreDelegado, int espacio) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombreDelegado, espacio);
    Delegado delegado = new Delegado(archivador);

    assertEquals(espacio, delegado.obtenerEspacioTotal());
  }

  /*
  * Descripción : Obtener el espacio disponible después de haber almacenado un correo.
  * Nivel : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos : Se obtiene mediante generación automática de datos:
  *     nombre : un String cualquiera para el nombre del Delegado,
  *     espacio : un integer mayor que 0 cualquiera para el espacio del Delegado,
  *     nombreTexto :  String cualquiera para el nombre del correo a almacenar,
  *     contenidoTexto : String cualquiera para el contenido del texto.
  */
  @Property
  public void obtenerEspacioDisponibleProperty(String nombre, int espacio, 
                String nombreTexto, String contenidoTexto) {

    assumeThat(espacio, greaterThan(0));

    ArchivadorSimple archivador = new ArchivadorSimple(nombre, espacio);
    Delegado delegado = new Delegado(archivador);

    Correo correo = new Mensaje(new Texto(nombreTexto, contenidoTexto));

    delegado.almacenarCorreo(correo);

    assertEquals(espacio - correo.obtenerTamaño(), delegado.obtenerEspacioDisponible());

  }
}
