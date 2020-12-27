package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Texto;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestAdjunto {
  Texto texto = new Texto("TextoPrueba", "Realizando una prueba");
  Mensaje mensajePrueba = new Mensaje(texto);
  Archivo archivoPrueba = new Texto("ArchivoPrueba", "Archivo de la prueba");

  /*
  * Obtener el tamaño de un adjunto, para ello se crea un adjunto formado por un mensaje 
  * y un archivo y se comprueba que el tamaño del mensaje mas el mensaje de un archivo coincide
  * con el tamaño del adjunto
  */
  @Test 
  public void obtenerTamano() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(adjunto.obtenerTamaño(), 
                  mensajePrueba.obtenerTamaño() + archivoPrueba.obtenerTamaño());

  }

  /*
  * Obtener la visualizacion de un adjunto, para ello se crea un adjunto formado por un mensaje 
  * y un archivo y se comprueba que la visualizacion del mensaje 
  * mas la previsualizacion de un archivo coincide
  * con la visualizacion del adjunto
  */
  @Test
  public void obtenerVisualizacion() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(adjunto.obtenerVisualizacion(), mensajePrueba.obtenerVisualizacion() 
                  + "\n\nAdxunto: " + archivoPrueba.obtenerPreVisualizacion());
  }

  /*
  * Obtener la ruta de un ajunto, para ello se crea un adjunto formado por un mensaje y un archivo
  * y se comprueba que el contenido del mensaje coincide con la ruta del adjunto
  */
  @Test
  public void obtenerRuta() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals("Realizando una prueba...", adjunto.obtenerRuta());
  }

  /*
  * Obtener la ruta de un ajunto dentro de una carpeta, 
  * para ello se crea un adjunto formado por un mensaje y un archivo
  * y una carpeta y se añade el adjunto a la carpeta y se comprueba 
  * que la ruta del padre mas la previsualizacion del adjunto
  * coincidan con la ruta del adjunto
  */
  @Test
  public void obtenerRutaConPadre() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Carpeta carpeta = new Carpeta("carpeta");

    carpeta.añadir(adjunto);

    assertEquals("carpeta (1) > Realizando una prueba...", adjunto.obtenerRuta());
  }

  /*
  * Se crea un adjunto y se comprueba que no ha sido leido, 
  * posteriormente se establece dicho adjunto como leido y
  * se comprueba que ahora sí ha sido leido y en consecuencia no obtenemos ningún no leido
  */
  @Test
  public void establecerYObtenerLeido() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(1, adjunto.obtenerNoLeidos());

    adjunto.establecerLeido(true);

    assertEquals(0, adjunto.obtenerNoLeidos());
  }

  /*
   * Obtener Icono, para ello se crea un adjunto y se comprueba 
   * que el icono de dicho adjunto corresponde
   * con el icono de un mensaje nuevo
   */
  @Test
  public void obtenerIcono() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(Adjunto.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());
  }

  /*
  * Obtener Previsualizacion, para ello se crea un adjunto 
  * y se comprueba que el contenido del mensaje de dicho 
  * adjunto corresponde con la previsualizacion del adjunto
  */
  @Test
  public void obtenerPrevisualizacion() {
  
    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals("Realizando una prueba...", adjunto.obtenerPreVisualizacion());
  }

  /*
  * Explorar un adjunto, se crea un adjunto y se intenta explorar pero no es posible
  * puesto que es una operación invalida y se produce la excepcion OperacionInvaldia.class
  */
  @Test(expected = OperacionInvalida.class)
  public void explorar() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    adjunto.explorar();
  }

  /*
  * Añadir , se intenta añadir un nuevo mensaje al correo con Adjunto pero no es posible puesto que
  * es una operación invalida y en consecuencia se devuelve la excepción OperaciónInvalida.class
  */
  @Test(expected = OperacionInvalida.class)
  public void anadir() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));

    adjunto.añadir(correo);

  }

  /*
  * Eliminar , se intenta eliminar un mensaje en el correo con Adjunto pero no es posible puesto que
  * es una operación invalida y en consecuencia se devuelve la excepción OperaciónInvalida.class
  */
  @Test(expected = OperacionInvalida.class)
  public void eliminar() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));

    adjunto.eliminar(correo);
  }

  /*
  * ObtenerHijo , se intenta obtener el hijo de un  correo con Adjunto pero no es posible puesto que
  * es una operación invalida y en consecuencia se devuelve la excepción OperaciónInvalida.class
  */
  @Test(expected = OperacionInvalida.class)
  public void obtenerHijo() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    adjunto.obtenerHijo(0);
  }

  /*
  * ObtenerPadre, para ello creamos un correo con adjunto y una carpeta 
  * y se establece que dicha carpeta
  * es padre del correo adjunto y comprobamos que la carpeta coincida con el padre del adjunto
  */
  @Test
  public void obtenerPadre() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(adjunto);

    assertEquals(carpeta, adjunto.obtenerPadre());
  }

  /*
  * Buscar adjunto, para ello se crea un correo adjunto 
  * formado por un mensaje y un archivo y una carpeta
  * y añadimos el adjunto a dicha carpeta y comprobamos que el correo contiene el mensaje
  */
  @Test
  public void buscar() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(adjunto);

    assertEquals(true, adjunto.buscar("prueba").contains(adjunto));
  }
}
