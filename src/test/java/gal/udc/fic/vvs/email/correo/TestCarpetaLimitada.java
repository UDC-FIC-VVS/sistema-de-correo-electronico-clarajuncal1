package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

public class TestCarpetaLimitada {

  private String nombre = "carpetaPrueba";
  Carpeta carpeta = new Carpeta(nombre);
  private int tamano = 50;

  private String nombreTexto = "Texto";
  private String contenidoTexto = "Texto de Prueba";
  Texto texto = new Texto(nombreTexto, contenidoTexto);

  /**
  * Descripción : obtener el tamaño de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerTamano() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerTamaño(), carpeta.obtenerTamaño());
  }

  /**
  * Descripción : Establecer los leidos de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void establecerLeido() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    carpetaLimitada.establecerLeido(true);

    assertEquals(0, carpetaLimitada.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener los leidos de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerNoLeido() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    Correo correo = new Mensaje(texto);

    carpetaLimitada.añadir(correo);

    assertEquals(1, carpetaLimitada.obtenerNoLeidos());
  }

  /**
  * Descripción : Obtener el icono de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerIcono() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerIcono(), carpeta.obtenerIcono());
  }

  /**
  * Descripción : Obtener la previsualización de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerPrevisualizacionCarpetaLimitadaTest() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerPreVisualizacion(), carpeta.obtenerPreVisualizacion());
  }

  /**
  * Descripción : Obtener la visualizacion de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerVisualizacion() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerVisualizacion(), carpeta.obtenerVisualizacion());
  }

  /**
  * Descripción : Obtener la ruta de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerRuta() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.obtenerRuta(), carpeta.obtenerRuta());
  }

  /**
  * Descripción : Explorar que una carpeta limitada contenga correos.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void explorar() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(carpetaLimitada.explorar(), carpeta.explorar());
  }

  /**
  * Descripción : Añadir un correo a una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void anadir() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.añadir(correo);
    
    assertEquals(correo.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
  }

  /**
  * Descripción : Eliminar un correo de una carpeta limitada.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void eliminar() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.eliminar(correo);
    
    assertEquals(0, carpetaLimitada.obtenerTamaño());
  }

  /**
  * Descripción : Obtener el hijo de una carpeta limitada a partir 
  *  de un correo previamente añadido.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  * @throws OperacionInvalida
  */
  @Test
  public void obtenerHijo() throws OperacionInvalida {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.añadir(correo);

    assertEquals(correo, carpetaLimitada.obtenerHijo(0));

  }

  /**
  * Descripción : obtener la carpeta limitada padre de un correo previamente añadido.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void establecerYObtenerPadre() {

    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);
    Correo correo = new Mensaje(texto);

    carpetaLimitada.establecerPadre(correo);

    assertEquals(correo, carpetaLimitada.obtenerPadre());

  }

  /**
  * Descripción : obtener la carpeta limitada padre sin correo.  
  * Nivel : Prueba de Unidad.
  * Categoría : Prueba dinámica de caja negra, positiva, funcional.
  */
  @Test
  public void obtenerPadreNull() {
    CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamano);

    assertEquals(null, carpetaLimitada.obtenerPadre());
  }
}
