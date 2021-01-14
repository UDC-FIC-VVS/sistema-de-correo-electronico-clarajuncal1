package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

public class DelegadoTest {
  private String nombreArchivador = "Archivador";
  private int espacioArchivador = 100;
  private String nombreTexto = "Texto";
  private String contenido = "Texto de prueba";
  Texto texto = new Texto(nombreTexto, contenido);

  /**
  * Descripción : Almacenar un correo correctamente en un delegado.
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
   * para ello se utilizan particiones equivalentes, esto es, se escoge un elemento
   * que representa al grupoado por un nombre y un tamaño.
  *   @Param Delegado : Formado por un archivador.
  *   @Param Correo : Formado por un mensaje(con un nombre y su contenido).
  */
  @Test
  public void almacenarCorreo() {
    //Se crea un delegado a partir de un archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Delegado delegado = new Delegado(archivador);
    //Se crea un mensaje , introduciendo un texto(nombre del texto, y contenido del texto)
    Correo correo = new Mensaje(texto);

    delegado.establecerDelegado(archivador);

    //Se comprueba que el delegado es capaz de almacenar dicho mensaje de correo.
    assertEquals(true, delegado.almacenarCorreo(correo));
  }
  
  /**
  * Descripción : Almacenar un correo correctamente en un delegado.
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan valores frontera.
  *   @Param Archivador : Formado por un nombre y un tamaño.
  *   @Param Delegado : Formado por un archivador.
  *   @Param Correo : Formado por un mensaje(con un nombre y su contenido).
  * @Exception: Salta una excepción puesto que el espacio es insuficiente
  * y no se puede almacenar el correo
  */
  @Test
  public void almacenarCorreoIncorrectamente() {
    //Se crea un delegado a partir de un archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, -10);
    Delegado delegado = new Delegado(archivador);
    
    delegado.establecerDelegado(archivador);

    //Se crea un mensaje , introduciendo un texto(nombre del texto, y contenido del texto)
    Correo correo = new Mensaje(texto);
    
    //Se comprueba que el delegado es capaz de almacenar dicho mensaje de correo.
    assertFalse(delegado.almacenarCorreo(correo));
  }

  /**
  * Descripción : Establecer y Obtener el delegado de un archivador.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge un elemento
  * que representa al grupo.
  *   @Param Archivador : Formado por un nombre y un tamaño.
  *   @Param Delegado : Formado por un archivador.
  */
  @Test
  public void establecerYObtenerDelegado() {

    //Se crea un delegado a partir de un archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Delegado delegado = new Delegado(archivador);

    //Se establece dicho archivador como delegado y se comprueba que ha sido establecido
    delegado.establecerDelegado(archivador);

    assertEquals(delegado.obtenerDelegado(), archivador);
  }
  
  /**
  * Descripción : Obtener el nombre de un delegado.
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge un elemento
  * que representa al grupo.
  *   @Param Archivador : Formado por un nombre y un tamaño.
  *   @Param Delegado : Formado por un archivador.
  */
  @Test
   public void obtenerNombre() {

    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Delegado delegado = new Delegado(archivador);

    assertEquals(archivador.obtenerNombre(), delegado.obtenerNombre());
  }
   
  /**
  * Descripción : Obtener el espacio total de un delegado una vez se crea
  * Nivel  : Prueba de Unidad
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * Mecanismo de selección de datos: Datos introducidos manualmente,
  * para ello se utilizan particiones equivalentes, esto es, se escoge un elemento
  * que representa al grupo.
  *   @Param Archivador : Formado por un nombre y un tamaño.
  *   @Param Delegado : Formado por un archivador.
  */
  @Test
  public void obtenerEspacioTotal() {

    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Delegado delegado = new Delegado(archivador);

    assertEquals(archivador.obtenerEspacioTotal(), delegado.obtenerEspacioTotal());
  }

  /**
 * Descripción : Obtener el espacio disponible después de haber almacenado un correo.
 * Nivel : Prueba de Integración
 * Categoría : Prueba dinámica de caja negra, positiva, funcional.
 * Mecanismo de selección de datos: Datos introducidos manualmente,
 * para ello se utilizan particiones equivalentes, esto es, se escoge un elemento
 * que representa al grupo.
 *   @Param Archivador : Formado por un nombre y un tamaño.
 *   @Param Delegado : Formado por un archivador.
 *   @Param Correo : Formado por un mensaje(con un nombre y su contenido).
 */
  @Test
  public void obtenerEspacioDisponible() {

    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Delegado delegado = new Delegado(archivador);

    Correo correo = new Mensaje(new Texto(nombreTexto, contenido));

    delegado.almacenarCorreo(correo);

    assertEquals(archivador.obtenerEspacioTotal() - correo.obtenerTamaño(), 
                  delegado.obtenerEspacioDisponible());

  }
}
