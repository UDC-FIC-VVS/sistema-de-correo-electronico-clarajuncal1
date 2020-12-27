package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DelegadoTest {
  private String nombreArchivador = "Archivador";
  private int espacioArchivador = 100;
  private String nombreTexto = "Texto";
  private String contenido = "Texto de prueba";
  Texto texto = new Texto(nombreTexto, contenido);

  /*
  * Comprobar que el correo se almacena correctamente
  */
  @Test
  public void almacenarCorreo() {
    //Se crea un delegado a partir de un archivador
    ArchivadorSimple archivador = new ArchivadorSimple(nombreArchivador, espacioArchivador);
    Delegado delegado = new Delegado(archivador);
    //Se crea un mensaje , introduciendo un texto(nombre del texto, y contenido del texto)
    Correo correo = new Mensaje(texto);

    //Se comprueba que el delegado es capaz de almacenar dicho mensaje de correo.
    assertEquals(true, delegado.almacenarCorreo(correo));
  }

  /*
   * Comprobar que se establecen y se obtienen correctamente los delegados
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
}
