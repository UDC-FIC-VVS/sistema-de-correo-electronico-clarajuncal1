package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Texto;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestAdjunto {
  Texto texto = new Texto("TextoPrueba", "Realizando una prueba");
  Mensaje mensajePrueba = new Mensaje(texto);
  Archivo archivoPrueba = new Texto("ArchivoPrueba", "Archivo de la prueba");

  /**
  * Descripción : Obtener el tamaño de un Adjunto, para ello se comprueba 
  *  que el tamaño del mensaje mas el mensaje de un archivo coincide
  *  con el tamaño del adjunto.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  */
  @Test 
  public void obtenerTamano() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(adjunto.obtenerTamaño(), 
                  mensajePrueba.obtenerTamaño() + archivoPrueba.obtenerTamaño());

  }

  /**
  * Descripción : Obtener la visualización de un Adjunto, para ello se comprueba que la 
  *  visualizacion del mensaje mas la previsualizacion de un archivo coincide
  *  con la visualizacion del adjunto  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  */
  @Test
  public void obtenerVisualizacion() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(adjunto.obtenerVisualizacion(), mensajePrueba.obtenerVisualizacion() 
                  + "\n\nAdxunto: " + archivoPrueba.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener la ruta de un Adjunto, para ello se comprueba que el contenido 
  *  del mensaje coincide con la ruta del adjunto.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  */
  @Test
  public void obtenerRuta() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals("Realizando una prueba...", adjunto.obtenerRuta());
  }

  /**
  * Descripción : Obtener la ruta de un Adjunto, para ello se comprueba que la ruta del padre
  *  mas la previsualizacion del adjunto coincidan con la ruta del adjunto 
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  * @Param Carpeta : Carpeta a la que se añade el adjunto
  */
  @Test
  public void obtenerRutaConPadre() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Carpeta carpeta = new Carpeta("carpeta");

    carpeta.añadir(adjunto);

    assertEquals("carpeta (1) > Realizando una prueba...", adjunto.obtenerRuta());
  }

  /**
  * Descripción : Establecer y Obtener si un Adjunto ha sido leido.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  */
  @Test
  public void establecerYObtenerLeido() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(1, adjunto.obtenerNoLeidos());

    adjunto.establecerLeido(true);

    assertEquals(0, adjunto.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el icono de un Adjunto.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  */
  @Test
  public void obtenerIcono() {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals(Adjunto.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());
  }

  /**
  * Descripción : Obtener la visualización de un Adjunto, para ello se comprueba que
  *  el contenido del mensaje e dicho adjunto corresponde con la previsualizacion 
  *  del adjunto
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  */
  @Test
  public void obtenerPreVisualizacionAdjuntoTest() {
  
    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    assertEquals("Realizando una prueba...", adjunto.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Explorar un Adjunto.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *  adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void explorar() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    adjunto.explorar();
  }

  /**
  * Descripción : Añadir un Adjunto.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *  adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void anadir() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));

    adjunto.añadir(correo);

  }

  /**
  * Descripción : Eliminar un Adjunto.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *  adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void eliminar() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Correo correo = new Mensaje(new Texto("prueba", "Intentar añadir un correo"));

    adjunto.eliminar(correo);
  }

  /**
  * Descripción : Obtener el hijo de un Adjunto.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  * @Exception OperacionInvalida : Devuelve una excepción, pues un
  *    adjunto no puede realizar dicha operación.
  */
  @Test(expected = OperacionInvalida.class)
  public void obtenerHijo() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);

    adjunto.obtenerHijo(0);
  }

  /**
  * Descripción : Obtener el padre de un Adjunto.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  * @Param Carpeta : Se crea una carpeta donde se va a añadir el adjunto.
  */
  @Test
  public void obtenerPadre() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(adjunto);

    assertEquals(carpeta, adjunto.obtenerPadre());
  }

  /**
  * Descripción : Búsqueda de un Adjunto.  
  * Nivel : Prueba de Integración.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @Param Adjunto : adjunto formado por un mensaje y un archivo.
  */
  @Test
  public void buscar() throws OperacionInvalida {

    Adjunto adjunto = new Adjunto(mensajePrueba, archivoPrueba);
    Carpeta carpeta = new Carpeta("Carpeta");

    carpeta.añadir(adjunto);

    assertEquals(true, adjunto.buscar("prueba").contains(adjunto));
  }
}
